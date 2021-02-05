package searchandsort;

import java.text.DecimalFormat;

public class OptimumLocationOfPoint {

    private static double pointDistance(Point point, double x, double y) {
        return Math.sqrt((point.x - x) * (point.x - x) + (point.y - y) * (point.y - y));
    }

    // find minimum cost
    private static double totalDistance(Point[] points, Line line, double x) {
        double y = -1 * (line.c + line.a * x) / line.b;
        double result = 0;
        for (Point p : points) {
            result += pointDistance(p, x, y);
        }
        return result;
    }

    private static Result minimumCost(Point[] points, Line line) {
        double low = -1e9;
        double high = 1e9;
        double eps = 1e-9;
        double mid1 = 0, mid2 = 0;

        while ((high - low) > eps) {
            mid1 = low + (high - low) / 3;
            mid2 = high - (high - low) / 3;
            double dist1 = totalDistance(points, line, mid1);
            double dist2 = totalDistance(points, line, mid2);
            if (dist1 < dist2) {
                high = mid2;
            } else {
                low = mid1;
            }
        }

        double x = (mid1 + mid2) / 2;
        double y = -1 * (line.c + line.a * x) / line.b;
        double distance = totalDistance(points, line, x);

        return new Result(x, y, distance);
    }

    private static Result optimumPoint(Line line, int[][] pointArr) {
        Point[] points = new Point[pointArr.length];
        for (int i = 0; i < pointArr.length; i++) {
            points[i] = new Point(pointArr[i][0], pointArr[i][1]);
        }
        return minimumCost(points, line);
    }

    public static void main(String[] args) {
        Line line = new Line(1, -1, -3);
        int[][] points = {{-3, -2}, {-1, 0}, {-1, 2}, {1, 2}, {3, 4}};
        System.out.println(optimumPoint(line, points));
    }

    private static class Result {
        double x, y;
        double distance;

        Result(double x, double y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            DecimalFormat d = new DecimalFormat("#0.000");
            return "Result{" +
                    "x=" + d.format(x) +
                    ", y=" + d.format(y) +
                    ", distance=" + d.format(distance) +
                    '}';
        }
    }

    // point class
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    // line class
    private static class Line {
        int a, b, c;

        Line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

}
