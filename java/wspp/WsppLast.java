package wspp;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import wordstat.BaseWordStat;
import wordstat.IntList;
import wordstat.WordInfo;
import wordstat.WordStatUtil;

/** WsppPos */
public class WsppLast extends BaseWordStat {

  public static void main(final String[] args) {
    new WsppLast().run(args);
  }

  @Override
  protected void fillWriter(final Map<String, WordInfo> words, final Writer writer)
      throws IOException {

    for (final Map.Entry<String, WordInfo> e : words.entrySet()) {
      final StringBuilder sb = new StringBuilder();
      sb.append(e.getKey() + " " + e.getValue().count());

      final Map<Integer, IntList> linePositions = e.getValue().linePositions();

      for (final Map.Entry<Integer, IntList> linePosEntry : linePositions.entrySet()) {

        final int[] lineNumberPositions = linePosEntry.getValue().asArray();

        if (!sb.isEmpty()) {
          sb.append(" ");
        }
        sb.append(lineNumberPositions[lineNumberPositions.length - 1]);
      }

      writer.write(sb.toString() + "\n");
    }
  }

  @Override
  protected boolean isValidChar(final char ch) {
    return super.isValidChar(ch) || ch == '_' || ch == '$' || Character.isDigit(ch);
  }

  @Override
  protected Map<String, WordInfo> sorted(Map<String, WordInfo> words) {
    return WordStatUtil.sorted(words);
  }
}
