package com.nerdysoft;

import java.util.ArrayList;

public class CheckFilePoints {
    private static ArrayList<String> stringArrayListPoints;
    private static ArrayList<String> strArrListPointDigit;

    CheckFilePoints(ArrayList<String> arrayList, ArrayList<String> arr) {
        stringArrayListPoints = arrayList;
        strArrListPointDigit = arr;
    }

    boolean step1ReadFile() {
        cleaningArrayListPoints();
        if (transformationStrArrayListPointsIntoInt()) {
            return true;
        }
        return false;
    }

    boolean step2CheckFile() {
        if (startCheckPoints()) {
            return true;   // a mistake
        }
        return false;
    }

    void showArrayListPointsChecking() {
        for (int i = 0; i < stringArrayListPoints.size(); i++) {
            System.out.print(stringArrayListPoints.get(i));
        }
        System.out.println(" size = " + stringArrayListPoints.size());
    }

    private void cleaningArrayListPoints() {

        for (int i = 0; i < stringArrayListPoints.size(); i++) {
            if (stringArrayListPoints.get(i).equals("(") || stringArrayListPoints.get(i).equals(")") || stringArrayListPoints.get(i).equals(",")) {
                stringArrayListPoints.remove(i);
            }
        }

        for (int i = 0; i < stringArrayListPoints.size(); i++) {
            if (stringArrayListPoints.get(i).equals(",")) {
                stringArrayListPoints.remove(i);
            }
        }
    }

    private boolean transformationStrArrayListPointsIntoInt() {
        ArrayList<Integer> integerArrayListPoints = new ArrayList<Integer>();

        for (int i = 0; i < stringArrayListPoints.size(); i++) {
            try {
                integerArrayListPoints.add(Integer.valueOf(stringArrayListPoints.get(i)));
            } catch (NumberFormatException e) {
                System.out.print("\nbut");
                System.err.println(" invalid format for specifying points in the file. " +
                        "Please fix the file and try again ");
                return true;
            }
        }
        return false;
    }


    boolean startCheckPoints() {
        checkPointsNumberDigit.transformationStringIntoInteger();
        if (checkPointsNumberDigit.pointsNotLessFour()) { // Illegal. The floor must have at least 4 corners
            return true;  // a mistake
        }
        if (checkPointsNumberDigit.pointsTwoFourSix()) { // Illegal.  No diagonal walls.(Number)
            return true; // a mistake
        }
        if (checkPointsNumberDigit.noDiagonalWall()) { //Illegal. No diagonal walls <<<-------
            return true; // a mistake
        }
        if (checkPointsNumberDigit.notLineX()) { // Illegal. Adjacent walls of the room must form right angles.
            return true; // a mistake
        }
        if (checkPointsNumberDigit.notLineY()) { // Illegal. Adjacent walls of the room must form right angles.
            return true; // a mistake
        }
        if (checkPointsNumberDigit.firstLastPoint()) { // Illegal. Duplicate point. No diagonal walls.
            return true; // a mistake
        }
        if (checkPointsNumberDigit.duplicatePointsCorner()) { // Illegal. Duplicate corners^^^(points)
            return true; // a mistake
        }
        if (checkPointsNumberDigit.intersectingLines()) { // Illegal. Intersecting lines
            return true; // a mistake
        }
        return false;
    }

    private CheckPointsNumberDigit checkPointsNumberDigit = new CheckPointsNumberDigit();

    private class CheckPointsNumberDigit {

        private void showInnerClassFileIn() {
            System.out.print("\n*** Inner class :  ");
            for (int i = 0; i < strArrListPointDigit.size(); i++) {
                System.out.print(strArrListPointDigit.get(i));
            }
        }

        ArrayList<Integer> pointsIntegerArrayList = new ArrayList<>();

