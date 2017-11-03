package user;

import java.util.*;
import java.sql.*;

public class DataProcessing {

	public static int max=50;
	// 创建一个静态的哈希表，特定键为一个String类型的变量，相应值是一个Student类的对象
	static Hashtable<String, Student> students;
	// 创建一个静态的哈希表，特定键为一个String类型的变量，相应值是一个Administrator类的对象
	static Hashtable<String, Administrator> administrators;
	// 创建一个静态的哈希表，特定键为一个String类型的变量，相应值是一个Course类的对象
	static Hashtable<String, Course> courses;
	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static String driverName = "com.mysql.jdbc.Driver"; // 加载数据库驱动类
	static String url = "jdbc:mysql://localhost:3306/css?useUnicode=true&characterEncoding=utf-8&useSSL=false"; // 声明数据库的URL(统一资源定位符)
	static String MyUser = "root"; // 数据库用户
	static String MyPassword = "176526";

	static {
		Init();
	}

	// public static void insert()throws SQLException{
	////
	//
	// //String sql="INSERT INTO salary
	// VALUES('010101','1200','1300')";//对数据库进行的插入语句
	// String sql1="DELETE FROM student WHERE ID>5";//对数据库进行的插入语句
	//
	// if(statement.executeUpdate(sql1)>0){
	// System.out.println("*********");
	// }
	//// if(statement.executeUpdate(sql)>0){
	//// System.out.println("!!!!!!!!!!");
	//// }
	// }

	public static void Init() {
		// connect to database

		// update database connection status
		try {
			Class.forName(driverName);// 加载数据库MySQL的驱动
			connection = DriverManager.getConnection(url, MyUser, MyPassword);// 建立数据库连接
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 创建语句对象，并设置ResultSet对象对修改不敏感，且为只读类型
		} catch (ClassNotFoundException e) {
			System.out.println("数据驱动错误");
		} catch (SQLException e) {
			System.out.println("数据库错误");
		}
		System.out.println("数据驱动成功！");
	}

	/*********************************************************
	 * 
	 * 查询信息
	 * 
	 ********************************************************/

