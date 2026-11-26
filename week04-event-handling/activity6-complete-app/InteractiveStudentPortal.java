// ============================================================
// INTERACTIVE STUDENT PORTAL (Week 4 Complete Application)
// ============================================================
// Upgrades the Week 3 static Swing mockup into a complete
// event-driven desktop application using:
//   - ActionListener (menu items, sidebar navigation, buttons, JComboBox)
//   - ItemListener   (JCheckBox and JRadioButton state changes)
//   - DocumentListener (live search filtering & live character count)
//   - CardLayout     (switching views inside the main content area)
// ============================================================


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class InteractiveStudentPortal {

// Navigation sections shared between the View menu, sidebar buttons, and CardLayout
    private static final String[] MENU_ITEMS = {
        "Dashboard", "Courses", "Grades", "Fees", "Timetable", "Messages"
    };

    // Sample course catalog data: {Course Name, Semester}
    private static final String[][] ALL_COURSES = {
        {"CS 201 - Event-Driven Programming", "Semester 2"},
        {"CS 204 - Data Structures & Algorithms", "Semester 2"},
        {"CS 210 - Database Systems", "Semester 1"},
        {"CS 215 - Computer Networks", "Semester 1"},
        {"CS 220 - Software Engineering", "Semester 2"},
        {"MATH 202 - Linear Algebra", "Semester 1"}
    };

     // Instance fields store UI references so event handlers can update them anytime
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel centerCards;
    private JLabel statusLabel;
    private JButton[] navButtons;

    // EDT Rule: All Swing GUI creation must run on the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InteractiveStudentPortal().createAndShow());
    }

    /**
     * Builds the main window shell (MenuBar, Header, Sidebar, StatusBar, Center Cards)
     * and displays the portal.
     */
    private void createAndShow() {
        frame = new JFrame("University Student Portal \u2014 Interactive Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.setJMenuBar(createMenuBar());
        frame.add(createHeader(), BorderLayout.NORTH);
        frame.add(createSidebar(), BorderLayout.WEST);
        
        // Build statusBar before centerCards because initial panel setup calls updateStatus()
        frame.add(createStatusBar(), BorderLayout.SOUTH);
        frame.add(createCenterCards(), BorderLayout.CENTER);

         // Set initial active navigation state and default status bar message
        highlightNavButton("Dashboard");
        updateStatus("Logged in as student");
        frame.setVisible(true);
    }

    /**
     * Creates the top menu bar (File, View, Help) with ActionListeners on each menu item.
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File menu: refresh status or exit with confirmation
        JMenu fileMenu = new JMenu("File");
        JMenuItem refreshItem = new JMenuItem("Refresh");
        refreshItem.addActionListener(e -> updateStatus("Portal refreshed"));
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> confirmExit());
        fileMenu.add(refreshItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // View menu: mirrors the sidebar sections so users can switch views from the menu
        JMenu viewMenu = new JMenu("View");
        for (String item : MENU_ITEMS) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.addActionListener(e -> navigateTo(item));
            viewMenu.add(menuItem);
        }

        // Help menu: opens an informational dialog
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(
                frame,
                "Interactive Student Portal (Week 4 Complete App)\nBuilt with Java Swing Event Handling",
                "About Student Portal",
                JOptionPane.INFORMATION_MESSAGE
        ));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    /**
     * Builds the top banner containing the portal title (WEST) and Logout button (EAST).
     */
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(25, 55, 115));
        header.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel title = new JLabel("\uD83C\uDF93 University Student Portal");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(200, 60, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> confirmExit());

        header.add(title, BorderLayout.WEST);
        header.add(logoutButton, BorderLayout.EAST);
        return header;
    }

    /**
     * Builds the left navigation sidebar using one shared ActionListener across all buttons.
     */
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new GridLayout(MENU_ITEMS.length, 1, 5, 5));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(new Color(240, 240, 245));
        sidebar.setBorder(new EmptyBorder(15, 10, 15, 10));

        navButtons = new JButton[MENU_ITEMS.length];

        // Shared listener identifies the clicked section via e.getActionCommand() (button text)
        ActionListener navListener = e -> navigateTo(e.getActionCommand());

        for (int i = 0; i < MENU_ITEMS.length; i++) {
            JButton btn = new JButton(MENU_ITEMS[i]);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setBackground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.addActionListener(navListener);
            navButtons[i] = btn;
            sidebar.add(btn);
        }
        return sidebar;
    }

     /**
     * Creates the CardLayout container holding all six portal screens.
     * Only one card is visible at a time; navigateTo() switches between them.
     */
    private JPanel createCenterCards() {
        cardLayout = new CardLayout();
        centerCards = new JPanel(cardLayout);

        centerCards.add(createDashboardPanel(), "Dashboard");
        centerCards.add(createCoursesPanel(), "Courses");
        centerCards.add(createGradesPanel(), "Grades");
        centerCards.add(createFeesPanel(), "Fees");
        centerCards.add(createTimetablePanel(), "Timetable");
        centerCards.add(createMessagesPanel(), "Messages");

        return centerCards;
    }

    /**
     * Dashboard view: summary stat cards and an interactive notifications list
     * filtered by an ItemListener on a JCheckBox.
     */

    private JPanel createDashboardPanel() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        content.setBackground(Color.WHITE);

        JLabel welcome = new JLabel("Welcome, John Doe!");
        welcome.setFont(new Font("Arial", Font.BOLD, 22));
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(welcome);
        content.add(Box.createVerticalStrut(20));

        // 3 equal-width stat cards side by side
        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        cardsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        cardsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardsPanel.add(createStatCard("GPA", "3.75", new Color(100, 180, 100)));
        cardsPanel.add(createStatCard("Units", "48 / 56", new Color(80, 140, 220)));
        cardsPanel.add(createStatCard("Fees", "Paid", new Color(230, 150, 60)));
        content.add(cardsPanel);
        content.add(Box.createVerticalStrut(25));

        // Notifications header row with filter checkbox
        JPanel notifHeader = new JPanel(new BorderLayout());
        notifHeader.setBackground(Color.WHITE);
        notifHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        notifHeader.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel notifTitle = new JLabel("\uD83D\uDCE2 Notifications");
        notifTitle.setFont(new Font("Arial", Font.BOLD, 16));
        JCheckBox unreadOnlyCheck = new JCheckBox("Show urgent only");
        unreadOnlyCheck.setBackground(Color.WHITE);
        notifHeader.add(notifTitle, BorderLayout.WEST);
        notifHeader.add(unreadOnlyCheck, BorderLayout.EAST);
        content.add(notifHeader);
        content.add(Box.createVerticalStrut(10));

        // DefaultListModel holds list items dynamically so we can clear/repopulate on filter changes
        DefaultListModel<String> notifModel = new DefaultListModel<>();
        String[] allNotes = {
            "\u2022 [Urgent] Fee payment deadline: 30th October 2026",
            "\u2022 [Urgent] Library book due for return on 12th October",
            "\u2022 Exam results for Semester 2 have been released",
            "\u2022 Your timetable has been updated"
        };
        for (String note : allNotes) {
            notifModel.addElement(note);
        }

        JList<String> notifList = new JList<>(notifModel);
        notifList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane notifScroll = new JScrollPane(notifList);
        notifScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        content.add(notifScroll);

        // ItemListener fires whenever the checkbox is checked or unchecked
        unreadOnlyCheck.addItemListener(e -> {
            notifModel.clear();
            boolean urgentOnly = unreadOnlyCheck.isSelected();
            for (String note : allNotes) {
                if (!urgentOnly || note.contains("[Urgent]")) {
                    notifModel.addElement(note);
                }
            }
            updateStatus(urgentOnly ? "Showing urgent notifications" : "Showing all notifications");
        });

        return content;
    }

    /**
     * Courses view: combines live DocumentListener text search, ItemListener semester
     * radio buttons, and an ActionListener button for enrolling in the selected course.
     */
    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(Color.WHITE);
        JLabel heading = new JLabel("Course Catalog (Live Search)");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(heading, BorderLayout.NORTH);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setToolTipText("Type to filter courses...");

        // ButtonGroup ensures only one semester radio button can be selected at a time
        JRadioButton allRadio = new JRadioButton("All", true);
        JRadioButton sem1Radio = new JRadioButton("Semester 1");
        JRadioButton sem2Radio = new JRadioButton("Semester 2");
        allRadio.setBackground(Color.WHITE);
        sem1Radio.setBackground(Color.WHITE);
        sem2Radio.setBackground(Color.WHITE);

        ButtonGroup semGroup = new ButtonGroup();
        semGroup.add(allRadio);
        semGroup.add(sem1Radio);
        semGroup.add(sem2Radio);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        filterPanel.setBackground(Color.WHITE);
        filterPanel.add(new JLabel("Search:"));
        searchField.setPreferredSize(new Dimension(240, 28));
        filterPanel.add(searchField);
        filterPanel.add(allRadio);
        filterPanel.add(sem1Radio);
        filterPanel.add(sem2Radio);
        topPanel.add(filterPanel, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH);

        DefaultListModel<String> courseModel = new DefaultListModel<>();
        JList<String> courseList = new JList<>(courseModel);
        courseList.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(new JScrollPane(courseList), BorderLayout.CENTER);

         // Shared filter logic reused by both the search DocumentListener and radio ItemListeners
        Runnable refreshCourses = () -> {
            String query = searchField.getText().trim().toLowerCase();
            String selectedSem = sem1Radio.isSelected() ? "Semester 1"
                    : sem2Radio.isSelected() ? "Semester 2" : "All";
            courseModel.clear();
            for (String[] c : ALL_COURSES) {
                boolean matchesText = c[0].toLowerCase().contains(query);
                boolean matchesSem = selectedSem.equals("All") || c[1].equals(selectedSem);
                if (matchesText && matchesSem) {
                    courseModel.addElement(c[0] + " (" + c[1] + ")");
                }
            }
            updateStatus("Found " + courseModel.size() + " matching course(s)");
        };

        // DocumentListener attaches to the Document model to react on every keystroke/paste/delete
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { refreshCourses.run(); }
            @Override
            public void removeUpdate(DocumentEvent e) { refreshCourses.run(); }
            @Override
            public void changedUpdate(DocumentEvent e) { }
        });

         // Shared ItemListener triggers re-filtering when any semester radio button changes
        ItemListener semListener = e -> refreshCourses.run();
        allRadio.addItemListener(semListener);
        sem1Radio.addItemListener(semListener);
        sem2Radio.addItemListener(semListener);

        // Populate initial list
        refreshCourses.run();

        // ActionListener validates selection and confirms course enrollment
        JButton enrollBtn = new JButton("Enroll in Selected Course");
        enrollBtn.addActionListener(e -> {
            String selected = courseList.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(frame, "Please select a course first.",
                        "No Course Selected", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Enrolled in:\n" + selected,
                        "Enrollment Confirmed", JOptionPane.INFORMATION_MESSAGE);
                updateStatus("Enrolled in " + selected);
            }
        });
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setBackground(Color.WHITE);
        bottom.add(enrollBtn);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

     /**
     * Grades view: uses an ActionListener on a JComboBox to switch between semester transcripts.
     */
    private JPanel createGradesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        top.setBackground(Color.WHITE);
        JLabel heading = new JLabel("Academic Grades");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<String> semBox = new JComboBox<>(new String[]{"Semester 2 (2026)", "Semester 1 (2026)"});
        top.add(heading);
        top.add(Box.createHorizontalStrut(20));
        top.add(new JLabel("Term:"));
        top.add(semBox);
        panel.add(top, BorderLayout.NORTH);

        JTextArea gradesArea = new JTextArea();
        gradesArea.setEditable(false);
        gradesArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panel.add(new JScrollPane(gradesArea), BorderLayout.CENTER);

       // Updates displayed grades based on the selected dropdown index
        Runnable loadGrades = () -> {
            if (semBox.getSelectedIndex() == 0) {
                gradesArea.setText(
                    "CS 201  Event-Driven Programming       A   (3.90)\n" +
                    "CS 204  Data Structures & Algorithms   A-  (3.70)\n" +
                    "CS 220  Software Engineering           B+  (3.50)\n\n" +
                    "Term GPA: 3.70"
                );
            } else {
                gradesArea.setText(
                    "CS 210  Database Systems               A   (4.00)\n" +
                    "CS 215  Computer Networks              A-  (3.70)\n" +
                    "MATH 202 Linear Algebra                A-  (3.70)\n\n" +
                    "Term GPA: 3.80"
                );
            }
            updateStatus("Loaded grades for " + semBox.getSelectedItem());
        };
        semBox.addActionListener(e -> loadGrades.run());
        loadGrades.run();

        return panel;
    }

    /**
     * Fees view: demonstrates mutually exclusive JRadioButtons with ItemListener
     * to update payment instructions dynamically.
     */
    private JPanel createFeesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Payment");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(heading);
        panel.add(Box.createVerticalStrut(15));

        JLabel balanceLabel = new JLabel("Current Balance: $0.00 (Paid)");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        balanceLabel.setForeground(new Color(0, 128, 0));
        balanceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(balanceLabel);
        panel.add(Box.createVerticalStrut(15));

        JLabel methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(methodLabel);

        JRadioButton mpesa = new JRadioButton("M-Pesa", true);
        JRadioButton bank = new JRadioButton("Bank Transfer");
        JRadioButton card = new JRadioButton("Credit / Debit Card");
        mpesa.setBackground(Color.WHITE);
        bank.setBackground(Color.WHITE);
        card.setBackground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(mpesa);
        group.add(bank);
        group.add(card);

        JLabel methodInfo = new JLabel("Paybill: 123456 | Account: STUDENT-001");
        methodInfo.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Updates payment instructions whenever the user picks a different payment radio button
        ItemListener methodListener = e -> {
            if (mpesa.isSelected()) {
                methodInfo.setText("Paybill: 123456 | Account: STUDENT-001");
            } else if (bank.isSelected()) {
                methodInfo.setText("Bank: University Bank | Acc: 0100-554321");
            } else if (card.isSelected()) {
                methodInfo.setText("Card gateway ready (Visa / Mastercard)");
            }
            updateStatus("Payment method updated");
        };
        mpesa.addItemListener(methodListener);
        bank.addItemListener(methodListener);
        card.addItemListener(methodListener);

        panel.add(mpesa);
        panel.add(bank);
        panel.add(card);
        panel.add(Box.createVerticalStrut(10));
        panel.add(methodInfo);
        panel.add(Box.createVerticalStrut(15));

        JButton receiptBtn = new JButton("Download Fee Receipt");
        receiptBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        receiptBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Fee receipt generated for John Doe.",
                    "Receipt Ready", JOptionPane.INFORMATION_MESSAGE);
            updateStatus("Downloaded fee receipt");
        });
        panel.add(receiptBtn);

        return panel;
    }

    /**
     * Timetable view: uses a JComboBox ActionListener to display classes for the chosen day.
     */
    private JPanel createTimetablePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        top.setBackground(Color.WHITE);
        JLabel heading = new JLabel("Weekly Timetable");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<String> dayBox = new JComboBox<>(new String[]{"Monday", "Wednesday", "Friday"});
        top.add(heading);
        top.add(Box.createHorizontalStrut(20));
        top.add(new JLabel("Day:"));
        top.add(dayBox);
        panel.add(top, BorderLayout.NORTH);

        JLabel scheduleLabel = new JLabel("", SwingConstants.LEFT);
        scheduleLabel.setVerticalAlignment(SwingConstants.TOP);
        scheduleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        scheduleLabel.setBorder(new EmptyBorder(15, 10, 10, 10));
        panel.add(scheduleLabel, BorderLayout.CENTER);

        Runnable updateDay = () -> {
            String day = (String) dayBox.getSelectedItem();
            if ("Monday".equals(day)) {
                scheduleLabel.setText("<html><b>09:00 - 11:00</b> CS 201 Event-Driven Programming (Lab 3)<br><br><b>14:00 - 16:00</b> CS 204 Data Structures (Room B12)</html>");
            } else if ("Wednesday".equals(day)) {
                scheduleLabel.setText("<html><b>10:00 - 12:00</b> CS 220 Software Engineering (Hall A)<br><br><b>15:00 - 17:00</b> CS 201 Swing Workshop (Lab 2)</html>");
            } else {
                scheduleLabel.setText("<html><b>08:30 - 10:30</b> CS 204 Tutorial (Room B04)<br><br><b>11:00 - 13:00</b> Academic Advising</html>");
            }
            updateStatus("Viewing " + day + " timetable");
        };
        dayBox.addActionListener(e -> updateDay.run());
        updateDay.run();

        return panel;
    }

     /**
     * Messages view: live character counter (DocumentListener) + validated form submission (ActionListener).
     */
    private JPanel createMessagesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel heading = new JLabel("Send Message to Advisor (max 200 chars)");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(heading, BorderLayout.NORTH);

        JTextArea msgArea = new JTextArea(6, 40);
        msgArea.setLineWrap(true);
        msgArea.setWrapStyleWord(true);
        msgArea.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(new JScrollPane(msgArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(Color.WHITE);
        JLabel charCountLabel = new JLabel("Characters: 0 / 200");
        JButton sendBtn = new JButton("Send Message");

        // Track typed/removed characters in real time and warn in red if > 200
        msgArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateCount(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updateCount(); }
            @Override
            public void changedUpdate(DocumentEvent e) { }

            private void updateCount() {
                int len = msgArea.getText().length();
                charCountLabel.setText("Characters: " + len + " / 200");
                charCountLabel.setForeground(len > 200 ? Color.RED : Color.BLACK);
            }
        });

         // Validate non-empty and <= 200 chars before confirming send
        sendBtn.addActionListener(e -> {
            String text = msgArea.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Message cannot be empty.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else if (text.length() > 200) {
                JOptionPane.showMessageDialog(frame, "Message exceeds 200 characters.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Message sent to your advisor!",
                        "Sent", JOptionPane.INFORMATION_MESSAGE);
                msgArea.setText("");
                updateStatus("Message sent successfully");
            }
        });

        bottom.add(charCountLabel, BorderLayout.WEST);
        bottom.add(sendBtn, BorderLayout.EAST);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Builds the bottom status bar displaying live feedback on the left and last login on the right.
     */
    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBackground(new Color(230, 230, 235));
        statusBar.setBorder(new EmptyBorder(5, 10, 5, 10));

        statusLabel = new JLabel("Status: Logged in as student");
        statusBar.add(statusLabel, BorderLayout.WEST);
        statusBar.add(new JLabel("Last login: 05 Oct 2026"), BorderLayout.EAST);
        return statusBar;
    }

     /**
     * Helper method that creates a colored metric card for the Dashboard.
     */
    private JPanel createStatCard(String title, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(color);
        card.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel valueLabel = new JLabel(value, SwingConstants.RIGHT);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 22));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        return card;
    }

    /**
     * Switches the visible CardLayout panel, updates sidebar button styling, and updates status.
     */
    private void navigateTo(String section) {
        cardLayout.show(centerCards, section);
        highlightNavButton(section);
        updateStatus("Viewing " + section);
    }

    /**
     * Highlights the currently active sidebar button and resets the rest.
     */
    private void highlightNavButton(String activeSection) {
        for (JButton btn : navButtons) {
            if (btn.getText().equals(activeSection)) {
                btn.setBackground(new Color(210, 225, 250));
                btn.setFont(new Font("Arial", Font.BOLD, 13));
            } else {
                btn.setBackground(Color.WHITE);
                btn.setFont(new Font("Arial", Font.PLAIN, 13));
            }
        }
    }

    /**
     * Safely updates the bottom status bar text.
     */
    private void updateStatus(String message) {
        if (statusLabel != null) {
            statusLabel.setText("Status: " + message);
        }
    }

    /**
     * Prompts the user for confirmation before closing the application.
     */
    private void confirmExit() {
        int choice = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to log out and exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION
        );
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
