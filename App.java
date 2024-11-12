/*
*
* @author Samet Senturk
* @version 1.1
* @date 11-12-2024
*
* */



//For GUI.
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//For Regex.
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//For Text and Fonts
import java.awt.BorderLayout;
import java.awt.Font;


public class App {
    public static void main(String[] args) {
        buttonpanel();
    }

    public static void buttonpanel(){

        JFrame frame = new JFrame("App 1.1 - Samet Senturk");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JLabel titleLabel = new JLabel("Untitled App 1.1 - It'll be developed.", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel rulesLabel = new JLabel("<html>Password must contain:<br>- At least 1 uppercase letter<br>- At least 2 digits<br>- Minimum 5 characters</html>", SwingConstants.CENTER);
        rulesLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(rulesLabel, BorderLayout.CENTER);


        frame.setVisible(true);

        JButton WordGuessApp = new JButton("Word Guess App");
        JButton ValidPassword = new JButton("Password Generator");

        WordGuessApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordguess();
            }
        });

        ValidPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValidPassword("");
            }
        });

        panel.add(WordGuessApp);
        panel.add(ValidPassword);

        frame.add(panel);
        frame.setVisible(true);


    }

    public static void wordguess(){
        String word = JOptionPane.showInputDialog("Enter Word: ");
        StringBuilder dot = new StringBuilder("*".repeat(word.length()));
        int count = 0;

        while (!dot.toString().equalsIgnoreCase(word)) {
            String guess = JOptionPane.showInputDialog("Enter Letter: " + dot + "\n Attempt: " + count);
            count++;

            if (guess.length() == 1 && word.contains(guess)) {
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toString(word.charAt(i)).equals(guess)) {
                        dot.setCharAt(i, word.charAt(i));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Matching Letter!");
            }
        }

        JOptionPane.showMessageDialog(null, "You guessed the word: " + word + "\n Attempt: " + count);
    }

    public static void ValidPassword(String Password){

        // Requiring Regex Knowledge.
        String regex = "^(?=.*[A-Z])(?=(.*\\d){2,}).{5,}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String password = JOptionPane.showInputDialog(null, "Enter Password:");

            if (password == null) {
                JOptionPane.showMessageDialog(null, "Password input cancelled.");
                break;
            }

            Matcher matcher = pattern.matcher(password);
            boolean check = matcher.matches();

            if (check) {
                JOptionPane.showMessageDialog(null, "Valid Password");
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Password. Must contain at least 1 uppercase letter \n 2 digits, and be at least 5 characters long.");
            }
        }
    }
}



