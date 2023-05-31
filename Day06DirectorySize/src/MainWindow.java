import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame {
    private JButton chooseButton;
    private JLabel sizeLabel;
    private JPanel mainPanel;

    public MainWindow() {
        super("Directory Size");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chooseButton = new JButton("Choose Directory");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(MainWindow.this);

                if (option == JFileChooser.APPROVE_OPTION) {
                    File directory = fileChooser.getSelectedFile();
                    long totalSize = computeDirectorySize(directory);
                    sizeLabel.setText("Total Size: " + totalSize + " KB");
                }
            }
        });

        sizeLabel = new JLabel("Size:");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(chooseButton, BorderLayout.CENTER);
        getContentPane().add(sizeLabel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private long computeDirectorySize(File directory) {
        long size = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    size += computeDirectorySize(file);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
