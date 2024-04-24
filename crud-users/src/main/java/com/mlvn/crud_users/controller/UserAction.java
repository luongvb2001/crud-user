package com.mlvn.crud_users.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.mlvn.crud_users.model.*;
import com.mlvn.crud_users.service.UserService;


public class UserAction extends MappingDispatchAction {
	
	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		return mapping.findForward("addUser");
	}
	
	public ActionForward editUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int id = Integer.valueOf(request.getParameter("id"));
		UserService userService = new UserService();
		UserDB user = userService.getUserById(id);
		request.setAttribute("user", user);
		
		return mapping.findForward("editUser");
	}
	
	public ActionForward getHomePage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		UserService userService = new UserService();
		List<UserDB> list = userService.getListUsers();
		request.setAttribute("list", list);
		return mapping.findForward("getHomePage");
	}
	
	public ActionForward proAddUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		User user = (User)form;
		UserService userService = new UserService();
		UserDB userDB = new UserDB(user.getName(), user.getEmail(), user.getPhone(), user.getBirthday());
		int result = userService.saveUser(userDB);
		if(result<=0){
			request.setAttribute("message", "Something wrong! Cannot add user");
		}else{
			request.setAttribute("message", "Add new user successfully!");
		}
		
		return mapping.findForward("proAddUser");
	}
	
	public ActionForward proEditUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		User user = (User) form;
		UserService userService = new UserService();
		UserDB userDB = new UserDB(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getBirthday());
		int result = userService.updateUser(userDB);
		if(result <= 0){
			request.setAttribute("message", "Something wrong! Cannot edit user");
		}else{
			request.setAttribute("message", "Edit user sucessfully!");
		}
		userService = new UserService();
		List<UserDB> list = userService.getListUsers();
		request.setAttribute("list", list);
		return mapping.findForward("proEditUser");
	}
	
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		int id = Integer.valueOf(request.getParameter("id"));
		UserService userService = new UserService();
		int result = userService.deleteUser(id);
		if(result<=0){
			request.setAttribute("message", "Something wrong! Cannot delete user");
		}else{
			request.setAttribute("message", "Delete user sucessfully!");
		}
		userService = new UserService();
		List<UserDB> list = userService.getListUsers();
		request.setAttribute("list", list);
		return mapping.findForward("deleteUser");
	}
}