import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

/**
 * This class provides a JTextField that only accepts valid numbers.
 *
 * @author Leo Bernard
 * @version 2013-02-13
 */
public class JDoubleTextField extends JTextField {
    public Color defColor;
    private boolean canUseMinus = true;
    public static final char colon = ',';

    /**
     * Initializes the JDoubleTextField with standard parameters
     */
    public JDoubleTextField() {
        super("0" + colon + "0");
        doInit();
    }

    /**
     * Initializes the JDoubleTextField with the given text
     * @param text the text that's shown inside the JDoubleTextField
     */
    public JDoubleTextField(String text) {
        super(text);
        doInit();
    }

    /**
     * Initializes the JDoubleTextField and decides if negative values may be used inside it
     * @param canUseMinus may negative values be used inside the JDoubleTextField
     */
    public JDoubleTextField(boolean canUseMinus) {
        super("0" + colon + "0");
        this.canUseMinus = canUseMinus;
        doInit();
    }

    /**
     * Initializes the JDoubleTextField with the given text and decides if negative values may be used inside it
     * @param text the text that's shown inside the JDoubleTextField
     * @param canUseMinus may negative values be used inside the JDoubleTextField
     */
    public JDoubleTextField(String text, boolean canUseMinus) {
        super(text);
        this.canUseMinus = canUseMinus;
        doInit();
    }

    /**
     * Resets the background of the JDoubleTextField to the System default
     */
    public void resetBackground(){
        this.setBackground(defColor);
    }

    /**
     * Initializes the JDoubleTextField
     */
    public void doInit(){
        defColor = this.getBackground();

        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();

                if (((key < '0' || key > '9') && key != colon && key != '-') ||
                        (key == colon && ((JTextField) e.getSource()).getText().contains(String.valueOf(colon))) ||
                        (key == '-' && (((JTextField) e.getSource()).getText().contains("-") ||
                         !canUseMinus || ((JTextField) e.getSource()).getCaretPosition() != 0)))
                {
                    e.setKeyChar('\0');
                }
            }

            public void keyPressed(KeyEvent e) {
                // Nothing to do here
            }

            public void keyReleased(KeyEvent e) {
                // Nothing to do here either
            }
        });
    }
}
