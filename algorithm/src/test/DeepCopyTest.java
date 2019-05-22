package test;

public class DeepCopyTest {

	public static void main(String[] args) {

//		int[] source = { 1, 2, 3, 4 };
//		int[] dest = source;
		

//		System.out.println(dest[1]);
//
//		source[1] = 5;
//
//		System.out.println(dest[1]);

//		System.out.println(source[1]);
//
//		dest[1] = 5;
//
//		System.out.println(source[1]);
		
		boolean[] source = new boolean[26];
		
		DeepCopy test = new DeepCopy(1, source);
		
		System.out.println(test.getVisited()[5]);
		
		source[5] = true;
		
		System.out.println(test.getVisited()[5]);
		
		

	}

}

class DeepCopy{
	
	private int x;
	private boolean[] visited = new boolean[26];
	
	public DeepCopy() {
		// TODO Auto-generated constructor stub
	}
	
	public DeepCopy(int x, boolean[] visited) {
		this.x = x;
//		this.visited = visited;
		System.arraycopy(visited, 0, this.visited, 0, visited.length);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}
	
	
	
}