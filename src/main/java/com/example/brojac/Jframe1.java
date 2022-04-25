/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.brojac;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


/**
 *mainFrame hehehh
 * @author krpa
 */
public class Jframe1 extends javax.swing.JFrame {
    
   int countdown = 0;
   Boolean stop = false;
   Boolean blnVecIde = false;
   
   /*//nije u funkciji
   public void countDown2(){
    long delay;
        System.out.println(Integer.toString(countdown));
        delay = 1000;

        final Timer timer = new Timer();

        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Integer.toString(countdown));
                Toolkit.getDefaultToolkit().beep();
                if (stop || countdown < 1){
                
                timer.cancel();
                timer.purge();
                }
            }
        };

        timer.schedule(task, delay);
       System.out.println("countDown2 gotovo");
   }
   */
   
   //ovo je glavna metoda
    public void countingDown(){
   
        //Color defaultBack = lblOdbrojavanje.getBackground();
        lblOdbrojavanje.setForeground(Color.BLACK);
        
        //int countdown = countdown;
        stop = false;
        blnVecIde=true;
        Timer timer = new Timer();
       
     timer.schedule(new TimerTask(){
         
            @Override
            public void run() {
             countdown=countdown - 1;
             if (countdown < 0){
                 timer.cancel();
                 timer.purge();
                 blnVecIde=false;
                 System.out.println("Izasao na kraju");
                 Toolkit.getDefaultToolkit().beep();
                 Jframe1.super.setVisible(true);
                 lblOdbrojavanje.setText("####");
                 lblOdbrojavanje.setForeground(Color.RED);
                 blnVecIde=false;
                 
                 //postavi prozor u prvi plan
                 int d = java.awt.Frame.ICONIFIED;
                         if(d== Jframe1.super.getState()){
                Jframe1.super.setState(Frame.NORMAL);
                }
                 }
             else if(stop){
                 timer.cancel();
                 timer.purge();
                 blnVecIde=false;
                 System.out.println("Izasao na stopu");
            }
             else{
             System.out.println(countdown);
             lblOdbrojavanje.setText(String.valueOf(countdown));
             }
                //label.setText(countdown +"second's left");
            }   
        },0, 1000);
     //timer.cancel();
     //timer.purge();
     
    }
    
    /**
     * Creates new form Jframe1
     */
    public Jframe1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOdbrojavanje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDuzina = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(350, 200));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lblOdbrojavanje.setFont(new java.awt.Font("Segoe UI", 1, 88)); // NOI18N
        lblOdbrojavanje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOdbrojavanje.setText("####");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDuzina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDuzina.setText("180");
        txtDuzina.setMinimumSize(new java.awt.Dimension(70, 30));
        txtDuzina.setName("txtDuzina"); // NOI18N
        txtDuzina.setPreferredSize(new java.awt.Dimension(70, 30));
        txtDuzina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuzinaActionPerformed(evt);
            }
        });
        txtDuzina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDuzinaKeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel1.setText("F5 start - stop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(29, 29, 29)
                            .addComponent(jButton1))
                        .addComponent(lblOdbrojavanje, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(lblOdbrojavanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
     
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
       
       if(blnVecIde){
           return;
       }
       //blnVecIde=true;
        System.out.println("Kliknio");
        Integer intDuzina;
        String strDuzina;
        strDuzina = txtDuzina.getText();
                System.out.println(strDuzina);

        if(strDuzina.isBlank() || strDuzina.isEmpty()){
            
        }
        else{
            
            try{
                intDuzina = Integer.valueOf(strDuzina);
                }    
                catch(Exception e){
                return;
        
                }
         
            countdown = intDuzina;
            if(!blnVecIde){
                blnVecIde=true;
                countingDown();
                System.out.println("opet zvao countdown");
                
            }
            }
        
        //blnVecIde=false;
        System.out.println("kraj button click");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        stop = true;                // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //kada se klikne enter u broju counter
    private void txtDuzinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuzinaActionPerformed
    //   txtDuzina.addActionListener(new ActionListener() {
    //        @Override
    //        public void actionPerformed(ActionEvent e) {
    //        //myTextArea.append(myTextField.getText() + "\n");
    //        }
    //    });
    //   jButton1.doClick();
    
     //if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
   //}
    
        
    }//GEN-LAST:event_txtDuzinaActionPerformed

    private void txtDuzinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuzinaKeyPressed
                // TODOsout add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            jButton1.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F5){
            if(blnVecIde){
                jButton2.doClick();
            }
            else{
                jButton1.doClick();
            }
        }
        //else if(evt.getKeyCode()== KeyEvent.VK_F5){
            
    }//GEN-LAST:event_txtDuzinaKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            
            jButton1.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_S){
        //    jButton2.doClick();
        }
        
    }//GEN-LAST:event_formKeyPressed

    
    /**
     * @param args the command line arguments
     */
  
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
            java.util.logging.Logger.getLogger(Jframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            new Jframe1().setVisible(true);
            }
      });
      
    }
              

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblOdbrojavanje;
    private javax.swing.JTextField txtDuzina;
    // End of variables declaration//GEN-END:variables

   
}

        
