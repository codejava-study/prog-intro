package markup;

import java.util.List;

/**
 * Paragraph
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Paragraph extends AbstractMarkup implements ListElement {
  public Paragraph(final List<ParagraphElement> elements) {
    super(elements, "", "p", "\\par{}", "");
  }
}
