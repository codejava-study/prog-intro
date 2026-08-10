package markup;

import java.util.List;

/**
 * UnorderedList
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class UnorderedList extends AbstractMarkup implements ListElement {
  public UnorderedList(final List<ListItem> elements) {
    super(elements, "", "ul", "\\begin{itemize}", "\\end{itemize}");
  }
}
