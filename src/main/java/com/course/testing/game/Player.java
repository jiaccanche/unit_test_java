package com.course.testing.game;

public class Player {
    private Dice dice;
    private int numberToWin;

    public Player(Dice dice, int numberToWin) {
        this.dice = dice;
        this.numberToWin = numberToWin;
    }

    public boolean win(){
        int diceNumber = dice.roll();
        return numberToWin >= diceNumber;
    }
}
