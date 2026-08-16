package markup;

import java.util.List;

/** Code */
public final class Code extends AbstractMarkup implements MarkupElement {
  public Code(final List<ParagraphElement> elements) {
    super(elements, "`", "code", "", "");
  }
}
