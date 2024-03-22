package sample2;

public class Foo implements InterFoo {
	public Foo() {
		System.out.println("Foo객체 생성 : Foo() 호출");
		System.out.println("this = " + this);
		System.out.println("-------------------------");
	}
	public Foo(String str) {
		System.out.println("Foo객체 생성 : Foo(String) 호출");
		System.out.println("this = " + this);
		System.out.println("전달된 String 객체 : " + str);
		System.out.println("-------------------------");	
	}
	public Foo(int num, String str) {
		System.out.println("Foo객체 생성 : Foo(int num, String str) 호출");
		System.out.println("this = " + this);
		System.out.println("num : " + num);
		System.out.println("str : " + str);
		System.out.println("-------------------------");	
	}
	public Foo(int num, String str, boolean flag) {
		System.out.println("Foo객체 생성 : Foo(int num, String str, boolean flag) 호출");
		System.out.println("this = " + this);
		System.out.println("num : " + num);
		System.out.println("str : " + str);
		System.out.println("flag :" + flag);
		System.out.println("-------------------------");	
	}
	public Foo(Bar bar) {
		System.out.println("Foo객체 생성 : Foo(Bar bar) 호출");
		System.out.println("this = " + this);
		System.out.println("전달된 Bar객체 : " + bar);
		System.out.println("-------------------------");
	}
	
}
