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

package devco.vg;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import model.Console;
import model.Game;
import model.LinkedList;

class TestLinkedList {

	LinkedList linkedList;
		
	//Create new LinkedList
	
	public void setupStage() {
		linkedList = new LinkedList();
		Game g1 = new Game("Black ops",50000,false, "any",20,null, new GregorianCalendar(2017,2,23),"PS4");
		Game g2 = new Game("Death Stranding",170000,false, "cool game",20,null, new GregorianCalendar(2019,11,23),"PS4");
		Game g3 = new Game("Metal gear",70000,false, "cool game",2,null, new GregorianCalendar(2015,11,23),"PS4");
		Game g4 = new Game("CyberPunk 2077",170000,false, "cool game",13,null, new GregorianCalendar(2019,12,23),"PS4");
		
		linkedList.setFirstGame(g1);
		linkedList.addGame(g2);
		linkedList.addGame(g3);
		linkedList.addGame(g4);
		
		Console c1 = new Console("PS4",500000,false, "any",20,null, new GregorianCalendar(2017,2,23));
		Console c2 = new Console("Xbox one",400000,false, "cool ",20,null, new GregorianCalendar(2019,11,23));
		Console c3 = new Console("PS4 PRO",1000000,false, "cool ",2,null, new GregorianCalendar(2015,11,23));
		Console c4 = new Console("Switch",1000000,false, "cool game",13,null, new GregorianCalendar(2019,12,23));
		
		linkedList.setFirstConsole(c1);
		linkedList.addConsole(c2);
		linkedList.addConsole(c3);
		linkedList.addConsole(c4);

	}
	
	@Test
	void testFindConsole() {
		setupStage();
		
		Console found = linkedList.findConsoleByName("PS4 PRO");
		
		assertTrue(found !=null && found.getPrice() == 1000000);
		
	}
	
	@Test
	void testFindGame() {
		setupStage();
		
		Game found = linkedList.findGameByName("metal gear");
		
		assertTrue(found !=null && found.getPrice() == 70000);
		
	}
	
	@Test
	void testSortByPriceConsole() {
		setupStage();
		
		linkedList.sortConsoleByPrice();
		
		Console next = linkedList.getFirstConsole();
		
		while ( next !=null) {
			if (next.getNext() != null && (next.getPrice()<= next.getNext().getPrice() == false)) {
				fail();
			}
			next = next.getNext();
			
		}
		
	}
	
	@Test
	void testSortByNameConsole() {
		setupStage();
		
		linkedList.sortConsoleByName();
		
		Console next = linkedList.getFirstConsole();
		
		while ( next !=null) {
			if (next.getNext() != null && (next.getName().compareToIgnoreCase(next.getNext().getName())>0)) {
				fail();
			}
			next = next.getNext();
			
		}
		
	}
	
	@Test
	void testSortByDateConsole() {
		setupStage();
		
		linkedList.sortConsoleByDate();
		
		Console next = linkedList.getFirstConsole();
		
		while ( next !=null) {
			if (next.getNext() != null && (next.getReleaseDate().compareTo(next.getNext().getReleaseDate())>0)) {
				fail();
			}
			next = next.getNext();
			
		}
		
	}
	
	@Test
	void testSortGameByName() {
		setupStage();
		
		linkedList.sortGamesByName();
		
		Game next = linkedList.getFirstGame();
		
		while ( next !=null) {
			
			if (next.getNext() != null && next.getName().compareToIgnoreCase(next.getNext().getName()) > 0) {
				fail();
			}
			next = (Game)next.getNext();
			
		}
		
	}
	
	@Test
	void testSortGameByConsole() {
		setupStage();
		
		linkedList.sortGamesByConsole();
		
		Game next = linkedList.getFirstGame();
		
		while ( next !=null) {
			
			if (next.getNext() != null && next.getConsole().compareToIgnoreCase(((Game) next.getNext()).getConsole()) > 0) {
				fail();
			}
			next = (Game)next.getNext();
			
		}
		
	}
	
	@Test
	void testSortGameByPrice() {
		setupStage();
		
		linkedList.sortGamesByPrice();
		
		Game next = linkedList.getFirstGame();
		
		while ( next !=null) {
			
			if (next.getNext() != null && next.getPrice()>next.getNext().getPrice()) {
				fail();
			}
			next = (Game)next.getNext();
			
		}
		
	}
	
	@Test
	void testSortGameByQuantity() {
		setupStage();
		
		linkedList.sortGamesByQuantity();
		
		Game next = linkedList.getFirstGame();
		
		while ( next !=null) {
			
			if (next.getNext() != null && next.getQuantity()>((Game)next.getNext()).getQuantity()) {
				fail();
			}
			next = (Game)next.getNext();
			
		}
		
	}
	
	
	@Test
	void testEraseGame() {
		setupStage();
		
		linkedList.eraseGame("Metal gear");
		
		Game next = linkedList.getFirstGame();
		
		while ( next !=null) {
			
			if (next.getName().contains("Metal gear")) {
				fail();
			}
			next = (Game)next.getNext();
			
		}
		
	}
	
	@Test
	void testEraseConsole() {
		setupStage();
		
		linkedList.eraseConsole("ps4 pro");
		
		Console next = linkedList.getFirstConsole();
		
		while ( next !=null) {
			
			if (next.getName().contains("PRO")) {
				fail();
			}
			next = next.getNext();
			
		}
		
	}
	
	

} //end of class
