package rifqimuhammadaziz.swing.view;

import javax.swing.*;

public class TargetForm {
    private JPanel rootTarget;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblAge;

    public void createLayout() {
        JFrame jFrame = new JFrame("Target Form");
        jFrame.setContentPane(rootTarget);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void receiveData(String firstName, String lastName, String age) {
        lblFirstName.setText(firstName);
        lblLastName.setText(lastName);
        lblAge.setText(age);
    }
}
