package utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Zip {

    public static void unzipWithPassword(String source, String destination, String password) throws ZipException {
        ZipFile zipFile = new ZipFile(source);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(destination);
    }

    public static void unzipWithoutPassword(String source, String destination) throws ZipException {
        unzipWithPassword(source, destination, "");
    }
}
