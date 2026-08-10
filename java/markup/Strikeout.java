package markup;

import java.util.List;

/**
 * Strikeout
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Strikeout extends AbstractMarkup implements MarkupElement {
  public Strikeout(final List<ParagraphElement> elements) {
    super(elements, "~", "s", "\\textst{", "}");
  }
}
