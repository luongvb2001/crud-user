package com.mlvn.crud_users.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlvn.crud_users.dao.DatabaseConnect;

import com.mlvn.crud_users.model.*;

public class UserRepository {
	private Connection connection;
	
	public UserRepository(){
		try {
			this.connection = DatabaseConnect.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	// create user
	public int createUser(UserDB user) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO users (name, email, phone, birthday) VALUES (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setDate(4, user.getBirthday());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	// get all users
	public List<UserDB> getAllUsers() throws SQLException, Exception {
		ResultSet rs = null;
		List<UserDB> list = new ArrayList<UserDB>();
		try {
			String sql = "SELECT * FROM struts.users";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserDB user = new UserDB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}
	
	// get user by id
	public UserDB getUserById(int id) throws SQLException, Exception{
		ResultSet rs = null;
		UserDB user = null;
		try {
			String sql = "SELECT * FROM struts.users where users.id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new UserDB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	// delete user
	public int deleteUser(int id) throws SQLException{
		int i = 0;
		try {
			String sql = "Delete From struts.users where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	// update user
	public int updateUser(UserDB user) throws Exception{
		int i = 0;
		try {
			String sql = "Update struts.users SET name=?, email=?, phone=?, birthday=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2,  user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setDate(4, user.getBirthday());
			ps.setInt(5,  user.getId());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}