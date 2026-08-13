package wordstat;

import java.util.Arrays;

/** IntList */
public class IntList {

  private int[] elements;
  private int pos;

  public IntList() {
    this.elements = new int[0];
    this.pos = 0;
  }

  public void add(int element) {
    ensureCapacity(pos + 1);
    elements[pos++] = element;
  }

  public int get(int i) {
    return elements[i];
  }

  public int length() {
    return pos;
  }

  public int[] asArray() {
    return Arrays.copyOf(elements, pos);
  }

  private void ensureCapacity(int capacity) {
    if (capacity >= elements.length) {
      elements = Arrays.copyOf(elements, (elements.length + 1) * 2);
    }
  }

  public static String asString(int[] array) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < array.length; i++) {
      if (!sb.isEmpty()) {
        sb.append(" ");
      }
      sb.append(array[i]);
    }

    return sb.toString();
  }
}
