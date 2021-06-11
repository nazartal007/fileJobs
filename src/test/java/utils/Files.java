package utils;

import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static String getTextFromFile(String filePath) throws IOException, TikaException {
        File inputFile = getFile(filePath);
        Tika tika = new Tika();
        return tika.parseToString(inputFile);

    }
}
