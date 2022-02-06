package me.orian.magicwings.wings;

import me.orian.magicwings.utilities.Point3D;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

public class ParticleWings extends Wings {

    Particle particles;
    Point3D[] points;

    public ParticleWings(Point3D[] points, int density, double offx, double offy, double offz, double speed, Particle particles) {
        super(density, offx, offy, offz, speed);
        this.particles = particles;
        this.points = points;
    }

    public void spawnParticles(Location l, float angle, float offset, int factor) {
        World world = l.getWorld();
        for(Point3D point : points) {
            Point3D p = new Point3D(factor * point.getX(), point.getY(), point.getZ());
            p = p.rotateYaw(angle + offset);
            world.spawnParticle(particles, new Location(world, l.getX() + p.getX(), l.getY() + p.getY(), l.getZ() + p.getZ()), density, offx, offy, offz, speed);
        }
    }

}
