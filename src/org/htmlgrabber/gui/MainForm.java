package org.htmlgrabber.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * org.htmlgrabber.gui
 * User: sanych
 * Date: 09.10.12
 * Time: 20:46
 */
public class MainForm {

    private JFrame frMain;

    private JPanel paMain;
    private JTextField teUrl;
    private JButton btnClear;
    private JButton btnParse;
    private JLabel laLinksCount;
    private JTable tableLinks;

    private static final String CAPTION_MAIN_FORM = "Анализатор ссылок";

    /**
     * Очистка поля ввода
     */
    private ClearInputAction actClearInput = new ClearInputAction(btnClear.getText());

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

        initActions(); // блоки действий
    }

    /**
     * Проводит инициализацию блоков действий
     */
    private void initActions() {
        btnClear.setAction(actClearInput);
    }

    /**
     * Отображение графического интерфейса
     */
    public void showGUI() {
        frMain.setVisible(true);
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
            //
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
            teUrl.setText("");
        }
    }
}
