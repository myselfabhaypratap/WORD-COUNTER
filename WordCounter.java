import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 40);
        resultLabel = new JLabel("Number of Words: 0");

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textArea.getText();
                int wordCount = countWords(inputText);
                resultLabel.setText("Number of Words: " + wordCount);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(countButton);
        panel.add(resultLabel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(textArea, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private int countWords(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        return tokenizer.countTokens();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounter();
            }
        });
    }
}
