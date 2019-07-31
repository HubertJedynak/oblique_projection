package oblique_projection;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Drawing implements Runnable {

    protected static void draw() {

        Thread thread = new Thread(new Drawing());
        thread.start();
    }

    private static void scale() {
        Graphics graphics = WW.pscale.getGraphics();

        int i = 10;
        graphics.setColor(new Color(200, 200, 200));
        while (i < 290) {
            graphics.drawLine(10, i, 290, i);
            i += 20;
        }

        i = 10;

        while (i <= 290) {
            graphics.drawLine(i, 10, i, 290);
            i += 20;
        }

        graphics.setColor(new Color(0, 0, 0));
        graphics.drawLine(10, 290, 10, 10);
        graphics.drawLine(5, 15, 10, 10);
        graphics.drawLine(15, 15, 10, 10);

        graphics.drawLine(10, 290, 290, 290);
        graphics.drawLine(290, 290, 285, 295);
        graphics.drawLine(290, 290, 285, 285);

        int x = 285;
        int y = 275;
        graphics.drawLine(x - 3, y - 5, x + 3, y + 5);
        graphics.drawLine(x - 3, y + 5, x + 3, y - 5);
        x++;
        graphics.drawLine(x - 3, y - 5, x + 3, y + 5);
        graphics.drawLine(x - 3, y + 5, x + 3, y - 5);

        x = 25;
        y = 15;
        graphics.drawLine(x - 3, y - 5, x, y);
        graphics.drawLine(x - 3, y + 5, x + 3, y - 5);
        x++;
        graphics.drawLine(x - 3, y - 5, x, y);
        graphics.drawLine(x - 3, y + 5, x + 3, y - 5);

    }

    @Override
    public void run() {
        scale();

        Graphics graphics = WW.pcurve.getGraphics();
        graphics.setColor(new Color(0, 255, 255, 100));

        double t = 0;
        while (t < 10.0) {

            graphics.fillOval((int) (Calculations.x(t)), (int) (Calculations.y(t)), 5, 5);
            synchronized (this) {
                try {
                    wait(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            t = t + 0.01;
        }
    }

}
