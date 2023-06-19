import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Pixel extends JPanel {
    BufferedImage image;
    int width;
    int height;
    int red, green, blue;
    int x, y;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        repaint();
        g2d.setColor(new Color(red, green, blue));
        g2d.fillOval(x, y, 5, 10);

    }

    public Pixel() {
        setBounds(0, 0, 350, 200);
        setVisible(true);
        setLayout(null);
        repaint();
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
                    red = c.getRed();
                    green = c.getGreen();
                    blue = c.getBlue();
                    x = i;
                    y = j;
                    Graphics g = this.getGraphics();
                }
            }

        } catch (Exception e) {
        }
    }

}

public class Main extends JFrame {
    private static Pixel pixel;

    Main() {
        super("Paint");
        setResizable(false);
        setVisible(true);
        setBounds(0, 0, 350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main paint = new Main();
        paint.setLocationRelativeTo(null);

        pixel = new Pixel();
        paint.add(pixel);
    }
}
