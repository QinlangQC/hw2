//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.File;

public class DrawingCanvas extends Canvas {
    private Image imgBuf;
    private Graphics imgGraphic;
    private Graphics visibleGraphic;
    public static final int MaxX = 1024;
    public static final int MaxY = 768;
    private int printCount = 0;

    public DrawingCanvas() {
    }

    public void addNotify() {
        super.addNotify();
        this.setBackground(Color.white);
        this.imgBuf = this.createImage(1024, 768);
        this.imgGraphic = this.imgBuf.getGraphics();
        this.imgGraphic.setPaintMode();
        this.imgGraphic.setColor(Color.black);
        this.visibleGraphic = this.getGraphics();
        this.clear(false);
    }

    public void print(Graphics var1) {
        super.print(var1);
    }

    public void paint(Graphics var1) {
        var1.drawImage(this.imgBuf, 0, 0, (ImageObserver)null);
    }

    public void setFontSize(int var1) {
        this.imgGraphic.setFont(new Font("Arial", 0, var1));
    }

    public void update(Graphics var1) {
        this.paint(var1);
    }

    public Dimension getPreferredSize() {
        return new Dimension(Math.min(640, 1024), Math.min(480, 768));
    }

    public Dimension getMaximumSize() {
        return new Dimension(1024, 768);
    }

    public void display() {
        Dimension var1 = this.getSize();
        this.display(0, 0, var1.width, var1.height);
    }

    public void display(int var1, int var2, int var3, int var4) {
        Shape var5 = this.visibleGraphic.getClip();
        this.visibleGraphic.setClip(var1, var2, var3 + 1, var4 + 1);
        this.visibleGraphic.drawImage(this.imgBuf, 0, 0, (ImageObserver)null);
        this.visibleGraphic.setClip(var5);
        this.repaint();
    }

    public Graphics getBackingGraphics() {
        return this.imgGraphic;
    }

    public void clear() {
        this.clear(true);
    }

    public void clear(boolean var1) {
        Color var2 = this.imgGraphic.getColor();
        this.imgGraphic.setColor(Color.white);
        this.imgGraphic.fillRect(0, 0, 1024, 768);
        this.imgGraphic.setColor(var2);
        if(var1) {
            this.display();
        }

    }

    public void setForeground(Color var1) {
        if(this.imgGraphic != null) {
            this.imgGraphic.setColor(var1);
        }

    }

    public void setColor(Color var1) {
        if(this.imgGraphic != null) {
            this.imgGraphic.setColor(var1);
        }

    }

    public void drawLine(int var1, int var2, int var3, int var4) {
        this.drawLine(var1, var2, var3, var4, true);
    }

    public void drawLine(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.drawLine(var1, var2, var3, var4);
        if(var5) {
            this.display(Math.min(var1, var3), Math.min(var2, var4), Math.abs(var3 - var1) + 1, Math.abs(var4 - var2) + 1);
        }

    }

    public void drawRect(int var1, int var2, int var3, int var4) {
        this.drawRect(var1, var2, var3, var4, true);
    }

    public void drawRect(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.drawRect(var1, var2, var3, var4);
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void fillRect(int var1, int var2, int var3, int var4) {
        this.fillRect(var1, var2, var3, var4, true);
    }

    public void fillRect(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.fillRect(var1, var2, var3 + 1, var4 + 1);
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void clearRect(int var1, int var2, int var3, int var4) {
        this.clearRect(var1, var2, var3, var4, true);
    }

    public void clearRect(int var1, int var2, int var3, int var4, boolean var5) {
        Color var6 = this.imgGraphic.getColor();
        this.imgGraphic.setColor(Color.white);
        this.imgGraphic.fillRect(var1, var2, var3, var4);
        this.imgGraphic.setColor(var6);
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void drawString(String var1, int var2, int var3) {
        this.drawString(var1, var2, var3, true);
    }

    public void drawString(String var1, int var2, int var3, boolean var4) {
        this.imgGraphic.drawString(var1, var2, var3);
        if(var4) {
            FontMetrics var5 = this.imgGraphic.getFontMetrics();
            this.display(var2, var3 - var5.getMaxAscent(), var5.stringWidth(var1) + var5.getMaxAdvance(), var5.getMaxAscent() + var5.getMaxDescent());
        }

    }

    public void drawOval(int var1, int var2, int var3, int var4) {
        this.drawOval(var1, var2, var3, var4, true);
    }

    public void drawOval(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.drawOval(var1, var2, var3, var4);
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void fillOval(int var1, int var2, int var3, int var4) {
        this.fillOval(var1, var2, var3, var4, true);
    }

    public void fillOval(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.fillOval(var1, var2, var3, var4);
        this.imgGraphic.drawOval(var1, var2, var3, var4);
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void drawArc(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.drawArc(var1, var2, var3, var4, var5, var6, true);
    }

    public void drawArc(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.imgGraphic.drawArc(var1, var2, var3, var4, var5, var6);
        if(var7) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void fillArc(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.fillArc(var1, var2, var3, var4, var5, var6, true);
    }

    public void fillArc(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.imgGraphic.fillArc(var1, var2, var3, var4, var5, var6);
        this.imgGraphic.drawArc(var1, var2, var3, var4, var5, var6);
        if(var7) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void invertLine(int var1, int var2, int var3, int var4) {
        this.invertLine(var1, var2, var3, var4, true);
    }

    public void invertLine(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.setXORMode(Color.white);
        this.imgGraphic.drawLine(var1, var2, var3, var4);
        this.imgGraphic.setPaintMode();
        if(var5) {
            this.display(Math.min(var1, var3), Math.min(var2, var4), Math.abs(var3 - var1) + 1, Math.abs(var4 - var2) + 1);
        }

    }

    public void invertRect(int var1, int var2, int var3, int var4) {
        this.invertRect(var1, var2, var3, var4, true);
    }

    public void invertRect(int var1, int var2, int var3, int var4, boolean var5) {
        this.imgGraphic.setXORMode(Color.white);
        this.imgGraphic.drawRect(var1, var2, var3, var4);
        this.imgGraphic.setPaintMode();
        if(var5) {
            this.display(var1, var2, var3, var4);
        }

    }

    public void drawImage(String var1, int var2, int var3, int var4, int var5) {
        this.drawImage(var1, var2, var3, var4, var5, true);
    }

    public void drawImage(String var1, int var2, int var3, int var4, int var5, boolean var6) {
        File var7 = new File(var1);
        if(var7.canRead()) {
            MediaTracker var9 = new MediaTracker(this);
            Image var8 = Toolkit.getDefaultToolkit().getImage(var1);
            var9.addImage(var8, 0);

            try {
                var9.waitForID(0);
            } catch (Exception var11) {
                ;
            }

            this.imgGraphic.drawImage(var8, var2, var3, var4, var5, this.getBackground(), this);
        } else {
            this.imgGraphic.drawRect(var2, var3, var4, var5);
            this.imgGraphic.drawLine(var2, var3, var4, var5);
            this.imgGraphic.drawLine(var4, var3, var2, var5);
        }

        if(var6) {
            this.display();
        }

    }
}

