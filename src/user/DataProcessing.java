package user;

import java.util.*;
import java.sql.*;

public class DataProcessing {

	public static int max=50;
	// ����һ����̬�Ĺ�ϣ���ض���Ϊһ��String���͵ı�������Ӧֵ��һ��Student��Ķ���
	static Hashtable<String, Student> students;
	// ����һ����̬�Ĺ�ϣ���ض���Ϊһ��String���͵ı�������Ӧֵ��һ��Administrator��Ķ���
	static Hashtable<String, Administrator> administrators;
	// ����һ����̬�Ĺ�ϣ���ض���Ϊһ��String���͵ı�������Ӧֵ��һ��Course��Ķ���
	static Hashtable<String, Course> courses;
	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static String driverName = "com.mysql.jdbc.Driver"; // �������ݿ�������
	static String url = "jdbc:mysql://localhost:3306/css?useUnicode=true&characterEncoding=utf-8&useSSL=false"; // �������ݿ��URL(ͳһ��Դ��λ��)
	static String MyUser = "root"; // ���ݿ��û�
	static String MyPassword = "176526";

	static {
		Init();
	}

	// public static void insert()throws SQLException{
	////
	//
	// //String sql="INSERT INTO salary
	// VALUES('010101','1200','1300')";//�����ݿ���еĲ������
	// String sql1="DELETE FROM student WHERE ID>5";//�����ݿ���еĲ������
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
			Class.forName(driverName);// �������ݿ�MySQL������
			connection = DriverManager.getConnection(url, MyUser, MyPassword);// �������ݿ�����
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// ���������󣬲�����ResultSet������޸Ĳ����У���Ϊֻ������
		} catch (ClassNotFoundException e) {
			System.out.println("������������");
		} catch (SQLException e) {
			System.out.println("���ݿ����");
		}
		System.out.println("���������ɹ���");
	}

	/*********************************************************
	 * 
	 * ��ѯ��Ϣ
	 * 
	 ********************************************************/

	// ��ѯ�γ���Ϣ
	// ���쳣�׳�
	public static Course searchCourse(String name) throws SQLException {
		String sql = "select * from course";// ��ѯcourse�е�������Ϣ ******
		resultSet = statement.executeQuery(sql);// ִ�в�ѯ���
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

	
	// ѧ����¼ϵͳ
	// ��ѯ����������������Ƿ���ڣ������ڣ��򷵻�һ��student�Ķ��󣻷��򣬷���null.
	// ���쳣�׳�
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

	
	// ����Ա��¼ϵͳ
	// ��ѯ����������������Ƿ���ڣ������ڣ��򷵻�һ��administrator�Ķ��󣻷��򣬷���null.
	// ���쳣�׳�
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

	
	// ѧ����������
	// ��ѯ�����ID�Ƿ���ڣ������ڣ��򷵻�һ��student�Ķ��󣻷��򣬷���null.
	// ���쳣�׳�
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

	
	// ����Ա��������
	// ��ѯ�����ID�Ƿ���ڣ������ڣ��򷵻�һ��administrator�Ķ��󣻷��򣬷���null.(��������)
	// ���쳣�׳�
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


	// �鿴course���������Ϣ
	// ��һ��Enumeration�ӿڵõ����пγ���Ϣ
	// ���쳣�׳�
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
	 * �������ݿ��е���Ϣ
	 * 
	 ********************************************************/
	// ��ӿγ�
	// �ɹ�����true;���򣬷���false
	// ���쳣�׳�
	public static boolean insertCourse(String name,double credit,int required,String term,int capacity,int number,String teacher,String time,String place,String description) throws SQLException {
		String n="";
		String sql = "INSERT INTO course VALUES('" + name + "','" + credit + "','" + required + "','" + term + "','"+ capacity + "','" + number + "','" + teacher + "','" + time + "','" + place + "','" + description + "','" + 0 + "','" + 0 + "','" + n + "')";// �����ݿ���еĲ������
		if (statement.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}


	/*********************************************************
	 * 
	 * �޸����ݿ��е���Ϣ
	 * 
	 ********************************************************/

	// ѧ���޸ĸ�������
	// ���쳣�׳�
	public static boolean updateStudentPwd(String ID, String password) throws SQLException {
		String sql = "UPDATE student SET password=? where ID=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setString(1, password);// Ԥ����
		preparedStatement.setString(2, ID);// Ԥ����
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
	
	
	// ѧ��ѡ�Ρ��˿�
	// ���쳣�׳�
	public static boolean updateStudentCourses(String ID, String courses) throws SQLException {
		String sql = "UPDATE student SET courses=? where ID=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setString(1, courses);// Ԥ����
		preparedStatement.setString(2, ID);// Ԥ����
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
	
	

	// ѧ����ӿγ̺�Կγ����ݿ���޸�,��ѡ������+1
	// ���쳣�׳�
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
		sql = "UPDATE course SET number=? where name=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setInt(1, num);// Ԥ����
		preparedStatement.setString(2, name);// Ԥ����
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// ѧ����ѡ�γ̺�Կγ����ݿ���޸�,��ѡ������-1
	// ���쳣�׳�
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
		sql = "UPDATE course SET number=? where name=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setInt(1, num);// Ԥ����
		preparedStatement.setString(2, name);// Ԥ����
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// ����Ա�޸Ŀγ���Ϣ
	// �ɹ�����true;���򣬷���false
	// ���쳣�׳�
	public static boolean updateCourse(String name,double credit,int required,String term,int capacity,String teacher,String time,String place,String description) throws SQLException {
		String sql = "UPDATE course SET credit=?,required=?,term=?,capacity=?,teacher=?,time=?, place=?, description=? where name=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setDouble(1, credit);// Ԥ����
		preparedStatement.setInt(2, required);// Ԥ����
		preparedStatement.setString(3, term);// Ԥ����
		preparedStatement.setInt(4, capacity);// Ԥ����
		preparedStatement.setString(5, teacher);// Ԥ����
		preparedStatement.setString(6, time);// Ԥ����
		preparedStatement.setString(7, place);// Ԥ����
		preparedStatement.setString(8, description);// Ԥ����
		
		preparedStatement.setString(9, name);// Ԥ����

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// ����Ա�޸ĸ�������
	// ���쳣�׳�
	public static boolean updateAdministratorPwd(String ID, String password) throws SQLException {
		String sql = "UPDATE administrator SET password=? where ID=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setString(1, password);// Ԥ����
		preparedStatement.setString(2, ID);// Ԥ����
		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

	
	// ����Աɾ���γ̣������ڸÿγ̣��򽫸ÿγ̴����ݿ����Ƴ�������true�����򷵻�false.
	// ���쳣�׳�
	public static boolean deleteCourse(String name) throws SQLException {
		String sql = "delete from course where name='" + name + "'";
		if (statement.executeUpdate(sql) > 0) {
			return true;
		}
		return false;
	}


	// ����Ա�޸�ѧ����Ϣ(ֻ���޸�name,password,pwdHint,banji)
	// ���쳣�׳�
	public static boolean updateStudentInfo(String ID, String name, String password, String pwdHint, String banji) throws SQLException {
		String sql = "UPDATE student SET name=?,password=?,pwdHint=?,banji=? where ID=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setString(1, name);// Ԥ����
		preparedStatement.setString(2, password);// Ԥ����
		preparedStatement.setString(3, pwdHint);// Ԥ����
		preparedStatement.setString(4, banji);// Ԥ����
		preparedStatement.setString(5, ID);// Ԥ����

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}



	// ѧ������
	// ���쳣�׳�
	public static boolean updateCourseEvaluate(String name, double score,int evaluateNum,String evaluation)throws SQLException {				
		String sql = "UPDATE course SET score=?,evaluateNum=?,evaluation=? where name=?";// Ԥ������һ��Ҫ������
		PreparedStatement preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement = connection.prepareStatement(sql);// Ԥ����
		preparedStatement.setDouble(1, score);// Ԥ����
		preparedStatement.setInt(2, evaluateNum);// Ԥ����
		preparedStatement.setString(3, evaluation);// Ԥ����
		preparedStatement.setString(4, name);// Ԥ����

		if (preparedStatement.executeUpdate() != 0) {
			return true;
		}
		return false;
	}
}