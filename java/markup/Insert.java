package markup;

import java.util.List;

/** Insertion */
public class Insert extends AbstractMarkup implements MarkupElement {
  public Insert(List<ParagraphElement> elements) {
    super(elements, "<<", ">>", "ins", "", "");
  }
}
