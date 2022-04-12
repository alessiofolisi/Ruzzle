package it.polito.tdp.ruzzle.model;

import java.util.*;

public class Ricerca {

	
	public List<Pos> trovaParola(String parola, Board board) {
		
		for(Pos p : board.getPositions()) {
			if(board.getCellValueProperty(p).get().charAt(0) == parola.charAt(0)) {
				
				List<Pos> parziale = new ArrayList<Pos>();
				parziale.add(p);
				if(cerca(parola , board , 1 , parziale)) return parziale;
			}
		}
		return null;
	}
	
	
	
	public boolean cerca(String parola , Board board , int L , List<Pos> percorso) {
		
		if(L == parola.length()) return true;
		
		Pos ultima = percorso.get(percorso.size()-1);
		
		List<Pos> adiacenti = board.getAdjacencies(ultima);
		for(Pos a : adiacenti) {
			if(!percorso.contains(a) && board.getCellValueProperty(a).get().charAt(0)==parola.charAt(L)) {
				percorso.add(a);
				if(cerca(parola,board,L+1,percorso)) return true;
				
				percorso.remove(percorso.size()-1);
			}
		}
		
		return false;
	}
	
}
