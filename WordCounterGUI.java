import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterGUI() {
        // Set up the JFrame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count will be displayed here.");

        // Set layout
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        add(buttonPanel, BorderLayout.SOUTH);

        add(resultLabel, BorderLayout.NORTH);

        // Attach event listener to the countButton
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String inputText = textArea.getText();
        int wordCount = WordCounter.countWords(inputText);
        resultLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterGUI().setVisible(true);
            }
        });
    }
}

class WordCounter {
    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
}
