package com.evosim.ui;

import com.evosim.util.Vector2;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import com.evosim.creature.Simulator;

public class GameViewController extends AnimationTimer {
    private GraphicsContext gc;
    private Simulator simulator;
    private long previous;

    private final double simulatorWidth = 5000.0;
    private final double pixelsPerMeter = 100.0;

    private double canvasWidth, canvasHeight;

    public GameViewController(GraphicsContext gc) {
        this.gc = gc;
        simulator = new Simulator();

    }

    @Override
    public void handle(long now) {
        double refreshRate = 30;
        if (now - previous >= (1_000_000_000) / refreshRate) {
            canvasWidth = gc.getCanvas().getWidth();
            canvasHeight = gc.getCanvas().getHeight();

            drawSimulator();

            simulator.cameraPos.add(new Vector2(0.01, 0));

            drawBorders(4, Color.BLACK);
            previous = now;
        }
    }

    private void drawBorders(int thickness, Color color){
        double width = canvasWidth;
        double height = canvasHeight;

        gc.setFill(color);
        gc.fillRect(0, 0, width, thickness);
        gc.fillRect(0, height - thickness, width, thickness);
        gc.fillRect(0, 0, thickness, height);
        gc.fillRect(width - thickness, 0, thickness, height);
    }

    private void drawSimulator() {

        gc.setFill(Color.CYAN);
        gc.fillRect(0,0, canvasWidth, canvasHeight);
        gc.setFill(Color.GREEN);
        Vector2 center = Vector2.scale(simulator.cameraPos, pixelsPerMeter);

        gc.fillRect(convertSpaceToScreenCoord(center).x - simulatorWidth / 2,
                    convertSpaceToScreenCoord(center).y,
                    simulatorWidth,
                    simulatorWidth);


        gc.setFill(Color.BLACK);

        for (int i = -100; i <= 100; i++) {
            gc.fillText(i + " [m]", i * pixelsPerMeter + canvasWidth / 2 - center.x + 5, 100);
            gc.fillRect(i * pixelsPerMeter + canvasWidth / 2 - center.x, 0, 1, 5000);
        }
    }

    private Vector2 convertSpaceToScreenCoord(Vector2 in) {
        return new Vector2(canvasWidth / 2 - in.x, canvasHeight / 2 + in.y);
    }


}
