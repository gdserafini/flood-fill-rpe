import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageBuffer extends JPanel {
    private BufferedImage bufferedImage;

    public ImageBuffer(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(this.bufferedImage, 0, 0, this);
    }
}