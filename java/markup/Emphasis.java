package markup;

import java.util.List;

/** Emphasis */
public class Emphasis extends AbstractMarkup implements MarkupElement {
  public Emphasis(List<ParagraphElement> elements) {
    super(elements, "*", "em", "\\emph{", "}");
  }
}
