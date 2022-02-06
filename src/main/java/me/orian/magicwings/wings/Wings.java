package me.orian.magicwings.wings;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public abstract class Wings {

    public int density = 1;
    public double offx;
    public double offy;
    public double offz;
    public double speed;

    private boolean hasOffset = true;
    private boolean hasSpeed = true;
    private boolean hasThickness = true;

    public Wings(int density, double offx, double offy, double offz, double speed) {
        this.density = density;
        this.offx = offx;
        this.offy = offy;
        this.offz = offz;
        this.speed = speed;
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

    public abstract void spawnParticles(Location l, float angle, float offset, int factor);

}
