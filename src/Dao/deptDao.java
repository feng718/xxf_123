package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


import pojo.dept;
import utils.JDBC;

public class deptDao {
	@Test
	public void test() {
		// 查询所有
		//List<dept> deptList = queryUsersInfo();
		//根据id查询
		//List<dept> deptList = queryUsersInfoByid(1);
		//根据部门名模糊查询
		List<dept> deptList = queryUsersInfoByName("行");
		for(dept dept : deptList) {
			System.out.println(dept);
		}
	}

	/**
	 * SELECT * FROM dept u;
	 */
	private List<dept> queryUsersInfo() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<dept>  deptList = new ArrayList<dept>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			
			String sql = "SELECT * FROM dept u";
		
			ps = conn.prepareStatement(sql);
			//执行sql
			rs = ps.executeQuery();
			
			while(rs.next()){
			
				dept dept = new dept(rs.getInt("d_id"),
						rs.getString("d_name"), 
						rs.getInt("d_louceng"));
				//通过循环追加的方式，添加到集合中
				deptList.add(dept);			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
		return deptList;
	}
	/**
	 * SELECT * FROM dept u where u.d_id = ?;
	 */
	private List<dept> queryUsersInfoByid(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<dept>  deptList = new ArrayList<dept>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			
			String sql = "SELECT * FROM dept u where u.d_id = ?";
		
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			//执行sql
			rs = ps.executeQuery();
			
			while(rs.next()){
			
				dept dept = new dept(rs.getInt("d_id"),
						rs.getString("d_name"), 
						rs.getInt("d_louceng"));
				//通过循环追加的方式，添加到集合中
				deptList.add(dept);			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
		return deptList;
	}

	/**
	 * SELECT * FROM dept u where u.d_name like ?;
	 */
	private List<dept> queryUsersInfoByName(String d_name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<dept>  deptList = new ArrayList<dept>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			String sql = "SELECT * FROM dept u where u.d_name like concat(?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "%" + d_name + "%");
			//执行sql
			rs = ps.executeQuery();
			while(rs.next()){
				dept dept = new dept(rs.getInt("d_id"),
						rs.getString("d_name"), 
						rs.getInt("d_louceng"));
				//通过循环追加的方式，添加到集合中
				deptList.add(dept);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
		return deptList;
	}

}
