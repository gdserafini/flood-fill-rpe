import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

class Main{
    public static void main(String[] args) {
        try{
            var file = new File("imageTest.jpeg");
            var image = ImageIO.read(file);
            var panel = new ImageBuffer(image);
            var frame = new JFrame("Processing buffere image");
            frame.add(panel);
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            var processor = new FloodFill(image, panel);
            //processor.fillBufferedImageStack();
            processor.fillBufferedImageQueue();
        }
        catch (Exception e) {
            e.printStackTrace();
        }  
    }
}