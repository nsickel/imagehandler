/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
/**
 *
 * @author nis
 */
public class SelectFolderActionListener implements ActionListener {

    private MainWindow mainWindow;
    private JFileChooser chooser;
    private JLabel label;

    public SelectFolderActionListener(MainWindow mainWindow, JFileChooser chooser, JLabel label) {
        this.mainWindow = mainWindow;
        this.chooser = chooser;
        this.label = label;
    }

    public void actionPerformed(ActionEvent ae) {
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choose image-folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this.mainWindow) == JFileChooser.APPROVE_OPTION) {
            label.setText(chooser.getSelectedFile().getAbsolutePath().toString());
        } else {
            label.setText("No Selection ");
        }
    }
}
