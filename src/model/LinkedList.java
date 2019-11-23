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

public class LinkedList implements CrudConsole, CrudGame{

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
	
	
	//METHODS FOR CONSOLE
	
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
	public void eraseConsole(Console death) {
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

	
	//METHODS FOR GAME
	
	
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
	public void eraseGame(Game death) {
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

} //end of class