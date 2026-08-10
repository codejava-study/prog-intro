package markup;

/**
 * Markup
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public interface Markup {

  void toMarkdown(StringBuilder sb);

  void toHtml(StringBuilder sb);

  void toTex(StringBuilder sb);
}
