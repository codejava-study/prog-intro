package markup;

import java.util.List;

/** Strikeout */
public class Strikeout extends AbstractMarkup implements MarkupElement {
  public Strikeout(List<ParagraphElement> elements) {
    super(elements, "~", "s", "\\textst{", "}");
  }
}
