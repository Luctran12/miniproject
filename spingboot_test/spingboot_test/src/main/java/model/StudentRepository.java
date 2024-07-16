package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class StudentRepository {
	private final JdbcTemplate jdbc;
	
	public StudentRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public void addStudent(Student student) {
		String sql = "INSERT INTO student(s_name,dob,age) values(?,?,?)";
		jdbc.update(sql,student.getName(),student.getDob(),student.getAge());
	}
	
	public void deleteStudent(String id) {
		String sql = "Delete FROM student WHERE id = ?";
		jdbc.update(sql, id);
	}
	
	public void updateStudent(Student student) {
		String sql = "Update student SET s_name = ?, dob = ?, age = ? WHERE id = ?";
		jdbc.update(sql,student.getName(),student.getDob(),student.getAge(),student.getId());
	}
	
	public List<Student> getAll() {
		String sql = "SELECT * FROM student";
		RowMapper<Student> studentRowMapper = (r, i) -> { 
			Student rowObject = new Student(); 
			 rowObject.setId(r.getString("id"));
			 rowObject.setName(r.getString("s_name")); 
			 rowObject.setDob(r.getDate("dob")); 
			 rowObject.setAge(r.getInt("age")); 
			 return rowObject; 
			 };
			 return jdbc.query(sql, studentRowMapper);
	}
	
	  public Student findById(String id) {
	        String sql = "SELECT * FROM student WHERE id = ?";
	        return jdbc.queryForObject(
	            sql,new Object[] {id},
	            new RowMapper<Student>() {
	                @Override
	                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    return new Student(
	                        rs.getString("id"),
	                        rs.getString("s_name"),
	                        rs.getDate("dob"),
	                        rs.getInt("age")
	                    );
	                }
	            }
	        );
	    }
}
