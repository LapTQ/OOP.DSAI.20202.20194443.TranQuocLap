package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {

    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an integer:"));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The accumulated sum is:"));

        tfOutput = new JTextField(10);
        cp.add(tfOutput);
        tfOutput.setEditable(false);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int n = Integer.parseInt(tfInput.getText());
            sum += n;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
