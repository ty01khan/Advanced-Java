package com.patternfly.SpringJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class SpringJdbcOperation {
	public static void main(String[] args) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/SpringMVC");
		dataSource.setUsername("talha");
		dataSource.setPassword("mypass");
		System.out.printf("Database Connected...%n%n");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);

		/*
		 * String insertQuery = "insert into EMPLOYEE(first_name, last_name, salary) values (?, ?, ?)";
		 * String updateQuery = "update EMPLOYEE set salary=? where id=?";
		 * String deleteQuery = "delete from EMPLOYEE where id=? ";
		 * String selectQuery = "select * from EMPLOYEE";
		 * 
		 * Creating rows in table
		 * template.update(insertQuery, "Avinash Sharma", "Data Analyst", 500000);
		 * template.update(insertQuery, "Abhinav Singh", "Business Analyst", 600000);
		 * 
		 * Updating rows in table
		 * template.update(updateQuery, 1000000, 3);
		 * 
		 * Deleting rows in table
		 * template.update(deleteQuery, 2);
		 * 
		 * Select whole table
		 * template.query(selectQuery, new RowMapper<Employee>());
		 */		
		
		List<Employee> list = template.query("select * from Employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				emp.setSalary(rs.getInt(4));

				return emp;
			}
		});
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
}