package me.orian.magicwings.utilities;

import org.bukkit.Color;
import org.bukkit.plugin.Plugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColoredPoint3D extends Point3D {

    private Color color;
    private static int c = 90;

    public ColoredPoint3D(float x, float y, float z, Color color) {
        super(x, y, z);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ColoredPoint3D rotateYawColor(float angle) {
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));

        return new ColoredPoint3D((float) (this.getX() * cos + this.getZ() * sin), this.getY(), (float) (this.getX() * sin + this.getZ() * cos), color);
    }

    public static ColoredPoint3D[] createSetFromPicture(String imgName, Plugin plugin) {
        try {
            File f = new File(plugin.getDataFolder() + File.separator + "wings" + File.separator + imgName);
            BufferedImage img = ImageIO.read(f);
            int width = img.getWidth();
            int height = img.getHeight();
            ColoredPoint3D[] points = new ColoredPoint3D[c * c];
            for(int x = 0; x < c; x++) {
                for (int y = c - 1; y >= 0; y--) {
                    int color = img.getRGB((int) ((double) x / c * width), (int) ((double) y / c * height));
                    points[x * c + y] = (new ColoredPoint3D((float) x / (c / 4), (float) y / (c / 4), 0, Color.fromRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff)));
                }
            }
            return points;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
