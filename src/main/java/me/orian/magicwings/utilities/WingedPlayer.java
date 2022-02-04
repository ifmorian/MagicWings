package me.orian.magicwings.utilities;

import me.orian.magicwings.wings.Wings;
import org.bukkit.Location;

public class WingedPlayer {

    private Location lastLocation;
    private boolean isMoving = false;
    private Wings[] wings = {null, null};

    public WingedPlayer(Location lastLocation, Wings[] wings) {
        this.lastLocation = lastLocation;
        this.wings = wings;
    }

    public WingedPlayer(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public Wings[] getWings() {
        return wings;
    }

    public void update(Location l) {
        isMoving = !l.equals(lastLocation);
        lastLocation = l;
    }
}
