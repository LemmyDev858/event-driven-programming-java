package layoutdemos;

public class FlowDemo extends javax.swing.JFrame {

    public FlowDemo() {
        initComponents();
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlowLayout Demo");
        getContentPane().setLayout(new java.awt.FlowLayout());

        jButton1.setText("Button 1");
        getContentPane().add(jButton1);

        jButton2.setText("Button 2");
        getContentPane().add(jButton2);

        jButton3.setText("Button 3");
        getContentPane().add(jButton3);

        jButton4.setText("Button 4");
        getContentPane().add(jButton4);

        jButton5.setText("Button 5");
        getContentPane().add(jButton5);

        jButton6.setText("Button 6");
        getContentPane().add(jButton6);

        jButton7.setText("Button 7");
        getContentPane().add(jButton7);

        jButton8.setText("Button 8");
        getContentPane().add(jButton8);

        jButton9.setText("Button 9");
        getContentPane().add(jButton9);

        jButton10.setText("Button 10");
        getContentPane().add(jButton10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlowDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
