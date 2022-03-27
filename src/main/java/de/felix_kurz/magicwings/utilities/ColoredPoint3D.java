package de.felix_kurz.magicwings.utilities;

import org.bukkit.Color;
import org.bukkit.plugin.Plugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ColoredPoint3D extends Point3D {

    private Color color;
    private static int c = 20;

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
            List<ColoredPoint3D> points = new ArrayList<ColoredPoint3D>();
            for(int x = 0; x < c; x++) {
                for (int y = 0; y < c; y++) {
                    int color = img.getRGB((int) ((double) x / c * width), (int) ((double) y / c * height));
                    if((color >> 24) != 0x00) {
                        points.add(new ColoredPoint3D((float) x / (c / 2), (c - (float) y) / (c / 2), 0, Color.fromRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff)));
                    }
                }
            }
            ColoredPoint3D[] array = new ColoredPoint3D[points.size()];
            for(int i = 0; i < array.length; i++) {
                array[i] = points.get(i);
            }
            return array;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
