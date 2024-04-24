package com.mlvn.crud_users.service;

import java.sql.SQLException;
import java.util.List;

import com.mlvn.crud_users.model.UserDB;
import com.mlvn.crud_users.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}
	
	public int saveUser(UserDB user){
		try{
			return userRepository.createUser(user);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public List<UserDB> getListUsers() throws SQLException, Exception{
		return userRepository.getAllUsers();
	}
	
	public UserDB getUserById(int id) throws SQLException, Exception{
		return userRepository.getUserById(id);
	}
	
	public int updateUser(UserDB user){
		try{
			return userRepository.updateUser(user);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public int deleteUser(int id){
		try{
			return userRepository.deleteUser(id);
		}catch(Exception ex){
			return -1;
		}
	}
}