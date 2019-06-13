package br.com.ufc.si.Controller;

import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Dao.UserDAO;
import br.com.ufc.si.Entity.User;

public class UserController {
	
	ConnectionPostgres connPostgres = new ConnectionPostgres();
	UserDAO userDao = new UserDAO(connPostgres);
	
	public User searchUserById(Long userId) {
		return userDao.read(userId);
	}
	
	public void addUser(String firstName, String lastName, String email, String gender,
			String password, Integer number, String street, String city, String state, String zipCode, String country,
			Long role) {
		User user = new User(firstName, lastName, email, gender, password, number, street, city, state, zipCode, country, role);
		
		userDao.create(user);
	}
	
	public void updateUser(String firstName, String lastName, String email, String gender,
			String password, Integer number, String street, String city, String state, String zipCode, String country,
			Long role) {
		
		User user = new User(firstName, lastName, email, gender, password, number, street, city, state, zipCode, country, role);
		
		userDao.update(user);
	}
	
	public void deleteUser(Long userId) {
		userDao.delete(userId);
	}
	
	public List<User> listAllUsers(){
		return userDao.getAllUsers();
	}
	
}
