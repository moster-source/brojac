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
import java.util.concurrent.TimeUnit;


/**
 *mainFrame hehehh
 * @author krpa
 */
public class Jframe1 extends javax.swing.JFrame {
    //Main-Class: com.example.brojac.Jframe1
    
   int countdown = 0;
   Boolean stop = false;
   Boolean blnVecIde = false;
   Color c;
   int intDuzina;
   long lngStartOvertime;
   long lngStopOvertime;
   boolean blnOvertimeGoing = false;
   int intUkupnaDuzina=0;
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
             countdown = countdown - 1;
             if (countdown < 0){
                 blnOvertimeGoing=false;  //daj dopustenje
                 countingDown2(); //nastavak brojanja od kraja
                 
                 timer.cancel();
                 timer.purge();
                 blnVecIde=false;
                 //System.out.println("Izasao na kraju"); //test
                 Toolkit.getDefaultToolkit().beep();
                 Jframe1.super.setVisible(true);
                 //lblOdbrojavanje.setText("####");
                 //lblOdbrojavanje.setText(strVratiVrijeme(countdown));
                 //lblOdbrojavanje.setText(strVratiVrijeme(Integer.valueOf(txtDuzina.getText())));
                 upisiUkupnuDuzinu();
                 lblOdbrojavanje.setText(strVratiVrijeme(intUkupnaDuzina));  //vrati na original

                //intDuzina
                 
                 lblOdbrojavanje.setForeground(Color.RED);
                 blnVecIde=false;
                 
                 //postavi prozor u prvi plan
                 int d = java.awt.Frame.ICONIFIED;
                    Jframe1.super.setAlwaysOnTop(true);
                    Jframe1.super.toFront();
                    Jframe1.super.requestFocus();
                    Jframe1.super.setAlwaysOnTop(false);
                    Jframe1.super.toFront();
                if(d== Jframe1.super.getState()){
                    Jframe1.super.setState(Frame.NORMAL);
                    Jframe1.super.requestFocus();
                    jButton1.requestFocus();//dize gad je minimaliziran
                             //System.out.println("Doljnji");
                }
            }
            else if(stop){
                timer.cancel();
                timer.purge();
                blnVecIde=false;
                //System.out.println("Izasao na stopu");
            }
            else{
                //System.out.println(countdown);
                //bivši countdown samo sekunde
                //lblOdbrojavanje.setText(String.valueOf(countdown));
                //System.out.println(strVratiVrijeme(countdown));
                lblOdbrojavanje.setText(strVratiVrijeme(countdown));
            }
                //label.setText(countdown +"second's left");
            }   
        },0, 1000);
    
    }
    
    
    public void countingDown2(){
        //int countdown = countdown;
        //stop = false;
        //blnVecIde=true;
        Timer timer = new Timer();
        lngStartOvertime=System.currentTimeMillis();
       
     timer.schedule(new TimerTask(){
         
            @Override
            public void run() {
             if (blnOvertimeGoing){
                 timer.cancel();
                 timer.purge();
                 System.out.println("overtime vec ide"); 
              
            }
            
            else{
                 lngStopOvertime=System.currentTimeMillis()-lngStartOvertime;
                 jLabel2.setText(getDurationBreakdown(lngStopOvertime));
            }

            }   
        },0, 1000);
    
    }
        public static String getDurationBreakdown(long millis) {
            if(millis < 0) {
                throw new IllegalArgumentException("Duration must be greater than zero!");
            }

                //long days = TimeUnit.MILLISECONDS.toDays(millis);
                //millis -= TimeUnit.DAYS.toMillis(days);
                long hours = TimeUnit.MILLISECONDS.toHours(millis);
                millis -= TimeUnit.HOURS.toMillis(hours);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
                millis -= TimeUnit.MINUTES.toMillis(minutes);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

            StringBuilder sb = new StringBuilder(64);
            //sb.append(days);
            //sb.append(" Days ");
            sb.append(hours);
            sb.append(" Sati ");
            sb.append(minutes);
            sb.append(" Minuta ");
            sb.append(seconds);
            sb.append(" Sekundi");

            return(sb.toString());
        }
    
    private String strVratiVrijeme(int intSekunde){
        String strVrati = null;
        int intMinute = intSekunde / 60;
        int SekundeTemp = intSekunde - (intMinute * 60);
        strVrati = Integer.toString(intMinute).concat(":".concat(Integer.toString(SekundeTemp)));
        
    
        return strVrati;
    }
    
    /**
     * Creates new form Jframe1
     */
    public Jframe1() {
        initComponents();
        c=jButton1.getBackground();
        
        upisiUkupnuDuzinu();
        lblOdbrojavanje.setText(strVratiVrijeme(intUkupnaDuzina));
        
        
        
        //jButton3.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOdbrojavanje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDuzina1 = new javax.swing.JTextField();
        txtDuzina = new javax.swing.JTextField();
        txtDuzina2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setFocusable(false);
        setResizable(false);
        setSize(new java.awt.Dimension(340, 200));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel1.setText("F5 start - stop");
        jLabel1.setFocusable(false);

        lblOdbrojavanje.setFont(new java.awt.Font("Segoe UI", 1, 88)); // NOI18N
        lblOdbrojavanje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOdbrojavanje.setText("####");
        lblOdbrojavanje.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("# Sati # Minuta # Sekundi");
        jLabel2.setToolTipText("");
        jLabel2.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblOdbrojavanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOdbrojavanje, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        jPanel2.setFocusCycleRoot(true);
        jPanel2.setFocusTraversalPolicyProvider(true);
        jPanel2.setNextFocusableComponent(txtDuzina);

        txtDuzina1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtDuzina1.setText("3");
        txtDuzina1.setMinimumSize(new java.awt.Dimension(70, 30));
        txtDuzina1.setName("txtDuzina1"); // NOI18N
        txtDuzina1.setPreferredSize(new java.awt.Dimension(70, 30));
        txtDuzina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuzina1ActionPerformed(evt);
            }
        });
        txtDuzina1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDuzina1KeyPressed(evt);
            }
        });

        txtDuzina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDuzina.setMinimumSize(new java.awt.Dimension(70, 35));
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

        txtDuzina2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDuzina2.setMinimumSize(new java.awt.Dimension(50, 35));
        txtDuzina2.setName("txtDuzina"); // NOI18N
        txtDuzina2.setPreferredSize(new java.awt.Dimension(50, 30));
        txtDuzina2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuzina2ActionPerformed(evt);
            }
        });
        txtDuzina2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDuzina2KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Stop");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Start");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel3.setText("sekunde");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel4.setText("minute");
        jLabel4.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDuzina1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDuzina2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDuzina1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDuzina2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDuzina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
     public void blicaj(){
          Timer timer2 = new Timer();
       
            timer2.schedule(new TimerTask(){
                int duzina = intDuzina;
               
         
            @Override
            public void run() {
             //public variable c, i kod init stavlja
              
              if(jButton1.getBackground() == Color.RED){
                jButton1.setBackground(c);
                jButton1.repaint();
                  //System.out.println("Ušao u prvi if");
                }
              else{
                  jButton1.setBackground(Color.RED);
                  jButton1.repaint();
                  //System.out.println("Ušao u drugi if");
              }
              duzina--;
              if(duzina<0){
                 jButton1.setBackground(c);
                 timer2.cancel();
                 timer2.purge();
                 
              }
              //System.out.println("duzina je " + duzina);
              
            }
    },0, 30);
     
     
     }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        blnOvertimeGoing=true;     //zaustavi brojac
        upisiUkupnuDuzinu();
        lblOdbrojavanje.setText(strVratiVrijeme(intUkupnaDuzina));  //vrati na original
        //jLabel2.setText(strVratiVrijeme(intUkupnaDuzina));
        jLabel2.setText("# Sati # Minuta # Sekundi");
        //jLabel2.setText("##:##");
        //## neka blicne malo
        intDuzina=10;
       
        
        if(blnVecIde){
           return;
       }
         blicaj();
       //blnVecIde=true;
        System.out.println("Kliknio");
        Integer intDuzina=0;
        Integer intDuzina1=0;
        String strDuzina;
        String strDuzina1;
        
        strDuzina = txtDuzina.getText();
        strDuzina1 = txtDuzina1.getText();
        
        try{
            intDuzina = Integer.parseInt(strDuzina);
            // is an integer!
        } catch (NumberFormatException e) {
           intDuzina=0;
            System.out.println("Greska intDuzina");
        }
        try{
            intDuzina1 = Integer.parseInt(strDuzina1);
            intDuzina1=intDuzina1*60;// is an integer!
        } catch (NumberFormatException e) {
           intDuzina1=0;
           System.out.println("Greska intDuzina1");
        }
                
        /*
        if(strDuzina.isBlank() || strDuzina.isEmpty()){
            strDuzina="0";
        }
         if(strDuzina1.isBlank() || strDuzina1.isEmpty()){
            strDuzina1="0";
        }
        */
            /*
            try{
                    //intDuzina = Integer.valueOf(strDuzina);
                    intDuzina=Integer.parseInt(strDuzina);
                    intDuzina=intDuzina+(Integer.parseInt(strDuzina1)*60);
                }    
                catch(Exception e){
                    System.out.println("Greska");
                }
            */
            countdown = intDuzina+intDuzina1;
            if(countdown<1){
                
                System.out.println(String.valueOf(intDuzina+intDuzina1));
                return;
            }
            if(!blnVecIde){
                blnVecIde=true;
                
                countingDown();
               // System.out.println("opet zvao countdown");
            }
        
        
        //blnVecIde=false;
       // System.out.println("kraj button click");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void upisiUkupnuDuzinu(){
    //string strDuzina = txtDuzina.getText();
        //strDuzina1 = txtDuzina1.getText();
        int x;
        int y;
        try{
            x = Integer.parseInt(txtDuzina.getText());
            // is an integer!
        } catch (NumberFormatException e) {
           x=0;
            System.out.println("Greska intDuzina");
        }
        
        try{
            y = Integer.parseInt(txtDuzina1.getText());
            y=y*60;// is an integer!
        } catch (NumberFormatException e) {
           y=0;
           System.out.println("Greska intDuzina1");
        }
        intUkupnaDuzina=y+x;
                
    
    
    
    }
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        stop = true;                // TODO add your handling code here:
        if(blnVecIde){
            System.out.println("Vec ide na klik");
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //kada se klikne enter u broju counter
    private void txtDuzinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuzinaActionPerformed
      
        
    }//GEN-LAST:event_txtDuzinaActionPerformed

    private void txtDuzinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuzinaKeyPressed
            
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
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
                if(evt.getKeyCode() == KeyEvent.VK_F6) {
                    Jframe1.this.setState(Frame.ICONIFIED);
           
                }
            
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

    private void txtDuzina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuzina1ActionPerformed
        // TODO add your handling code here:
             
    }//GEN-LAST:event_txtDuzina1ActionPerformed

    private void txtDuzina1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuzina1KeyPressed
        // TODO add your handling code here:
             
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //jButton3.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F5){
            if(blnVecIde){
                jButton2.doClick();
            }
            else{
                jButton1.doClick();
            }
        }
                if(evt.getKeyCode() == KeyEvent.VK_F6) {
            Jframe1.this.setState(Frame.ICONIFIED);
           
        }
                
                if(evt.getKeyCode() == KeyEvent.VK_TAB) {

            
                    this.txtDuzina2.requestFocus();
                    System.out.println("tab");
           
        }
                
            
    }//GEN-LAST:event_txtDuzina1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
             
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton2.doClick();
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
            
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
             
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
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
            
    }//GEN-LAST:event_jButton1KeyPressed

    private void txtDuzina2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuzina2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuzina2ActionPerformed

    private void txtDuzina2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuzina2KeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //jButton1.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F5){
            if(blnVecIde){
                jButton2.doClick();
            }
            else{
                jButton1.doClick();
            }
        }
        
        //F6 minimalizira
        if(evt.getKeyCode() == KeyEvent.VK_F6) {
            Jframe1.this.setState(Frame.ICONIFIED);
           
        }
        
    }//GEN-LAST:event_txtDuzina2KeyPressed

    
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblOdbrojavanje;
    private javax.swing.JTextField txtDuzina;
    private javax.swing.JTextField txtDuzina1;
    private javax.swing.JTextField txtDuzina2;
    // End of variables declaration//GEN-END:variables

   
}

        
