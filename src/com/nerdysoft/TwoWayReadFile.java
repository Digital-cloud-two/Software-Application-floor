package com.nerdysoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TwoWayReadFile implements WorkingWithPoints {

    @Override
    public boolean beginningTask() {
        System.out.println("Reading from file...");
        if (fileInputStream == null) {
            readFromFile();
            duplicateArrayListPoints();
        } else {
            System.out.print("File was reading successful:  ");
        }
        CheckFilePoints checkPoints = new CheckFilePoints(arrayListPoints,arrayListPointsNumberDigit );
        showArrayListPointsFromFile();
        if (checkPoints.step1ReadFile()) { // if (true) -- a mistake in the file
            return false;
        }

        if (checkPoints.step2CheckFile()) {
            return false;
        }
        System.out.println("---=| The floor plan is good |=---");
        return true;
    }

    private ArrayList<String> arrayListPoints = new ArrayList<String>();
    private ArrayList<String> arrayListPointsNumberDigit = new ArrayList<String>();

    private FileInputStream fileInputStream = null;

    private void readFromFile() {
        int symbol = 0;
        try {
            fileInputStream = new FileInputStream("The Points.txt");
            while ((symbol = fileInputStream.read()) != -1) {
                arrayListPoints.add(String.valueOf((char) symbol));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print("File was reading successful:  ");
    }

    private int zero = 0;
    private ArrayList<String> test = new ArrayList<String>();

    private void showArrayListPointsFromFile() {

        if (zero == 0) {
            for (int i = 0; i < arrayListPoints.size(); i++) {
                test.add(arrayListPoints.get(i));
            }
        }
        zero++;
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i));
        }
    }

    private void duplicateArrayListPoints(){
        for (String s: arrayListPoints){
            arrayListPointsNumberDigit.add(s);
        }
    }
}
