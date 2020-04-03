package main;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BFS {
	public State runBFS(State startState) {
		if (startState.isFinal()) {
			return startState;
		}
		Queue<State> frontier = new LinkedList<State>(); // Our expanding "tree"
		LinkedList<State> explored = new LinkedList<State>(); // Explored "nodes"
		frontier.add(startState); //Add to our frontier our start state (3,3,1)
		while (true) {
			if (frontier.isEmpty()) {
				return null; //no initial state???
			}
			State state = frontier.poll();  //remove the head of the frontier
			explored.add(state); // add the head to the explored
			List<State> successors = state.generateSuccessors(); // Generate possible scenarios
			for (State child : successors) { //iterate our newly generated scenarios that can actually happen
				if (!explored.contains(child) && !explored.contains(child)) { // if it is not our "initial" state, nor is it explored
					if (child.isFinal()) { 
						return child;   //for when we hit our final State - our goal.
					}
					//System.out.println("( " + state.getMissionary() + " , " + state.getCannibal() + " , " + state.getBoat() + " )");
					frontier.add(child); // if not, add it to our potential path pool, and let's hit the recursion button! 
				}
			}
		}
	}

}
