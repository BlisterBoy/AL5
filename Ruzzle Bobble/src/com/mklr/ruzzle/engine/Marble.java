package com.mklr.ruzzle.engine;

import java.util.ArrayList;

public class Marble {
    public static final byte NO_BONUS = 0;
    public static final byte LETTER_COUNT_DOUBLE = 1;
    public static final byte LETTER_COUNT_TRIPLE = 2;
    public static final byte WORD_COUNT_DOUBLE = 4;
    public static final byte WORD_COUNT_TRIPLE = 8;
    
    private Letter letter;
    private byte bonus; 
    private boolean selected;
    private ArrayList<Marble> neighbours;

    public Marble() {
        this(null, NO_BONUS);
    }

    public Marble(Letter letter) {
        this(letter, NO_BONUS);
    }

    public Marble(Letter letter, byte bonus) {
        this(letter, bonus, new ArrayList<Marble>());
    }

    public Marble(Letter letter, byte bonus, ArrayList<Marble> neighbours) {
        this.letter = letter;
        this.bonus = bonus;
        this.neighbours = neighbours;
        selected = false;
    }

    /**
     * @return the l
     */
    public Letter getLetter() {
        return letter;
    }

    /**
     * @param l the l to set
     */
    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    /**
     * @return the bonus
     */
    public byte getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(byte bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the neighbours
     */
    public ArrayList<Marble> getNeighbours() {
        return neighbours;
    }

    /**
     * @param neighbours the neighbours to set
     */
    public void setNeighbours(ArrayList<Marble> neighbours) {
        this.neighbours = neighbours;
    }
}
