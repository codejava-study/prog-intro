package markup;

import java.util.List;

/** Strong */
public class Strong extends AbstractMarkup implements MarkupElement {
  public Strong(List<ParagraphElement> elements) {
    super(elements, "__", "strong", "\\textbf{", "}");
  }
}
