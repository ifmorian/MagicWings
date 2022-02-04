package me.orian.magicwings.wings;

import me.orian.magicwings.utilities.Point3D;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Wings {

    public Point3D[] points;
    public Particle particles;
    public int thickness = 1;
    public Color color1;
    public Color color2;
    public double offx = 0;
    public double offy = 0;
    public double offz = 0;
    public double speed = 0;

    private boolean hasOffset = true;
    private boolean hasSpeed = true;
    private boolean hasThickness = true;

    public Wings(Point3D[] points, Color color1, Color color2, int thickness, double offx, double offy, double offz, double speed) {
        this.points = points;
        this.particles = Particle.REDSTONE;
        this.thickness = thickness;
        this.color1 = color1;
        this.color2 = color2;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
    }

    public Wings(Point3D[] points, Color color1, int thickness, double offx, double offy, double offz, double speed) {
        this.points = points;
        this.particles = Particle.REDSTONE;
        this.thickness = thickness;
        this.color1 = this.color2 = color1;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
    }

    public Wings(Point3D[] points, Color color1, int thickness, double offx, double offy, double offz) {
        this.points = points;
        this.particles = Particle.REDSTONE;
        this.thickness = thickness;
        this.color1 = this.color2 = color1;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasSpeed = false;
    }

    public Wings(Point3D[] points, Color color1, int thickness) {
        this.points = points;
        this.particles = Particle.REDSTONE;
        this.thickness = thickness;
        this.color1 = this.color2 = color1;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasOffset = false;
        this.hasSpeed = false;
    }

    public Wings(Point3D[] points, Color color1) {
        this.points = points;
        this.particles = Particle.REDSTONE;
        this.thickness = thickness;
        this.color1 = this.color2 = color1;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;


        this.hasOffset = false;
        this.hasSpeed = false;
        this.hasThickness = false;
    }

    public Wings(Point3D[] points, Particle particles, int thickness, double offx, double offy, double offz, double speed) {
        this.points = points;
        this.particles = particles;
        this.thickness = thickness;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
    }

    public Wings(Point3D[] points, Particle particles, int thickness, double offx, double offy, double offz) {
        this.points = points;
        this.particles = particles;
        this.thickness = thickness;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasSpeed = false;
    }

    public Wings(Point3D[] points, Particle particles, int thickness) {
        this.points = points;
        this.particles = particles;
        this.thickness = thickness;

        this.hasOffset = false;
        this.hasSpeed = false;
    }

    public Wings(Point3D[] points, Particle particles) {
        this.points = points;
        this.particles = particles;

        this.hasOffset = false;
        this.hasSpeed = false;
        this.hasThickness = false;
    }

    public void spawnWings(Location location) {
        float angle = location.getYaw();
        Vector d = location.getDirection();
        d.setY(0);
        d.normalize();
        Location l = location.add(d.multiply(-0.3));
        spawnParticles(l, angle, -20, 1);
        spawnParticles(l, angle, 20, -1);
    }

    private void spawnParticles(Location l, float angle, float offset, int factor) {
        World world = l.getWorld();
        for(Point3D point : points) {
            Point3D p = new Point3D(factor * point.getX(), point.getY(), point.getZ());
            p = p.rotateYaw(angle + offset);
            double x = l.getX() + p.getX();
            double y = l.getY() + p.getY();
            double z = l.getZ() + p.getZ();
            if(particles.equals(Particle.REDSTONE)) {
                world.spawnParticle(particles, new Location(world, x, y, z), thickness, new Particle.DustTransition(color1, color2, 1F));
            } else {
                world.spawnParticle(particles, new Location(world, x, y, z), thickness, offx, offy, offz, speed);
            }
        }
    }
}
