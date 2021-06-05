package view;

import view.projeto.ViewProjetoInsert;
import view.estado.ViewEstadoInsert;
import view.empregado.ViewEmpregadoInsert;
import view.cidade.ViewCidadeInsert;
import view.alocacao.ViewAlocacaoInsert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.alocacao.ViewAlocacaoDelete;
import view.alocacao.ViewAlocacaoRead;
import view.alocacao.ViewAlocacaoUpdate;
import view.cidade.ViewCidadeDelete;
import view.cidade.ViewCidadeRead;
import view.cidade.ViewCidadeUpdate;
import view.empregado.ViewEmpregadoDelete;
import view.empregado.ViewEmpregadoRead;
import view.empregado.ViewEmpregadoUpdate;
import view.estado.ViewEstadoDelete;
import view.estado.ViewEstadoRead;
import view.estado.ViewEstadoUpdate;
import view.projeto.ViewProjetoDelete;
import view.projeto.ViewProjetoRead;
import view.projeto.ViewProjetoUpdate;

/**
 *
 * @author Rafael Luna
 */
public class Submenu extends javax.swing.JFrame {
    
    private JFrame frame = this;
    
    public Submenu() {
        initComponents();
        back();
    }
    
    public Submenu(int table) {
        initComponents();
        insert(table);
        read(table);
        delete(table);
        update(table);
        back();
        
    }
    
    private void insert(int table) {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              
               
               switch (table) {
                   case 1: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEmpregadoInsert()); break;
                   case 2: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewCidadeInsert()); break;
                   case 3: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEstadoInsert()); break;
                   case 4: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewProjetoInsert()); break;
                   case 5: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewAlocacaoInsert()); break;
               }
            }
        });            
    }
    
    private void read( int table )
    {
            jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              
               
               switch (table) {
                   case 1: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEmpregadoRead()); break;
                   case 2: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewCidadeRead()); break;
                   case 3: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEstadoRead()); break;
                   case 4: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewProjetoRead()); break;
                   case 5: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewAlocacaoRead()); break;
               }
            }
        });  
    }
    
    private void delete( int table )
    {
            jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             
               
               switch(table){
                case 1: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEmpregadoDelete()); break;
                case 2: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewCidadeDelete()); break;
                case 3: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEstadoDelete()); break;
                case 4: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewProjetoDelete()); break;
                case 5: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewAlocacaoDelete()); break;
               
           }
            }
        });  
    }

    
    private void update(int table){
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
               
               switch(table){
                case 1: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEmpregadoUpdate()); break;
                case 2: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewCidadeUpdate()); break;
                case 3: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewEstadoUpdate()); break;
                case 4: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewProjetoUpdate()); break;
                case 5: Main.paintFrame(  new JFrameRoot().getFrame(), new ViewAlocacaoUpdate()); break;
           }
            }
        });  
    }
    
    
    private void back() {
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
               Main.paintFrame(  new JFrameRoot().getFrame(), new Menu());
            }
        });
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione uma das opções:");

        jButton2.setText("Update");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");

        jButton5.setText("Read");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Submenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Submenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Submenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Submenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Submenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
