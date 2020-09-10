package NestedClass;

public class Test {
	private static String msg1 = "Static message";
	private String msg2 = "non-static message";
	public static class NestedStatic {
		public static void printStatic() {
			System.out.println(msg1);
		}
	}
	public class InnerClass{
		public void print() {
			System.out.println(msg1);
			System.out.println(msg2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		Test.InnerClass obj1 = new Test().new InnerClass();
		Test.InnerClass obj3 = t1.new InnerClass();
		NestedStatic obj2 = new NestedStatic();
		obj2.printStatic();
	}

}
