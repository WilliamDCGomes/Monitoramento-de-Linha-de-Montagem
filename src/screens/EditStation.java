package screens;
import commands.Hash;
import conexaobd.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class EditStation extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form EditStation
     */
    public EditStation() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    boolean stationValid = false;
    private void remove(){
        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA APAGAR ESSA ESTAÇÃO?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "delete from stations where id = ?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, inputNumberOfStation.getText());
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null,"ESTAÇÃO APAGADA COM SUCESSO");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"ESTAÇÃO NÃO CADASTRADA NO BANCO DE DADOS");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    private void localeStation(){
        String sqlnome = "select login from stations where id = ?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,inputNumberOfStation.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                inputLogin.setText(rs.getString(1));
            }
            else{
                JOptionPane.showMessageDialog(null,"ESTAÇÃO NÃO ENCONTRADA NO BANCO DE DADOS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void checkStation(){
        String sqlnome = "select * from stations where id = ? and login = ? and passwors = MD5(MD5(MD5(?)))";
        try {
            Hash hash = new Hash();
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,inputNumberOfStation.getText());
            pst.setString(2,inputLogin.getText());
            pst.setString(3,hash.DoHash(inputOldPassword.getText()));
            rs = pst.executeQuery();
            if (rs.next()) {
                String x = (rs.getString(1));
                stationValid=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"INFORMAÇÕES NÃO CONFEREM COM A CADASTRADA NO BANCO DE DADOS");
                stationValid=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO AO SE CONECTAR COM O BANCO DE DADOS\n" + e);
        }
    }
    private void updateStation(){
        String sql = "update stations set passwors=MD5(MD5(MD5(?))) where id=?";
        try {
            Hash hash = new Hash();
            pst=conexao.prepareStatement(sql);
            pst.setString(1,hash.DoHash(inputPassword.getText()));
            pst.setString(2,inputNumberOfStation.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"ESTAÇÃO ATUALIZADA COM SUCESSO");
            stationValid=false;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumberOfStation = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        txtPassword = new javax.swing.JLabel();
        inputNumberOfStation = new javax.swing.JTextField();
        inputLogin = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        inputConfirmPassword = new javax.swing.JPasswordField();
        txtNewStation = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonLocale = new javax.swing.JButton();
        txtOldPassword = new javax.swing.JLabel();
        inputOldPassword = new javax.swing.JPasswordField();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Estação");

        txtNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtNumberOfStation.setText("NÚMERO DA ESTAÇÃO");

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtLogin.setText("LOGIN");

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtPassword.setText("NOVA SENHA");

        inputNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        inputLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        txtConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtConfirmPassword.setText("CONFIRMAR SENHA");

        inputPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        inputConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        txtNewStation.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtNewStation.setText("EDITAR ESTAÇÃO");

        buttonSave.setText("SALVAR");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonLocale.setText("LOCALIZAR");
        buttonLocale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLocaleActionPerformed(evt);
            }
        });

        txtOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtOldPassword.setText("ANTIGA SENHA");

        inputOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        buttonDelete.setText("APAGAR");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNewStation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLocale)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSave)
                                .addGap(44, 44, 44)
                                .addComponent(buttonDelete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLogin)
                                        .addComponent(txtNumberOfStation, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPassword)
                                        .addComponent(txtConfirmPassword))
                                    .addComponent(txtOldPassword))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputPassword)
                                    .addComponent(inputLogin)
                                    .addComponent(inputConfirmPassword)
                                    .addComponent(inputNumberOfStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(inputOldPassword, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtNewStation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberOfStation)
                    .addComponent(inputNumberOfStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLocale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOldPassword)
                    .addComponent(inputOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPassword)
                    .addComponent(inputConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonDelete))
                .addGap(45, 45, 45))
        );

        setSize(new java.awt.Dimension(416, 476));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        remove();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonLocaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLocaleActionPerformed
        if(inputNumberOfStation.getText().equals("")){
            JOptionPane.showMessageDialog(null, "INFORME O NÚMERO DA ESTAÇÃO");
        }
        else{
            localeStation();
        }
    }//GEN-LAST:event_buttonLocaleActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if(inputNumberOfStation.getText().equals("")||inputLogin.getText().equals("")||inputOldPassword.getText().equals("")||inputPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
        }
        else{
            checkStation();
            if(stationValid == true){
                if((inputPassword.getText().equals(inputConfirmPassword.getText()))){
                    updateStation();
                }
                else{
                    JOptionPane.showMessageDialog(null, "CAMPOS DA NOVA SENHA NÃO CONFEREM");
                }
            }
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonLocale;
    private javax.swing.JButton buttonSave;
    private javax.swing.JPasswordField inputConfirmPassword;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JTextField inputNumberOfStation;
    private javax.swing.JPasswordField inputOldPassword;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel txtConfirmPassword;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtNewStation;
    private javax.swing.JLabel txtNumberOfStation;
    private javax.swing.JLabel txtOldPassword;
    private javax.swing.JLabel txtPassword;
    // End of variables declaration//GEN-END:variables
}
