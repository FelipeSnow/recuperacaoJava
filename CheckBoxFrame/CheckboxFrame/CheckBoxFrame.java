import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame {
    private JTextField textField;
    private JCheckBox boldCheckBox;
    private JCheckBox italiCheckBox;

    public CheckBoxFrame() {
        super("JCheckBox Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 20);
        add(textField);

        boldCheckBox = new JCheckBox();
        italiCheckBox = new JCheckBox();

        add(boldCheckBox);
        add(italiCheckBox);

        CheckBoxHandler handler = new CheckBoxHandler();
        boldCheckBox.addItemListener(handler);
        italiCheckBox.addItemListener(handler);

    }

    private class CheckBoxHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Font font = null;
            if (boldCheckBox.isSelected() && italiCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            else if (italiCheckBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            else
                font = new Font("Serif", Font.PLAIN, 14);

            textField.setFont(font);
        }

    }
}
