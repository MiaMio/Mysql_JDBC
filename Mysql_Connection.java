package dbTest;

import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Mysql_Connection {
	public static void signup(String account, String pwd, Connection connection){
		PreparedStatement preparedStatement=connection.prepareStatement("insert into users(user_account, pwd) values(?, ?)");
		
	}
	public static void login(String account, String pwd){
		
	}
	public static void main(String[] args) throws Exception{
		Mysql_Employee employee;
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:MySql:///mydatabase", "root", "pptzz25228");
		System.out.println("reach");
		Statement statement=connection.createStatement();
		String string ="select * from users";
		String insert="insert into users(user_account, pwd) values('tom', '12345')";
		
		int con=statement.executeUpdate(insert);
		ResultSet resultSet=statement.executeQuery(string);
		resultSet.next();
		resultSet.next();
		employee=new Mysql_Employee(resultSet.getInt("id"), resultSet.getString("user_account"), resultSet.getString("pwd"), resultSet.getInt("balance"));
		connection.close();
		System.out.println(employee);
	}
}
