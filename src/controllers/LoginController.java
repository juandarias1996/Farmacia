/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import models.Employees;
import models.EmployeesDao;
import views.LoginView;
import views.SystemView;

/**
 *
 * @author juand
 */
public class LoginController implements ActionListener {

    private Employees employee;
    private EmployeesDao employees_dao;
    private LoginView login_view;

    public LoginController(Employees employee, EmployeesDao employees_dao, LoginView login_view) {
        this.employee = employee;
        this.employees_dao = employees_dao;
        this.login_view = login_view;
        //Se define el elemento que debe estar escuchando la interfaz en la vista login_view
        this.login_view.btn_enter.addActionListener(this);
        this.login_view.txt_password.addActionListener(this);
        this.login_view.txt_username.addActionListener(this);
        this.login_view.chk_showpassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Obtener los datos de la vista
        String user = login_view.txt_username.getText().trim();
        String pass = String.valueOf(login_view.txt_password.getPassword());

        //Se detecta que se presionó el botón ingresar ó se presionó la tecla ENTER estando en Usuario ó en Contraseña
        //La tecla ENTER esta envevida en los eventos capturados del teclado y entra directo al condicional if
        if (ae.getSource() == login_view.btn_enter || ae.getSource() == login_view.txt_password || ae.getSource() == login_view.txt_username) {
            //Validar que los campos no esten vacíos
            if (!user.equals("") && !pass.equals("")) {
                //Pasar los parámetros al método login
                employee = employees_dao.loginQuery(user, pass);
                //Verificar la existencia del usuario
                if (employee.getUsername() != null) {
                    if (employee.getRol().equals("Administrador")) {
                        SystemView admin = new SystemView();
                        admin.setVisible(true);
                    } else {
                        SystemView aux = new SystemView();
                        aux.setVisible(true);
                    }
                    this.login_view.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrect@");
                }
            } else if (!login_view.txt_username.getText().trim().equals("")) {
                if (login_view.txt_password.requestFocusInWindow()) {
                    //Se transfiere el foco al siguiente Jtextflield, Jpasswordfield, etc...
                    ((JComponent) ae.getSource()).transferFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            }
        }
    }

}
