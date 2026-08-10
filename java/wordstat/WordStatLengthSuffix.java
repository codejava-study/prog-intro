package wordstat;

import java.util.Map;

/**
 * WordStatLengthSuffix
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordStatLengthSuffix extends BaseWordStat {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new WordStatLengthSuffix().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#sorted(java.util.Map)
   */
  @Override
  protected final Map<String, WordInfo> sorted(final Map<String, WordInfo> words) {
    return WordStatUtil.sorted(words);
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#modify(java.lang.String)
   */
  @Override
  protected final String[] modify(final String word) {
    return new String[] {word.substring(word.length() - word.length() / 2)};
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#isValidWord(java.lang.String)
   */
  @Override
  protected final boolean isValidWord(final String word) {
    return word.length() > 1;
  }
}
