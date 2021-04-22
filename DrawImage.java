package com.demo.imagedemo;
 
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
 
public class DrawImage {
 
  static Image image;
 
  public static void main(String[] args) throws IOException {
 
// The image URL - change to where your image file is located!
 
//String imageURL = "image.png";
 
// This call returns immediately and pixels are loaded in the background
 
//image = Toolkit.getDefaultToolkit().getImage(imageURL);
Scanner sc=new Scanner(System.in);
System.out.println("[200,240],[1000,1400],[400,400] ");//test values of height and width
System.out.println("enter height and width");

int h=sc.nextInt();
int w=sc.nextInt();
 image=MRImageDemo.getMyImage(h, w);
 //1920, 1080
 //1280, 768
 //640, 360
// Create a frame
 
JFrame frame = new JFrame();

 
// Add a component with a custom paint method
 
frame.add(new CustomPaintComponent());

frame.addWindowListener(new WindowAdapter() {
	 
@Override

public void windowClosing(WindowEvent e) {

   System.exit(0);

}

 });
// Display the frame
 
//int frameWidth = 300;
 
//int frameHeight = 300;

int frameWidth = image.getHeight(null);

int frameHeight = image.getWidth(null);
frame.setSize(frameWidth, frameHeight);
 
frame.setVisible(true);
 
 }
 
 /**
  * To draw on the screen, it is first necessary to subclass a Component 
  * and override its paint() method. The paint() method is automatically called 
  * by the windowing system whenever component's area needs to be repainted.
  */
  static class CustomPaintComponent extends Component {
 
public void paint(Graphics g) {
 
  // Retrieve the graphics context; this object is used to paint shapes
 
  Graphics2D g2d = (Graphics2D)g;
 
  /**
   * Draw an Image object
   * The coordinate system of a graphics context is such that the origin is at the 
   * northwest corner and x-axis increases toward the right while the y-axis increases 
   * toward the bottom.
   */
 
  int x = 0;
 
  int y = 0;
 
  g2d.drawImage(image, x, y, this);
 
}
 
  }
 
}
