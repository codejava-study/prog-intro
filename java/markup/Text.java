package markup;

/**
 * Text
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Text implements TextElement {

  private final String text;

  public Text(final String text) {
    this.text = text;
  }

  @Override
  public final void toMarkdown(final StringBuilder sb) {
    sb.append(text);
  }

  @Override
  public final void toHtml(final StringBuilder sb) {
    sb.append(text);
  }

  @Override
  public final void toTex(final StringBuilder sb) {
    sb.append(text);
  }
}
