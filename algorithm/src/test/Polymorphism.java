package test;

public class Polymorphism {
	public static void main(String[] args) {
		SuperClass sup = new SubClass(); // Promotion : �ڵ� Ÿ�Ժ�ȯ, Pholymorphism
		// ���� ���ε�
		sup.methodA(); // Runtime�ÿ� �����ȴ�. SubClass�� �޼ҵ� ȣ��
		// ���� ���ε�
		sup.staticMethodA(); // static �޼ҵ�� compile�ÿ� ����, SuperClass�� �޼ҵ� ȣ��
	}
}

class SuperClass {
	void methodA() {
		System.out.println("SuperClass");
	}

	void staticMethodA() {
		System.out.println("SuperClass");
	}
}

class SubClass extends SuperClass {
	void methodA() {
		System.out.println("SubClass");
	}

	void staticMethodA() {
		System.out.println("SubClass");
	}
}
