package edtdemo;

public class FreezeForm extends javax.swing.JFrame {

    public FreezeForm() {
        initComponents();
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDT Demo — BAD Practice");
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setText("Ready");
        getContentPane().add(jLabel1);

        jButton1.setText("Freeze the UI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel1.setText("Working...");
        jButton1.setEnabled(false);

        // GOOD: Run the long task on a background thread
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) { }

            // CRITICAL: Update GUI on the EDT
            javax.swing.SwingUtilities.invokeLater(() -> {
                jLabel1.setText("Done!");
                jButton1.setEnabled(true);
            });
        }).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FreezeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
