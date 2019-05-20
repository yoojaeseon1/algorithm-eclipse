package test;

public class DeepCopyTest {

	public static void main(String[] args) {

		int[] source = { 1, 2, 3, 4 };
		int[] dest = source;

//		System.out.println(dest[1]);
//
//		source[1] = 5;
//
//		System.out.println(dest[1]);

		System.out.println(source[1]);

		dest[1] = 5;

		System.out.println(source[1]);

	}

}
