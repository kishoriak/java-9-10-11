package com.demo.imagedemo;
import java.awt.Image;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.imageio.ImageIO;
 
public class MRImageDemo {
	//public static void main(String[] args) throws IOException {
	public static Image getMyImage(int h,int w) throws IOException { 
	 String BASEDIR = System.getProperty("user.dir");
	 System.out.println("Base Directory of the project: " + BASEDIR);
	 
	 List<String> imageLocations = List.of(BASEDIR + File.separator + "320px-Eagle.jpg",
	 BASEDIR + File.separator + "480px-Eagle.jpg", BASEDIR + File.separator + "1024px-Eagle.jpg",
	 BASEDIR + File.separator + "720px-Eagle.jpg");
	 
	 
	 List<Image> imgList = new ArrayList<Image>();
	 for(String loc: imageLocations) {
	 Image currentImg = ImageIO.read(new File(loc));
	 imgList.add(currentImg);
	 }
	 
	 
	 MultiResolutionImage mrImages = new BaseMultiResolutionImage(imgList.toArray(new Image[0]));
	 
	 List<Image> diffResolutions = mrImages.getResolutionVariants();
	 
	 System.out.println("Number of available resolutions for the same image: " + diffResolutions.size());
	 
	 Image img1 = mrImages.getResolutionVariant(h, w);
	 System.out.printf("\nRetrieved Image variant for a 21.5 inch monitor with high resolution [%d,%d] has resolution [%d,%d]\n", 1920, 1080, img1.getWidth(null),
	 img1.getHeight(null));
	 
	/* Image img2 = mrImages.getResolutionVariant(1280, 768);
	 System.out.printf("\nRetrieved Image variant for a simple desktop monitor [%d,%d] has resolution [%d,%d]\n", 1280, 768, img2.getWidth(null),
	 img2.getHeight(null));
	 
	 Image img3 = mrImages.getResolutionVariant(640, 360);
	 System.out.printf("\nRetrieved Image variant for a small device resolution [%d,%d] has resolution [%d,%d]\n", 640, 360, img3.getWidth(null),
	 img3.getHeight(null));
	 
	 
	 Image img4 = mrImages.getResolutionVariant(240, 120);
	 System.out.printf("\nRetrieved Image variant for an extra small device resolution [%d,%d] has resolution [%d,%d]\n", 240, 120, img4.getWidth(null),
	 img4.getHeight(null));*/
	  return img1;
	 
	 }
	
	
}
