package studentportal;

public class StudentPortalForm extends javax.swing.JFrame {

    public StudentPortalForm() {
        initComponents();
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        sidebarPanel = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        coursesButton = new javax.swing.JButton();
        gradesButton = new javax.swing.JButton();
        feesButton = new javax.swing.JButton();
        timetableButton = new javax.swing.JButton();
        messagesButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        cardsPanel = new javax.swing.JPanel();
        gpaCardPanel = new javax.swing.JPanel();
        gpaTitleLabel = new javax.swing.JLabel();
        gpaValueLabel = new javax.swing.JLabel();
        unitsCardPanel = new javax.swing.JPanel();
        unitsTitleLabel = new javax.swing.JLabel();
        unitsValueLabel = new javax.swing.JLabel();
        feesCardPanel = new javax.swing.JPanel();
        feesTitleLabel = new javax.swing.JLabel();
        feesValueLabel = new javax.swing.JLabel();
        notificationsPanel = new javax.swing.JPanel();
        notifTitleLabel = new javax.swing.JLabel();
        notif1Label = new javax.swing.JLabel();
        notif2Label = new javax.swing.JLabel();
        notif3Label = new javax.swing.JLabel();
        notif4Label = new javax.swing.JLabel();
        statusBarPanel = new javax.swing.JPanel();
        statusLeftLabel = new javax.swing.JLabel();
        statusRightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Student Portal");

        headerPanel.setBackground(new java.awt.Color(25, 55, 115));
        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        headerPanel.setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("🎓 University Student Portal");
        headerPanel.add(titleLabel, java.awt.BorderLayout.LINE_START);

        logoutButton.setBackground(new java.awt.Color(200, 60, 60));
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        headerPanel.add(logoutButton, java.awt.BorderLayout.LINE_END);

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        sidebarPanel.setBackground(new java.awt.Color(240, 240, 245));
        sidebarPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(180, 0));
        sidebarPanel.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        dashboardButton.setBackground(new java.awt.Color(255, 255, 255));
        dashboardButton.setText("Dashboard");
        dashboardButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(dashboardButton);

        coursesButton.setBackground(new java.awt.Color(255, 255, 255));
        coursesButton.setText("Courses");
        coursesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(coursesButton);

        gradesButton.setBackground(new java.awt.Color(255, 255, 255));
        gradesButton.setText("Grades");
        gradesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(gradesButton);

        feesButton.setBackground(new java.awt.Color(255, 255, 255));
        feesButton.setText("Fees");
        feesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(feesButton);

        timetableButton.setBackground(new java.awt.Color(255, 255, 255));
        timetableButton.setText("Timetable");
        timetableButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(timetableButton);

        messagesButton.setBackground(new java.awt.Color(255, 255, 255));
        messagesButton.setText("Messages");
        messagesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarPanel.add(messagesButton);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new java.awt.BorderLayout(0, 15));

        welcomeLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        welcomeLabel.setText("Welcome, John Doe!");
        contentPanel.add(welcomeLabel, java.awt.BorderLayout.PAGE_START);

        cardsPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardsPanel.setLayout(new java.awt.GridLayout(1, 3, 15, 15));

        gpaCardPanel.setBackground(new java.awt.Color(100, 180, 100));
        gpaCardPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        gpaCardPanel.setLayout(new java.awt.BorderLayout());

        gpaTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        gpaTitleLabel.setText("GPA");
        gpaCardPanel.add(gpaTitleLabel, java.awt.BorderLayout.PAGE_START);

        gpaValueLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        gpaValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        gpaValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gpaValueLabel.setText("3.75");
        gpaCardPanel.add(gpaValueLabel, java.awt.BorderLayout.CENTER);

        cardsPanel.add(gpaCardPanel);

        unitsCardPanel.setBackground(new java.awt.Color(80, 140, 220));
        unitsCardPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        unitsCardPanel.setLayout(new java.awt.BorderLayout());

        unitsTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        unitsTitleLabel.setText("Units");
        unitsCardPanel.add(unitsTitleLabel, java.awt.BorderLayout.PAGE_START);

        unitsValueLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        unitsValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        unitsValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        unitsValueLabel.setText("48 / 56");
        unitsCardPanel.add(unitsValueLabel, java.awt.BorderLayout.CENTER);

        cardsPanel.add(unitsCardPanel);

        feesCardPanel.setBackground(new java.awt.Color(230, 150, 60));
        feesCardPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        feesCardPanel.setLayout(new java.awt.BorderLayout());

        feesTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        feesTitleLabel.setText("Fees");
        feesCardPanel.add(feesTitleLabel, java.awt.BorderLayout.PAGE_START);

        feesValueLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        feesValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        feesValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        feesValueLabel.setText("Paid");
        feesCardPanel.add(feesValueLabel, java.awt.BorderLayout.CENTER);

        cardsPanel.add(feesCardPanel);

        contentPanel.add(cardsPanel, java.awt.BorderLayout.CENTER);

        notificationsPanel.setBackground(new java.awt.Color(255, 255, 255));
        notificationsPanel.setLayout(new java.awt.GridLayout(5, 1));

        notifTitleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        notifTitleLabel.setText("Notifications");
        notificationsPanel.add(notifTitleLabel);

        notif1Label.setText("• Exam results for Semester 2 have been released");
        notificationsPanel.add(notif1Label);

        notif2Label.setText("• Fee payment deadline: 30th October 2026");
        notificationsPanel.add(notif2Label);

        notif3Label.setText("• Your timetable has been updated");
        notificationsPanel.add(notif3Label);

        notif4Label.setText("• Library book due for return on 12th October");
        notificationsPanel.add(notif4Label);

        contentPanel.add(notificationsPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        statusBarPanel.setBackground(new java.awt.Color(230, 230, 235));
        statusBarPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        statusBarPanel.setLayout(new java.awt.BorderLayout());

        statusLeftLabel.setText("Status: Logged in as student");
        statusBarPanel.add(statusLeftLabel, java.awt.BorderLayout.LINE_START);

        statusRightLabel.setText("Last login: 05 Oct 2026");
        statusBarPanel.add(statusRightLabel, java.awt.BorderLayout.LINE_END);

        getContentPane().add(statusBarPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPortalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton coursesButton;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton feesButton;
    private javax.swing.JPanel feesCardPanel;
    private javax.swing.JLabel feesTitleLabel;
    private javax.swing.JLabel feesValueLabel;
    private javax.swing.JPanel gpaCardPanel;
    private javax.swing.JLabel gpaTitleLabel;
    private javax.swing.JLabel gpaValueLabel;
    private javax.swing.JButton gradesButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton messagesButton;
    private javax.swing.JLabel notif1Label;
    private javax.swing.JLabel notif2Label;
    private javax.swing.JLabel notif3Label;
    private javax.swing.JLabel notif4Label;
    private javax.swing.JLabel notifTitleLabel;
    private javax.swing.JPanel notificationsPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel statusBarPanel;
    private javax.swing.JLabel statusLeftLabel;
    private javax.swing.JLabel statusRightLabel;
    private javax.swing.JButton timetableButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel unitsCardPanel;
    private javax.swing.JLabel unitsTitleLabel;
    private javax.swing.JLabel unitsValueLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
