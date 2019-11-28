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

import java.io.Serializable;

public class LinkedList implements CrudConsole, CrudGame, Serializable{

	private Console firstConsole;
	private Game firstGame;

	public LinkedList() {
		this.firstConsole = null;
		this.firstGame = null;
	}

	public Console getFirstConsole() {
		return this.firstConsole;
	}

	/**
	 * 
	 * @param firstConsole
	 */
	public void setFirstConsole(Console firstConsole) {
		this.firstConsole = firstConsole;
	}

	public Game getFirstGame() {
		return this.firstGame;
	}

	/**
	 * 
	 * @param firstGame
	 */
	public void setFirstGame(Game firstGame) {
		this.firstGame = firstGame;
	}
	
	
	
	
	//-------------- METHODS FOR CONSOLE --------------
	
	@Override
	public void addConsole(Console newConsole) {
		Console last = getLastConsole();
		if(last != null) {
			last.setNext(newConsole);
			newConsole.setPrior(last);
			
		} else {
			setFirstConsole(newConsole);
		}
		
	}
	

	@Override
	public Console getLastConsole() {
		Console last = getFirstConsole();
		
		if(last != null) {
			while(last.getNext() != null) {
				last = last.getNext();
			}
		}
		return last;
	}

	@Override
	public Console findPriorConsole(Console actual) {
		Console first = getFirstConsole();
		Console prior = null;
		boolean stop = false;
		
		while (first != null && !stop) {
			if (actual.getName().equalsIgnoreCase(first.getName())) {
				stop = true;
				prior = first;
			} else{
				first = first.getNext();	
			}
			
		}
		return prior;
	}

	@Override
	public Console findConsoleByName(String theId) {
		Console match = getFirstConsole();
		boolean stop = false;
		
		while(match != null && !stop) {
			if (match.getName().equalsIgnoreCase(theId)) {
				stop = true;
			} 
			else {match = match.getNext();}
		}
		return match;
	}

	@Override
	public void eraseConsole(String theId) {
		Console death = findConsoleByName(theId);
		if (death != null) {
			
			Console priorC = death.getPrior();
			Console nextC = death.getNext();
				
			if (priorC != null) {
				if(nextC != null) {
					nextC.setPrior(priorC);	
				} 
				priorC.setNext(nextC);
				
			} else {
				setFirstConsole(nextC);
				
			}
		}
		
		
	}
	
	//SELECTION SORT 1
	public void sortConsoleByName() {
		Console match = getFirstConsole();
		Console smaller = null;
		
		while(match != null ) {
			smaller = match.smallerThanByName();

			if(smaller != null) {
				
				switchPositionsConsole(match, smaller);
			}
			
			match = match.getNext();
		}
		
	}
	
	//SELECTION SORT 2
	public void sortConsoleByPrice() {
		Console match = getFirstConsole();
		Console smaller = null;
		
		while(match != null ) {
			smaller = match.smallerThanByPrice();
	
			if(smaller != null) {
				
				switchPositionsConsole(match, smaller);
			}
			
			match = match.getNext();
		}
			
	}
	
	//SELECTION SORT 3
	public void sortConsoleByDate() {
		Console match = getFirstConsole();
		Console smaller = null;
		
		while(match != null ) {
			smaller = match.smallerThanByDate();

			if(smaller != null) {
				
				switchPositionsConsole(match, smaller);
			}
			
			match = match.getNext();
		}
				
	}
	
	
		

	
	public void switchPositionsConsole(Console match, Console smaller) {
		
		Console tempM = match.clone();
		Console tempS = smaller.clone();
		
		match.setName(tempS.getName());
		match.setPrice(tempS.getPrice());
		match.setPreowned(tempS.getPreowned());
		match.setDescription(tempS.getDescription());
		match.setQuantity(tempS.getQuantity());
		match.setImgRef(tempS.getImgRef());
		match.setReleaseDate(tempS.getReleaseDate());
		
		smaller.setName(tempM.getName());
		smaller.setPrice(tempM.getPrice());
		smaller.setPreowned(tempM.getPreowned());
		smaller.setDescription(tempM.getDescription());
		smaller.setQuantity(tempM.getQuantity());
		smaller.setImgRef(tempM.getImgRef());
		smaller.setReleaseDate(tempM.getReleaseDate());
		
	}

	
	//-------------- METHODS FOR GAME --------------
	
	
	@Override
	public void addGame(Game newGame) {
		Game last = getLastGame();
		if(last != null) {
			last.setNext(newGame);
			newGame.setPrior(last);
			
		} else {
			setFirstGame(newGame);
		}
		
	}

