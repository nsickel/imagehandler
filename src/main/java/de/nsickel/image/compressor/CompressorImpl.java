package de.nsickel.image.compressor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CompressorImpl implements Compressor {

    /**
     *
     * @param imageFile
     * @param quality
     * @throws Exception
     */
    public void compressImage(File imageFile, float quality) throws Exception {

        File compressedImageFile = new File("target/compressed/" + imageFile.getName());

        InputStream is = new FileInputStream(imageFile);
        OutputStream os = new FileOutputStream(compressedImageFile);

        // create a BufferedImage as the result of decoding the supplied InputStream
        BufferedImage image = ImageIO.read(is);

        // get all image writers for JPG format
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

        ImageWriter writer = (ImageWriter) writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);
        ImageWriteParam param = writer.getDefaultWriteParam();

        // compress to a given quality
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);

		// appends a complete image stream containing a single image and
        //associated stream and image metadata and thumbnails to the output
        writer.write(null, new IIOImage(image, null, null), param);

        // close all streams
        is.close();
        os.close();
        ios.close();
        writer.dispose();

        System.out.println(compressedImageFile.getName() + " processed");
    }

    /*
     * (non-Javadoc)
     * @see de.nsickel.image.compressor.Compressor#compressImages(java.lang.String, java.lang.String, float)
     */
    @Override
    public void compressImages(String sourceFilesDirectory,
            String targetFilesDirectory, float quality) throws Exception {

        File[] images = new File(sourceFilesDirectory).listFiles();
        System.out.println("start compressing images");

        for (File image : images) {
            if (image.exists()) {
                this.compressImage(image, quality);
            }
        }

        System.out.println("finished compressing images");
    }
}
