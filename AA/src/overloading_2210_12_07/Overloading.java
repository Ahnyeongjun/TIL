//package overloading_2210_12_07;
//
//import java.awt.Toolkit;
//public class Overloading {
//	public static void main(String[] args) {
//		//���� Ÿ���� �޶� ��� ���� (�̸� ����, Ÿ�� ���� �޶�ߵ�(Ÿ��,����,����))
////		A a = new A();
////		a.run("a");
////		a.run("a",1);
////		a.run(2,"a");
//		
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Runnable beepTask = new BeepTask();
//		Thread thread = new Thread(beepTask);
//		
////		for(int i=0;i<5;i++) {
////			toolkit.beep();
////			try{Thread.sleep(500);}catch(Exception e) {}
////		}
//		for(int i=0;i<5;i++) {
//			System.out.println("a");
//			try{Thread.sleep(900);}catch(Exception e) {}
//
//		}
//	}
//
//	
//}
//////class A{
//////	A(){
//////		System.out.println("A");
//////	}
//////	void a() {
//////		System.out.println("a");
//////	}
//////	void run(String a) {
//////		System.out.println(a);
//////	}
//////	void run(String a,int a1) {
//////		System.out.println(a+a1);
//////	}
//////	void run(int a1,String a) {
//////		System.out.println(a1+a);
//////	}
//////}
////////�ڹٴ� ���� �ʵ��� �ʱ�ȭ �۾��� ���� ���� ����� ����
////////���� ����� ��Ŭ������ �޸𸮷� �ε��ɶ� �ڵ������� ����ȴ�.
//////class B extends A{
//////	void A() {
//////		System.out.println("a");
//////	}
//////	void B() {
//////		System.out.println("B");
//////		a();
//////		super.a();
//////	}
//////	
//////}
