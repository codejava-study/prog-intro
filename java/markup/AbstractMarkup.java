package markup;

import java.util.List;

/**
 * AbstractMarkup
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class AbstractMarkup implements Markup {
  private final List<? extends Markup> elements;
  private final String mdOpen;
  private final String mdClose;
  private final String htmlWrapper;
  private final String texOpen;
  private final String texClose;

  public AbstractMarkup(
      final List<? extends Markup> elements,
      final String mdWrapper,
      final String htmlWrapper,
      final String texOpen,
      final String texClose) {
    this.elements = elements;
    this.mdOpen = mdWrapper;
    this.mdClose = mdWrapper;
    this.htmlWrapper = htmlWrapper;
    this.texOpen = texOpen;
    this.texClose = texClose;
  }

  public AbstractMarkup(
      final List<? extends Markup> elements,
      final String mdOpen,
      final String mdClose,
      final String htmlWrapper,
      final String texOpen,
      final String texClose) {
    this.elements = elements;
    this.mdOpen = mdOpen;
    this.mdClose = mdClose;
    this.htmlWrapper = htmlWrapper;
    this.texOpen = texOpen;
    this.texClose = texClose;
  }

  /**
   * (non-Javadoc)
   *
   * @see markup.Markup#toHtml(java.lang.StringBuilder)
   */
  @Override
  public final void toHtml(final StringBuilder sb) {
    sb.append("<" + htmlWrapper + ">");
    elements.forEach(e -> e.toHtml(sb));
    sb.append("</" + htmlWrapper + ">");
  }

  /**
   * (non-Javadoc)
   *
   * @see markup.Markup#toMarkdown(java.lang.StringBuilder)
   */
  @Override
  public final void toMarkdown(final StringBuilder sb) {
    sb.append(mdOpen);
    elements.forEach(e -> e.toMarkdown(sb));
    sb.append(mdClose);
  }

  /**
   * (non-Javadoc)
   *
   * @see markup.Markup#toTex(java.lang.StringBuilder)
   */
  @Override
  public final void toTex(final StringBuilder sb) {
    sb.append(texOpen);
    elements.forEach(e -> e.toTex(sb));
    sb.append(texClose);
  }
}
