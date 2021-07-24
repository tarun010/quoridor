/**
 *
 * @author jacobkeiley
 */
public class SetAILevelsWindow extends javax.swing.JPanel {

    /**
     * Creates new form SetAILevels
     */
    public SetAILevelsWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        AIDifficultyPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Player4EasyButton = new javax.swing.JRadioButton();
        Player3EasyButton = new javax.swing.JRadioButton();
        Player2EasyButton = new javax.swing.JRadioButton();
        Player2HardButton = new javax.swing.JRadioButton();
        Player3HardButton = new javax.swing.JRadioButton();
        Player4HardButton = new javax.swing.JRadioButton();

        AIDifficultyPanel.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player2");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player3");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Player4");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Set Player Difficulty");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Easy");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hard");

        buttonGroup3.add(Player4EasyButton);
        Player4EasyButton.setText(" ");
        Player4EasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4EasyButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(Player3EasyButton);
        Player3EasyButton.setText(" ");
        Player3EasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player3EasyButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(Player2EasyButton);

        buttonGroup1.add(Player2HardButton);

        buttonGroup2.add(Player3HardButton);

        buttonGroup3.add(Player4HardButton);

        javax.swing.GroupLayout AIDifficultyPanelLayout = new javax.swing.GroupLayout(AIDifficultyPanel);
        AIDifficultyPanel.setLayout(AIDifficultyPanelLayout);
        AIDifficultyPanelLayout.setHorizontalGroup(
            AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Player2EasyButton))
                            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Player3EasyButton))
                            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(Player4EasyButton)))))
                    .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Player4HardButton)
                                    .addComponent(jLabel6)
                                    .addComponent(Player3HardButton)
                                    .addComponent(Player2HardButton))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        AIDifficultyPanelLayout.setVerticalGroup(
            AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIDifficultyPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Player2EasyButton)
                    .addComponent(Player2HardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(Player3EasyButton)
                    .addComponent(Player3HardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(Player4EasyButton)
                    .addComponent(Player4HardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIDifficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AIDifficultyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AIDifficultyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }// </editor-fold>                        

    private void Player4EasyButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void Player3EasyButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SetAILevelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SetAILevelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SetAILevelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SetAILevelsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SetAILevelsWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel AIDifficultyPanel;
    private javax.swing.JRadioButton Player2EasyButton;
    private javax.swing.JRadioButton Player2HardButton;
    private javax.swing.JRadioButton Player3EasyButton;
    private javax.swing.JRadioButton Player3HardButton;
    private javax.swing.JRadioButton Player4EasyButton;
    private javax.swing.JRadioButton Player4HardButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration                   
}