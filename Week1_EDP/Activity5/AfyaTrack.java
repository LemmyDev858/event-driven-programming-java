
import javax.swing.*;
import java.awt.*;

public class AfyaTrack extends JFrame {

    // Variables used to keep track of the user's daily fitness activities.
    private int steps = 0;
    private int waterGlasses = 0;
    private boolean workoutActive = false;

    // Labels used to display the current fitness information on the screen.
    private final JLabel stepsLabel = new JLabel("Steps: 0");
    private final JLabel waterLabel = new JLabel("Water: 0 glasses");
    private final JLabel workoutLabel = new JLabel("Workout: Not started");

    // Text area used to show a history of the user's activities.
    private final JTextArea activityLog = new JTextArea(8, 30);

    // Constructor: sets up the application window and its components.
    public AfyaTrack() {

        // Set the window title, closing behaviour and layout.
        setTitle("AfyaTrack - Kenyan Fitness Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the heading displayed at the top of the application.
        JLabel heading = new JLabel("AfyaTrack - Your Daily Fitness Companion", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        add(heading, BorderLayout.NORTH);

        // Create a dashboard to display steps, water intake and workout status.
        JPanel dashboard = new JPanel(new GridLayout(3, 1, 8, 8));
        dashboard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Set the font size and style of the dashboard labels.
        stepsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        waterLabel.setFont(new Font("Arial", Font.BOLD, 16));
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Add the three fitness labels to the dashboard panel.
        dashboard.add(stepsLabel);
        dashboard.add(waterLabel);
        dashboard.add(workoutLabel);

        // Make the activity log read-only so users cannot edit its messages.
        activityLog.setEditable(false);

        // Allow long messages to continue on the next line.
        activityLog.setLineWrap(true);
        activityLog.setWrapStyleWord(true);

        // Create the centre panel to hold the dashboard and activity log.
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.add(dashboard, BorderLayout.NORTH);

        // Add a scroll bar so users can view the activity history.
        centerPanel.add(new JScrollPane(activityLog), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Create a button that allows the user to record 500 steps.
        JButton addStepsButton = new JButton("Add 500 Steps");

        // ActionListener runs this code whenever the button is clicked.
        addStepsButton.addActionListener(e -> {
            steps += 500; // Increase the step count by 500.
            updateDisplay(); // Refresh the dashboard with the new step count.
            logEvent("Recorded 500 steps."); // Record the action in the activity log.
        });

        // Create a button for recording one glass of water.
        JButton addWaterButton = new JButton("Add 1 Glass of Water");

        // Run this code when the user clicks the water button.
        addWaterButton.addActionListener(e -> {
            waterGlasses++; // Increase the water count by one glass.
            updateDisplay(); // Update the water information on the dashboard.
            logEvent("Recorded one glass of water."); // Record the action.
        });

        // Create a toggle button for starting and stopping a workout.
        JToggleButton workoutButton = new JToggleButton("Start Workout");

        // This event handler runs whenever the workout button is clicked.
        workoutButton.addActionListener(e -> {

            // Check whether the button is selected and update the workout status.
            workoutActive = workoutButton.isSelected();

            // Change the button text depending on the workout status.
            workoutButton.setText(workoutActive ? "Stop Workout" : "Start Workout");

            // Refresh the dashboard to show the current workout status.
            updateDisplay();

            // Record whether the user started or stopped the workout.
            logEvent(workoutActive ? "Workout started." : "Workout stopped.");
        });

        // Create a button for resetting the daily fitness information.
        JButton resetButton = new JButton("Reset Day");

        // This event handler runs when the user clicks the reset button.
        resetButton.addActionListener(e -> {

            // Reset all fitness tracking variables to their initial values.
            steps = 0;
            waterGlasses = 0;
            workoutActive = false;

            // Return the workout button to its original, unselected state.
            workoutButton.setSelected(false);
            workoutButton.setText("Start Workout");

            // Refresh the dashboard and record that the information was reset.
            updateDisplay();
            logEvent("Daily tracking values were reset.");
        });

        // Create a panel to arrange the four buttons in two rows and two columns.
        JPanel controls = new JPanel(new GridLayout(2, 2, 8, 8));
        controls.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Add all the buttons to the controls panel.
        controls.add(addStepsButton);
        controls.add(addWaterButton);
        controls.add(workoutButton);
        controls.add(resetButton);

        // Place the controls panel at the bottom of the application window.
        add(controls, BorderLayout.SOUTH);

        // Set the window size and position it in the centre of the screen.
        setSize(520, 480);
        setLocationRelativeTo(null);

        // Display an initial message in the activity log.
        logEvent("AfyaTrack is ready.");
    }

    // Updates the dashboard labels whenever the fitness information changes.
    private void updateDisplay() {

        // Display the current number of steps.
        stepsLabel.setText("Steps: " + steps);

        // Display the current number of glasses of water.
        waterLabel.setText("Water: " + waterGlasses + " glasses");

        // Display whether a workout is active or not.
        workoutLabel.setText("Workout: " + (workoutActive ? "Active" : "Not active"));
    }

    // Adds a message to the activity log whenever the user performs an action.
    private void logEvent(String message) {

        // Add the new message on a separate line.
        activityLog.append(message + "\n");

        // Automatically move to the latest message in the activity log.
        activityLog.setCaretPosition(activityLog.getDocument().getLength());
    }

    public static void main(String[] args) {

        // Start the application on the Event Dispatch Thread (EDT).
        // This is the recommended way to create and display Swing applications.
        SwingUtilities.invokeLater(() -> new AfyaTrack().setVisible(true));
    }
}
