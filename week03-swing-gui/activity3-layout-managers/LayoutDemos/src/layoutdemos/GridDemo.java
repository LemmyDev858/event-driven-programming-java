package layoutdemos;

public class GridDemo extends javax.swing.JFrame {

    public GridDemo() {
        initComponents();
        setSize(400, 500);
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
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GridLayout — Calculator");
        getContentPane().setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        jButton1.setText("7");
        getContentPane().add(jButton1);

        jButton2.setText("8");
        getContentPane().add(jButton2);

        jButton3.setText("9");
        getContentPane().add(jButton3);

        jButton4.setText("/");
        getContentPane().add(jButton4);

        jButton5.setText("4");
        getContentPane().add(jButton5);

        jButton6.setText("5");
        getContentPane().add(jButton6);

        jButton7.setText("6");
        getContentPane().add(jButton7);

        jButton8.setText("*");
        getContentPane().add(jButton8);

        jButton9.setText("1");
        getContentPane().add(jButton9);

        jButton10.setText("2");
        getContentPane().add(jButton10);

        jButton11.setText("3");
        getContentPane().add(jButton11);

        jButton12.setText("-");
        getContentPane().add(jButton12);

        jButton13.setText("0");
        getContentPane().add(jButton13);

        jButton14.setText("C");
        getContentPane().add(jButton14);

        jButton15.setText("=");
        getContentPane().add(jButton15);

        jButton16.setText("+");
        getContentPane().add(jButton16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
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
