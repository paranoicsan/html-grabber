package org.htmlgrabber;

import junit.framework.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * org.htmlgrabber
 * User: sanych
 * Date: 09.10.12
 * Time: 21:50
 */
public class HtmlGrabberTest {

    private HtmlGrabber grabber;
    private static final String TEST_URL = "http://www.google.com";

    @BeforeMethod
    public void setUp() throws Exception {
        grabber = new HtmlGrabber(TEST_URL);
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testDefaultConstruction() {
        Assert.assertNotNull(grabber);
    }

    /**
     *  Должен скачать запросом страницу и пропарсить её DOM-структуру
     */
    @Test
    public void testParsePage() throws Exception {
        grabber.parsePage();
        Assert.assertNotNull(grabber.getDocument());
        String title = "Google";
        Assert.assertEquals(title, grabber.getDocument().title());
    }

}
