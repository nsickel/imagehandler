/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nsickel.image.application;

import de.nsickel.image.compressor.Compressor;

/**
 *
 * @author nis
 */
public class ImageHandler {
    
    private Compressor compressor;
    
    public ImageHandler(Compressor compressor) {
        this.compressor = compressor;
    }
    
    public void compressImages(String sourceFilesDirectory) {
        try {
            compressor.compressImages(sourceFilesDirectory, "test", 0.5f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
