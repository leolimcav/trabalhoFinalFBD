package br.com.ufc.si.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ufc.si.Controller.PlaceController;
import br.com.ufc.si.Controller.TelephoneController;
import br.com.ufc.si.Controller.TripController;
import br.com.ufc.si.Controller.UserController;
import br.com.ufc.si.Entity.Telephone;
import br.com.ufc.si.Entity.User;

public class InterfaceMain {
	
	Scanner scan = new Scanner(System.in);
	UserController userController = new UserController();
	PlaceController placeController = new PlaceController();
	TripController tripController = new TripController();
	TelephoneController telephoneController = new TelephoneController();
	
	public void start() throws SQLException{
		boolean loop = true;
		
		do {
			System.out.println("1 - User Menu");
			System.out.println("2 - Trip Menu");
			System.out.println("3 - Place Menu");
			System.out.println("4 - Telephone Menu");
			System.out.println("5 - Exit");
			System.out.print("> ");
			int opt = scan.nextInt();
			switch (opt) {
			case 1:
				userMenu();
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Option! Try Again");
				break;
			}
		}while(loop);
	}
	
	public void userMenu() {
		boolean loop = true;
		int usrOpt;
		do {
			System.out.println("1 - Search User By Id");
			System.out.println("2 - Create User");
			System.out.println("3 - Update User");
			System.out.println("4 - Delete User");
			System.out.println("5 - List All Users");
			System.out.println("6 - List All Telephones");
			System.out.println("7 - Show User Telephone By ID");
			System.out.println("8 - Exit");
			System.out.print("> ");
			usrOpt = scan.nextInt();
			switch (usrOpt) {
			case 1:
				System.out.print("Type the User ID: ");
				Long userId = scan.nextLong();
				User user = userController.searchUserById(userId);
				System.out.println(user.toString());
				break;
			case 2:
				System.out.print("FirstName: ");
				String firstName = scan.next();
				System.out.print("LastName: ");
				String lastName = scan.next();
				System.out.print("Email: ");
				String email = scan.next();
				System.out.print("Password: ");
				String password = scan.next();
				System.out.print("Gender: ");
				String gender = scan.next();
				System.out.print("Number: ");
				int number = scan.nextInt();
				System.out.print("Street: ");
				String street = scan.next();
				System.out.print("City: ");
				String city = scan.next();
				System.out.print("State: ");
				String state = scan.next();
				System.out.print("ZipCode: ");
				String zipCode = scan.next();
				System.out.print("Country: ");
				String country = scan.next();
				System.out.println("1 - Guest/ 2 - Host");
				System.out.print("> ");
				int rl = scan.nextInt();
				Long role;
				if(rl == 1) {
					role = 2L;
				}else {
					role = 3L;
				}
				userController.addUser(firstName, lastName, email, gender, password, number, street, city, state, zipCode, country, role);
				break;
			case 3:
				System.out.print("Type the ID of the User: ");
				User updUser = userController.searchUserById(scan.nextLong());
				System.out.print("FirstName: ");
				firstName = scan.next();
				System.out.print("LastName: ");
				lastName = scan.next();
				System.out.print("Email: ");
				email = scan.next();
				System.out.print("Password: ");
				password = scan.next();
				System.out.print("Gender: ");
				gender = scan.next();
				System.out.print("Number: ");
				number = scan.nextInt();
				System.out.print("Street: ");
				street = scan.next();
				System.out.print("City: ");
				city = scan.next();
				System.out.print("State: ");
				state = scan.next();
				System.out.print("ZipCode: ");
				zipCode = scan.next();
				System.out.print("Country: ");
				country = scan.next();
				
				userController.updateUser(firstName, lastName, email, gender, password, number, street, city, state, zipCode, country, updUser.getRole());
				break;
			case 4:
				System.out.print("Type the ID of the User: ");
				Long id = scan.nextLong();
				userController.deleteUser(id);
				break;
			case 5:
				List<User> users = new ArrayList<User>();
				users = userController.listAllUsers();
				for(User u : users) {
					System.out.println(u.toString());
				}
				break;
			case 6:
				List<Telephone> phones = new ArrayList<Telephone>();
				phones = telephoneController.listAllTelephones();
				for(Telephone t : phones) {
					System.out.println(t.toString());
				}
				break;
			case 7:
				List<Telephone> userPhones = new ArrayList<Telephone>();
				System.out.print("Type the user ID: ");
				userId = scan.nextLong();
				userPhones = telephoneController.userTelephone(userId);
				for(Telephone t : userPhones) {
					System.out.println(t.toString());
				}
				break;
			case 8:
				loop = false;
				break;
			default:
				System.out.println("Invalid Option! Try Again");
				break;
			}
		}while(loop);
	}
	
	public void tripMenu() {
		
	}
	
}
