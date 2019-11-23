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

public class Accessory extends Product implements Comparable<Accessory> {

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
	public Accessory(String name, double price, boolean preowned, String description, int quantity, Image imgRef, String compatibleConsole) {
		super(name, price, preowned, description, quantity, imgRef);
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

	public void addAccessory(Accessory newAccessory) {
		if (compareTo(newAccessory)<0) {
			if (getRight() != null) {
				getRight().addAccessory(newAccessory);
			} else {
				setRight(newAccessory);
			}
			
		} 
		if (compareTo(newAccessory)>0){
			if (getLeft() != null) {
				getLeft().addAccessory(newAccessory);
			} else {
				setLeft(newAccessory);
			}
		} 
		
	}

	@Override
	public int compareTo(Accessory accessory) {
		int value = 0;
		
		if (getName().compareToIgnoreCase(accessory.getName()) > 0) {
			value = 1;
		} else if (getName().compareToIgnoreCase(accessory.getName()) < 0) {
			value = -1;
		}
		
		return value;
	}

	public Accessory searchAccessoryByName(Accessory only4TheName) {
		
		if (compareTo(only4TheName) == 0) {
			return this;
		} else if (compareTo(only4TheName) > 0 && getLeft() != null) {
			getLeft().searchAccessoryByName(only4TheName);
		} else if(getRight() != null){
			getRight().searchAccessoryByName(only4TheName);
		} 
		
	
	return null;
	}
	
	
	

} //end of class