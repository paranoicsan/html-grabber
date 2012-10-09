package org.htmlgrabber.gui;

import org.htmlgrabber.HtmlGrabber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * org.htmlgrabber.gui
 * User: sanych
 * Date: 09.10.12
 * Time: 20:46
 */
public class MainForm {

    private static final String CAPTION_MAIN_FORM = "Анализатор ссылок";
    private static final String LABEL_LINKS_COUNT = "Найдено ссылок: %s";


    private JFrame frMain;
    private JPanel paMain;
    private JTextField teUrl;
    private JButton btnClear;
    private JButton btnParse;
    private JLabel laLinksCount;
    private JTable tableLinks;
    private JLabel laPageTitle;

    /**
     * Экземпляр граббера
     */
    private HtmlGrabber grabber;

    /**
     * Очистка поля ввода
     */
    private ClearInputAction actClearInput = new ClearInputAction(btnClear.getText());
    /**
     * Запуск парсера
     */
    private GrabAction actGrab = new GrabAction(btnParse.getText());

    public MainForm() {
        initGUI();
    }

    /**
     * Инициализация графического интерфейса
     */
    private void initGUI() {
        frMain = new JFrame(CAPTION_MAIN_FORM);
        frMain.setContentPane(paMain);
        frMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frMain.pack();
        frMain.setLocationRelativeTo(null);

        laPageTitle.setText("");
        laLinksCount.setText(String.format(LABEL_LINKS_COUNT, 0));

        initActions(); // блоки действий
    }

    /**
     * Проводит инициализацию блоков действий
     */
    private void initActions() {
        btnClear.setAction(actClearInput);
        btnParse.setAction(actGrab);
    }

    /**
     * Отображение графического интерфейса
     */
    public void showGUI() {
        frMain.setVisible(true);
    }

    /**
     * Запускает процесс граббинга
     */
    private void startGrab() {
        grabber = new HtmlGrabber(teUrl.getText());
        try {
            grabber.parsePage(); // запускаем процесс парсинга
            laPageTitle.setText(grabber.getDocument().title()); // выставляем название страницы
            makeOperations(); // выполняем настраиваемые операции
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Выполняет настраиваемые операции
     */
    private void makeOperations() {
        parseLinks();
    }

    /**
     * Обработка ссылок
     */
    private void parseLinks() {
        HashMap<String, String> links = grabber.parseAllLinks();
        String s = String.format(LABEL_LINKS_COUNT, links.size());
        laLinksCount.setText(s);
    }

    /**
     * Действие начала граббинга
     */
    private class GrabAction extends AbstractAction {
        /**
         * Действие для запуска граббера
         * @param name Название действия
         */
        private GrabAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Cursor cur = frMain.getCursor();
            frMain.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            try {
                startGrab();
            } finally {
                frMain.setCursor(cur);
            }
        }
    }

    /**
     * Действие для очистки поля ввода
     */
    private class ClearInputAction extends AbstractAction {
        /**
         * Действие для очистки поля ввода
         * @param name Название действия
         */
        private ClearInputAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            laPageTitle.setText("");
            laLinksCount.setText(String.format(LABEL_LINKS_COUNT, 0));
        }
    }
}
