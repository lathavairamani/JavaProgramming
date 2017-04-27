package com.grayscale;
import edu.duke.*;
import java.io.*;

public class BatchGrayscale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			ImageResource inImage = new ImageResource(f);
			String fname = inImage.getFileName();
			ImageResource invertedImage = makeInverted(inImage, fname);
			invertedImage.draw();
			invertedImage.save();
			ImageResource grayImage = makeGray(inImage, fname);
			grayImage.draw();
			grayImage.save();
		}
	}

	private static ImageResource makeGray(ImageResource inImage, String fname) {
		String newName = "gray-" + fname;
		for(Pixel p:inImage.pixels()){
			int avg = (p.getRed() + p.getBlue() + p.getGreen()) / 3;
			p.setRed(avg);
			p.setGreen(avg);
			p.setBlue(avg);
		}
		inImage.setFileName(newName);
		return inImage;
	}
	
	private static ImageResource makeInverted(ImageResource inImage, String fname) {
		String newName = "inverted-" + fname;
		for(Pixel p:inImage.pixels()){
			p.setRed(255 - p.getRed());
			p.setGreen(255 - p.getGreen());
			p.setBlue(255 - p.getBlue());
		}
		inImage.setFileName(newName);
		return inImage;
	}

}
