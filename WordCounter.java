import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        // Set up the frame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        // Layout setup
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        // Button action listener
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Word Count: " + wordCount);
            }
        });
    }

    // Method to count words
    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounter().setVisible(true);
            }
        });
    }
}