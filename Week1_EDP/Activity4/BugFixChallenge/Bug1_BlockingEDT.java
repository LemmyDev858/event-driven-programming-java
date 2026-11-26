import javax.swing.*;


public class Bug1_BlockingEDT extends JFrame {
    private JLabel statusLabel;
    private JButton processButton;

    public Bug1_BlockingEDT() {
        setTitle("Bug 1 - Blocking EDT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        statusLabel = new JLabel("Ready");
        processButton = new JButton("Process");

        processButton.addActionListener(e -> {
            processButton.setEnabled(false);
            statusLabel.setText("Processing...");

            // Bug fix: long operation runs in a background thread to avoid blocking the EDT.
            new Thread(() -> {
                try {
                    Thread.sleep(5000); // Simulates a long task.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                // Bug fix: Swing components are updated on the EDT.
                SwingUtilities.invokeLater(() -> {
                    statusLabel.setText("Done!");
                    processButton.setEnabled(true);
                });
            }).start();
        });

        add(statusLabel);
        add(processButton);
        setSize(320, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug1_BlockingEDT().setVisible(true));
    }
}
