package kiosk;

import java.io.IOException;
import java.util.Calendar;

public class Carry_Carts_Remote3 extends javax.swing.JFrame {

      public Carry_Carts_Remote3() {
                initComponents();
            }

           @SuppressWarnings("unchecked")
            private void initComponents() {
               jButton1 = new javax.swing.JButton();

               setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

               jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
               jButton1.setForeground(new java.awt.Color(204, 0, 0));
               jButton1.setText("CLOSE");
               jButton1.setToolTipText("");
               jButton1.addActionListener(new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                       jButton1ActionPerformed(evt);
                   }
               });

               javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
               getContentPane().setLayout(layout);
               layout.setHorizontalGroup(
                   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(18, 18, 18)
                       .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addContainerGap(19, Short.MAX_VALUE))
               );
               layout.setVerticalGroup(
                   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addContainerGap(21, Short.MAX_VALUE))
               );

               pack();
           }                       

            private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(DISPOSE_ON_CLOSE);
             //  System.exit(EXIT_ON_CLOSE);
        // TODO add your handling code here:
            }                                        

            public static void main(String args[]) throws IOException, InterruptedException {
        		

                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Carry_Carts_Remote3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Carry_Carts_Remote3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Carry_Carts_Remote3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Carry_Carts_Remote3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Carry_Carts_Remote3().setVisible(true);
                    }
                });
                
                Carry_Carts_Remote3 object = new Carry_Carts_Remote3();
      	      object.action();
            }

            private javax.swing.JButton jButton1;
            
            
        	private synchronized void action() throws IOException, InterruptedException {
        		try {
        			
        			while (true) {
        			System.out.println("action class are running program ==> " + Calendar.getInstance().getTime());
        			
        			
        			this.wait(3000);
        			read_database.read();
        			Write_file.update_totalcash();
                   write_database.kiosk_data_update();
          

        			} 
        			} catch (InterruptedException e) {e.printStackTrace();}
        		
         
        	}
        }


