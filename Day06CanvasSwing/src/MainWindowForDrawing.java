import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MainWindowForDrawing extends JFrame {
    public MainWindowForDrawing() {
        add(new DrawingPanel());
    }

    public static void main(String[] args) {
        MainWindowForDrawing window = new MainWindowForDrawing();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(0, 0, 100, 100);
        g.setColor(Color.BLUE);
        g.drawRect(100, 100, 100, 100);
        g.setColor(Color.GREEN);
        g.drawOval(200, 200, 100, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(300, 300, 100, 100);
        g.setColor(Color.ORANGE);
        g.fillRect(400, 400, 100, 100);
    }
}
