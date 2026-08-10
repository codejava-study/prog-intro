package wordstat;

/**
 * WordInfo
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordInfo {

  private final String word;
  private int count;

  /**
   * @param word
   */
  public WordInfo(final String word) {
    this.word = word;
  }

  public final void incrementCount() {
    count++;
  }

  public final int getCount() {
    return count;
  }
}
