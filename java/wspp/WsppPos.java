package wspp;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import wordstat.BaseWordStat;
import wordstat.IntList;
import wordstat.WordInfo;

/** WsppPos */
public class WsppPos extends BaseWordStat {

  public static void main(String[] args) {
    new WsppPos().run(args);
  }

  @Override
  protected void fillWriter(Map<String, WordInfo> words, Writer writer) throws IOException {

    int allCount = 0;
    for (Map.Entry<String, WordInfo> e : words.entrySet()) {
      allCount += e.getValue().count();
    }

    for (Map.Entry<String, WordInfo> e : words.entrySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getKey() + " " + e.getValue().count());

      Map<Integer, IntList> linePositions = e.getValue().linePositions();

      for (Map.Entry<Integer, IntList> linePosEntry : linePositions.entrySet()) {

        int lineNumber = linePosEntry.getKey();
        int[] lineNumberPositions = linePosEntry.getValue().asArray();

        for (int position : lineNumberPositions) {
          if (!sb.isEmpty()) {
            sb.append(" ");
          }
          sb.append(lineNumber + ":" + (allCount - position + 1));
        }
      }

      writer.write(sb.toString() + "\n");
    }
  }

  @Override
  protected boolean isValidChar(char ch) {
    return super.isValidChar(ch) || ch == '_' || ch == '$' || Character.isDigit(ch);
  }
}
