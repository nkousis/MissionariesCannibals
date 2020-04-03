package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		State startState = new State (3, 3, 1);
		
		BFS bfs = new BFS();
		State solution = bfs.runBFS(startState);
		if (solution == null) {
			System.out.print("\nNo solution found.");
		}
			else {
				List<State> path = new ArrayList<State>();
				State state = solution;
				while(state!=null)	{
					path.add(state);
					state=state.getParentState();
				}
				int count = path.size() -1;
				System.out.println("The Move Sets for the game:");
				for (int i=count; i>=0; i--) {
					state=path.get(i);
					
					System.out.println("( " + state.getMissionary() + " , " + state.getCannibal() + " , " + state.getBoat() + " )");
					
				}
				
			}
			
		
		
		
	}

}
