package rifqimuhammadaziz.swing.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtAge;
    private JButton btnOpenSecondForm;
    private JButton btnOpenOptionPane;
    private JPanel JPanel;
    private JPanel rootPanel;

    public MainForm() {
        btnOpenOptionPane.addActionListener(e -> {
            JOptionPane.showMessageDialog(rootPanel, "Hello from JOptionPane", "Information", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(rootPanel, "Error on message", "Error", JOptionPane.ERROR_MESSAGE);
            int result = JOptionPane.showConfirmDialog(rootPanel, "Are you sure want to continue?");
            if (result == JOptionPane.YES_OPTION) {
                String message = JOptionPane.showInputDialog("Input your message: ");
                JOptionPane.showMessageDialog(rootPanel, "Inputted message: " + message, "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnOpenSecondForm.addActionListener(e -> {
            TargetForm targetForm = new TargetForm();
            targetForm.createLayout();
            targetForm.receiveData(txtFirstName.getText(), txtLastName.getText(), txtAge.getText());
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
