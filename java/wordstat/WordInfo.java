package wordstat;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * WordInfo
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class WordInfo {

  private final String word;
  private IntList positions;
  private Map<Integer, IntList> linePositions;
  private int count;

  /**
   * @param word
   */
  public WordInfo(final String word) {
    this.word = word;
    this.positions = new IntList();
    this.linePositions = new LinkedHashMap<>();
  }

  public void addPosition(int pos) {
    positions.add(pos);
    incrementCount();
  }

  public void addLinePosition(int line, int pos) {
    if (linePositions.containsKey(line)) {
      IntList il = linePositions.get(line);
      il.add(pos);
    } else {
      IntList il = new IntList();
      il.add(pos);
      linePositions.put(line, il);
    }
    addPosition(pos);
  }

  public final void incrementCount() {
    count++;
  }

  public final int[] positions() {
    return positions.asArray();
  }

  public final Map<Integer, IntList> linePositions() {
    return linePositions;
  }

  public final int count() {
    return count;
  }

  public final String word() {
    return word;
  }
}
