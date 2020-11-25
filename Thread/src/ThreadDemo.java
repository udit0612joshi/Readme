class A extends Thread {

	public void run() {

		for (int i = 1; i <= 5; i++) {
			System.out.println("HI");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class B extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class ThreadDemo {
	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		a.start();
		b.start();

	}

}
