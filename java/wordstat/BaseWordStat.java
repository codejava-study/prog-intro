package wordstat;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * BaseWordStat
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class BaseWordStat {

  private int pos = 1;
  private int lineNumber = 1;

  /**
   * @param args
   */
  protected final void run(final String[] args) {

    if (args.length != 2) {
      printUsageTip();
      return;
    }

    final String inputFilename = args[0];
    final String outputFilename = args[1];

    final Map<String, WordInfo> words = readInput(inputFilename);

    writeOutput(sorted(words), outputFilename);
  }

  /**
   * @param words
   * @return
   */
  protected Map<String, WordInfo> sorted(Map<String, WordInfo> words) {
    return words;
  }

  /**
   * @param word
   * @return
   */
  protected String[] modify(final String word) {
    return new String[] {word};
  }

  /**
   * @param word
   * @return
   */
  protected boolean isValidWord(final String word) {
    return true;
  }

  /**
   * @param filename
   * @return
   */
  private final Map<String, WordInfo> readInput(final String filename) {

    final Map<String, WordInfo> words = new LinkedHashMap<>();

    try {
      final Reader reader =
          new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));

      try {
        int read = reader.read();
        final StringBuilder sb = new StringBuilder();
        while (read != -1) {
          final char ch = (char) read;

          if (isValidChar(ch)) {
            sb.append(ch);
          } else {
            processWord(sb, words);

            if (ch == '\n') {
              lineNumber++;
            }
          }

          read = reader.read();
        }

        processWord(sb, words);
      } finally {
        reader.close();
      }

    } catch (final UnsupportedEncodingException e) {
      System.out.println("Encoding unsupported, try UTF-8 instead: " + e.getMessage());
    } catch (final FileNotFoundException e) {
      System.out.println("File '" + filename + "' was not found: " + e.getMessage());
    } catch (final IOException e) {
      System.out.println("General IO exception occured, reason: " + e.getMessage());
    }

    return words;
  }

  private final void printUsageTip() {
    System.err.println("Usage: java " + getClass().toString() + " <in> <out>");
  }

  /**
   * @param words
   * @param filename
   */
  private final void writeOutput(final Map<String, WordInfo> words, final String filename) {
    try {
      final Writer writer =
          new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));

      try {
        fillWriter(words, writer);
      } finally {
        writer.close();
      }
    } catch (final UnsupportedEncodingException e) {
      System.out.println("Encoding unsupported, try UTF-8 instead: " + e.getMessage());
    } catch (final FileNotFoundException e) {
      System.out.println("File '" + filename + "' was not found: " + e.getMessage());
    } catch (final IOException e) {
      System.out.println("General IO exception occured, reason: " + e.getMessage());
    }
  }

  protected void fillWriter(Map<String, WordInfo> words, Writer writer) throws IOException {
    for (final Map.Entry<String, WordInfo> e : words.entrySet()) {
      writer.write(e.getKey() + " " + e.getValue().count() + "\n");
    }
  }

  /**
   * @param sb
   * @param words
   */
  private final void processWord(final StringBuilder sb, final Map<String, WordInfo> words) {

    if (!sb.isEmpty()) {
      final String word = sb.toString().toLowerCase();
      sb.setLength(0);

      if (isValidWord(word)) {
        final String[] modified = modify(word);

        for (final String modifiedWord : modified) {
          WordInfo wi;
          if (words.containsKey(modifiedWord)) {
            wi = words.get(modifiedWord);
            wi.addLinePosition(lineNumber, pos);
          } else {
            wi = new WordInfo(modifiedWord);
            wi.addLinePosition(lineNumber, pos);
            words.put(modifiedWord, wi);
          }

          pos++;
        }
      }
    }
  }

  /**
   * @param ch
   * @return
   */
  protected boolean isValidChar(final char ch) {
    return Character.isLetter(ch)
        || ch == '\''
        || Character.getType(ch) == Character.DASH_PUNCTUATION;
  }
}
