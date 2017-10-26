package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;


public class HtmlPagesConverterTest {
    FileManager fileManager = new FileManager();

    @Test
    public void testHtmlPagesConverter() throws Exception {
        fileManager.createFile(NAME_FILE, CONTENT_FILE);
        FileTextReader textReader = new FileTextReader(fileManager.getFilePath(NAME_FILE));
        HtmlPagesConverter converter = new HtmlPagesConverter(textReader, new HtmlEscapeString());
        converter.convert();

        assertEquals(HTML_CONVERTED_PAGE_ONE, converter.getPage(0));
        assertEquals(HTML_CONVERTED_PAGE_TWO, converter.getPage(1));
        assertEquals(HTML_CONVERTED_PAGE_THREE, converter.getPage(2));
        fileManager.deleteFile(NAME_FILE);
    }

    static final String NAME_FILE = "temp.txt";
    static final String CONTENT_FILE =
            "Nel mezzo del cammin di nostra vita\n" +
                    "mi ritrovai per una selva oscura,\n" +
                    "ché la diritta via era smarrita. \n" +
                    "PAGE_BREAK\n" +
                    "Ahi quanto a dir qual era è cosa dura\n" +
                    "esta selva selvaggia e aspra e forte\n" +
                    "che nel pensier rinova la paura! \n" +
                    "PAGE_BREAK\n" +
                    "Tant’è amara che poco è più morte;\n" +
                    "ma per trattar del ben ch’i’ vi trovai,\n" +
                    "dirò de l’altre cose ch’i’ v’ ho scorte.";

    static final String HTML_CONVERTED_PAGE_ONE =
            "Nel mezzo del cammin di nostra vita<br />mi ritrovai per una selva oscura," +
                    "<br />ché la diritta via era smarrita. <br />";

    static final String HTML_CONVERTED_PAGE_TWO =
            "Ahi quanto a dir qual era è cosa dura<br />esta selva selvaggia e aspra e forte<br />" +
                    "che nel pensier rinova la paura! <br />";

    static final String HTML_CONVERTED_PAGE_THREE =
            "Tant’è amara che poco è più morte;<br />ma per trattar del ben ch’i’ vi trovai,<br />" +
                    "dirò de l’altre cose ch’i’ v’ ho scorte.<br />";
}
