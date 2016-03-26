package stenography;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Decryption {
	BufferedImage image;
	int width;
	int height;
 

	public Decryption() {
		try {
			File input = new File("abcd2.jpg");
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			System.out.println("width, height: " + width + ", " + height);
			int[][] pixelData = new int[width * height][3];
			int[] rgb;
       
			int counter = 0;
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					rgb = getPixelData(image, i, j);

					for(int k = 0; k < rgb.length; k++){
						pixelData[counter][k] = rgb[k];
						}

					counter++;
					}
			}
		}
			
       
       /*for(int i=0;i<15;i++){
         	for(int j=0;j<3;j++){
             	System.out.print(" " + pixelData[i][j]);
             	}System.out.println(" ");
      	}*/
       
    catch (Exception e) {}
    }
 static public void main(String args[]) throws Exception {
	 Decryption obj = new Decryption();
	 }
 private static int[] getPixelData(BufferedImage image, int x, int y) {
	 int argb = image.getRGB(x, y);

	 int rgb[] = new int[] {
			 (argb >> 16) & 0xff, //red
			 (argb >>  8) & 0xff, //green
			 (argb      ) & 0xff  //blue
			 };
	 return rgb;
	 }
 }

