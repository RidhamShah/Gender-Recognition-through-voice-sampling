package sas;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp
 */
public class TestDataScreen2 extends javax.swing.JFrame {

    String prediction;

    public TestDataScreen2(String predic) {
        initComponents();
        this.prediction = predic;
        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        this.getContentPane().setBackground(Color.cyan);
    }

    //Do not disturb
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(172, 108, 230));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HELP US IMPROVE OUR DATA");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(172, 108, 230));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WAS OUR PREDICTION CORRECT ?");
        jLabel2.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cross.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String xx = null;
        if (prediction.equals("MALE")) {
            try {
                BufferedReader br;
                br = new BufferedReader(new FileReader("F:\\Studies\\Sem-3\\SignalAndSystems\\SAS Project\\TestDataSet\\\\AddData.txt"));
                xx = br.readLine();
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Process p;
                p = Runtime.getRuntime().exec("python F:\\Studies\\Sem-3\\SignalAndSystems\\SASProject\\SASGenderRecognition\\src\\AddMale.py " + xx);
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestDataScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                BufferedReader br;
                br = new BufferedReader(new FileReader("F:\\Studies\\Sem-3\\SignalAndSystems\\SAS Project\\TestDataSet\\\\AddData.txt"));
                xx = br.readLine();
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Process p;
                p = Runtime.getRuntime().exec("python F:\\Studies\\Sem-3\\SignalAndSystems\\SASProject\\SASGenderRecognition\\src\\AddFemale.py " + xx);
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestDataScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String xx = null;
        if (prediction.equals("MALE")) {
            try {
                BufferedReader br;
                br = new BufferedReader(new FileReader("F:\\Studies\\Sem-3\\SignalAndSystems\\SAS Project\\TestDataSet\\\\AddData.txt"));
                xx = br.readLine();
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Process p;
                p = Runtime.getRuntime().exec("python F:\\Studies\\Sem-3\\SignalAndSystems\\SASProject\\SASGenderRecognition\\src\\AddFemale.py " + xx);
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestDataScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                BufferedReader br;
                br = new BufferedReader(new FileReader("F:\\Studies\\Sem-3\\SignalAndSystems\\SAS Project\\TestDataSet\\\\AddData.txt"));
                xx = br.readLine();
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Process p;
                p = Runtime.getRuntime().exec("python F:\\Studies\\Sem-3\\SignalAndSystems\\SASProject\\SASGenderRecognition\\src\\AddMale.py " + xx);
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestDataScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestDataScreen2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(Color.ORANGE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(Color.ORANGE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButton2MouseExited

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestDataScreen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDataScreen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDataScreen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDataScreen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDataScreen2("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
