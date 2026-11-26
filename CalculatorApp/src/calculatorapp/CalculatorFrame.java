package calculatorapp;

import javax.swing.JButton;

public class CalculatorFrame extends javax.swing.JFrame {

    // Add these instance variables at the top of the class
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public CalculatorFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnDivide = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnMultiply = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnSubtract = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnEquals = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Event-Driven Calculator");
        setResizable(false);

        display.setEditable(false);
        display.setBackground(new java.awt.Color(255, 255, 255));
        display.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        display.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        display.setText("0");

        buttonPanel.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        btn7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn7);

        btn8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn8);

        btn9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn9);

        btnDivide.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnDivide.setText("/");
        btnDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorActionPerformed(evt);
            }
        });
        buttonPanel.add(btnDivide);

        btn4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn4);

        btn5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn5);

        btn6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn6);

        btnMultiply.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnMultiply.setText("*");
        btnMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorActionPerformed(evt);
            }
        });
        buttonPanel.add(btnMultiply);

        btn1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn1);

        btn2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn2);

        btn3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn3);

        btnSubtract.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnSubtract.setText("-");
        btnSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorActionPerformed(evt);
            }
        });
        buttonPanel.add(btnSubtract);

        btn0.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberActionPerformed(evt);
            }
        });
        buttonPanel.add(btn0);

        btnClear.setBackground(new java.awt.Color(255, 150, 150));
        btnClear.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnClear.setText("C");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        buttonPanel.add(btnClear);

        btnEquals.setBackground(new java.awt.Color(100, 200, 100));
        btnEquals.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnEquals.setText("=");
        btnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualsActionPerformed(evt);
            }
        });
        buttonPanel.add(btnEquals);

        btnAdd.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorActionPerformed(evt);
            }
        });
        buttonPanel.add(btnAdd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(display)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Handler for NUMBER buttons (7, 8, 9, 4, 5, 6, 1, 2, 3, 0)
    private void btnNumberActionPerformed(java.awt.event.ActionEvent evt) {
        JButton clickedButton = (JButton) evt.getSource();
        String digit = clickedButton.getText();

        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    // Handler for OPERATOR buttons (+, -, *, /)
    private void btnOperatorActionPerformed(java.awt.event.ActionEvent evt) {
        JButton clickedButton = (JButton) evt.getSource();
        firstOperand = Double.parseDouble(display.getText());
        operator = clickedButton.getText();
        startNewNumber = true;
    }

    // Handler for EQUALS button (=)
    private void btnEqualsActionPerformed(java.awt.event.ActionEvent evt) {
        double secondOperand = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "-": result = firstOperand - secondOperand; break;
            case "*": result = firstOperand * secondOperand; break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    display.setText("Error");
                    startNewNumber = true;
                    return;
                }
                break;
            default: return;
        }

        display.setText(String.valueOf(result));
        startNewNumber = true;
    }

    // Handler for CLEAR button (C)
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDivide;
    private javax.swing.JButton btnEquals;
    private javax.swing.JButton btnMultiply;
    private javax.swing.JButton btnSubtract;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextField display;
    // End of variables declaration//GEN-END:variables
}
