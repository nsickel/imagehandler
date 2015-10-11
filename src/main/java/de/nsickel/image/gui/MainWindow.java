/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.gui;

import de.nsickel.image.application.ImageHandler;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author nis
 */
public class MainWindow extends JFrame {

    private ImageHandler imageHandler;
    
    public MainWindow(ImageHandler imageHandler) {
        super("Image-Handler");
        this.imageHandler = imageHandler;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Selected Folder");
        getContentPane().add(label);
        
        JButton buttonFolderSelect = new JButton("Select Folder");
        getContentPane().add(buttonFolderSelect);
        buttonFolderSelect.addActionListener(new SelectFolderActionListener(this,new JFileChooser(), label));
        
        JButton buttonStartCompress = new JButton("Start Compression");
        getContentPane().add(buttonStartCompress);
        buttonStartCompress.addActionListener(new StartImageCompressionActionListener(this, label));
        
        setLocation(250, 190);
        setSize(500, 500);
        setVisible(true);
    }
    
    public String startImageCompression(String sourceFilesDirectory) {
        this.imageHandler.compressImages(sourceFilesDirectory);
        return "image compression processed";
    }
}
