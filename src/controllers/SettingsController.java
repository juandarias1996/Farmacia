/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.SystemView;

/**
 *
 * @author juand
 */
public class SettingsController implements MouseListener{

    private SystemView views;
    
    public SettingsController(SystemView views){
        this.views = views;
        this.views.jLabelProducts.addMouseListener(this);
        this.views.jLabelPurchases.addMouseListener(this);
        this.views.jLabelCustomers.addMouseListener(this);
        this.views.jLabelEmployees.addMouseListener(this);
        this.views.jLabelSuppliers.addMouseListener(this);
        this.views.jLabelCategories.addMouseListener(this);
        this.views.jLabelReports.addMouseListener(this);
        this.views.jLabelSettings.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == views.jLabelProducts){
            views.jPanelProducts.setBackground(new Color(152, 202, 63));
        }else if(me.getSource() == views.jLabelPurchases){
            views.jPanelPurchases.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelCustomers){
            views.jPanelCustomers.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelEmployees){
            views.jPanelEmployees.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelSuppliers){
            views.jPanelSuppliers.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelCategories){
            views.jPanelCategories.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelReports){
            views.jPanelReports.setBackground(new Color(152, 202, 63));            
        }else if(me.getSource() == views.jLabelSettings){
            views.jPanelSettings.setBackground(new Color(152, 202, 63));            
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == views.jLabelProducts){
            views.jPanelProducts.setBackground(new Color(18, 45, 61));
        }else if(me.getSource() == views.jLabelPurchases){
            views.jPanelPurchases.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelCustomers){
            views.jPanelCustomers.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelEmployees){
            views.jPanelEmployees.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelSuppliers){
            views.jPanelSuppliers.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelCategories){
            views.jPanelCategories.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelReports){
            views.jPanelReports.setBackground(new Color(18, 45, 61));            
        }else if(me.getSource() == views.jLabelSettings){
            views.jPanelSettings.setBackground(new Color(18, 45, 61));            
        }
    }
    
}
