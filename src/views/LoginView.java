/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Libs.Imgsize;
import Libs.TextPrompt;
import controllers.LoginController;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import models.Employees;
import models.EmployeesDao;

/**
 *
 * @author juand
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    
    Employees employee = new Employees();
    EmployeesDao employee_dao = new EmployeesDao();
    
    public LoginView() {
        initComponents();
        //Controlador del login
        LoginController employee_login = new LoginController(employee, employee_dao,this);
        setSize(930, 430);
        setResizable(false);
        setTitle("Ingresar al sistema");
        setLocationRelativeTo(null);
        this.repaint();

        //Placeholders
        TextPrompt txt_Username = new TextPrompt("Usuario", txt_username);
        TextPrompt txt_Password = new TextPrompt("Contraseña", txt_password);
        
        //Redimensionar imagen al tamaño del JLabel
        Imgsize logoBASA = new Imgsize(this.manImage, "./src/images/Iconos/employee.png", this);
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
        jLabel2 = new javax.swing.JLabel();
        btn_enter = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        manImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(40, 147, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nimbus Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 60));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        btn_enter.setText("INGRESAR");
        btn_enter.setAlignmentY(0.0F);
        jPanel1.add(btn_enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        txt_username.setToolTipText("");
        txt_username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, -1));

        txt_password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_password.setPreferredSize(new java.awt.Dimension(65, 24));
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, -1));

        chk_showpassword.setBackground(jPanel1.getBackground());
        chk_showpassword.setForeground(new java.awt.Color(255, 255, 255));
        chk_showpassword.setText("Mostrar contraseña");
        chk_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));
        jPanel1.add(manImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 490, 420));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Iconos/wallpaper.jpg"))); // NOI18N
        jPanel2.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 412));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        // TODO add your handling code here:
        //Limita que se escriban espacios y carácteres no deseados y se habilita teclas específicas
        if((evt.getKeyChar() < '0' || evt.getKeyChar() > '9') && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z') 
                && (evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z') && evt.getKeyCode() != VK_BACK_SPACE && evt.getKeyCode() != VK_DELETE 
                && evt.getKeyCode() != VK_LEFT && evt.getKeyCode() != VK_RIGHT){
            evt.consume();
        }
    }//GEN-LAST:event_txt_usernameKeyTyped

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        //Limita que se escriban espacios y carácteres no deseados y se habilita teclas específicas
        if(evt.getKeyChar() == VK_SPACE){evt.consume();}
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
        //Se muestra la contraseña al seleccionar el checkbox de mostrar contraseña
        if(chk_showpassword.isSelected()){
                txt_password.setEchoChar((char) 0);
            } else {
                txt_password.setEchoChar('*');
            }
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper;
    public javax.swing.JButton btn_enter;
    public javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel manImage;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}