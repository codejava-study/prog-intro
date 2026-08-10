package markup;

import java.util.List;

/**
 * ListItem
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ListItem extends AbstractMarkup {
  /**
   * @param elements
   */
  public ListItem(final List<ListElement> elements) {
    super(elements, "", "li", "\\item ", "");
  }
}
