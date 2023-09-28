package lab03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private int failedAttempts;

    public LoginWin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));
        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(30);
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(30);
        JButton loginButton = new JButton("Login");
        
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("marcus") && String.valueOf(password).equals("president")) {
                    JOptionPane.showMessageDialog(LoginWin.this, "Login successful!");
                    dispose();
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
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        add(panel);
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