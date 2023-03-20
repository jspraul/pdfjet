/**
 *  DonutChart.java
 *
Copyright 2023 Innovatics Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.pdfjet;

import java.util.*;


public class DonutChart {

	Font f1;
    Font f2;
	Float xc;
    Float yc;
    Float r1;
    Float r2;
	List<Float> angles;
	List<Integer> colors;
    boolean isDonutChart = true;
    
    public DonutChart(Font f1, Font f2, boolean isDonutChart) {
	    this.f1 = f1;
	    this.f2 = f2;
	    this.isDonutChart = isDonutChart;
        this.angles = new ArrayList<Float>();
        this.colors = new ArrayList<Integer>();
    }

    public void setLocation(Float xc, Float yc) {
        this.xc = xc;
        this.yc = yc;
    }

    public void setR1AndR2(Float r1, Float r2) {
        this.r1 = r1;
        this.r2 = r2;
        if (this.r1 < 1.0) {
            this.isDonutChart = false;
        }
    }
    
    private List<Point> getCurvePoints(Float xc, Float yc, Float r, Float angle1, Float angle2) {
        angle1 *= -1f;
        angle2 *= -1f;

        // Start point coordinates
        Float x1 = xc + r*((float) (Math.cos(angle1)*(Math.PI/180.0)));
        Float y1 = yc + r*((float) (Math.sin(angle1)*(Math.PI/180.0)));
        // End point coordinates
        Float x4 = xc + r*((float) (Math.cos(angle2)*(Math.PI/180.0)));
        Float y4 = yc + r*((float) (Math.sin(angle2)*(Math.PI/180.0)));
    
        Float ax = x1 - xc;
        Float ay = y1 - yc;
        Float bx = x4 - xc;
        Float by = y4 - yc;
        Float q1 = ax*ax + ay*ay;
        Float q2 = q1 + ax*bx + ay*by;
    
        Float k2 = 4f/3f * (((float) Math.sqrt(2f*q1*q2)) - q2) / (ax*by - ay*bx);
    
        Float x2 = xc + ax - k2*ay;
        Float y2 = yc + ay + k2*ax;
        Float x3 = xc + bx + k2*by;
        Float y3 = yc + by - k2*bx;
    
        List<Point> list = new ArrayList<Point>();
        list.add(new Point(x1, y1));
        list.add(new Point(x2, y2, Point.CONTROL_POINT));
        list.add(new Point(x3, y3, Point.CONTROL_POINT));
        list.add(new Point(x4, y4));
    
        return list;
    }

    public void drawSlice(
            Page page,
            Float xc, Float yc,
            Float r1, Float r2,     // r1 must be bigger that r2
            Float angle1, Float angle2) {
        // Start point coordinates
        Float x1 = xc + r1*((float) Math.cos(angle1));
        Float y1 = yc + r1*((float) Math.sin(angle1));
        // End point coordinates
        Float x4 = xc + r1*((float) Math.cos(angle2));
        Float y4 = yc + r1*((float) Math.sin(angle2));
    
        Float ax = x1 - xc;
        Float ay = y1 - yc;
        Float bx = x4 - xc;
        Float by = y4 - yc;
        Float q1 = ax*ax + ay*ay;
        Float q2 = q1 + ax*bx + ay*by;
        Float k2 = 4f/3f * (((float) Math.sqrt(2f*q1*q2)) - q2) / (ax*by - ay*bx);
    
        // Control points coordinates
        Float x2 = xc + ax - k2*ay;
        Float y2 = yc + ay + k2*ax;
        Float x3 = xc + bx + k2*by;
        Float y3 = yc + by - k2*bx;

        System.out.println(x1 + " " + y1);
        System.out.println(x2 + " " + y2);
        System.out.println(x3 + " " + y3);
        System.out.println(x4 + " " + y4);

        // Start point coordinates
        Float x5 = xc + r2*((float) Math.cos(angle1));
        Float y5 = yc + r2*((float) Math.sin(angle1));
        // End point coordinates
        Float x8 = xc + r2*((float) Math.cos(angle2));
        Float y8 = yc + r2*((float) Math.sin(angle2));
    
        ax = x5 - xc;
        ay = y5 - yc;
        bx = x8 - xc;
        by = y8 - yc;
        q1 = ax*ax + ay*ay;
        q2 = q1 + ax*bx + ay*by;
        k2 = 4f/3f * (((float) Math.sqrt(2f*q1*q2)) - q2) / (ax*by - ay*bx);
    
        // Control points coordinates
        Float x6 = xc + ax - k2*ay;
        Float y6 = yc + ay + k2*ax;
        Float x7 = xc + bx + k2*by;
        Float y7 = yc + by - k2*bx;

        page.moveTo(x1, y1);
        page.curveTo(x2, y2, x3, y3, x4, y4);
        page.lineTo(x8, y8);
        page.curveTo(x7, y7, x6, y6, x5, y5);
        page.fillPath();
    }

    // GetArcPoints calculates a list of points for a given arc of a circle
    // @param xc the x-coordinate of the circle's centre.
    // @param yc the y-coordinate of the circle's centre
    // @param r the radius of the circle.
    // @param angle1 the start angle of the arc in degrees.
    // @param angle2 the end angle of the arc in degrees.
    // @param includeOrigin whether the origin should be included in the list (thus creating a pie shape).
    private List<Point> getArcPoints(
            Float xc, Float yc, Float r, Float angle1, Float angle2, boolean includeOrigin) {
        List<Point> list = new ArrayList<Point>();

        if (includeOrigin) {
            list.add(new Point(xc, yc));
        }

        float startAngle;
        float endAngle;
        if (angle1 <= angle2) {
            startAngle = angle1;
            endAngle = angle1 + 90;
            while (endAngle < angle2) {
                list.addAll(getCurvePoints(xc, yc, r, startAngle, endAngle));
                startAngle += 90;
                endAngle += 90;
            }
            endAngle -= 90;
            list.addAll(getCurvePoints(xc, yc, r, endAngle, angle2));
        }
        else {
            startAngle = angle1;
            endAngle = angle1 - 90;
            while (endAngle > angle2) {
                list.addAll(getCurvePoints(xc, yc, r, startAngle, endAngle));
                startAngle -= 90;
                endAngle -= 90;
            }
            endAngle += 90;
            list.addAll(getCurvePoints(xc, yc, r, endAngle, angle2));
        }

        return list;
    }

    // GetDonutPoints calculates a list of points for a given donut sector of a circle.
    // @param xc the x-coordinate of the circle's centre.
    // @param yc the y-coordinate of the circle's centre.
    // @param r1 the inner radius of the donut.
    // @param r2 the outer radius of the donut.
    // @param angle1 the start angle of the donut sector in degrees.
    // @param angle2 the end angle of the donut sector in degrees.
    private List<Point> getDonutPoints(Float xc, Float yc, Float r1, Float r2, Float angle1, Float angle2) {
        List<Point> list = new ArrayList<Point>();
        list.addAll(getArcPoints(xc, yc, r1, angle1, angle2, false));
        list.addAll(getArcPoints(xc, yc, r2, angle2, angle1, false));
        return list;
    }

    // AddSector -- TODO:
    public void addSector(Float angle, int color) {
        this.angles.add(angle);
        this.colors.add(color);
    }

    // Draws donut chart on the specified page.
    public void drawOn(Page page) throws Exception {
        page.setBrushColor(Color.blueviolet);
        drawSlice(page, 300f, 300f, 200f, 100f, 0f, 90f);
/*
        Float startAngle = 0f;
        Float endAngle = 0f;
        int lastColorIndex = 0;
        for (int i = 0; i < angles.size(); i++) {
            endAngle = startAngle + angles.get(i);
            List<Point> list = new ArrayList<Point>();
            if (isDonutChart) {
                list.addAll(getDonutPoints(xc, yc, r1, r2, startAngle, endAngle));
            }
            else {
                list.addAll(getArcPoints(xc, yc, r2, startAngle, endAngle, true));
            }
            // for (Point point : list) {
            // 	point.drawOn(page);
            // }
            page.setBrushColor(colors.get(i));
            page.drawPath(list, Operation.FILL);
            startAngle = endAngle;
            lastColorIndex = i;
        }

        if (endAngle < 360f) {
            endAngle = 360f;
            List<Point> list = new ArrayList<Point>();
            if (isDonutChart) {
                list.addAll(getDonutPoints(xc, yc, r1, r2, startAngle, endAngle));
            }
            else {
                list.addAll(getArcPoints(xc, yc, r2, startAngle, endAngle, true));
            }
            // for (Point point : list) {
            // 	point.drawOn(page);
            // }
            // page.setBrushColor(colors.get(lastColorIndex));
            page.setBrushColor(Color.blue);
            page.drawPath(list, Operation.FILL);
        }
*/
    }

}
