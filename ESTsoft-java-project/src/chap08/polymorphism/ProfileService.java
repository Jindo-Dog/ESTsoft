package chap08.polymorphism;

public class ProfileService {
	ProfileRepository repository;

	void saveProdile() {
		repository = new ProfileDBRepository();    // 만약 다른 저장소가 추가된다면 객체 생성자만 바꿔끼우면 됨
		repository.save();
	}

	void saveProfile(ProfileRepository repository) {
		this.repository.save();
	}
}
