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

public class Console extends Product {

	private Console prior;
	private Console next;
	private GregorianCalendar releaseDate;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 * @param imgRef
	 * @param releaseDate
	 */
	
	

	public GregorianCalendar getReleaseDate() {
		return this.releaseDate;
	}

	public Console(String name, double price, boolean preowned, String description, int quantity, Image imgRef,
			GregorianCalendar releaseDate) {
		super(name, price, preowned, description, quantity, imgRef);
		this.releaseDate = releaseDate;
		this.prior = null;
		this.next = null;
	}

	/**
	 * 
	 * @param releaseDate
	 */
	public void setReleaseDate(GregorianCalendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Console getPrior() {
		return this.prior;
	}

	/**
	 * 
	 * @param prior
	 */
	public void setPrior(Console prior) {
		this.prior = prior;
	}

	public Console getNext() {
		return this.next;
	}

	/**
	 * 
	 * @param next
	 */
	public void setNext(Console next) {
		this.next = next;
	}
	
	public Console clone() {
		Console other = new Console("", 0, false, "", 0, null, null);
		
		other.setName(getName());
		other.setPrice(getPrice());
		other.setPreowned(getPreowned());
		other.setDescription(getDescription());
		other.setQuantity(getQuantity());
		other.setImgRef(getImgRef());
		other.setReleaseDate(getReleaseDate());
		
		other.setNext(getNext());
		other.setPrior(getPrior());
		
		
		
		return other;
	}
	
	
	public Console smallerThanByName() {
		Console smaller = this;
		Console following = getNext();
		
		while(following != null) {
		
			if (smaller.compareByName(following) >0) {
				smaller = following;
			}
			following = following.getNext();
		}
		
		
		return smaller;
	}
	
	public int compareByName( Console console2) {
		
		int value = 0;
			
		String console2Name = console2.getName();
		if(getName().compareToIgnoreCase(console2Name) >0){
			value = 1;
		}else if(getName().compareToIgnoreCase(console2Name) <0){
			value = -1;
		} 
	    
		return value;
	}

	public Console smallerThanByPrice() {
		Console smaller = this;
		Console following = getNext();
		
		while(following != null) {
		
			if (smaller.compareByPrice(following) >0) {
				smaller = following;
			}
			following = following.getNext();
		}
		
		
		return smaller;
	}

	public int compareByPrice(Console console2) {
		int value = 0;
		
		double console2Price = console2.getPrice();
		if(getPrice() > console2Price){
			value = 1;
		}else if(getPrice() < console2Price){
			value = -1;
		} 
	    
		return value;
	}
	

} //end of class
