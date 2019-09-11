package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int a = 5;
	
	public static void main(String[] args) {
		
//		boolean[] source = {true,true,false};
//		
//		Position test = new Position(5, source);
//		
//		source[1] = false;
		
		int[] numbers = {1,1,1,1,1};
		
		System.out.println(solution(numbers,3));
		

	}
	
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int sumOfNumbers = 0;
        boolean[] visited = new boolean[numbers.length];
        
        
        for(int ni = 0; ni < numbers.length; ni++) {
        	sumOfNumbers+=numbers[ni];
        }
        
        Queue<Position> searchQueue = new LinkedList<>();
        boolean[] nextVisited;
        for(int vi = 0; vi < numbers.length; vi++) {
        	nextVisited = new boolean[numbers.length];
        	nextVisited[vi] = true;
        	Position nextPosition = new Position(sumOfNumbers-numbers[vi], nextVisited);
        	searchQueue.add(nextPosition);	
        }
        
        while(!searchQueue.isEmpty()) {
        	System.out.println("enqueue");
        	Position currentPosition = searchQueue.poll();
        	int currentValue = currentPosition.getCurrentValue();
        	boolean[] currentVisited = currentPosition.getVisited();
        	
        	if(currentValue == target) answer++;
        	
        	for(int ni = 0; ni < numbers.length; ni++) {
        		
        		if(!currentVisited[ni]) {
        			
        			currentVisited[ni] = true;
        			Position nextPosition = new Position(currentValue-numbers[ni], currentVisited);
        			searchQueue.add(nextPosition);
        			currentVisited[ni] = false;
        			
        		}
        		
        	}

        }
        
        return answer;
    }
}

class Position{
	
	private int currentValue;
	private boolean[] visited;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}
	
	public Position(int currentValue, boolean[] visited) {
		this.currentValue = currentValue;
		this.visited = new boolean[visited.length];
		System.arraycopy(visited, 0, this.visited, 0, visited.length);
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}
	
}
