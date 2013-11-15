package com.mklr.graphics.engine;

import com.mklr.graphics.stage.GameStage;
import com.mklr.graphics.stage.GameTitle;
import com.mklr.graphics.stage.Stage;
import com.mklr.ruzzle.engine.Board;

/**La classe Engine represente le moteur de jeu
 * C'est elle qui charge les sequences du jeu et commande le raffraichissement du GameScreen.
 * @author Mehdi
 *
 */
public class Engine implements Runnable{
	public static final String PATH = "";
	
	private GameScreen gamescreen;
	private Stage stage;
	
	public Engine(){
		this.gamescreen = new GameScreen();
		
		//On cree lance le thread de raffraichissement de l'ecran
		Thread t = new Thread(this);
		t.start();
	}
	
	
	   //////////////////////////////////////////////////////////////////
	  ////////////////////////////// METHODES //////////////////////////
	 //////////////////////////////////////////////////////////////////	

	//Methode de chargement des sequences
	public void setGameTitle(){
		this.stage = new GameTitle(this);
		gamescreen.setStage(stage);
	}
	public void setGameStage(){
		//Arret des Thread de GameTitle
		this.stage.close();
		
		//Creation du jeu PROVISOIRE
		Board d = new Board();
		d.init();
		System.out.println(d);
		
		
		//Lancement de la phase de jeu
		this.stage = new GameStage(this, d);
		gamescreen.setStage(stage);
	}
	
	public void run(){
		refresh_gamescreen();
	}
	
	//Methode de raffraichissement
	public void refresh_gamescreen(){
		while(true){
			gamescreen.repaint();
			try{
				  Thread.sleep(32); //Ici, une pause d'une seconde
			}catch(InterruptedException e) {
			  e.printStackTrace();
			}
		}
	}
	
	/**Methode fermant la sequence de jeu en cours et fermant son sequenceur midi proprement**/
	public int exit(){
		if(stage != null)
			stage.close();
		System.exit(0);
		return 1;
	}
	
	   //////////////////////////////////////////////////////////////////
	  ///////////////////////// ACCESSEURS MODIFIEURS///////////////////
	 //////////////////////////////////////////////////////////////////
	/**
	 * @return the sequence
	 */
	public Stage getStage() {
		return stage;
	}
	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Stage stage) {
		this.stage = stage;
	}


	/**
	 * @return the gamescreen
	 */
	public GameScreen getGamescreen() {
		return gamescreen;
	}


	/**
	 * @param gamescreen the gamescreen to set
	 */
	public void setGamescreen(GameScreen gamescreen) {
		this.gamescreen = gamescreen;
	}
	
}
