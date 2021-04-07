package hust.soict.dsai.lab01.JavaBasics;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?");

        JOptionPane.showMessageDialog(null, "You've confirm: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        System.exit(0);
    }
}