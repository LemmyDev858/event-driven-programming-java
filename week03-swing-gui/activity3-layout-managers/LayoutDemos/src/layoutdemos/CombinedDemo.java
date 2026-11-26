package layoutdemos;

public class CombinedDemo extends javax.swing.JFrame {

    public CombinedDemo() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sidebarPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Combined Layout Demo");

        toolbarPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        toolbarPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton1.setText("New");
        toolbarPanel.add(jButton1);

        jButton2.setText("Open");
        toolbarPanel.add(jButton2);

        jButton3.setText("Save");
        toolbarPanel.add(jButton3);

        jButton4.setText("Exit");
        toolbarPanel.add(jButton4);

        getContentPane().add(toolbarPanel, java.awt.BorderLayout.PAGE_START);

        sidebarPanel.setPreferredSize(new java.awt.Dimension(150, 0));
        sidebarPanel.setLayout(new java.awt.GridLayout(5, 1));

        jButton5.setText("Home");
        sidebarPanel.add(jButton5);

        jButton6.setText("Profile");
        sidebarPanel.add(jButton6);

        jButton7.setText("Messages");
        sidebarPanel.add(jButton7);

        jButton8.setText("Settings");
        sidebarPanel.add(jButton8);

        jButton9.setText("Logout");
        sidebarPanel.add(jButton9);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setLayout(new java.awt.GridLayout(3, 3));

        jButton10.setText("Card 1");
        contentPanel.add(jButton10);

        jButton11.setText("Card 2");
        contentPanel.add(jButton11);

        jButton12.setText("Card 3");
        contentPanel.add(jButton12);

        jButton13.setText("Card 4");
        contentPanel.add(jButton13);

        jButton14.setText("Card 5");
        contentPanel.add(jButton14);

        jButton15.setText("Card 6");
        contentPanel.add(jButton15);

        jButton16.setText("Card 7");
        contentPanel.add(jButton16);

        jButton17.setText("Card 8");
        contentPanel.add(jButton17);

        jButton18.setText("Card 9");
        contentPanel.add(jButton18);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        statusLabel.setText("Ready");
        statusLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(statusLabel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombinedDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel toolbarPanel;
    // End of variables declaration//GEN-END:variables
}
