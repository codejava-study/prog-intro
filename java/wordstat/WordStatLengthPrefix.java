package wordstat;

import java.util.Map;

/**
 * WordStatLengthPrefix
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordStatLengthPrefix extends BaseWordStat {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new WordStatLengthPrefix().run(args);
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
    return new String[] {word.substring(0, word.length() / 2)};
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
