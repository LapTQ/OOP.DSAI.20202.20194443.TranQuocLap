package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class Exercise225 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        
        strNum1 = JOptionPane.showInputDialog(null, "Please input the 1st number:", "Operation", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the 2nd number:", "Operation", JOptionPane.INFORMATION_MESSAGE);

        double result = Double.parseDouble(strNum1) % Double.parseDouble(strNum2);
        
        JOptionPane.showMessageDialog(null, result, "Result of the quotient operationg", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}