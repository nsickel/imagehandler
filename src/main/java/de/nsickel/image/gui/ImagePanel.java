/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private Image img;
    
    private int imgWidth;
    
    private int imgHeight;

    public ImagePanel(Image img) {
        this.img = img;
    }
    
    private void scaleSizes() {
        setImgWidth(img.getWidth(null));
        setImgHeight(img.getHeight(null));
        if ( getWidth() > 500 || getHeight() > 500) {
            setImgWidth(getImgWidth() / 4);
            setImgHeight(getImgHeight() / 4);
        }
    }
    
    private void setDimensions() {
        Dimension size = new Dimension(getImgWidth(), getImgHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.scaleSizes();
        this.setDimensions();
        g.drawImage(img,0,0, getImgWidth(), getImgHeight(), null);
    }

    /**
     * @return the imgWidth
     */
    public int getImgWidth() {
        return imgWidth;
    }

    /**
     * @param imgWidth the imgWidth to set
     */
    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    /**
     * @return the imgHeight
     */
    public int getImgHeight() {
        return imgHeight;
    }

    /**
     * @param imgHeight the imgHeight to set
     */
    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }
}
