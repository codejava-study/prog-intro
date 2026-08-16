package markup;

import java.util.List;

/** Variables */
public class Variable extends AbstractMarkup implements MarkupElement {

  public Variable(List<ParagraphElement> elements) {
    super(elements, "%", "var", "", "");
  }
}
