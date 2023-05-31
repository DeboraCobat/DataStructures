import javax.swing.*;
import java.awt.*;

public class MainWindow extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2.0f));

        int[] xPoints = {WIDTH / 2, 100, WIDTH - 100};
        int[] yPoints = {100, HEIGHT - 100, HEIGHT - 100};

        g2d.drawPolygon(xPoints, yPoints, 3);

        int[] xInnerPoints = {WIDTH / 2, WIDTH / 4, 3 * WIDTH / 4};
        int[] yInnerPoints = {HEIGHT / 2, HEIGHT / 4, HEIGHT / 4};

        g2d.drawPolygon(xInnerPoints, yInnerPoints, 3); 
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.add(new MainWindow());
        frame.setVisible(true);
    }
}