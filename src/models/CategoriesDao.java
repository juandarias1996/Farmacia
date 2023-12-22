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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class CategoriesDao {
    //Instanciar la conexión
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    //Registrar categoría
    public boolean registerCategoryQuery(Categories categorie){
        String query = "INSERT INTO categories (name, created, updated) VALUES(?,?,?)";     
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, categorie.getName());
            pst.setTimestamp(2, datetime);
            pst.setTimestamp(3, datetime);
            pst.execute();
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar la categoría " + e);
            return false;
        }
    }
    
    //Listar categorias
    public List listCategoriesQuery(String value){
        List<Categories> list_categories = new ArrayList();
        String query = "SELECT * FROM categories";
        String query_search_categories = "SELECT * FROM categories WHERE name LIKE '%" + value + "%'";
        try {
            conn = cn.getConnection();
            if (value.equalsIgnoreCase("")) {
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                pst = conn.prepareStatement(query_search_categories);
                rs = pst.executeQuery();
            }

            while (rs.next()) {
                Categories categories = new Categories();
                categories.setId(rs.getInt("id"));
                categories.setName(rs.getString("name"));
                list_categories.add(categories);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list_categories;
    }
    
    //Modificar categoría
    public boolean updateCategoryQuery(Categories categorie){
        String query = "UPDATE categories SET name = ?, updated = ? WHERE id = ?";     
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, categorie.getName());
            pst.setTimestamp(2, datetime);
            pst.setInt(3, categorie.getId());
            pst.execute();
            return true;          
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar los datos de la categoría " + e);
            return false;
        }
    }
    
    //Eliminar categoria
    public boolean deleteCategoryQuery(int id){
        String query = "DELETE FROM categories WHERE id = " + id;
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.execute();
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede eliminar una categoría que tenga relación con otra tabla " + e);
            return false;
        }
    }
}
