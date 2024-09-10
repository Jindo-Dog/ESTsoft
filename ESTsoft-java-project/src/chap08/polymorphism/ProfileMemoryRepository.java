package chap08.polymorphism;

public class ProfileMemoryRepository implements ProfileRepository {
	@Override
	public void save() {
		System.out.println("ProfileMemoryRepository.save");
	}
}
