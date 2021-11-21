package com.jdbc.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jdbc.springmvc.beans.Student;

public class StudentDAO {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Student s) {
		String query = "insert into Student(Name, Branch, College) values ('"+s.getName()+"','"+s.getBranch()+"','"+s.getCollege()+"')";
		return template.update(query);
	}
	
	public int update(Student s) {
		String query="update Student set Name='"+s.getName()+"', Branch='"+s.getBranch()+"',College='"+s.getCollege()+"' where ID="+s.getId()+""; 
	    return template.update(query);
	}
	
	public int delete(int id) {
		String query = "delete from Student where id = "+id+"";
		return template.update(query);
	}
	
	public Student getStudentById(int id) {
		String query = "select * from Student where ID=?";
		return template.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public List<Student> getStudents() {
		return template.query("select * from Student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setBranch(rs.getString(3));
				s.setCollege(rs.getString(4));
				
				return s;
			}
		});
	}
}
