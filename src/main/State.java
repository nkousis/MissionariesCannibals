package main;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private int missionary;
	private int cannibal;
	private int boat;
	
	
	private State parentState;
	
	public State(int missionary, int cannibal, int boat)	{
		this.missionary=missionary;
		this.cannibal=cannibal;
		this.boat=boat;
	}
	
	//
	//Set And Get Functions
	//
	
	public State getParentState() {
		return parentState;
	}

	public void setParentState(State parentState) {
		this.parentState = parentState;
	}

		
	public int getMissionary() {
		return missionary;
	}

	public void setMissionary(int missionary) {
		this.missionary=missionary;
	}
		
	public int getCannibal() {
		return cannibal;
	}
			
	public void setCannibal(int cannibal) {
		this.cannibal=cannibal;
	}

	public int getBoat() {
		return boat;
	}
			
	public void setBoat(int boat) {
		this.boat=boat;
	}
	
	//
	// End Of Set-Get functions
	//
		
	public boolean isFinal() {
		return cannibal==0 && missionary==0;
	}
	
	public boolean checkState() {
		
		if( (missionary < cannibal && missionary>0) || (missionary==2 && cannibal==1) || (missionary==1 && cannibal==0) || (missionary==2 && cannibal==0) || (missionary<0 || missionary>3) || (cannibal<0 || cannibal>3)) {
			return false;
		}
		
		return true;
	}
	
		
	
	public List<State> generateSuccessors() {
		List<State> successors = new ArrayList<State>();
		if (boat==1)	{
			checkAndAddSuccessors(successors, new State(missionary-2, cannibal,0)); // Move 2 missionaries to opposite bank
			
			checkAndAddSuccessors(successors, new State(missionary, cannibal-2,0)); // Move 2 cannibals to opposite bank
			checkAndAddSuccessors(successors, new State(missionary-1, cannibal-1,0)); // Move 1 cannibal and 1 missionary to opposite bank
			checkAndAddSuccessors(successors, new State(missionary-1, cannibal,0)); // Move 1 missionary to opposite bank
			checkAndAddSuccessors(successors, new State(missionary, cannibal-1,0)); // Move 1 cannibal to opposite bank
		}
		else	{
			checkAndAddSuccessors(successors, new State(missionary+2, cannibal,1)); // Move 2 missionaries to opposite bank
		checkAndAddSuccessors(successors, new State(missionary, cannibal+2,1)); // Move 2 cannibals to opposite bank
		checkAndAddSuccessors(successors, new State(missionary+1, cannibal+1,1)); // Move 1 cannibal and 1 missionary to opposite bank
		checkAndAddSuccessors(successors, new State(missionary+1, cannibal,1)); // Move 1 missionary to opposite bank
		checkAndAddSuccessors(successors, new State(missionary, cannibal+1,1)); // Move 1 cannibal to opposite bank
		}
		return successors;
	}
	
	private void checkAndAddSuccessors(List<State> successors, State newState) {
		if (newState.checkState()) {
			
			newState.setParentState(this);
			successors.add(newState);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
		    return true;
		}
		
		if (!(obj instanceof State)) {
			return false;
		}
		State s = (State) obj;
        return (s.missionary == missionary && s.cannibal == cannibal && s.boat == boat);
	}
	

}
