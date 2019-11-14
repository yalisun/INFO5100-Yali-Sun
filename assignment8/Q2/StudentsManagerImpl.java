package assignment8.Q2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentsManagerImpl extends Component {

    private Map<String, Student> studentMap = new HashMap<String, Student>();
    private String filePath = "src/assignment8/Q2/student.txt";

    public StudentsManagerImpl() throws FileNotFoundException {
        readFile();
    }

    public void readFile() throws FileNotFoundException {
        File f = new File(filePath);
        if (f.exists() == false) {
            return;
        }
        FileInputStream fs = new FileInputStream(f);
        Scanner s = new Scanner(fs);
        while (s.hasNext()) {
            String l = s.nextLine();
            String[] tokens = l.split("\\|");
            Student student = new Student(tokens[0], tokens[1], tokens[2], tokens[3]);
            this.addStudentIntoMap(student);
        }
        s.close();
    }

    public void addStudentIntoMap(Student student) {
        String id = student.getId();
        Student stu = studentMap.get(id);
        if (stu == null) {
            studentMap.put(student.getId(), student);
        } else {
            throw new RuntimeException("Student " + student.getName() + " is already added!");
        }
    }

    public void addStudent(Student student) throws RuntimeException, IOException {
        String id = student.getId();
        Student stu = studentMap.get(id);
        if (stu == null) {
            studentMap.put(student.getId(), student);
        } else {
            throw new RuntimeException("Student " + student.getName() + " is already added!");
        }
        writeFile(student);
    }

    private void writeFile(Student student) throws IOException {
        try {
            FileOutputStream file = new FileOutputStream(filePath, true);
            PrintStream ps = new PrintStream(file);
            ps.println(student.getId() + "|" + student.getName() + "|" + student.getAge() + "|" + student.getGender());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getStudentCount() {
        return studentMap.size();
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    public void display() {
        System.out.println(studentMap.values());
    }
}
