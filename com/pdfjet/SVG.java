/**
 *  SVG.java
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

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SVG {
    public static List<String> getSVGPaths(String fileName) throws IOException {
        List<String> paths = new ArrayList<String>();
        StringBuilder buf = new StringBuilder();
        boolean inPath = false;
        FileInputStream stream = new FileInputStream(fileName);
        int ch;
        while ((ch = stream.read()) != -1) {
            if (!inPath && buf.toString().endsWith("<path d=")) {
                inPath = true;
                buf.setLength(0);
            } else if (inPath && ch == '\"') {
                inPath = false;
                paths.add(buf.toString());
                buf.setLength(0);
            } else {
                buf.append((char) ch);
            }
        }
        stream.close();
        return paths;
    }

    private static boolean isCommand(char ch) {
        // Please note:
        // Capital letter commands use absolute coordinates
        // Small letter commands use relative coordinates
        if (ch == 'M' || ch == 'm') {           // moveto
            return true;
        } else if (ch == 'L' || ch == 'l') {    // lineto
            return true;
        } else if (ch == 'H' || ch == 'h') {    // horizontal lineto
            return true;
        } else if (ch == 'V' || ch == 'v') {    // vertical lineto
            return true;
        } else if (ch == 'C' || ch == 'c') {    // cubic curveto
            return true;
        } else if (ch == 'S' || ch == 's') {    // smooth cubic curveto
            return true;
        } else if (ch == 'Q' || ch == 'q') {    // quadratic curveto
            return true;
        } else if (ch == 'T' || ch == 't') {    // smooth quadratic curveto
            return true;
        } else if (ch == 'A' || ch == 'a') {    // elliptical arc
            return true;
        } else if (ch == 'Z' || ch == 'z') {    // close path
            return true;
        }
        return false;
    }

    public static List<PathOp> getSVGPathOps(List<String> paths) {
        List<PathOp> operations = new ArrayList<PathOp>();
        PathOp op = null;
        for (String path : paths) {
            // Path example:
            // "M22.65 34h3v-8.3H34v-3h-8.35V14h-3v8.7H14v3h8.65ZM24 44z"
            System.out.println(path);
            System.out.println();
            StringBuilder buf = new StringBuilder();
            boolean token = false;
            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                if (isCommand(ch)) {                    // open path
                    if (token) {
                        op.args.add(buf.toString());
                        buf.setLength(0);
                    }
                    token = false;
                    op = new PathOp(ch);
                    operations.add(op);
                } else if (ch == ' ' || ch == ',') {
                    if (token) {
                        op.args.add(buf.toString());
                        buf.setLength(0);
                    }
                    token = false;
                } else if (ch == '-') {
                    if (token) {
                        op.args.add(buf.toString());
                        buf.setLength(0);
                    }
                    token = true;
                    buf.append(ch);
                } else if (ch == '.') {
                    if (buf.toString().contains(".")) {
                        op.args.add(buf.toString());
                        buf.setLength(0);
                    }
                    token = true;
                    buf.append(ch);
                } else {
                    token = true;
                    buf.append(ch);
                }
            }
        }
        return operations;
    }

    public static List<PathOp> getPDFPathOps(List<PathOp> list) {
        List<PathOp> operations = new ArrayList<PathOp>();
        float x0 = 0f;  // Subpath initial point x
        float y0 = 0f;  // Subpath initial point y
        float x = 0f;
        float y = 0f;
        PathOp pathOp = null;
        PathOp prevOp = null;
        for (PathOp op : list) {
            if (op.cmd == 'M') {
                x = Float.valueOf(op.args.get(0));
                y = Float.valueOf(op.args.get(1));
                x0 = x;
                y0 = y;
                pathOp = new PathOp('M', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'm') {
                x += Float.valueOf(op.args.get(0));
                y += Float.valueOf(op.args.get(1));
                x0 = x;
                y0 = y;
                pathOp = new PathOp('M', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'L') {
                x = Float.valueOf(op.args.get(0));
                y = Float.valueOf(op.args.get(1));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'l') {
                x += Float.valueOf(op.args.get(0));
                y += Float.valueOf(op.args.get(1));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'H') {
                x = Float.valueOf(op.args.get(0));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'h') {
                x += Float.valueOf(op.args.get(0));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'V') {
                y = Float.valueOf(op.args.get(0));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'v') {
                y += Float.valueOf(op.args.get(0));
                pathOp = new PathOp('L', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 'Q') {
            } else if (op.cmd == 'q') {
                pathOp = new PathOp('Q');
                for (int i = 0; i <= op.args.size() - 4; i += 4) {
                    float x1 = x + Float.valueOf(op.args.get(i));
                    float y1 = y + Float.valueOf(op.args.get(i + 1));
                    pathOp.appendArgs(x1, y1);
                    x += Float.valueOf(op.args.get(i + 2));
                    y += Float.valueOf(op.args.get(i + 3));
                    pathOp.appendArgs(x, y);
                }
                operations.add(pathOp);
            } else if (op.cmd == 'T') {
                x = Float.valueOf(op.args.get(0));
                y = Float.valueOf(op.args.get(1));
                pathOp = new PathOp('T', x, y);
                operations.add(pathOp);
            } else if (op.cmd == 't') {
                if (prevOp.cmd == 'Q' || prevOp.cmd == 'q') {
                    pathOp = new PathOp('Q', prevOp.x1, prevOp.y1);
                } else {
                    pathOp = new PathOp('Q');
                }

/*
                https://stackoverflow.com/questions/5287559/calculating-control-points-for-a-shorthand-smooth-svg-path-bezier-curve
                XR, YR is just the reflection of P2 about P3 so:

                XR = 2*X3 - X2 and 
                YR = 2*Y3 - Y2
*/

            } else if (op.cmd == 'Z' || op.cmd == 'z') {
                x = x0;
                y = y0;
            }
            prevOp = pathOp;
        }
        return operations;
    }

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("test.svg");
        writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"48\" width=\"48\">\n");
        // writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" height=\"100\" width=\"100\">\n");
        writer.write("  <path d=\"");
        // writer.write("M 20 20 q 0 60 60 60 0 -60 -60 -60 Z");
        List<String> paths = getSVGPaths(args[0]);
        List<PathOp> svgPathOps = getSVGPathOps(paths);
        List<PathOp> pdfPathOps = getPDFPathOps(svgPathOps);
        for (PathOp op : pdfPathOps) {
            System.out.print(op.cmd + " ");
            writer.write(op.cmd + " ");
            for (String argument : op.args) {
                System.out.print(argument + " ");
                writer.write(argument + " ");
            }
        }
        System.out.println();
        writer.write("\"/>\n");
        writer.write("</svg>\n");
        writer.flush();
        writer.close();
    }
}

