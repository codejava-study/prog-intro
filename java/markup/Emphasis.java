package markup;

import java.util.List;

/**
 * Emphasis
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Emphasis extends AbstractMarkup implements MarkupElement {
  /**
   * @param elements
   */
  public Emphasis(final List<ParagraphElement> elements) {
    super(elements, "*", "em", "\\emph{", "}");
  }
}
