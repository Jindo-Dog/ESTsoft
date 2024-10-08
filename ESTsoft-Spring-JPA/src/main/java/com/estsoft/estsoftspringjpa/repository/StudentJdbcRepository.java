package com.estsoft.estsoftspringjpa.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringjpa.model.Student;
import com.estsoft.estsoftspringjpa.model.StudentRowMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentJdbcRepository implements StudentRepository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**TODO
	 * student, instructor, lecture_course
	 * SELECT * FROM TABLE
	 * SELECT * FROM XXX WHERE id = 그외 기타 컬럼들로 = , > < (숫자, 날짜)
	 * INSERT INTO TABLE VALUE
	 * UPDATE STUDENT SET AGE = :age where id = :id
	 */

	/*public List<String> selectStudentNameList() {
		return jdbcTemplate.queryForList("SELECT name FROM students", String.class);
	}*/

	/*public Map<String, Object> selectStudentName(String name, Integer age) {
		return jdbcTemplate.queryForMap("SELECT name FROM student WHERE name = ? AND age > ?", name, age);
	}*/

	/*public Map<String, Object> selectStudentName2(String name, Integer age) {
		return namedParameterJdbcTemplate.queryForMap(
			"SELECT name FROM student WHERE name = :name AND age > :age",
			new MapSqlParameterSource("name", name).addValues("age", age)
		);
	}*/

	/*public Map<String, Object> selectStudentName3(String name, Integer age) {
		return namedParameterJdbcTemplate.queryForObject(
			"SELECT * FROM student WHERE name = :name AND age > :age",
			new MapSqlParameterSource("name", name).addValues("age", age),
			(rs, rowNum) -> new Student(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getString("desc"),
				rs.getDate("created_at")
			)
		);
	}*/
	@Override
	public int countOfStudents() {
		return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM student", Integer.class);
	}

	@Override
	public List<String> selectListOfStudentName() {
		return jdbcTemplate.queryForList("SELECT name FROM student", String.class);
	}

	@Override
	public int insertStudent(Map<String, Object> params) {
		String name = (String)params.get("name");
		int age = Integer.parseInt((String)params.get("age"));
		return jdbcTemplate.update("INSERT INTO student(name, age, created_at) VALUES(?, ?, NOW())", name, age);
	}

	@Override
	public Map<String, Object> getStudent(int id) {
		return jdbcTemplate.queryForMap("SELECT id, name FROM student WHERE id = ?", id);
	}

	@Override
	public Student getStudentById(int id) {
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT id, name, age, DESC FROM student WHERE id = ?", id);
		Student student = new Student();
		student.setId((Long)map.get("id"));
		student.setName((String)map.get("name"));
		student.setAge((Integer)map.get("age"));
		student.setDesc((String)map.get("desc"));

		return student;
	}

	@Override
	public int insertStudent(Student student) {
		return jdbcTemplate.update("INSERT INTO student(name, age) VALUES(?, ?)", student.getName(), student.getAge());
	}

	@Override
	public List<Student> selectListOfStudent() {
		List<Student> list = jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());

		return jdbcTemplate.query("SELECT * FROM student",
			(rs, rowNum) -> new Student(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getDate("created_at")
			));
	}

	@Override
	public List<Student> findStudents(String name) {
		return jdbcTemplate.query(
			"SELECT * FROM student WHERE name LIKE ?",
			new Object[] {"%" + name + "%"},
			(rs, rowNum) -> new Student(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getDate("created_at")
			));
	}

	@Override
	public Optional<Student> selectStudentById(Integer studentId) {
		return jdbcTemplate.queryForObject(
			"SELECT * FROM student WHERE id = ?",
			new Object[] {studentId},
			(rs, rowNum) -> Optional.of(new Student(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getDate("created_at")
			))
		);
	}
}
