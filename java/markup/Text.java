package markup;

/** Text */
public class Text implements TextElement {

  private final String text;

  public Text(String text) {
    this.text = text;
  }

  @Override
  public void toMarkdown(StringBuilder sb) {
    sb.append(text);
  }

  @Override
  public void toHtml(StringBuilder sb) {
    sb.append(text);
  }

  @Override
  public void toTex(StringBuilder sb) {
    sb.append(text);
  }
}
