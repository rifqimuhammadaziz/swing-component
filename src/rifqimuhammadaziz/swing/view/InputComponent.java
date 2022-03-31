package rifqimuhammadaziz.swing.view;

import rifqimuhammadaziz.swing.entity.Department;
import rifqimuhammadaziz.swing.entity.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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
    private JSplitPane rootPanel;
    private JTable table1;

    public InputComponent() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "S2 Komputer", 2023));
        departments.add(new Department(2, "S2 Ekonomi", 2022));
        departments.add(new Department(3, "S2 Bahasa Inggris", 2024));
        departments.add(new Department(4, "S2 Psikologi", 2025));

        DefaultComboBoxModel<Department> departmentDefaultComboBoxModel =
                new DefaultComboBoxModel<>(departments.toArray(new Department[0]));
        comboBox2.setModel(departmentDefaultComboBoxModel);

        List<Student> students = new ArrayList<>();
        students.add(new Student("10813", "Bagas Dwi Yulianto", true, departments.get(2), 5));
        students.add(new Student("10817", "Rifqi Virgiawan", true, departments.get(3), 3));
        students.add(new Student("10818", "Rizqi Virgiawan", true, departments.get(3), 3));
        students.add(new Student("10819", "Rifqi Muhammad Aziz", true, departments.get(3), 4));
        students.add(new Student("10820", "Bayu Prasetyo Wibowo", true, departments.get(3), 2));
        students.add(new Student("10821", "Fiqi Arifianto", true, departments.get(3), 1));

        StudentTableModel studentTableModel = new StudentTableModel(students);
        table1.setModel(studentTableModel);
        table1.setAutoCreateRowSorter(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputComponent");
        frame.setContentPane(new InputComponent().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class StudentTableModel extends AbstractTableModel {

        private final String[] COLUMNS = {"ID", "NAME", "GENDER", "PROG. SKILL"};
        private List<Student> students;

        public StudentTableModel(List<Student> students) {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> students.get(rowIndex).getId();
                case 1 -> students.get(rowIndex).getName();
                case 2 -> students.get(rowIndex).isMale();
                case 3 -> students.get(rowIndex).getProgrammingSkill();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            } else {
                return Object.class;
            }
        }
    }
}
