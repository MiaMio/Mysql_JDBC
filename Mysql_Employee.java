package dbTest;

public class Mysql_Employee {
	private int id;
	private String user_account;
	private String pwd;
	private int balance;
	public Mysql_Employee(int id, String user_account, String pwd, int balance) {
		super();
		this.id = id;
		this.user_account = user_account;
		this.pwd = pwd;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Mysql_Employee [id=" + id + ", user_account=" + user_account + ", pwd=" + pwd + ", balance=" + balance
				+ "]";
	}
	
}
