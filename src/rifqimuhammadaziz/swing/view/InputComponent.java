package rifqimuhammadaziz.swing.view;

import rifqimuhammadaziz.swing.entity.Department;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InputComponent {
    private JTextField textField1;
    private JTextArea textArea1;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JCheckBox readCheckBox;
    private JCheckBox musicCheckBox;
    private JCheckBox sportCheckBox;
    private JSlider slider1;
    private JComboBox<String> comboBox1;
    private JComboBox<Department> comboBox2;
    private JPanel rootPanel;

    public InputComponent() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "S2 Komputer", 2023));
        departments.add(new Department(2, "S2 Ekonomi", 2022));
        departments.add(new Department(3, "S2 Bahasa Inggris", 2024));
        departments.add(new Department(4, "S2 Psikologi", 2025));
        DefaultComboBoxModel<Department> departmentDefaultComboBoxModel =
                new DefaultComboBoxModel<>(departments.toArray(new Department[0]));
        comboBox2.setModel(departmentDefaultComboBoxModel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputComponent");
        frame.setContentPane(new InputComponent().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
