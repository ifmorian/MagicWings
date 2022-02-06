package me.orian.magicwings.wings;

import me.orian.magicwings.utilities.Point3D;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

public class SingleColorWings extends Wings {

    private Color color;
    private Point3D[] points;
    private float size;

    public SingleColorWings(Point3D[] points, int density, float size, double offx, double offy, double offz, double speed, Color color) {
        super(density, offx, offy, offz, speed);
        this.color = color;
        this.points = points;
        this.size = size;
    }

    public void spawnParticles(Location l, float angle, float offset, int factor) {
        World world = l.getWorld();
        for(Point3D point : points) {
            Point3D p = new Point3D(factor * point.getX(), point.getY(), point.getZ());
            p = p.rotateYaw(angle + offset);
            double x = l.getX() + p.getX();
            double y = l.getY() + p.getY();
            double z = l.getZ() + p.getZ();
            world.spawnParticle(Particle.REDSTONE, new Location(world, x, y, z), density, new Particle.DustOptions(color, size));
        }
    }

}
