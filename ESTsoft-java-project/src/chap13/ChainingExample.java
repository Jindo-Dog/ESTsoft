package chap13;

/**
 * 메소드 체이닝
 */
public class ChainingExample {
	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		pizza
			.topping("Pepperoni")
			.sauce("Tomato")
			.dough("Thin");
	}
}

class Pizza {
	String topping;
	String sauce;
	String dough;

	//    Pizza(String topping, ... ) 생성자 대신
	Pizza topping(String topping) {
		this.topping = topping;
		return this;
	}

	Pizza sauce(String sauce) {
		this.sauce = sauce;
		return this;
	}

	Pizza dough(String dough) {
		this.dough = dough;
		return this;
	}
}
