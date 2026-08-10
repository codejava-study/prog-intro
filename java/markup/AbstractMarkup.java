package markup;

import java.util.List;

/**
 * AbstractMarkup
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class AbstractMarkup implements Markup {
  private final List<? extends Markup> elements;
  private final String mdWrapper;
  private final String htmlWrapper;
  private final String texOpen;
  private final String texClose;

  /**
   * @param elements
   * @param mdWrapper
   * @param htmlWrapper
   * @param texOpen
   * @param texClose
   */
  public AbstractMarkup(
      final List<? extends Markup> elements,
      final String mdWrapper,
      final String htmlWrapper,
      final String texOpen,
      final String texClose) {
    this.elements = elements;
    this.mdWrapper = mdWrapper;
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
    for (final Markup element : elements) {
      element.toHtml(sb);
    }
    sb.append("</" + htmlWrapper + ">");
  }

  /**
   * (non-Javadoc)
   *
   * @see markup.Markup#toMarkdown(java.lang.StringBuilder)
   */
  @Override
  public final void toMarkdown(final StringBuilder sb) {
    sb.append(mdWrapper);
    for (final Markup element : elements) {
      element.toMarkdown(sb);
    }
    sb.append(mdWrapper);
  }

  /**
   * (non-Javadoc)
   *
   * @see markup.Markup#toTex(java.lang.StringBuilder)
   */
  @Override
  public final void toTex(final StringBuilder sb) {
    sb.append(texOpen);
    for (final Markup element : elements) {
      element.toTex(sb);
    }
    sb.append(texClose);
  }
}
