package markup;

import java.util.List;

/** Pre */
public class Pre extends AbstractMarkup implements MarkupElement {
  public Pre(List<ParagraphElement> elements) {
    super(elements, "```", "pre", "", "");
  }
}
