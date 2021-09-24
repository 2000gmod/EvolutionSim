package com.evosim.util;

public class Vector2 {
    public double x, y;

    public static final Vector2 UP = new Vector2(0, 1);
    public static final Vector2 RIGHT = new Vector2(1, 0);
    public static final Vector2 LEFT = new Vector2(-1, 0);
    public static final Vector2 DOWN = new Vector2(0, -1);

    public static final Vector2 ZERO = new Vector2();

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 b) {
        this.x += b.x;
        this.y += b.y;
        return this;
    }

    public Vector2 scale(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2 subtract(Vector2 b) {
        return this.add(b.scale(-1));
    }

    public Vector2 divide(double scalar) {
        return this.scale(1 / scalar);
    }

    public double dot(Vector2 b) {
        return x * b.x + y * b.y;
    }

    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public static Vector2 subtract(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    public static Vector2 scale(Vector2 a, double scale) {
        return new Vector2(a.x * scale, a.y * scale);
    }

    public static double dot(Vector2 a, Vector2 b) {
        return a.dot(b);
    }


}
