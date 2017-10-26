package tddmicroexercises.textconvertor;

public class HtmlTextConverter implements ITextConverter {
    public static final String STRING_EMPTY = "";
    public static final String HTML_TAG_BR_CLOSURE = "<br />";
    private ITextReader textReader;
    private IEscapeString escapeString;

    public HtmlTextConverter(ITextReader textReader, IEscapeString escapeString) {
        this.textReader = textReader;
        this.escapeString = escapeString;
    }

    public String convert() {
        String htmlConverted = STRING_EMPTY;
        String textLine = textReader.readLine();

        while (!textLine.equals(STRING_EMPTY)) {
            htmlConverted += escapeString.escape(textLine);
            htmlConverted += HTML_TAG_BR_CLOSURE;
            textLine = textReader.readLine();
        }

        return htmlConverted;
    }
}
