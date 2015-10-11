/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author nis
 */
public class ImageWindow extends JFrame {
    
    public ImageWindow(String imagePath) {
        
        ImagePanel panel = new ImagePanel(new ImageIcon(imagePath).getImage());
        add(panel);
        setLocation(0, 0);
        setSize(500, 500);
        setVisible(true);
    }
    
}
