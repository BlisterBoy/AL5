package com.mklr.ruzzle.engine;

import java.util.ArrayList;

import com.mklr.graphics.engine.Engine;
import com.mklr.ruzzle.data.RuzzleDictionary;

public class Game {
	private Engine engine;
    private Board gameBoard;
    private RuzzleDictionary gameDictionary;
    private int score;

    public Game(Engine e, Board b) {
        engine = e;
        gameBoard = b;
        gameDictionary = b.getDico();
    }

    public int getScoreofMove(ArrayList<Marble> path, String word) {
        int wordScore = 0;
        int wordMultiplicator = 1;
        if (!gameDictionary.searchWord(word))
            return -1;

        for (Marble m : path) {
            int l_score = m.getLetter().getValue();
            
            switch (m.getBonus()) {
                case Marble.LETTER_COUNT_DOUBLE:
                    l_score *= 2;
                    break;
                case Marble.LETTER_COUNT_TRIPLE:
                    l_score *= 3;
                    break;
                case Marble.WORD_COUNT_DOUBLE:
                    wordMultiplicator *= 2;
                    break;
                case Marble.WORD_COUNT_TRIPLE:
                    wordMultiplicator *= 3;
                    break;
                default:
                    break;
            }

            wordScore += l_score;
        }

        this.score += (wordScore * wordMultiplicator);
        return (wordScore * wordMultiplicator);
    }

	//options : langue
	//tester les mots
	
	//f isReady qui appelle gameIsReady dans l'engine
	
	//f getScore qui recoit la chaine de caractere et renvoie le score
	// -1 si le mot n'existe pas... > 0 sinon
    
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	} 
}
