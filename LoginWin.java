package lab03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private int failedAttempts;

    private Feature2 window2;
    private void openFeature2() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window2 = new Feature2();
                window2.setVisible(true);
            }
        });
    }
    
    public LoginWin() {
        setTitle("Login");
        setSize(534, 284);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(32, 33, 90, 29);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        usernameField = new JTextField(30);
        usernameField.setBounds(32, 63, 451, 29);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(32, 114, 86, 29);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField = new JPasswordField(30);
        passwordField.setBounds(32, 143, 451, 29);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 183, 194, 29);
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("marcus") && String.valueOf(password).equals("president")) {
                    dispose();
                    openFeature2();
                } else {
                    failedAttempts++;
                    if (failedAttempts >= 3) {
                        JOptionPane.showMessageDialog(LoginWin.this, "Too many attempts; TERMINATING PROGRAM!");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(LoginWin.this, "Invalid username or password. Please try again.");
                    }
                }

                usernameField.setText("");
                passwordField.setText("");
            }
        });

        panel.setLayout(null);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginWin();
            }
        });
    }
}