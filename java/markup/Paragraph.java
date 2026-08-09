package markup;

import java.util.List;

/** Paragraph */
public class Paragraph extends AbstractMarkup implements IParagraph, ListElement {
  public Paragraph(List<ParagraphElement> elements) {
    super(elements, "", "p", "\\par{}", "");
  }
}
