package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Laboratory3 extends JFrame {

    private JTextField inputTextField;
    private JTextArea outputTextArea;

    public Laboratory3() {
        setTitle("Reverse Sequence App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        inputTextField = new JTextField();
        inputTextField.setBounds(91, 43, 203, 20);
        mainPanel.add(inputTextField);

        outputTextArea = new JTextArea();
        outputTextArea.setMargin(new Insets(50, 120, 50, 50));
        outputTextArea.setBounds(21, 74, 342, 119);
        mainPanel.add(outputTextArea);

        JButton reverseButton = new JButton("Reverse");
        reverseButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        reverseButton.setBounds(133, 204, 115, 23);
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseSequence();
            }
        });
        mainPanel.add(reverseButton);

        getContentPane().add(mainPanel);
    }

    private void reverseSequence() {
        String input = inputTextField.getText();
        if (!validateInput(input)) {
            showErrorMessage("Error! Numbers separated by spaces only.");
            return;
        }

        List<String> numbers = Arrays.asList(input.split(" "));
        Collections.reverse(numbers);
        StringBuilder reversedSequence = new StringBuilder();
        for (String number : numbers) {
            reversedSequence.append(number).append(" ");
        }
        outputTextArea.setText(reversedSequence.toString());
    }

    private boolean validateInput(String input) {
        // Check if the input contains only numbers and spaces
        return input.matches("[0-9\\s]+");
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Laboratory3 app = new Laboratory3();
                app.setVisible(true);
            }
        });
    }
}