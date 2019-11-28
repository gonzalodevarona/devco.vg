/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* FINAL PROJECT 
* @AUTHOR: GONZALO DE VARONA
* @LAST UPDATE DATE: 22 NOVEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.util.GregorianCalendar;

import javafx.scene.image.Image;

public class Game extends Console {

	private String console;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 * @param imgRef
	 * @param releaseDate
	 * @param console
	 */
	


	public Game(String name, double price, boolean preowned, String description, int quantity, Image imgRef,
			GregorianCalendar releaseDate, String console) {
		super(name, price, preowned, description, quantity, imgRef, releaseDate);
		this.console = console;
	}
	
	public String getConsole() {
		return this.console;
	}


	
	/**
	 * 
	 * @param console
	 */
	public void setConsole(String console) {
		this.console = console;
	}
	
	public Game clone() {
		Game other = new Game("", 0, false, "", 0, null, null, "");
		
		other.setName(getName());
		other.setPrice(getPrice());
		other.setPreowned(getPreowned());
		other.setDescription(getDescription());
		other.setQuantity(getQuantity());
		other.setImgRef(getImgRef());
		other.setReleaseDate(getReleaseDate());
		
		other.setNext(getNext());
		other.setPrior(getPrior());
		
		other.setConsole(getConsole());

		return other;
	}

	public int compareByConsole(Game game2) {
		int value = 0;
		
		String game2Console = game2.getConsole();
		if(getConsole().compareToIgnoreCase(game2Console) >0){
			value = 1;
		}else if(getConsole().compareToIgnoreCase(game2Console) <0){
			value = -1;
		} 
	    
		return value;
	}



} //end of class
