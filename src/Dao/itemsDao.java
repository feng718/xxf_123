package Dao;

import java.sql.*;
import java.util.*;

import org.junit.Test;

import pojo.items;
import utils.JDBC;

public class itemsDao {
	@Test
	public void test() {
		//List<items> itemsList = queryUsersInfo();
		//List<items> itemsList = queryUsersInfoByid(344444463);
		List<items> itemsList = queryUsersInfoByName("小");
		for(items items : itemsList) {
			System.out.println(items);
		}
	}
	
	
	/**
	 * SELECT * FROM items u;
	 */
	public List<items>  queryUsersInfo(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//定义一个容器，通过循环追加的方式，添加到集合中
		List<items>  itemsList = new ArrayList<items>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			
			String sql = "SELECT * FROM items u";
		
			ps = conn.prepareStatement(sql);
			//执行sql
			rs = ps.executeQuery();
			
			while(rs.next()){
			
				items items = new items(rs.getInt("id"),
						rs.getString("name"), 
						rs.getDouble("price"), 
						rs.getString("detail"), 
						rs.getString("pic"), 
						rs.getDate("createtime"));
				
				//通过循环追加的方式，添加到集合中
				itemsList.add(items);			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
	
		return itemsList;
		
	}
	/**
	 * SELECT * FROM items u where u.id = ?;
	 */
	public List<items>  queryUsersInfoByid(int id){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//定义一个容器，通过循环追加的方式，添加到集合中
		List<items>  itemsList = new ArrayList<items>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			
			String sql = "SELECT * FROM items u where u.id = ?";
		
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			//执行sql
			rs = ps.executeQuery();
			
			while(rs.next()){
			
				items items = new items(rs.getInt("id"),
						rs.getString("name"), 
						rs.getDouble("price"), 
						rs.getString("detail"), 
						rs.getString("pic"), 
						rs.getDate("createtime"));
				
				//通过循环追加的方式，添加到集合中
				itemsList.add(items);			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
	
		return itemsList;
		
	}
	/**
	 * SELECT * FROM items u where u.id = ?;
	 */
	public List<items>  queryUsersInfoByName(String name){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//定义一个容器，通过循环追加的方式，添加到集合中
		List<items>  itemsList = new ArrayList<items>();
		try {
			//获取连接
			conn = JDBC.getConnection();
			
			String sql = "SELECT * FROM items u where u.name like ?";
		
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "%" + name + "%");
			//执行sql
			rs = ps.executeQuery();
			
			while(rs.next()){
			
				items items = new items(rs.getInt("id"),
						rs.getString("name"), 
						rs.getDouble("price"), 
						rs.getString("detail"), 
						rs.getString("pic"), 
						rs.getDate("createtime"));
				
				//通过循环追加的方式，添加到集合中
				itemsList.add(items);			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC.close(rs, ps, conn);
		}
	
		return itemsList;
		
	}
}
