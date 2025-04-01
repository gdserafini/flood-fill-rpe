import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {
    private BufferedImage bufferedImage;
    private Stack<Pixel> stack;
    private Queue<Pixel> queue;
    private JPanel panel;
    private static final int TARGET_COLOR = Color.WHITE.getRGB();
    private static final int FILL_COLOR = Color.RED.getRGB();

    public FloodFill(BufferedImage bufferedImage, JPanel panel){
        this.bufferedImage = bufferedImage;
        this.panel = panel;
        this.stack = new Stack<>();
        this.queue = new Queue<>();
    }

    public void fillBufferedImageStack() throws InterruptedException {
        boolean found = false;
        for (int y = 0; y < bufferedImage.getHeight() && !found; y++) {
            for (int x = 0; x < bufferedImage.getWidth() && !found; x++) {
                if (bufferedImage.getRGB(x, y) == TARGET_COLOR) {
                    stack.push(new Pixel(x, y, TARGET_COLOR));
                    found = true;
                }
            }
        }

        if (found) {
            while (!stack.isEmpty()) {
                Pixel currentPixel = stack.pop();
                int x = currentPixel.getX();
                int y = currentPixel.getY();
                if (bufferedImage.getRGB(x, y) != TARGET_COLOR) {
                    continue;
                }
                bufferedImage.setRGB(x, y, FILL_COLOR);
                panel.repaint();
                if (x > 0) stack.push(new Pixel(x - 1, y, TARGET_COLOR));
                if (x < bufferedImage.getWidth() - 1) stack.push(new Pixel(x + 1, y, TARGET_COLOR));
                if (y > 0) stack.push(new Pixel(x, y - 1, TARGET_COLOR));
                if (y < bufferedImage.getHeight() - 1) stack.push(new Pixel(x, y + 1, TARGET_COLOR));
                Thread.sleep(1);
            }
        }
    }

    public void fillBufferedImageQueue() throws InterruptedException {
        boolean found = false;
        for (int y = 0; y < bufferedImage.getHeight() && !found; y++) {
            for (int x = 0; x < bufferedImage.getWidth() && !found; x++) {
                if (bufferedImage.getRGB(x, y) == TARGET_COLOR) {
                    queue.enqueue(new Pixel(x, y, TARGET_COLOR));
                    found = true;
                }
            }
        }
        if (found) {
            while (!queue.isEmpty()) {
                Pixel currentPixel = queue.dequeue();
                int x = currentPixel.getX();
                int y = currentPixel.getY();
                if (bufferedImage.getRGB(x, y) != TARGET_COLOR) {
                    continue;
                }
                bufferedImage.setRGB(x, y, FILL_COLOR);
                panel.repaint();
                if (x > 0) queue.enqueue(new Pixel(x - 1, y, TARGET_COLOR));
                if (x < bufferedImage.getWidth() - 1) queue.enqueue(new Pixel(x + 1, y, TARGET_COLOR));
                if (y > 0) queue.enqueue(new Pixel(x, y - 1, TARGET_COLOR));
                if (y < bufferedImage.getHeight() - 1) queue.enqueue(new Pixel(x, y + 1, TARGET_COLOR));
                Thread.sleep(1);
            }
        }
    }
}