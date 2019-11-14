package assignment8.Q2;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {

    public BaseFrame() {
        create();
        Container container = getContentPane();
        add(container);
        addListeners();
        makeItVisible();
    }

    public void makeItVisible() {
        setTitle("Student Information System");
        setSize(500, 600);
        setVisible(true);
    }

    public abstract void add(Container con);

    public abstract void addListeners();

    public abstract void create();

}
