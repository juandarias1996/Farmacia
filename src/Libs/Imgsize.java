package Libs;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imgsize{
    
    private JLabel jlabel = new JLabel();
    private String src;
    private JFrame jframe = new JFrame();
    private ImageIcon image = new ImageIcon();
    private Icon icon;
    
    
    
    public Imgsize(JLabel jlabel, String src, JFrame jframe){
        this.jlabel = jlabel;
        this.src = src;
        this.jframe = jframe;
        
        Imgsizelabel(jlabel, src, jframe);
    }
    
    private void Imgsizelabel (JLabel jlabel, String src, JFrame jframe){
        ImageIcon image = new ImageIcon(src);
        this.icon = new ImageIcon(
                        image.getImage().getScaledInstance(
                        jlabel.getWidth(), 
                        jlabel.getHeight(), 
                        Image.SCALE_DEFAULT
                        )
        );
        jlabel.setIcon(this.icon);
        jframe.repaint();
    }
    
    
    
    

}