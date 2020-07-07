package com.bl.selenium;

import com.bl.selenium.base.SeleniumBasicBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PDFReader extends SeleniumBasicBase {

    @Test
    public void readPDF() throws IOException {
        initializeBase();
        webDriver.get(properties.getProperty("pdfurl"));
        String currentUrl = webDriver.getCurrentUrl();
        // url initialization
        URL url=new URL(currentUrl);
        InputStream is=url.openStream();
        BufferedInputStream fileParse=new BufferedInputStream(is);
        //load as pdf document
        PDDocument pd=PDDocument.load(fileParse);
        //get pdf document as text
        String pdfContent = new PDFTextStripper().getText(pd);
        System.out.println(pdfContent);
        //verify the content of pdf
        Assert.assertTrue(pdfContent.contains("Employment History"));
        Assert.assertTrue(pdfContent.contains("Education"));
    }
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
