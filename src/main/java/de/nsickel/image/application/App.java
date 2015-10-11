package de.nsickel.image.application;

import de.nsickel.image.compressor.CompressorImpl;
import de.nsickel.image.gui.MainWindow;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        MainWindow window = new MainWindow(
                new ImageHandler(
                    new CompressorImpl()
                )
        );
    }
}
