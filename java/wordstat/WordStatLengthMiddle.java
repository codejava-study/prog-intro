package wordstat;

import java.util.Map;

/**
 * WordStatLengthMiddle
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordStatLengthMiddle extends BaseWordStat {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new WordStatLengthMiddle().run(args);
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
    return new String[] {word.substring(3, word.length() - 3)};
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#isValidWord(java.lang.String)
   */
  @Override
  protected final boolean isValidWord(final String word) {
    return word.length() >= 7;
  }
}
