package Ayoub;

import javax.swing.*;
import java.awt.*;

public class DrawPanel implements Runnable
{
    static int width = 250;
    static int height = 250;
    JFrame application;
    public void run()
    {
        application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(new IDrawPanel());
        application.setSize(width, height);
        application.setVisible(true);
    }
    public static void main(String[] args)
    {
        DrawPanel dp = new DrawPanel();
        SwingUtilities.invokeLater(dp);
    }
    class IDrawPanel extends JPanel
    {
        int steps = 16;
        Color clr = new Color(0, 192, 0);
        public void paint(Graphics gr)
        {
            int hgt, wid, x1, y1, x2, y2, x3, y3, hst, vst;
            Graphics2D g2 = (Graphics2D)gr;
            g2.setColor(clr);
            wid = getWidth();
            hgt = getHeight();
            hst = wid / steps;
            vst = hgt / steps;
            x1 = y1 = 0;
            x3 = wid - 1;
            y3 = hgt - 1;
            for (x2 = hst, y2 = hgt - vst;
                 x2 < wid && y2 > 0;
                 x2 += hst, y2 -= vst)
            {
                g2.drawLine(x1, y1, x2, y2);
                g2.drawLine(x2, y2, x3, y3);
            }
        }
    }
}