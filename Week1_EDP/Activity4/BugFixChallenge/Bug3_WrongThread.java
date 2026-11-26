import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Bug3_WrongThread extends JFrame {
    private final JLabel timeLabel = new JLabel("Time: ");
    private final JButton startButton = new JButton("Start Clock");
    private volatile boolean running = false;

    public Bug3_WrongThread() {
        setTitle("Bug 3 - Fixed Wrong Thread");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        startButton.addActionListener(e -> {
            if (running) {
                running = false;
                startButton.setText("Start Clock");
                return;
            }

            running = true;
            startButton.setText("Stop Clock");

            Thread clockThread = new Thread(() -> {
                while (running) {
                    String currentTime = new Date().toString();

                    // Bug fix: Updated the label on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater.
                    SwingUtilities.invokeLater(() ->
                        timeLabel.setText("Time: " + currentTime)
                    );

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            clockThread.setDaemon(true);
            clockThread.start();
        });

        add(timeLabel);
        add(startButton);
        setSize(430, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug3_WrongThread().setVisible(true));
    }
}
