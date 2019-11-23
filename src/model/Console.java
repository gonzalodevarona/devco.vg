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

}
