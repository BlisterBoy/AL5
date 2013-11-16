package com.mklr.graphics.sprite;

import com.mklr.graphics.stage.GameStage;
import com.mklr.ruzzle.engine.Marble;

public class LetterSprite extends Sprite {
	private boolean selected;
	private char letter;
	protected Integer[] boardPosition;
	private GameStage gamestage;
	private Marble marble;
	
	public LetterSprite(String chemin, int x, int y, int width, int height, char letter, int line, int row, Marble marble, GameStage gamestage){
		super(chemin, x, y, width, height);
		this.letter = letter;
		this.selected = false;
		this.gamestage = gamestage;
		this.marble = marble;
		boardPosition = new Integer[2];
		boardPosition[0] = line;
		boardPosition[1] = row;
	}
	
	public void onMousePressedWay(LetterSprite previousLetter){
		if(!selected){
			selected = true;
			if(previousLetter == null || (previousLetter != null && this.marble.isNeighbour(previousLetter.boardPosition))){
				//System.out.println(previousLetter + " " +boardPosition + " " + previousLetter.boardPosition + " " + this.marble.isNeighbour(previousLetter.boardPosition));
				gamestage.addToCurrentWord(letter);
			}
		}
	}

	   //////////////////////////////////////////////////////////////////
	  ///////////////////////// ACCESSEURS MODIFIEURS///////////////////
	 //////////////////////////////////////////////////////////////////
	
	public boolean isSelected(){
		return selected;
	}
	public char getLetter(){
		return letter;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the marble
	 */
	public Marble getMarble() {
		return marble;
	}

	/**
	 * @param marble the marble to set
	 */
	public void setMarble(Marble marble) {
		this.marble = marble;
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
}
