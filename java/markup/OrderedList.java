package markup;

import java.util.List;

/** OrderedList */
public class OrderedList extends AbstractMarkup implements ListElement {

  public OrderedList(List<ListItem> elements) {
    super(elements, "", "", "\\begin{enumerate}", "\\end{enumerate}");
  }
}