	// 查询课程信息
	// 将异常抛出
	public static Course searchCourse(String name) throws SQLException {
		String sql = "select * from course";// 查询course中的所有信息 ******
		resultSet = statement.executeQuery(sql);// 执行查询语句
		String name1;
		Course temp = null;
		while (resultSet.next()) {
			name1 = resultSet.getString("name");
			if (name.equals(name1)) {
				double score = resultSet.getDouble("score");
				int evaluateNum = resultSet.getInt("evaluateNum");
				String evaluation = resultSet.getString("evaluation");
				int capacity = resultSet.getInt("capacity");
				int number = resultSet.getInt("number");
				double credit = resultSet.getDouble("credit");
				String description = resultSet.getString("description");
				int required = resultSet.getInt("required");
				String teacher = resultSet.getString("teacher");
				String term = resultSet.getString("term");
				String time = resultSet.getString("time");
				String place = resultSet.getString("place");
				temp = new Course(name, credit, required, term, capacity, number, teacher, time, place, description,score, evaluateNum, evaluation);
				break;
			}
		}
		return temp;
	}

	
	// 学生登录系统
	// 查询输入的姓名和密码是否存在，若存在，则返回一个student的对象；否则，返回null.
	// 将异常抛出
	public static Student searchStudent(String ID, String password) throws SQLException {
		String sql = "select * from student";
		resultSet = statement.executeQuery(sql);
		String name = null;
		String ID1 = null;
		String password1 = null;
		String pwdHint = null;
		String role = "student";
		String banji = null;
		String courses = null;
		Student temp = null;
		while (resultSet.next()) {
			ID1 = resultSet.getString("ID");
			password1 = resultSet.getString("password");
			if (ID1.equals(ID) && password1.equals(password)) {
				name = resultSet.getString("name");
				pwdHint = resultSet.getString("pwdHint");
				banji = resultSet.getString("banji");
				courses = resultSet.getString("courses");
				temp = new Student(ID, name, password, pwdHint, role, banji, courses);
				break;
			}
		}
		return temp;
	}

	
	// 管理员登录系统
	// 查询输入的姓名和密码是否存在，若存在，则返回一个administrator的对象；否则，返回null.
	// 将异常抛出
	public static Administrator searchAdministrator(String ID, String password) throws SQLException {
		String sql = "select * from administrator";
		resultSet = statement.executeQuery(sql);
		String name = null;
		String ID1 = null;
		String password1 = null;
		String pwdHint = null;
		String role = "administrator";
		Administrator temp = null;
		while (resultSet.next()) {
			ID1 = resultSet.getString("ID");
			password1 = resultSet.getString("password");
			if (ID1.equals(ID) && password1.equals(password)) {
				name = resultSet.getString("name");
				pwdHint = resultSet.getString("pwdHint");
				temp = new Administrator(ID, name, password, pwdHint, role);
				break;
			}

		}
		return temp;
	}

	
	// 学生忘记密码
	// 查询输入的ID是否存在，若存在，则返回一个student的对象；否则，返回null.
	// 将异常抛出
	public static Student searchStudent(String ID) throws SQLException {
		String sql = "select * from student";
		resultSet = statement.executeQuery(sql);
		String name = null;
		String ID1 = null;
		String password = null;
		String pwdHint = null;
		String role = "student";
		String banji = null;
		String courses = null;
		Student temp = null;
		while (resultSet.next()) {
			ID1 = resultSet.getString("ID");
			if (ID1.equals(ID)) {
				name = resultSet.getString("name");
				password = resultSet.getString("password");
				pwdHint = resultSet.getString("pwdHint");
				banji = resultSet.getString("banji");
				courses = resultSet.getString("courses");
				temp = new Student(ID, name, password, pwdHint, role, banji, courses);
				break;
			}

		}
		return temp;
	}

	
	// 管理员忘记密码
	// 查询输入的ID是否存在，若存在，则返回一个administrator的对象；否则，返回null.(忘记密码)
	// 将异常抛出
	public static Administrator searchAdministrator(String ID) throws SQLException {
		String sql = "select * from administrator";
		resultSet = statement.executeQuery(sql);
		String name = null;
		String ID1 = null;
		String password = null;
		String pwdHint = null;
		String role = "administrator";
		Administrator temp = null;
		while (resultSet.next()) {
			ID1 = resultSet.getString("ID");

			if (ID1.equals(ID)) {
				name = resultSet.getString("name");
				password = resultSet.getString("password");
				pwdHint = resultSet.getString("pwdHint");
				temp = new Administrator(ID, name, password, pwdHint, role);
				break;
			}
		}
		return temp;
	}


