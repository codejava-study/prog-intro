package markup;

import java.util.List;

/**
 * OrderedList
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class OrderedList extends AbstractMarkup implements ListElement {
  public OrderedList(final List<ListItem> elements) {
    super(elements, "", "ol", "\\begin{enumerate}", "\\end{enumerate}");
  }
}
