package chap10.wildcard;

public class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {    // Object에서 물려받은 toString() 메소드 재정의
		return name;
		// return getName();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person)obj;
			return p.name.equals(name);
		} else {
			return super.equals(obj);
		}
	}
}
