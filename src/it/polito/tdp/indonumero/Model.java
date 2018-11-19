package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	private int NMAX=100;
	private int TMAX=7;
	
	private int segreto;//numero da indovinare
	private int tentativi;//tentativi già effettuati
	
	private boolean inGame = false;

	public Model() {
		
		this.inGame = false;
	}
	/**
	 * Avvio una nuova partita generando un nuovo numero segreto
	 */
	public void newGame() {
		this.segreto=(int) (Math.random()*NMAX)+1;
    	this.tentativi=0;
    	this.inGame=true;
	}
	/**
	 * utente inserisce un valore  
	 * @param t valore del tentativo
	 * @return 0 se indovinato 1 se alto -1 se basso
	 */
	public int tentativo(int t) {
		
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva.");
		}
		if (!valoreValido(t)){
			throw new InvalidParameterException("Tentivo fuori range.");
		}
		this.tentativi++;
		if(this.tentativi==TMAX) {
			this.inGame=false;
		}
		
		if(t==segreto) { 
			this.inGame=false;
			return 0;}
		else if (t>segreto){return 1;}
		else {return -1;}
	}
	/**
	 * Controlla che il numero inseirto sia nel range stabilito
	 * @param tentativo
	 * @return {@code} true se è valido
	 */
	public boolean valoreValido(int tentativo) {
		return tentativo>=1 && tentativo<=this.NMAX;
	}
	public int getTentativi() {
		return this.tentativi;
	}
	
	public int getSegreto() {
		return segreto;
	}
	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	public int getNMAX() {
		return NMAX;
	}
	public int getTMAX() {
		return TMAX;
	}
	public boolean isInGame() {
		return inGame;
	}
}
