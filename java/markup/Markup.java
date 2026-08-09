package markup;

/** Markup */
public interface Markup {

  void toMarkdown(StringBuilder sb);

  void toHtml(StringBuilder sb);

  void toTex(StringBuilder sb);
}
