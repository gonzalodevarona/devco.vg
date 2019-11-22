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

import javafx.scene.image.Image;

public class Accessory extends Product {

	private Accessory right;
	private Accessory left;
	private String compatibleConsole;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 * @param imgRef
	 * @param compatibleConsole
	 */
	public Accessory(String name, double price, String description, int quantity, Image imgRef, String compatibleConsole) {
		super(name, price, description, quantity, imgRef);
		this.compatibleConsole = compatibleConsole;
		this.right = null;
		this.left = null;
	}

	public String getCompatibleConsole() {
		return this.compatibleConsole;
	}

	/**
	 * 
	 * @param compatibleConsole
	 */
	public void setCompatibleConsole(String compatibleConsole) {
		this.compatibleConsole = compatibleConsole;
	}

	public Accessory getRight() {
		return right;
	}

	public void setRight(Accessory right) {
		this.right = right;
	}

	public Accessory getLeft() {
		return left;
	}

	public void setLeft(Accessory left) {
		this.left = left;
	}
	
	
	

} //end of class