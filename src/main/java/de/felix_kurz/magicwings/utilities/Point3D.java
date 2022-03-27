package de.felix_kurz.magicwings.utilities;

public class Point3D {

    private float x;
    private float y;
    private float z;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D rotateYaw(float angle) {
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));

        return new Point3D((float) (x * cos + z * sin), y, (float) (x * sin + z * cos));
    }

    public void setYaw(float angle) {
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));

        this.x = (float) (x * cos + z * sin);
        this.z = (float) (x * sin + z * cos);
    }

    public String stringValue() {
        return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z);
    }

}
