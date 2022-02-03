package me.orian.magicwings.wings;

import me.orian.utilities.Point3D;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

public class Wings {

    public Location l;
    public Point3D[] points;
    public Particle particle;
    public int thickness = 1;
    public Color color;
    public double offx = 0;
    public double offy = 0;
    public double offz = 0;
    public double speed = 0;

    private boolean hasOffset = true;
    private boolean hasSpeed = true;
    private boolean hasThickness = true;

    public Wings(Location l, Point3D[] points, Color color, int thickness,  double offx, double offy, double offz, double speed) {
        this.l = l;
        this.points = points;
        this.particle = Particle.REDSTONE;
        this.thickness = thickness;
        this.color = color;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
    }

    public Wings(Location l, Point3D[] points, Color color, int thickness, double offx, double offy, double offz) {
        this.l = l;
        this.points = points;
        this.particle = Particle.REDSTONE;
        this.thickness = thickness;
        this.color = color;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasSpeed = false;
    }

    public Wings(Location l, Point3D[] points, Color color, int thickness) {
        this.l = l;
        this.points = points;
        this.particle = Particle.REDSTONE;
        this.thickness = thickness;
        this.color = color;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasOffset = false;
        this.hasSpeed = false;
    }

    public Wings(Location l, Point3D[] points, Color color) {
        this.l = l;
        this.points = points;
        this.particle = Particle.REDSTONE;
        this.thickness = thickness;
        this.color = color;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;


        this.hasOffset = false;
        this.hasSpeed = false;
        this.hasThickness = false;
    }

    public Wings(Location l, Point3D[] points, Particle particle, int thickness,  double offx, double offy, double offz, double speed) {
        this.l = l;
        this.points = points;
        this.particle = particle;
        this.thickness = thickness;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
    }

    public Wings(Location l, Point3D[] points, Particle particle, int thickness, double offx, double offy, double offz) {
        this.l = l;
        this.points = points;
        this.particle = particle;
        this.thickness = thickness;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;

        this.hasSpeed = false;
    }

    public Wings(Location l, Point3D[] points, Particle particle, int thickness) {
        this.l = l;
        this.points = points;
        this.particle = particle;
        this.thickness = thickness;

        this.hasOffset = false;
        this.hasSpeed = false;
    }

    public Wings(Location l, Point3D[] points, Particle particle) {
        this.l = l;
        this.points = points;
        this.particle = particle;

        this.hasOffset = false;
        this.hasSpeed = false;
        this.hasThickness = false;
    }

    public void addToPlayer() {

    }

    public void spawnWings() {

    }
}
