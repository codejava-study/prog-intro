package markup;

import java.util.List;

/** ListItem */
public class ListItem extends AbstractMarkup {

  public ListItem(List<ListElement> elements) {
    super(elements, "", "", "\\item ", "");
  }
}
