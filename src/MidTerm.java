import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * 
 *@author RanaSiroosian&JeannieMcCarthy
 *
 */
public class MidTerm {

	public static void main(String[] args) {
		int width = 120;
		int height = 20;
		
		BufferedImage bufferedImage = new BufferedImage(
				  width, height, 
				  BufferedImage.TYPE_INT_RGB);
				Graphics graphics = bufferedImage.getGraphics();
				Graphics2D graphics2D = (Graphics2D) graphics;
				graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
				  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				graphics2D.drawString("BAELDUNG", 12, 24);
				for (int y = 0; y < height; y++) {
				    StringBuilder stringBuilder = new StringBuilder();
				 
				    for (int x = 0; x < width; x++) {
				        stringBuilder.append("*");
				    }
				 
				    if (stringBuilder.toString().trim().isEmpty()) {
				        continue;
				    }
				 
				    System.out.println(stringBuilder);
				}
		
	}

}
