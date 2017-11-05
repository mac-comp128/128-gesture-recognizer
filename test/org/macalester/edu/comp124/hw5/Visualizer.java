package org.macalester.edu.comp124.hw5;

import comp124graphics.*;
import comp124graphics.Rectangle;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;


public class Visualizer extends CanvasWindow {

    private Recognizer recognizer;
    private List<Point2D> originalPoints;

    public Visualizer(){
        super("$1 Recognizer Visualizer", 600, 600);

        recognizer = new Recognizer();
        IOManager ioManager = new IOManager();
        originalPoints = ioManager.loadGesture("arrowTest.xml");

        drawLegend();
        drawAxes();
        visualizeSteps();
    }

    private void visualizeSteps(){
        drawPath(originalPoints, Color.BLACK);

//
//        int n = 25;
//        List<Point2D> resampled = recognizer.resample(originalPoints, n);
//        drawPath(resampled, Color.BLUE);
//
//        List<Point2D> rotated = recognizer.rotateBy(resampled, Math.PI);
//        drawPath(rotated, Color.RED);
//
//        List<Point2D> scaled = recognizer.scaleTo(rotated, 100);
//        drawPath(scaled, Color.GREEN);
//
//        List<Point2D> translated = recognizer.translateTo(scaled, new Point2D.Double(0.0,0.0));
//        drawPath(translated, Color.MAGENTA);
    }

    private void drawLegend(){
        GraphicsGroup legend = new GraphicsGroup();
        legend.add(createLegendRow(Color.BLUE, "Resampled"), 0, 0);
        legend.add(createLegendRow(Color.RED, "Rotated"), 0, 25);
        legend.add(createLegendRow(Color.GREEN, "Scaled"), 0, 50);
        legend.add(createLegendRow(Color.MAGENTA, "Translated"), 0, 75);
        add(legend, 10, 10);
    }

    private void drawAxes(){
        Line xAxis = new Line(getWidth()/2.0-10, getHeight()/2.0, getWidth(), getHeight()/2.0);
        xAxis.setStrokeColor(Color.LIGHT_GRAY);
        add(xAxis);
        Line yAxis = new Line(getWidth()/2.0, getHeight()/2.0-10, getWidth()/2.0, getHeight());
        yAxis.setStrokeColor(Color.LIGHT_GRAY);
        add(yAxis);
        GraphicsText text = new GraphicsText("(0,0)", getWidth()/2-20, getHeight()/2-20);
        text.setStrokeColor(Color.LIGHT_GRAY);
        add(text);
    }

    private GraphicsGroup createLegendRow(Color color, String label){
        GraphicsGroup row = new GraphicsGroup();
        Rectangle rect = new Rectangle(0,0,20,20);
        rect.setFilled(true);
        rect.setFillColor(color);
        row.add(rect);
        GraphicsText text = new GraphicsText(label, 30, 0);
        int height = text.getFont().getSize();
        text.setY(height);
        row.add(text);
        return row;
    }


    //For debugging
    private void drawPath(List<Point2D> path, Color color){
        Iterator<Point2D> it = path.iterator();
        GraphicsGroup group = new GraphicsGroup(getWidth()/2.0, getHeight()/2.0);
        while(it.hasNext()){
            Point2D p = it.next();
            Ellipse e = new Ellipse(p.getX(), p.getY(), 5, 5);
            e.setFilled(true);
            e.setStroked(false);
            e.setFillColor(color);
            group.add(e);
        }
        add(group);
    }

    public static void main(String[] args){
        Visualizer vis = new Visualizer();
    }
}
