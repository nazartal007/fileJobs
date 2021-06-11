package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class TxtFileTests {
    @Test
    public void assertTextInTxt() throws IOException {
        String txtFilePath = "./src/test/resources/files/1.txt",
                expectedText = "Hello all peoples!";

        String actualData = readTextFromPath(txtFilePath);

        assertThat(actualData, containsString(expectedText));
    }

    @Test
    public void canAssertThatPdfContainsText() throws IOException {
        String pdfFilePath = "src/test/resources/files/Как скачать файл с помощью Selenide.pdf",
                expectedText = "Как скачать файл с помощью Selenide";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedText));
    }

    @Test
    public void canAssertThatXslContainsText() throws IOException {
        String xlsFilePath = "src/test/resources/files/file_example_XLS_10.xls",
                expectedText = "France";

        XLS xls = getXls(xlsFilePath);
        String country = xls.excel.getSheetAt(0).getRow(3).getCell(4).toString();
        assertThat(country, containsString(expectedText));
    }
}
