package markup;

import java.util.List;

/** Sample */
public class Sample extends AbstractMarkup implements MarkupElement {
  public Sample(List<ParagraphElement> elements) {
    super(elements, "!!", "samp", "", "");
  }
}
