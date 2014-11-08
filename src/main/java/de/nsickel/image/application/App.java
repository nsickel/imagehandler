package de.nsickel.image.application;


import de.nsickel.image.compressor.Compressor;
import de.nsickel.image.compressor.CompressorImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	switch (args[0]){
    	case Modes.COMPRESS :
    		System.out.println("run compressor");
    		Compressor compressor = new CompressorImpl();
    		float quality = 0.5f;
    		try {
				compressor.compressImages(args[1], "test", quality);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
		default:
			System.out.println("unknown mode, exit now");
			break;
    	}
    }
}
