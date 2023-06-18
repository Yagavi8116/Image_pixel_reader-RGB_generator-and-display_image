import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Pixel {
    BufferedImage image;
    int width;
    int height;

    public Pixel() {
        try {
            File input = new File("src/img.png");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            int count = 0;

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println("S.No: " + count + " Red: " + c.getRed() + "  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }

        } catch (Exception e) {
        }
    }

    static public void main(String args[]) throws Exception {
        Pixel obj = new Pixel();
    }
}
