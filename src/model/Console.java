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

	

	public Console smallerThanByDate() {
		Console smaller = this;
		Console following = getNext();
		
		while(following != null) {
		
			if (smaller.compareByDate(following) >0) {
				smaller = following;
			}
			following = following.getNext();
		}
		
		
		return smaller;
	}

	public int compareByDate(Console following) {
		int value = 0;
		
		GregorianCalendar followingDate = following.getReleaseDate();
    	if(getReleaseDate().compareTo(followingDate) > 0 ){
    		value = 1;
    	}else if(getReleaseDate().compareTo(followingDate) < 0){
    		value = -1;
    	} 
        
		return value;
	}
	

} //end of class
