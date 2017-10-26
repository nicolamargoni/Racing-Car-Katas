package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTextReader implements ITextReader {
    public static final String STRING_EMPTY = "";

    private String filePath;
    private BufferedReader bufferedReader;
    private FileReader fileReader;

    public FileTextReader(String filePath) throws Exception {
        this.filePath = filePath;
        init();
    }

    public String readLine() {
        try {
            String textLine = bufferedReader.readLine();
            if (textLine != null) {
                return textLine;
            } else {
                return STRING_EMPTY;
            }
        } catch (Exception e) {
            return STRING_EMPTY;
        }
    }

    public void init() throws IOException {
        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
    }

    public void close() throws IOException {
        bufferedReader.close();
        fileReader.close();
    }

    public void skip(int position) throws IOException {
        reset();
        bufferedReader.skip(position);
    }

    public void reset() throws IOException{
        close();
        init();
    }
}
