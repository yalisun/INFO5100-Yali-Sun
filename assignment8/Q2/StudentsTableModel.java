package assignment8.Q2;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentsTableModel implements TableModel {

    private StudentsManagerImpl studentsManager;

    public StudentsTableModel(StudentsManagerImpl studentsManager) {
        this.studentsManager = studentsManager;
    }

    @Override
    public int getRowCount() {
        return studentsManager.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "Age";
            case 3:
                return "Gender";
            default:
                throw new IllegalArgumentException("Error!");
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Student student = studentsManager.getStudents().get(i);
        switch (i1) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getAge();
            case 3:
                return student.getGender();
            default:
                throw new IllegalArgumentException("Error!");
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
