package lab03;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Feature3 extends JFrame {

private JPanel contentPane;
private JLabel label1,label2,label3, s1,s2,s3;
private JTextField name;
private JComboBox<String> course1, section;
private String courses[] = {"Computer Engineering","Computer Science", "Civil Engineering"};
private String sections[] = {"1-1","1-2", "1-3", "1-1", "1-2", "1-3", "1-1", "1-2"};
private JButton input;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
	Feature3 frame = new Feature3();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public Feature3() {
setTitle("Feature3");
setBackground(new Color(255, 255, 255));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 500, 300);
contentPane = new JPanel();
contentPane.setBackground(new Color(222, 184, 135));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);
label1 = new JLabel("Name");
label1.setBounds(18, 10, 39, 19);
label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
getContentPane().add(label1);
name = new JTextField(20);
name.setBounds(82, 11, 175, 20);
getContentPane().add(name);
label2 = new JLabel("Course");
label2.setBounds(18, 40, 45, 19);
label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
getContentPane().add(label2);
course1 = new JComboBox(courses);
course1.setSelectedItem(null);
course1.setBounds(82, 41, 175, 20);
getContentPane().add(course1);
label3 = new JLabel("Section");
label3.setBounds(18, 70, 46, 19);
label3.setHorizontalAlignment(SwingConstants.CENTER);
label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
getContentPane().add(label3);
section = new JComboBox(sections);
section.setSelectedItem(null);
section.setBounds(82, 72, 62, 20);
getContentPane().add(section);
input = new JButton("Submit");
input.setBounds(18, 125, 90, 45);
input.setFont(new Font("Tahoma", Font.BOLD, 14));
input.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent event) {
String nameInput = name.getText();
String courseInput = (String) course1.getSelectedItem();
String sectionInput = (String) section.getSelectedItem();


if(nameInput.isEmpty()|| courseInput.isEmpty()|| sectionInput.isEmpty()) {
JOptionPane.showMessageDialog(Feature3.this, "Fill up all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
}else {
JOptionPane.showMessageDialog(Feature3.this, "Complete", "Verify", JOptionPane.INFORMATION_MESSAGE);
}


}
});
getContentPane().add(input);
}

}