package chap08.inherit;

public class ImplementsC implements InterfaceC {
	@Override
	public void methodC() {
		System.out.println("ImplementsC.methodC");
	}

	@Override
	public void methodA() {
		System.out.println("ImplementsC.methodA");
	}

	@Override
	public void methodB() {
		System.out.println("ImplementsC.methodB");
	}
}