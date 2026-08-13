package wspp;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import wordstat.BaseWordStat;
import wordstat.IntList;
import wordstat.WordInfo;

/** Wspp */
public class Wspp extends BaseWordStat {

  public static void main(String[] args) {
    new Wspp().run(args);
  }

  @Override
  protected void fillWriter(Map<String, WordInfo> words, Writer writer) throws IOException {
    for (Map.Entry<String, WordInfo> e : words.entrySet()) {
      writer.write(
          e.getKey()
              + " "
              + e.getValue().count()
              + " "
              + IntList.asString(e.getValue().positions())
              + "\n");
    }
  }
}
