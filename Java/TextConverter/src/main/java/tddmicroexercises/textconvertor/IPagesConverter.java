package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface IPagesConverter {
    String getPage(int page) throws IOException;
    void convert() throws IOException;

}
