package me.orian.magicwings.wings;

import me.orian.magicwings.utilities.ColoredPoint3D;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

public class MulitpleColorWings extends Wings {

    private ColoredPoint3D[] points;
    private float size;

    public MulitpleColorWings(ColoredPoint3D[] points, int density, float size, double offx, double offy, double offz, double speed) {
        super(density, offx, offy, offz, speed);
        this.points = points;
        this.size = size;
    }

    public void spawnParticles(Location l, float angle, float offset, int factor) {
        World world = l.getWorld();
        for(ColoredPoint3D point : points) {
            ColoredPoint3D p = new ColoredPoint3D(factor * point.getX(), point.getY(), point.getZ(), point.getColor());
            p = p.rotateYawColor(angle + offset);
            double x = l.getX() + p.getX();
            double y = l.getY() + p.getY();
            double z = l.getZ() + p.getZ();

            world.spawnParticle(Particle.REDSTONE, new Location(world, x, y, z), density, new Particle.DustOptions(p.getColor(), size));
        }
    }

}
