package com.nerdysoft;

import java.util.Scanner;

public class DecisionReadEnter {

    void start() {
        showOpenText();
        while (true) {
            Actions userDecision = userMakeDecision();
            WorkingWithPoints workingWithPoints;
            if ((workingWithPoints = decisionReadOrEnter(userDecision)) != null) {
                if (workingWithPoints.beginningTask()) {
                    System.out.println("Try again");
                } else {
                    return;
                }
            } else {
                return; // The End
            }
        }
    }

    private void showOpenText() {
        System.out.println(" *** THIS SOFTWARE APPLICATION HELPS WITH FLOOR LAYOUT ***");
        String mas[] = {" Y ^", "   |", "   |", "   |", "   |", "   |",
                "---|------------------------->", "0  |                         X"};
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }

    private Actions userMakeDecision() {
        while (true) {
            System.out.println("Сhoose the number how you want to set points:\n" +
                    "                                            1. Read from file\n" +
                    "                                            2. Enter in the console\n" +
                    "                                            0. Exit");
            Scanner scannerUserDecision = new Scanner(System.in);
            int userDecision;
            try {
                userDecision = scannerUserDecision.nextInt();
            } catch (Exception e) {
                System.out.println("Choose is wrong " +
                        "\n Try again!!!");
                continue;
            }

            if (userDecision < 0 || userDecision > 2) {
                System.out.println("The number of chose is wrong >>>  " + userDecision +
                        "\n           Try again!!!");
                continue;
            }
            Actions action;
            switch (userDecision) {
                case 1:
                    return action = Actions.FILE;
                case 2:
                    return action = Actions.CONSOLE;
                case 0:
                    return action= Actions.EXIT;
                default:
                    System.out.println("Error unknown" +
                            "\n it is impossible!" +
                            "\n Method: userMakeDecision ");
                    continue;
            }
        }
    }

    private WorkingWithPoints decisionReadOrEnter(Actions userDecision) {
        WorkingWithPoints workingWithPoints = null;

        switch (userDecision) {
            case FILE:
                workingWithPoints = new TwoWayReadFile();
                break;
            case CONSOLE:
                workingWithPoints = new OneWayEnterConsole();
                break;
            case EXIT:
                System.out.println("The End");
                break;
            default:
                System.out.println("Error unknown" +
                        "\n it is impossible!" +
                        "\n Method: decisionReadOrEnter ");
                break;
        }
        return workingWithPoints;
    }
    
}
