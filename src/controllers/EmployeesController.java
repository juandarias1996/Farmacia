/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Employees;
import models.EmployeesDao;
import static models.EmployeesDao.rol_user;
import views.SystemView;

/**
 *
 * @author juand
 */
public class EmployeesController implements ActionListener, MouseListener, KeyListener{
    private Employees employee;
    private EmployeesDao employeeDao;
    private SystemView views;
    //Rol
    String rol = rol_user;
    //Para poder interactuar con la tabla
    DefaultTableModel model = new DefaultTableModel();

    public EmployeesController(Employees employee, EmployeesDao employeeDao, SystemView views) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.views = views;
        //Escuchar evento del botón Registrar
        this.views.btn_register_employee.addActionListener(this);
        //Escuchar evento del botón de Modificar
        this.views.btn_update_employee.addActionListener(this);
        //Escuchar eventos del mouse
        this.views.employees_table.addMouseListener(this);
        //Escuchar eventos de teclado
        this.views.txt_search_employee.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Evento del botón Registrar
        if(ae.getSource() == views.btn_register_employee){
            //Verificar si los campos están vacíos
            if(views.txt_employee_id.getText().equals("")
                    ||views.txt_employee_fullname.getText().equals("")
                    ||views.txt_employee_username.getText().equals("")
                    ||views.txt_employee_address.getText().equals("")
                    ||views.txt_employee_telephone.getText().equals("")
                    ||views.txt_employee_email.getText().equals("")
                    ||views.cmb_rol.getSelectedItem().toString().equals("")
                    ||String.valueOf(views.txt_employee_password.getPassword()).equals("")){
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                //Realizar la inserción
                employee.setId(Integer.parseInt(views.txt_employee_id.getText().trim()));
                employee.setFull_name(views.txt_employee_fullname.getText().trim());
                employee.setUsername(views.txt_employee_username.getText().trim());
                employee.setAddress(views.txt_employee_address.getText().trim());
                employee.setTelephone(views.txt_employee_telephone.getText().trim());
                employee.setEmail(views.txt_employee_email.getText().trim());
                employee.setPassword(String.valueOf(views.txt_employee_password.getPassword()));
                employee.setRol(views.cmb_rol.getSelectedItem().toString());
                
                if(employeeDao.registerEmployeeQuery(employee)){
                    cleanTable();
                    JOptionPane.showMessageDialog(null, "Emplead@ registrad@ con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar emplead@");
                }
            }
        }//Evento del botón Modificar
        else if(ae.getSource() == views.btn_update_employee){
            //Verificar si los campos están vacíos
            if(views.txt_employee_id.getText().equals("")
                ||views.txt_employee_fullname.getText().equals("")
                ||views.txt_employee_username.getText().equals("")
                ||views.txt_employee_address.getText().equals("")
                ||views.txt_employee_telephone.getText().equals("")
                ||views.txt_employee_email.getText().equals("")
                ||views.cmb_rol.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios!");
            }else{
                //Realizar la inserción de datos a modificar
                employee.setId(Integer.parseInt(views.txt_employee_id.getText().trim()));
                employee.setFull_name(views.txt_employee_fullname.getText().trim());
                employee.setUsername(views.txt_employee_username.getText().trim());
                employee.setAddress(views.txt_employee_address.getText().trim());
                employee.setTelephone(views.txt_employee_telephone.getText().trim());
                employee.setEmail(views.txt_employee_email.getText().trim());
                employee.setPassword(String.valueOf(views.txt_employee_password.getPassword()));
                employee.setRol(views.cmb_rol.getSelectedItem().toString());

                if(employeeDao.updateEmployeeQuery(employee)){
                    cleanTable();
                    listAllEmployees();
                    views.btn_register_employee.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Datos del empleado modificados con exito!");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar los datos del empleado!");
                }
            }
        }
    }
    
    //Listar todos los empleados
    public void listAllEmployees(){
        if(rol.equals("Administrador")){
            List<Employees> list = employeeDao.listEmployeesQuery(views.txt_search_employee.getText());
            model = (DefaultTableModel) views.employees_table.getModel();
            Object[] row = new Object[7];
            for(int i = 0; i < list.size(); i++){
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getFull_name();
                row[2] = list.get(i).getUsername();
                row[3] = list.get(i).getAddress();
                row[4] = list.get(i).getTelephone();
                row[5] = list.get(i).getEmail();
                row[6] = list.get(i).getRol();
                model.addRow(row);
            }
        }
    }
    
    //Evento de click del mouse
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == views.employees_table){
            int row = views.employees_table.rowAtPoint(me.getPoint());
            
            views.txt_employee_id.setText(views.employees_table.getValueAt(row, 0).toString());
            views.txt_employee_fullname.setText(views.employees_table.getValueAt(row, 1).toString());
            views.txt_employee_username.setText(views.employees_table.getValueAt(row, 2).toString());
            views.txt_employee_address.setText(views.employees_table.getValueAt(row, 3).toString());
            views.txt_employee_telephone.setText(views.employees_table.getValueAt(row, 4).toString());
            views.txt_employee_email.setText(views.employees_table.getValueAt(row, 5).toString());
            views.cmb_rol.setSelectedItem(views.employees_table.getValueAt(row, 6).toString());
            
            //Deshabilita
            views.txt_employee_id.setEnabled(false);
            views.txt_employee_password.setEnabled(false);
            views.btn_register_employee.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
         if(ke.getSource() == views.txt_search_employee){
            cleanTable();
            listAllEmployees();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    public void cleanTable(){
        for(int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
            i -= 1;
        }
    }
}
