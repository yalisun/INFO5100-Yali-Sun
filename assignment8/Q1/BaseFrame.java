package assignment8.Q1;

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
        setTitle("Calculator");
        setSize(400, 300);
        setVisible(true);
    }

    public abstract void add(Container container);

    public abstract void addListeners();

    public abstract void create();

}
