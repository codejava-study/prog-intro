package markup;

import java.util.List;

/** AbstractMarkup */
public abstract class AbstractMarkup implements Markup {
  private List<? extends Markup> elements;
  private final String mdWrapper;
  private final String htmlWrapper;
  private final String texOpen;
  private final String texClose;

  public AbstractMarkup(
      List<? extends Markup> elements,
      String mdWrapper,
      String htmlWrapper,
      String texOpen,
      String texClose) {
    this.elements = elements;
    this.mdWrapper = mdWrapper;
    this.htmlWrapper = htmlWrapper;
    this.texOpen = texOpen;
    this.texClose = texClose;
  }

  @Override
  public void toHtml(StringBuilder sb) {
    sb.append("<" + htmlWrapper + ">");
    for (final Markup element : elements) {
      element.toHtml(sb);
    }
    sb.append("</" + htmlWrapper + ">");
  }

  @Override
  public void toMarkdown(StringBuilder sb) {
    sb.append(mdWrapper);
    for (final Markup element : elements) {
      element.toMarkdown(sb);
    }
    sb.append(mdWrapper);
  }

  @Override
  public void toTex(StringBuilder sb) {
    sb.append(texOpen);
    for (final Markup element : elements) {
      element.toTex(sb);
    }
    sb.append(texClose);
  }
}