	// 查看course表的所有信息
	// 用一个Enumeration接口得到所有课程信息
	// 将异常抛出
	public static Enumeration<Course> getAllCourses() throws SQLException {
		Hashtable<String, Course> courses = new Hashtable<String, Course>();
		Enumeration<Course> e;
		Course temp = null;
		
		String sql = "select * from course";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String name=resultSet.getString("name");
			double score = resultSet.getDouble("score");
			int evaluateNum = resultSet.getInt("evaluateNum");
			String evaluation = resultSet.getString("evaluation");
			int capacity = resultSet.getInt("capacity");
			int number = resultSet.getInt("number");
			double credit = resultSet.getDouble("credit");
			String description = resultSet.getString("description");
			int required = resultSet.getInt("required");
			String teacher = resultSet.getString("teacher");
			String term = resultSet.getString("term");
			String time = resultSet.getString("time");
			String place = resultSet.getString("place");
			temp = new Course(name, credit, required, term, capacity, number, teacher, time, place, description,score, evaluateNum, evaluation);
			courses.put(name,temp);
		}
		e = courses.elements();
		return e;
	}

	
	
	
	/*********************************************************
	 * 
	 * 插入数据库中的信息
	 * 
	 ********************************************************/
	// 添加课程
	// 成功返回true;否则，返回false
	// 将异常抛出
	public static boolean insertCourse(String name,double credit,int required,String term,int capacity,int number,String teacher,String time,String place,String description) throws SQLException {
		String n="";
		String sql = "INSERT INTO course VALUES('" + name + "','" + credit + "','" + required + "','" + term + "','"+ capacity + "','" + number + "','" + teacher + "','" + time + "','" + place + "','" + description + "','" + 0 + "','" + 0 + "','" + n + "')";// 对数据库进行的插入语句
		if (statement.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}


	/*********************************************************
	 * 
	 * 修改数据库中的信息
	 * 
	 ********************************************************/

	// 学生修改个人密码
	// 将异常抛出
	public static boolean updateStudentPwd(String ID, String password) throws SQLException {
		String sql = "UPDATE student SET password=? where ID=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setString(1, password);// 预编译
		preparedStatement.setString(2, ID);// 预编译
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
	
	
	// 学生选课、退课
	// 将异常抛出
	public static boolean updateStudentCourses(String ID, String courses) throws SQLException {
		String sql = "UPDATE student SET courses=? where ID=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setString(1, courses);// 预编译
		preparedStatement.setString(2, ID);// 预编译
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
	
	

	// 学生添加课程后对课程数据库的修改,即选课人数+1
	// 将异常抛出
	public static boolean updateCoursePlus(String name) throws SQLException {
		String sql = "select * from course";
		String name1;
		int num = 0;
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			name1 = resultSet.getString("name");
			if (name.equals(name1)) {
				num = resultSet.getInt("number");
				break;
			}
		}
		num++;
		sql = "UPDATE course SET number=? where name=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setInt(1, num);// 预编译
		preparedStatement.setString(2, name);// 预编译
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// 学生退选课程后对课程数据库的修改,即选课人数-1
	// 将异常抛出
	public static boolean updateCourseMinus(String name) throws SQLException {
		String sql = "select * from course";
		String name1;
		int num = 0;
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			name1 = resultSet.getString("name");
			if (name.equals(name1)) {
				num = resultSet.getInt("number");
				break;
			}
		}
		num--;
		sql = "UPDATE course SET number=? where name=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setInt(1, num);// 预编译
		preparedStatement.setString(2, name);// 预编译
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// 管理员修改课程信息
	// 成功返回true;否则，返回false
	// 将异常抛出
	public static boolean updateCourse(String name,double credit,int required,String term,int capacity,String teacher,String time,String place,String description) throws SQLException {
		String sql = "UPDATE course SET credit=?,required=?,term=?,capacity=?,teacher=?,time=?, place=?, description=? where name=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setDouble(1, credit);// 预编译
		preparedStatement.setInt(2, required);// 预编译
		preparedStatement.setString(3, term);// 预编译
		preparedStatement.setInt(4, capacity);// 预编译
		preparedStatement.setString(5, teacher);// 预编译
		preparedStatement.setString(6, time);// 预编译
		preparedStatement.setString(7, place);// 预编译
		preparedStatement.setString(8, description);// 预编译
		
		preparedStatement.setString(9, name);// 预编译

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// 管理员修改个人密码
	// 将异常抛出
	public static boolean updateAdministratorPwd(String ID, String password) throws SQLException {
		String sql = "UPDATE administrator SET password=? where ID=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setString(1, password);// 预编译
		preparedStatement.setString(2, ID);// 预编译
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// 管理员删除课程，若存在该课程，则将该课程从数据库中移除并返回true；否则返回false.
	// 将异常抛出
	public static boolean deleteCourse(String name) throws SQLException {
		String sql = "delete from course where name='" + name + "'";
		if (statement.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}


	// 管理员修改学生信息(只可修改name,password,pwdHint,banji)
	// 将异常抛出
	public static boolean updateStudentInfo(String ID, String name, String password, String pwdHint, String banji) throws SQLException {
		String sql = "UPDATE student SET name=?,password=?,pwdHint=?,banji=? where ID=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setString(1, name);// 预编译
		preparedStatement.setString(2, password);// 预编译
		preparedStatement.setString(3, pwdHint);// 预编译
		preparedStatement.setString(4, banji);// 预编译
		preparedStatement.setString(5, ID);// 预编译

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}



	// 学生评教
	// 将异常抛出
	public static boolean updateCourseEvaluate(String name, double score,int evaluateNum,String evaluation)throws SQLException {				
		String sql = "UPDATE course SET score=?,evaluateNum=?,evaluation=? where name=?";// 预先声明一下要更新了
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement = connection.prepareStatement(sql);// 预编译
		preparedStatement.setDouble(1, score);// 预编译
		preparedStatement.setInt(2, evaluateNum);// 预编译
		preparedStatement.setString(3, evaluation);// 预编译
		preparedStatement.setString(4, name);// 预编译

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
}