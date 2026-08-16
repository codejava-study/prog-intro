package markup;

import java.util.List;

/** Deletion */
public class Delete extends AbstractMarkup implements MarkupElement {
  public Delete(List<ParagraphElement> elements) {
    super(elements, "}}", "{{", "del", "", "");
  }
}
