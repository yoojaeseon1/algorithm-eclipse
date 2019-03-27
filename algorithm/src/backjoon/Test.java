package backjoon;

public class Test extends test2 implements TestInterface{

	public static void main(String[] args) {

		
		char testChar = 'A';
		System.out.println("_" + (char)((int)testChar + 32));
		
		Test a = new Test();
		
		System.out.println(a.func1(1,1));
		
		a.func1(1);
		
		a.haha();
		
		a.test();
	}

	@Override
	public void haha() {

		System.out.println("haha hoho");
		
	}

	@Override
	public void test() {
		
		System.out.println("implemented method");
		
	}
	
}

abstract class test2 {
	
	int a;
	
	public abstract void haha();
	
	public void func1(int num) {
		System.out.println("haha");
	}
	
	public int func1(int num, int num2) {
		return 0;
	}

}