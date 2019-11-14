package assignment8.Q2;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentInformationSystem extends BaseFrame {

    private JLabel idLabel, nameLabel, genderLabel, ageLabel;
    private JTextField idField, nameField, ageField;
    private JComboBox genderBox;
    private JButton addButton;
    private JTable studentsTable;
    private StudentsTableModel studentsTableModel;
    private StudentsManagerImpl studentsManager;

    @Override
    public void add(Container con) {
        BorderLayout layout = new BorderLayout();
        con.setLayout(layout);
        con.add(new JScrollPane(studentsTable), BorderLayout.SOUTH);
        createPanel(con);
    }

    private void createPanel(Container con) {
        JPanel p = new JPanel(new GridLayout(5, 2));
        //row1
        p.add(idLabel);
        p.add(idField);
        //row2
        p.add(nameLabel);
        p.add(nameField);
        //row3
        p.add(ageLabel);
        p.add(ageField);
        //row4
        p.add(genderLabel);
        p.add(genderBox);
        //row5
        p.add(new JLabel());
        p.add(addButton);

        con.add(p, BorderLayout.NORTH);
    }

    @Override
    public void addListeners() {
        addButton.addActionListener((e) -> addButtonAction());
    }

    private void addButtonAction() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = genderBox.getSelectedItem().toString();
        JFrame frame = new JFrame();
        try {
            studentsManager.addStudent(new Student(id, name, age, gender));
            JOptionPane.showMessageDialog(frame, String.format("Successfully added new student with id %s", id));
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
        studentsTable.revalidate();
    }

    @Override
    public void create() {
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        ageLabel = new JLabel("Age:");
        genderLabel = new JLabel("Gender:");
        idField = new JTextField(15);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        genderBox = new JComboBox(new String[] {"Male", "Female"});
        addButton = new JButton("Submit");
        try {
            studentsManager = new StudentsManagerImpl();
            studentsTableModel = new StudentsTableModel(studentsManager);
        } catch (IllegalArgumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        studentsTable = new JTable(studentsTableModel);

    }

    public static void main(String[] args) {
        new StudentInformationSystem();
    }
}