        private void transformationStringIntoInteger() {
            for (int i = 0; i < strArrListPointDigit.size(); i++) {
                try {
                    pointsIntegerArrayList.add(Integer.valueOf(strArrListPointDigit.get(i)));
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            System.out.print("\n");

        }

        private boolean pointsNotLessFour() {
            if (8 <= pointsIntegerArrayList.size()) {
                return false;
            }
            System.err.println("\n Illegal. The floor must have at least 4 corners" +
                    "\nPlease fix the file and try again ");
            return true;
        }

        private boolean pointsTwoFourSix() {
            if (pointsIntegerArrayList.size() % 2 == 0) {
                if ((pointsIntegerArrayList.size() / 2) % 2 == 0)
                    return false;
            }
            System.err.println("\n Illegal.  No diagonal walls.(Number)" +
                    "\nPlease fix the file and try again ");
            return true;
        }

        private int lineX1 = 0;
        private int lineX2 = 2;
        private int lineX3 = 4;

        private boolean notLineX() {
            while (true) {
                int x1;
                int x2;
                int x3;
                try {
                    x1 = pointsIntegerArrayList.get(lineX1);
                    lineX1 += 2;
                    x2 = pointsIntegerArrayList.get(lineX2);
                    lineX2 += 2;
                    x3 = pointsIntegerArrayList.get(lineX3);
                    lineX3 += 2;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
                if (x1 == x2 & x2 == x3) {
                    System.err.println("Illegal (X). Adjacent walls of the room must form right angles." +
                            "\nPlease fix the file and try again ");
                    return true;
                }
            }
        }

        private int lineY1 = 1;
        private int lineY2 = 3;
        private int lineY3 = 5;

        private boolean notLineY() {
            while (true) {
                int y1;
                int y2;
                int y3;
                try {
                    y1 = pointsIntegerArrayList.get(lineY1);
                    lineY1 += 2;
                    y2 = pointsIntegerArrayList.get(lineY2);
                    lineY2 += 2;
                    y3 = pointsIntegerArrayList.get(lineY3);
                    lineY3 += 2;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
                if (y1 == y2 & y2 == y3) {
                    System.err.println("Illegal (Y). Adjacent walls of the room must form right angles." +
                            "\nPlease fix the file and try again ");
                    return true;
                }
            }
        }

        private boolean firstLastPoint() {
            int pointNumberXFirst = pointsIntegerArrayList.get(0);
            int pointNumberYFirst = pointsIntegerArrayList.get(1);
            int pointNumberYLast = pointsIntegerArrayList.get(pointsIntegerArrayList.size() - 1);
            int pointNumberXLast = pointsIntegerArrayList.get(pointsIntegerArrayList.size() - 2);

            if (pointNumberXFirst == pointNumberXLast & pointNumberYFirst == pointNumberXLast) {
                System.err.println("Illegal. Duplicate point(corners)***(Last point)" +
                        "\nPlease fix the file and try again ");
                return true;
            }

            if (pointNumberXFirst == pointNumberXLast || pointNumberYFirst == pointNumberYLast) {
                return false;
            } else {
                System.err.println("Illegal. No diagonal walls***(Last point)." +
                        "\nPlease fix the file and try again ");
                return true;
            }
        }

        private int pointX = 0;
        private int pointY = 1;

        private boolean noDiagonalWall() {
            while (true) {
                int x1;
                int x2;
                int y1;
                int y2;
                try {
                    x1 = pointsIntegerArrayList.get(pointX);// 0x
                    pointX += 2;
                    x2 = pointsIntegerArrayList.get(pointX);// 2x
                    y1 = pointsIntegerArrayList.get(pointY);// 1y
                    pointY += 2;
                    y2 = pointsIntegerArrayList.get(pointY);// 3y
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
                if (x1 == x2 & y1 == y2) {
                    System.err.println("Illegal. Duplicate point(corners)***" +
                            "\nPlease fix the file and try again ");
                    return true;
                }

                if (x1 == x2 || y1 == y2) {
//                    System.out.println("good");
                } else {
                    System.err.println("Illegal. No diagonal walls" +
                            "\nPlease fix the file and try again ");
                    return true;
                }
            }
        }

        private int indexX = 0;
        private int indexY = 1;

        private boolean duplicatePointsCorner() { // Duplicate corners
            while (true) {
                int x;
                int y;
                try {
                    x = pointsIntegerArrayList.get(indexX);
                    y = pointsIntegerArrayList.get(indexY);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
                int indX = 0;
                int indY = 1;
                while (true) {

                    if (indexX == indX & indexY == indY) {
                        indX += 2;
                        indY += 2;
                        continue;
                    }
                    int xI;
                    int yI;
                    try {
                        xI = pointsIntegerArrayList.get(indX);
                        yI = pointsIntegerArrayList.get(indY);
                    } catch (IndexOutOfBoundsException e) {
                        indexX += 2;
                        indexY += 2;
                        break;
                    }

                    if (xI == x & yI == y) {
                        System.err.println("Illegal. Duplicate corners^^^(points)" +
                                "\nPlease fix the file and try again ");
                        return true;
                    }
                    indX += 2;
                    indY += 2;
                }
            }
        }

        private int indexsX1 = 0;
        private int indexsX2 = 2;
        private int indexsY1 = 1;
        private int indexsY2 = 3;

        private boolean intersectingLines() {
            while (true) {
                boolean flag = true;
                int x1;
                int x2;
                int y1;
                int y2;
                try {
                    x1 = pointsIntegerArrayList.get(indexsX1);
                    x2 = pointsIntegerArrayList.get(indexsX2);
                    y1 = pointsIntegerArrayList.get(indexsY1);
                    y2 = pointsIntegerArrayList.get(indexsY2);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
                int inX1 = 0;
                int inX2 = 2;
                int inY1 = 1;
                int inY2 = 3;
                while (true) {
                    if ((indexsX1 == inX1 & indexsY1 == inY1) || (indexsX2 == inX2 & indexsY2 == inY2)) {
                        if (flag) {
                            inX1 += 4;
                            inX2 += 4;
                            inY1 += 4;
                            inY2 += 4;
                            flag = false;
                            continue;
                        }
                    } else {
                        inX1 += 2;
                        inX2 += 2;
                        inY1 += 2;
                        inY2 += 2;
                    }
                    int x1I;
                    int x2I;
                    int y1I;
                    int y2I;
                    try {
                        x1I = pointsIntegerArrayList.get(inX1);
                        x2I = pointsIntegerArrayList.get(inX2);
                        y1I = pointsIntegerArrayList.get(inY1);
                        y2I = pointsIntegerArrayList.get(inY2);
                    } catch (IndexOutOfBoundsException e) {
                        indexsX1 += 2;
                        indexsX2 += 2;
                        indexsY1 += 2;
                        indexsY2 += 2;
                        break;
                    }

                    if (x1 == x2) {
                        if (addXIntersectingLines(x1I, x2I, y1I, y2I, x1, x2, y1, y2)) {
                            System.err.println("Illegal. Walls do not intersect " +
                                    "\nPlease fix the file and try again ");
                            return true;
                        }
                        continue;

                    } else if (y1 == y2) {
                        if (addYIntersectingLines(x1I, x2I, y1I, y2I, x1, x2, y1, y2)) {
                            System.err.println("Illegal. Walls do not intersect " +
                                    "\nPlease fix the file and try again ");
                            return true;
                        }
                        continue;
                    }
                    inX1 += 2;
                    inX2 += 2;
                    inY1 += 2;
                    inY2 += 2;
                }
            }
        }

        private boolean addXIntersectingLines(int x1I, int x2I, int y1I, int y2I, int x1, int x2, int y1, int y2) {
            if ((x1I < x1 & x2 < x2I) & (y1 < y1I & y2I < y2)) {
                return true;
            }
            return false;
        }

        private boolean addYIntersectingLines(int x1I, int x2I, int y1I, int y2I, int x1, int x2, int y1, int y2) {
            if ((y1I < y1 & y2 < y2I) & (x1 < x1I & x2I < x2)) {
                return true;
            }
            return false;
        }
    }
}
