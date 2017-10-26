package tddmicroexercises.textconvertor;

import java.io.*;

public class FileManager {

    public void createFile(String nameFile, String contentFile) throws Exception {
        File file = new File(nameFile);
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(contentFile);
        bufferedWriter.flush();
    }

    public String getFilePath(String nameFile) throws Exception {
        File file = new File(nameFile);
        return file.getAbsolutePath();
    }

    public void deleteFile(String nameFile) {
        File file = new File(nameFile);
        if (isFileExisting(nameFile)) {
            file.delete();
        }
    }

    public boolean isFileExisting(String nameFile) {
        File file = new File(nameFile);
        return file.exists();
    }

}
