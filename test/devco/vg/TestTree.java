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

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import model.Accessory;
import model.Business;
import model.Card;
import model.Client;
import model.Expense;
import model.Sale;
import model.Tree;

import org.junit.jupiter.api.Test;

class TestTree {
	
	Tree tree;
	
	public void setupStage() {
		tree = new Tree();
		
		Accessory a1 = new Accessory("Sniper ps4",80000,false, "sniper para ps4",4,null, "PS4");
		Accessory a2 = new Accessory("Mando xbox",80000,false, "sniper para ps4",4,null, "XBOX");
		Accessory a3 = new Accessory("Memory card",80000,false, "sniper para ps4",4,null, "ps2");
		Accessory a4 = new Accessory("Guitarra rock band",80000,false, "sniper para ps4",4,null, "ps3");
		
		Card c1 = new Card("Plus trimestre ps4",80000,"sniper para ps4",4,null, "PS4",3);
		Card c2 = new Card("Spotify Anio",80000,"sniper para ps4",4,null, "",12);
		Card c3 = new Card("Gold semestre",80000,"sniper para ps4",4,null, "xbox",6);
		
		Expense e1 = new Expense("001","se compraron unos ps4 ", 3000000, new GregorianCalendar(2018,5,19));
		Expense e2 = new Expense("002","se compraron unos xbox ", 2000000, new GregorianCalendar(2019,6,19));
		Expense e3 = new Expense("003","se compraron unos juegos ", 670000, new GregorianCalendar(2016,3,19));
		Expense e4 = new Expense("004","se compraron un pc", 1700000, new GregorianCalendar(2019,10,19));
		
		
		tree.addAccessory(a1);
		tree.addAccessory(a2);
		tree.addAccessory(a3);
		tree.addAccessory(a4);
		
		tree.addAccessory(c1);
		tree.addAccessory(c2);
		tree.addAccessory(c3);
		
		tree.addExpense(e1);
		tree.addExpense(e2);
		tree.addExpense(e3);
		tree.addExpense(e4);
	}

	@Test
	void testSearchExpenseByDate() {
		setupStage();
		
		Expense e = tree.searchExpenseByDate(new GregorianCalendar(2016,3,19));
		
		assertTrue(e != null);
	}
	
	@Test
	void testSearchExpenseByNumber() {
		setupStage();
		
		Expense e = tree.searchExpenseByNumber("003");
		
		assertTrue(e != null);
	}

}
