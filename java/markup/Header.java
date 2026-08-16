package markup;

import java.util.List;

/** Header */
public final class Header extends AbstractMarkup {
  public Header(List<ParagraphElement> elements, final int level) {
    super(elements, new StringBuilder().repeat('#', level).toString(), "h" + level, "", "");
  }
}