	@Override
	public Game getLastGame() {
		Game last = getFirstGame();
		
		if(last != null) {
			while(last.getNext() != null) {
				last = (Game) last.getNext();
			}
		}
		return last;
	}

	@Override
	public Game findPriorGame(Game actual) {
		Game first = getFirstGame();
		Game prior = null;
		boolean stop = false;
		
		while (first != null && !stop) {
			if (actual.getName().equalsIgnoreCase(first.getName())) {
				stop = true;
				prior = first;
			} else{
				first = (Game) first.getNext();	
			}
			
		}
		return prior;
	}

	@Override
	public Game findGameByName(String theId) {
		Game match = getFirstGame();
		boolean stop = false;
		
		while(match != null && !stop) {
			if (match.getName().equalsIgnoreCase(theId)) {
				stop = true;
			} 
			else {match = (Game) match.getNext();}
		}
		return match;
	}

	@Override
	public void eraseGame(String theId) {
		Game death = findGameByName(theId);
		if (death != null) {
			
			Game priorC = (Game)death.getPrior();
			Game nextC = (Game)death.getNext();
				
			if (priorC != null) {
				if(nextC != null) {
					nextC.setPrior(priorC);	
				} 
				priorC.setNext(nextC);
				
			} else {
				setFirstGame(nextC);
				
			}
		}
		
	}
	
	public void switchPositionsGame(Game match, Game smaller) {
		
		Game tempM = match.clone();
		Game tempS = smaller.clone();
		
		match.setName(tempS.getName());
		match.setPrice(tempS.getPrice());
		match.setPreowned(tempS.getPreowned());
		match.setDescription(tempS.getDescription());
		match.setQuantity(tempS.getQuantity());
		match.setImgRef(tempS.getImgRef());
		match.setReleaseDate(tempS.getReleaseDate());
		
		smaller.setName(tempM.getName());
		smaller.setPrice(tempM.getPrice());
		smaller.setPreowned(tempM.getPreowned());
		smaller.setDescription(tempM.getDescription());
		smaller.setQuantity(tempM.getQuantity());
		smaller.setImgRef(tempM.getImgRef());
		smaller.setReleaseDate(tempM.getReleaseDate());
		
	}
	
	public void sortGamesByName() {
		Game match = getFirstGame();
		Game priorG = null;
		Game nextMatch = null;
		
		while(match != null ) {
			 nextMatch = (Game) match.getNext(); 
			 
			 priorG = match;
			
				while(priorG != null) {
					
					if(priorG.getNext() != null && priorG.compareByName(priorG.getNext()) > 0) {
						switchPositionsGame(priorG, (Game)priorG.getNext());
					}
					
					priorG = (Game) priorG.getPrior();
				}		
					
			match = nextMatch;
		}
	}
	
	public void sortGamesByPrice() {
		Game match = getFirstGame();
		Game priorG = null;
		Game nextMatch = null;
		
		while(match != null ) {
			 nextMatch = (Game) match.getNext(); 
			 
			 priorG = match;
			
				while(priorG != null) {
					if(priorG.getNext() != null && priorG.compareByPrice(priorG.getNext()) > 0) {
						switchPositionsGame(priorG, nextMatch);
					}
					
					priorG = (Game) priorG.getPrior();
				}		
					
			match = nextMatch;
		}
	}
	
	public void sortGamesByConsole() {
		Game match = getFirstGame();
		Game priorG = null;
		Game nextMatch = null;
		
		while(match != null ) {
			 nextMatch = (Game) match.getNext(); 
			 
			 priorG = match;
			
				while(priorG != null) {
					if(priorG.getNext() != null && priorG.compareByConsole((Game)priorG.getNext()) > 0) {
						switchPositionsGame(priorG, nextMatch);
					}
					
					priorG = (Game)priorG.getPrior();
				}		
					
			match = nextMatch;
		}
	}
	
	public void sortGamesByQuantity() {
		Game match = getFirstGame();
		Game priorG = null;
		Game nextMatch = null;
		
		while(match != null ) {
			 nextMatch = (Game) match.getNext(); 
			 
			 priorG = match;
			
				while(priorG != null) {
					if(priorG.getNext() != null && priorG.compareByQuantity(priorG.getNext()) > 0) {
						switchPositionsGame(priorG, (Game) priorG.getNext());
					}
					
					priorG = (Game) priorG.getPrior();
				}		
					
			match = nextMatch;
		}
	}

} //end of class