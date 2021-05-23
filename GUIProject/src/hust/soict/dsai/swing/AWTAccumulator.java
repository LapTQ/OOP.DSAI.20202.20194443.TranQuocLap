package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {

    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {

        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an enteger:"));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The accumulated sum is:"));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
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
