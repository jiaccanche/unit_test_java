package com.course.testing.game;

public class Dice {
    private int sides;

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int roll(){
        return 1;
    }

    public Dice(int sides) {
        this.sides = sides;
    }
}
