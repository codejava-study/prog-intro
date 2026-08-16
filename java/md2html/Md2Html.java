package md2html;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import markup.*;

/** Md2Html */
public class Md2Html {
  private static final int BUFFER_SIZE = 8096;

  public static void main(String[] args) {

    if (args.length != 2) {
      System.err.println("Usage: java md2html.Md2Html <in> <out>");
      return;
    }

    final String inputFileName = args[0];
    final String outputFileName = args[1];

    try (Reader reader =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(new File(inputFileName)), StandardCharsets.UTF_8));
        Writer writer =
            new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(new File(outputFileName)), StandardCharsets.UTF_8))) {

      final char[] buffer = new char[BUFFER_SIZE];
      int read = reader.read(buffer);
      StringBuilder current = new StringBuilder();
      StringBuilder line = new StringBuilder();

      while (read != -1) {

        for (int i = 0; i < read; i++) {
          char ch = buffer[i];

          if (ch == '\n') {
            if (line.isEmpty()) {
              if (!current.isEmpty()) {
                Markup markup = parse(current.toString());
                StringBuilder htmlMarkup = new StringBuilder();
                markup.toHtml(htmlMarkup);
                writer.write(htmlMarkup.toString() + "\n");
                current.setLength(0);
              }
            } else {
              if (!current.isEmpty()) {
                current.append("\n");
              }
              current.append(line.toString());
              line.setLength(0);
            }
          } else {
            line.append(ch);
          }
        }

        read = reader.read(buffer);
      }

      if (!line.isEmpty()) {
        current.append(line.toString());
      }

      if (!current.isEmpty()) {
        Markup markup = parse(current.toString());
        StringBuilder htmlMarkup = new StringBuilder();
        markup.toHtml(htmlMarkup);
        writer.write(htmlMarkup.toString() + "\n");
      }

    } catch (IOException e) {
      System.out.println("General IO exception occured, reason: " + e.getMessage());
    }
  }

  private static Markup parse(String string) {
    if (string.startsWith("#")) {
      int level = 0;

      while (string.charAt(level) == '#') {
        level++;
      }

      if (string.charAt(level) == ' ') {
        return parseHeader(string, level);
      } else {
        return parseParagraph(string);
      }
    } else {
      return parseParagraph(string);
    }
  }

  private static Paragraph parseParagraph(String string) {
    return new Paragraph(parseElements(string));
  }

  private static Header parseHeader(String string, final int level) {
    return new Header(parseElements(string.substring(level + 1)), level);
  }

  private static List<ParagraphElement> parseElements(String string) {
    List<ParagraphElement> elements = new ArrayList<>();
    StringBuilder text = new StringBuilder();
    int i = 0;

    while (i < string.length()) {
      char ch = string.charAt(i);

      if (ch == '\\' && i + 1 < string.length() && isEscapable(string.charAt(i + 1))) {
        text.append(escapeHtml(string.charAt(i + 1)));
        i += 2;
        continue;
      }

      Parsed parsed =
          switch (ch) {
            case '`' -> parseCodeOrPre(string, i);
            case '*', '_' -> parseEmphasisOrStrong(string, i, ch);
            case '-' -> parseStrikeout(string, i);
            case '!' -> parseSample(string, i);
            case '<' -> parseInsert(string, i);
            case '}' -> parseDelete(string, i);
            case '%' -> parseVariable(string, i);
            default -> null;
          };

      if (parsed != null) {
        flush(text, elements);
        elements.add(parsed.element());
        i = parsed.nextIndex();
        continue;
      }

      text.append(escapeHtml(ch));
      i++;
    }
    flush(text, elements);
    return elements;
  }

  private static Parsed parseVariable(String string, int i) {
    int close = findClosingMarker(string, i + 1, "%");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 1, close));
    return new Parsed(new Variable(inner), close + 1);
  }

  private static Parsed parseCodeOrPre(String string, int i) {
    if (string.startsWith("```", i)) {
      return parsePre(string, i);
    } else {
      return parseCode(string, i);
    }
  }

  private static Parsed parsePre(String string, int i) {
    if (!string.startsWith("```", i)) {
      return null;
    }
    int close = findClosingMarker(string, i + 3, "```");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = List.of(new Text(string.substring(i + 3, close)));
    return new Parsed(new Pre(inner), close + 3);
  }

  private static Parsed parseCode(String string, int i) {
    int close = findClosingMarker(string, i + 1, "`");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 1, close));
    return new Parsed(new Code(inner), close + 1);
  }

  private static Parsed parseDelete(String string, int i) {
    if (!string.startsWith("}}", i)) {
      return null;
    }
    int close = findClosingMarker(string, i + 2, "{{");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 2, close));
    return new Parsed(new Delete(inner), close + 2);
  }

  private static Parsed parseInsert(String string, int i) {
    if (!string.startsWith("<<", i)) {
      return null;
    }
    int close = findClosingMarker(string, i + 2, ">>");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 2, close));
    return new Parsed(new Insert(inner), close + 2);
  }

  private static Parsed parseSample(String string, int i) {
    if (!string.startsWith("!!", i)) {
      return null;
    }
    int close = findClosingMarker(string, i + 2, "!!");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 2, close));
    return new Parsed(new Sample(inner), close + 2);
  }

  private static void flush(StringBuilder text, List<ParagraphElement> elements) {
    if (!text.isEmpty()) {
      elements.add(new Text(text.toString()));
      text.setLength(0);
    }
  }

  private static record Parsed(ParagraphElement element, int nextIndex) {}

  private static Parsed parseStrikeout(String string, int i) {
    if (!string.startsWith("--", i)) {
      return null;
    }
    int close = findClosingMarker(string, i + 2, "--");
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(i + 2, close));
    return new Parsed(new Strikeout(inner), close + 2);
  }

  private static Parsed parseEmphasisOrStrong(String string, int i, char marker) {
    boolean strong = i + 1 < string.length() && string.charAt(i + 1) == marker;
    String open = strong ? "" + marker + marker : String.valueOf(marker);
    int contentStart = i + open.length();
    int close = findClosingMarker(string, contentStart, open);
    if (close == -1) {
      return null;
    }
    List<ParagraphElement> inner = parseElements(string.substring(contentStart, close));
    ParagraphElement element = strong ? new Strong(inner) : new Emphasis(inner);
    return new Parsed(element, close + open.length());
  }

  // private static String escapeHtml(String content) {
  //   StringBuilder sb = new StringBuilder();
  //   for (char ch : content.toCharArray()) {
  //     sb.append(escapeHtml(ch));
  //   }
  //   return sb.toString();
  // }

  private static String escapeHtml(char ch) {
    return switch (ch) {
      case '&' -> "&amp;";
      case '<' -> "&lt;";
      case '>' -> "&gt;";
      default -> String.valueOf(ch);
    };
  }

  private static boolean isEscapable(char ch) {
    return ch == '*'
        || ch == '_'
        || ch == '-'
        || ch == '`'
        || ch == '\\'
        || ch == '#'
        || ch == '!'
        || ch == '<'
        || ch == '>'
        || ch == '{'
        || ch == '}'
        || ch == '%';
  }

  private static int findClosingMarker(String string, int from, String marker) {
    int i = from;
    while (i <= string.length() - marker.length()) {
      char ch = string.charAt(i);

      if (ch == '\\' && i + 1 < string.length()) {
        i += 2;
        continue;
      }

      if (!marker.equals("```") && string.startsWith("```", i)) {
        int preClose = string.indexOf("```", i + 3);
        i = (preClose == -1) ? i + 3 : preClose + 3;
        continue;
      }

      if (marker.length() == 1
          && marker.charAt(0) != '`'
          && string.startsWith(marker, i)
          && i + 1 < string.length()
          && string.charAt(i + 1) == marker.charAt(0)) {
        i += 2;
        continue;
      }

      if (string.startsWith(marker, i)) {
        return i;
      }
      i++;
    }
    return -1;
  }
}
