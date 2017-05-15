package dbTest;

import java.util.Scanner;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Mysql_Connection {
	public static void signup(String account, String pwd, Connection connection)throws Exception{
		PreparedStatement preparedStatement=connection.prepareStatement("select id from users where user_account=? and pwd=?");
		preparedStatement.setString(1, account);
		preparedStatement.setString(2, pwd);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			System.out.println("account exists");
			return;
		}
		PreparedStatement preparedStatement2=connection.prepareStatement("insert into users(user_account, pwd) values(?, ?)");
		preparedStatement2.setString(1, account);
		preparedStatement2.setString(2, pwd);
		preparedStatement2.executeUpdate();
	}
	public static boolean login(String account, String pwd, Connection connection)throws Exception{
		PreparedStatement preparedStatement=connection.prepareStatement("select * from users where user_account=? and pwd=?");
		preparedStatement.setString(1, account);
		preparedStatement.setString(2, pwd);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			Mysql_Employee employee=new Mysql_Employee(resultSet.getInt("id"), resultSet.getString("user_account"), resultSet.getString("pwd"), resultSet.getInt("balance"));
			System.out.println("login success");
			System.out.println(employee);
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:MySql:///mydatabase", "root", "pptzz25228");
//		System.out.println("reach");
		Scanner input=new Scanner(System.in);
		while (true) {
			System.out.println("Input your account: ");
			String account=input.next();
			if(account.equals("exit"))
				break;
			System.out.println("Input your password: ");
			String password=input.next();
			if(password.equals("exit"))
				break;
			
			if(!login(account, password, connection)){
				signup(account, password, connection);
			}
		}
		input.close();
		connection.close();
	}
}
