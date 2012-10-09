package org.htmlgrabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * org.htmlgrabber
 * User: sanych
 * Date: 09.10.12
 * Time: 20:46
 */
public class HtmlGrabber {

    /**
     * URL страницы, которую надо загрузить
     */
    private String url;
    /**
     * Загруженная и обработанная страница
     */
    private Document document;

    /**
     * Конструктор объекта для граббинга страниц
     * @param url Адрес страницы, которую надо загрузить для анализа
     */
    public HtmlGrabber(String url) {
        this.url = url;
    }

    /**
     * Выполняет загрузку старницы
     */
    public void parsePage() throws Exception {
        document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .timeout(3000)
                .get();
    }

    public Document getDocument() {
        return document;
    }
}


