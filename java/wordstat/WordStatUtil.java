package wordstat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * WordStatUtil
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordStatUtil {
  /**
   * @param words
   * @return
   */
  public static final Map<String, WordInfo> sorted(final Map<String, WordInfo> words) {

    final List<String> wordsKeys = new ArrayList<>();
    for (final Map.Entry<String, WordInfo> entry : words.entrySet()) {
      wordsKeys.add(entry.getKey());
    }

    wordsKeys.sort(
        new Comparator<String>() {
          @Override
          public int compare(final String s1, final String s2) {
            return Integer.compare(s1.length(), s2.length());
          }
        });

    final Map<String, WordInfo> sorted = new LinkedHashMap<>();
    for (final String word : wordsKeys) {
      sorted.put(word, words.getOrDefault(word, new WordInfo(word)));
    }

    return sorted;
  }

  private WordStatUtil() {}
}
