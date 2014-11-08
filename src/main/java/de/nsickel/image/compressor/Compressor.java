package de.nsickel.image.compressor;

public interface Compressor {

	public void compressImages(String sourceFilesDirectory,
			String targetFilesDirectory, float quality) throws Exception;
}
