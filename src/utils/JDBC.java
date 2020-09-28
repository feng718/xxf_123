package utils;

import java.sql.*;

public class JDBC {

	static String DriverClassName = "com.mysql.jdbc.Driver";
	static String DriverClassName123 = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://127.0.0.1:3306/shopping?characterEncoding=utf-8";
	static String userName = "root";
	static String password = "123456";
	
	//因为加载驱动只需要加载一次，所以放在静态代码块中
	static{
		try {
			Class.forName(DriverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败："+e.getMessage());
		}
	}
	/**
	 * 获得连接的方法
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			System.out.println("创建连接失败："+e.getMessage());
		}
		return conn;
	}
	
	/**
	 * 关闭所有资源的方法
	 * @param rs 结果集
	 * @param ps  执行sql的对象
	 * @param conn 连接
	 */
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭ResultSet失败："+e.getMessage());
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("关闭PreparedStatement失败："+e.getMessage());
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭Connection失败："+e.getMessage());
			}
		}
	}

}
