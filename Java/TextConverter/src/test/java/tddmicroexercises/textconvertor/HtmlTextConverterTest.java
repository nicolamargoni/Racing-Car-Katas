package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {

    static final String NAME_FILE = "temp.txt";
    static final String CONTENT_FILE =
            "Nel mezzo del cammin di nostra vita\n" +
                    "mi ritrovai per una selva oscura,\n" +
                    "ché la diritta via era smarrita. \n" +
                    "& < > \" '";

    static final String HTML_CONVERTED =
            "Nel mezzo del cammin di nostra vita<br />mi ritrovai per una selva oscura," +
                    "<br />ché la diritta via era smarrita. <br />&amp; &lt; &gt; &quot; &quot;<br />";


    FileManager fileManager = new FileManager();

    @Test
    public void testHtmlTextConverter() throws Exception {
        fileManager.createFile(NAME_FILE, CONTENT_FILE);
        FileTextReader fileTextReader = new FileTextReader(fileManager.getFilePath(NAME_FILE));

        HtmlTextConverter converter = new HtmlTextConverter(fileTextReader, new HtmlEscapeString());
        assertEquals(HTML_CONVERTED, converter.convert());

        fileManager.deleteFile(NAME_FILE);
    }


}
