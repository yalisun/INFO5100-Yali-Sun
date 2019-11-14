package assignment8.Q1;

import javax.swing.*;
import java.awt.*;

public class Calculator extends BaseFrame {

    private JButton[] digitButtons;
    private JButton acButton, ceButton, deleteButton, equalButton;
    private JButton divideButton, multiplyButton, minusButton, plusButton;
    private JTextField displayField;

    private int previousNumber;
    private int currentNumber;
    private Operation operation;

    @Override
    public void create() {
        digitButtons = new JButton[10];
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
        }

        acButton = new JButton("AC");
        ceButton = new JButton("CE");
        deleteButton = new JButton("delete");
        divideButton = new JButton("÷");
        multiplyButton = new JButton("x");
        minusButton = new JButton("-");
        plusButton = new JButton("+");
        equalButton = new JButton("=");

        displayField = new JTextField(20);
        displayField.setEditable(false);
        displayField.setFont(new Font("Helvetica", Font.PLAIN, 40));

        clearAll();
    }

    @Override
    public void add(Container con) {
        GridLayout gl = new GridLayout(2, 0);
        con.setLayout(gl);

        con.add(displayField);
        con.add(createPanel());
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        // row 1
        panel.add(acButton);
        panel.add(ceButton);
        panel.add(deleteButton);
        panel.add(divideButton);
        // row 2
        for (int i = 7; i <= 9; i++) {
            panel.add(digitButtons[i]);
        }
        panel.add(multiplyButton);
        // row 3
        for (int i = 4; i <= 6; i++) {
            panel.add(digitButtons[i]);
        }
        panel.add(minusButton);
        // row 4
        for (int i = 1; i <= 3; i++) {
            panel.add(digitButtons[i]);
        }
        panel.add(plusButton);
        // row 5
        panel.add(new JLabel());
        panel.add(digitButtons[0]);
        panel.add(new JLabel());
        panel.add(equalButton);

        return panel;
    }

    @Override
    public void addListeners() {
        for (int i = 0; i < digitButtons.length; i++) {
            final int digit = i;
            digitButtons[i].addActionListener((e) -> enterDigit(digit));
        }

        divideButton.addActionListener((e) -> enterOperation(Operation.DIVIDE));
        multiplyButton.addActionListener((e) -> enterOperation(Operation.MULTIPLE));
        minusButton.addActionListener((e) -> enterOperation(Operation.MINUS));
        plusButton.addActionListener((e) -> enterOperation(Operation.PLUS));

        acButton.addActionListener((e) -> clearAll());
        ceButton.addActionListener((e) -> clearEntry());
        deleteButton.addActionListener((e) -> backspace());
        equalButton.addActionListener((e) -> equal());
    }

    private void equal() {
        switch (operation) {
//            case NONE:
//                break;
            case PLUS:
                currentNumber += previousNumber;
                break;
            case MINUS:
                currentNumber = previousNumber - currentNumber;
                break;
            case MULTIPLE:
                currentNumber *= previousNumber;
                break;
            case DIVIDE:
                if (currentNumber == 0) {
                    displayField.setText("Not a number");
                    return;
                } else {
                    currentNumber = previousNumber / currentNumber;
                }
        }
        updateDisplay();
        operation = Operation.NONE;
    }

    private void backspace() {
        currentNumber /= 10;
        updateDisplay();
    }

    private void clearEntry() {
        currentNumber = 0;
        updateDisplay();
    }

    private void clearAll() {
        currentNumber = 0;
        previousNumber = 0;
        operation = Operation.NONE;
        updateDisplay();
    }

    private void enterDigit(int digit) {
        currentNumber = currentNumber * 10 + digit;
        updateDisplay();
    }

    private void enterOperation(Operation operation) {
        previousNumber = currentNumber;
        currentNumber = 0;
        this.operation = operation;
    }

    private void updateDisplay() {
        displayField.setText(String.valueOf(currentNumber));
    }

    public static void main(String[] args) {
        new Calculator();
    }

    private enum Operation {
        DIVIDE,
        MULTIPLE,
        MINUS,
        PLUS,
        NONE
    }

}
