package com.nerdysoft;

public enum Actions {
    CONSOLE("Enter in the console"),
    FILE("Read from file"),
    EXIT("Exit");

    private String string;

    Actions(String string) {
        this.string = string;
    }
}
