import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class Main {


    static BufferedImage image;
    static int width;
    static int height;
    static int red;
    static int green;
    static int blue;
    static int count = 0;
    static int i = 0;
    static int j = 0;
    static JFrame frame;
    int x, y;

    public static void createAndShowGUI() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            File input = new File("src/img_1.png");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
        } catch (Exception e) {

        }

        Timer timer = new Timer(1, new MyActionListener());
        timer.start();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });


    }

    public static class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            count++;
            if (j >= width - 2) {
                j = 0;
                if (i >= height - 2) {

                } else {
                    i++;
                }
            } else {
                j++;
            }
            Color c = new Color(image.getRGB(j, i));
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

}