import org.htmlgrabber.gui.MainForm;

import javax.swing.*;

/**
  * User: sanych
 * Date: 23.08.12
 * Time: 22:40
 */
public class Launcher {

    public static void main(String[] args) {

        // Устанавливаем тему для Look&Feel
        setLF();

        MainForm mf = new MainForm();
        mf.showGUI();

    }

    /**
     * Установка системной темы для визуального отображения элементов управления
     */
    private static void setLF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
