import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

class Main {

    static BufferedImage image;
    static int width;
    static int height;
    static int red;
    static int green;
    static int blue;

    static JFrame frame;
    static int x, y;


    public static void createAndShowGUI() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

                }
            }

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

public class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0) {

        int red,green,blue;
        JFrame frame=new JFrame();
        int i = 0;
        int j = 0;
        int count = 0;
        Color c = new Color(Main.image.getRGB(j, i));
        System.out.println("S.No: " + count + " Red: " + c.getRed() + "  Green: " + c.getGreen() + " Blue: " + c.getBlue());
        red = c.getRed();
        green = c.getGreen();
        blue = c.getBlue();
        JPanel newpixel = new JPanel();
        newpixel.setBounds(j + 5, i + 5, 5, 5);
        newpixel.setBackground(new Color(red, green, blue));
        frame.add(newpixel);
        SwingUtilities.updateComponentTreeUI(frame);
    }
}