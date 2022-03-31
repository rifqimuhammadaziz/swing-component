package rifqimuhammadaziz.swing.view;

import rifqimuhammadaziz.swing.entity.Department;
import rifqimuhammadaziz.swing.entity.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private JButton updateButton;
    private JButton resetButton;
    private JButton saveButton;

    private Student selectedStudent;
    private int selectedIndex;

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

        // SAVE BUTTON
        saveButton.addActionListener(e -> {
            Student student = new Student();
            student.setId(String.valueOf(new Random().nextInt()));
            student.setName(textField1.getText());
            student.setMale(maleRadioButton.isSelected());
            student.setProgrammingSkill(slider1.getValue());
            student.setDepartment((Department) comboBox2.getSelectedItem());
            if (musicCheckBox.isSelected()) {
                student.getHobbies().add(musicCheckBox.getText());
            } else if (readCheckBox.isSelected()) {
                student.getHobbies().add(readCheckBox.getText());
            } else if (sportCheckBox.isSelected()) {
                student.getHobbies().add(sportCheckBox.getText());
            }
            students.add(student);
            studentTableModel.fireTableDataChanged();
            resetTextfield();
        });

        // RESET BUTTON
        resetButton.addActionListener(e -> {
            resetTextfield();
        });

        // UPDATE BUTTON
        updateButton.addActionListener(e -> {
            selectedStudent.setId(String.valueOf(new Random().nextInt()));
            selectedStudent.setName(textField1.getText());
            selectedStudent.setMale(maleRadioButton.isSelected());
            selectedStudent.setProgrammingSkill(slider1.getValue());
            selectedStudent.setDepartment((Department) comboBox2.getSelectedItem());
            if (musicCheckBox.isSelected() && selectedStudent.getHobbies().stream().noneMatch(s -> s.equals(musicCheckBox.getText()))) {
                selectedStudent.getHobbies().add(musicCheckBox.getText());
            } else {
                selectedStudent.getHobbies().remove(musicCheckBox.getText());
            }

            if (readCheckBox.isSelected() && selectedStudent.getHobbies().stream().noneMatch(s -> s.equals(readCheckBox.getText()))) {
                selectedStudent.getHobbies().add(readCheckBox.getText());
            } else {
                selectedStudent.getHobbies().remove(readCheckBox.getText());
            }

            if (sportCheckBox.isSelected() && selectedStudent.getHobbies().stream().noneMatch(s -> s.equals(readCheckBox.getText()))) {
                selectedStudent.getHobbies().add(sportCheckBox.getText());
            } else {
                selectedStudent.getHobbies().remove(sportCheckBox.getText());
            }

            students.set(selectedIndex, selectedStudent);
            studentTableModel.fireTableDataChanged();
            resetTextfield();
        });

        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!table1.getSelectionModel().isSelectionEmpty()) {
                selectedIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
                selectedStudent = students.get(selectedIndex);
                if (selectedStudent != null) {
                    textField1.setText(selectedStudent.getName());
                    if (selectedStudent.isMale()) {
                        maleRadioButton.setSelected(true);
                    } else {
                        femaleRadioButton.setSelected(true);
                    }
                    readCheckBox.setSelected(selectedStudent.getHobbies().stream().anyMatch(s -> s.equals(readCheckBox.getText())));
                    musicCheckBox.setSelected(selectedStudent.getHobbies().stream().anyMatch(s -> s.equals(musicCheckBox.getText())));
                    sportCheckBox.setSelected(selectedStudent.getHobbies().stream().anyMatch(s -> s.equals(sportCheckBox.getText())));
                    slider1.setValue(selectedStudent.getProgrammingSkill());
                    comboBox2.setSelectedItem(selectedStudent.getDepartment());
                    saveButton.setEnabled(false);
                    updateButton.setEnabled(true);
                }
            }
        });
    }

    private void resetTextfield() {
        textField1.setText("");
        textArea1.setText("");
        readCheckBox.setSelected(false);
        musicCheckBox.setSelected(false);
        sportCheckBox.setSelected(false);
        table1.clearSelection();
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        selectedStudent = null;
        selectedIndex = -1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputComponent");
        frame.setContentPane(new InputComponent().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }

    private static class StudentTableModel extends AbstractTableModel {

        private final String[] COLUMNS = {"ID", "NAME", "GENDER", "PROG. SKILL", "DEPARTEMENT"};
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
                case 4 -> students.get(rowIndex).getDepartment().getName();
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
