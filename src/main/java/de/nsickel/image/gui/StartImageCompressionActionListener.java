/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author nis
 */
public class StartImageCompressionActionListener implements ActionListener {

    private MainWindow mainWindow;
    private JLabel label;

    public StartImageCompressionActionListener(MainWindow mainWindow, JLabel label) {
        this.mainWindow = mainWindow;
        this.label = label;
    }

    public void actionPerformed(ActionEvent ae) {
        String message = mainWindow.startImageCompression(label.getText());
        label.setText(message);
    }
    
}
