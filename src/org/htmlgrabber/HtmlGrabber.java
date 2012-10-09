package org.htmlgrabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

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
     *
     * Выполняет загрузку старницы
     */
    public void parsePage() throws Exception {
        document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .timeout(3000)
                .get();
    }

    /**
     * Возвращает все ссылки на странице
     * @return Карту ссылок, ключ - текст, значение - сама ссылка
     */
    public HashMap<String, String> parseAllLinks() {
        HashMap<String, String> linksMap = new HashMap<String, String>();

        Element body = document.getElementsByTag("body").get(0); // получаем тело
        Elements links = body.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            linksMap.put(linkText, linkHref);
        }

        return linksMap;
    }

    public Document getDocument() {
        return document;
    }
}


