# Mysql_JDBC
connect mysql to jdbc

javac Mysql_Connection.java and Mysql_Employee.java
This will help you to visit the database in mysql
You need to create a database named mydatabase in mysql and a table named users
as 
create table users(
  id int not null auto_increment,
  user_account varchar(20) not null,
  pwd varchar(20) not null,
  balance int default 0,
  primary_key(id)
);

the program is a demo of a simple login/signup function
you can type in your account and password
if the account exists and password is correct, you succeed in login otherwise you fail
if the account does not exist, your input will be assumed to be a sign up operation

By the way, you also need to add mysql-connector-java-5.1.35-bin.jar to your build path.
