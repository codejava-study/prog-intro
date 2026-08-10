package markup;

import java.util.List;

/**
 * Strong
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Strong extends AbstractMarkup implements MarkupElement {
  public Strong(final List<ParagraphElement> elements) {
    super(elements, "__", "strong", "\\textbf{", "}");
  }
}
