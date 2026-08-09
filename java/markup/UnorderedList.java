package markup;

import java.util.List;

/** UnorderedList */
public class UnorderedList extends AbstractMarkup implements ListElement {

  public UnorderedList(List<ListItem> elements) {
    super(elements, "", "", "\\begin{itemize}", "\\end{itemize}");
  }
}
