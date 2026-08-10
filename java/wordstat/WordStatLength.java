package wordstat;

import java.util.Map;

/**
 * WordStat
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordStatLength extends BaseWordStat {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new WordStatLength().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#modify(java.lang.String)
   */
  @Override
  protected final String[] modify(final String word) {
    return new String[] {word};
  }

  /**
   * (non-Javadoc)
   *
   * @see wordstat.BaseWordStat#isValidWord(java.lang.String)
   */
  @Override
  protected final boolean isValidWord(final String word) {
    return true;
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
}
