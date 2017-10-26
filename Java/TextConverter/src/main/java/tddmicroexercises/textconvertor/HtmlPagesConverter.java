package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter implements IPagesConverter {
    public static final String PAGE_BREAK = "PAGE_BREAK";
    public static final String HTML_TAG_BR = "<br />";
    public static final String STRING_EMPTY = "";

    private ITextReader textReader;
    private IEscapeString escapeString;
    private List<Integer> breaks = new ArrayList<>();

    public HtmlPagesConverter(ITextReader textReader, IEscapeString escapeString) throws IOException {
        this.textReader = textReader;
        this.escapeString = escapeString;
    }

    public void convert() {
        this.breaks.add(0);
        int cumulativeCharCount = 0;
        String textLine = textReader.readLine();
        while (!textLine.equals(STRING_EMPTY)) {
            cumulativeCharCount += textLine.length() + 1; // add one for the newline
            if (textLine.contains(PAGE_BREAK)) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            textLine = textReader.readLine();
        }
    }

    public String getPage(int page) throws IOException {
        textReader.skip(breaks.get(page));
        StringBuffer htmlPage = new StringBuffer();
        String textLine = textReader.readLine();
        while (textLine != STRING_EMPTY) {
            if (textLine.contains(PAGE_BREAK)) {
                break;
            }
            htmlPage.append(escapeString.escape(textLine));
            htmlPage.append(HTML_TAG_BR);

            textLine = textReader.readLine();
        }
        textReader.close();
        return htmlPage.toString();
    }
}
