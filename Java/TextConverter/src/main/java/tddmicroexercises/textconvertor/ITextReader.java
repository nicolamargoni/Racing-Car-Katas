package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface ITextReader {
    String readLine();
    void close() throws IOException;
    void skip(int position) throws IOException;
}
