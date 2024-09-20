package chap10.wildcard;

import java.util.Arrays;

/**
 * 와일드카드로 선언한 매개변수
 * 와일드카드 extends, super 키워드로 타입 제한
 */
public class WildCardExample {

	public static void registerCourse(Course<?> t) {    //모든 과정
		System.out.println(t.getName() + " 수강생: " + Arrays.toString(t.getStudents()));
	}

	/*public static void registerCourseStudent(Course<? extends Student> t) {    //학생 과정
		System.out.println(t.getName() + " 수강생: " + Arrays.toString(t.getStudents()));
	}*/

	// 와일드카드 타입(?) 대신에 타입파라미터(T) 지정 가능
	// 위에서 정의한 registerCourseStudent와 동일한 동작.
	public static <T extends Student> void registerCourseStudent(Course<T> t) {
		System.out.println(t.getName() + ": " + Arrays.toString(t.getStudents()));
	}

	public static void registerCourseWorker(Course<? super Worker> t) {    // 직장인과 일반인 과정
		System.out.println(t.getName() + " 수강생: " + Arrays.toString(t.getStudents()));
	}

	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));

		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));

		Course<Student> studentCourse = new Course<>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));

		Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
		highStudentCourse.add(new HighStudent("고등학생"));

		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);                // 모든 과정 등록 가능
		System.out.println();

		// registerCourseStudent(personCourse);  (X)
		// registerCourseStudent(workerCourse);	 (X)
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);        // 학생 과정만 등록 가능
		System.out.println();

		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);                // 일반인과 직장인 과정만 등록 가능
		// registerCourseWorker(studentCourse); 	(X)
		// registerCourseWorker(highStudentCourse); (X)
	}
}