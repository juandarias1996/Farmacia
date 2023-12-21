/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class CustomersDao {
    
    //Instanciar la conexión
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    //Registrar cliente
    public boolean registerCustomerQuery(Customers customer){
        String query = "INSERT INTO customers (id, full_name, address, telephone, email, created, updated)"
                + "VALUES(?,?,?,?,?,?,?)";
        
        Timestamp datetime = new Timestamp(new Date().getTime());
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, customer.getId());
            pst.setString(2, customer.getFull_name());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getTelephone());
            pst.setString(5, customer.getEmail());
            pst.setTimestamp(6, datetime);
            pst.setTimestamp(7, datetime);
            pst.execute();
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar al cliente " + e);
            return false;
        }
    }
    
    //Listar clientes
}
