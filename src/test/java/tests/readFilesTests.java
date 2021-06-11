package tests;

import net.lingala.zip4j.exception.ZipException;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getTextFromFile;
import static utils.Zip.unzipWithPassword;
import static utils.Zip.unzipWithoutPassword;

public class readFilesTests {
    @Test
    public void txtTest() throws IOException, TikaException {
        String txtFilePath = "./src/test/resources/files/1.txt",
                expectedText = "Hello all peoples!";

        String actualData = getTextFromFile(txtFilePath);

        assertThat(actualData, containsString(expectedText));
    }

    @Test
    public void pdfTest() throws IOException, TikaException {
        String pdfFilePath = "src/test/resources/files/Как скачать файл с помощью Selenide.pdf",
                expectedText = "Как скачать файл с помощью Selenide";

        String pdf = getTextFromFile(pdfFilePath);
        assertThat(pdf, containsString(expectedText));
    }

    @Test
    public void xlsTest() throws TikaException, IOException {
        String xlsFilePath = "src/test/resources/files/file_example_XLS_10.xls",
                expectedText = "Kathleen";

        String xls = getTextFromFile(xlsFilePath);
        assertThat(xls, containsString(expectedText));
    }

    @Test
    public void xlsxTest() throws TikaException, IOException {
        String xlsxFilePath = "src/test/resources/files/1.xlsx",
                expectedText = "1667325";

        String xlsx = getTextFromFile(xlsxFilePath);
        assertThat(xlsx, containsString(expectedText));
    }

    @Test
    public void zipWithoutPasswordTest() throws ZipException, IOException, TikaException {
        String zipFilePath = "src/test/resources/files/1.zip",
                unzipFolderPath = "src/test/resources/files/unzip",
                unzipTxtPath = "src/test/resources/files/unzip/1.txt",
                expectedText = "Hello all peoples!";

        unzipWithoutPassword(zipFilePath, unzipFolderPath);

        String actualData = getTextFromFile(unzipTxtPath);

        assertThat(actualData, containsString(expectedText));
    }

    @Test
    public void zipWithPasswordTest() throws ZipException, IOException, TikaException {
        String zipFilePath = "src/test/resources/files/1password.zip",
                unzipFolderPath = "src/test/resources/files/unzip",
                unzipTxtPath = "src/test/resources/files/unzip/1password.txt",
                expectedText = "Hello all peoples!",
                password = "123";

        unzipWithPassword(zipFilePath, unzipFolderPath, password);

        String actualData = getTextFromFile(unzipTxtPath);

        assertThat(actualData, containsString(expectedText));
    }

    @Test
    public void docTest() throws IOException, TikaException {
        String txtFilePath = "src/test/resources/files/kocbyru-kid.doc",
                expectedText = "Здоровый малыш";

        String actualData = getTextFromFile(txtFilePath);

        assertThat(actualData, containsString(expectedText));
    }
}
