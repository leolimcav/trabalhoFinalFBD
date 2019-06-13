package br.com.ufc.si.Controller;

import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Dao.TelephoneDAO;
import br.com.ufc.si.Entity.Telephone;

public class TelephoneController {
	
	ConnectionPostgres connPostgres = new ConnectionPostgres();
	TelephoneDAO telDao = new TelephoneDAO(connPostgres);
	
	public List<Telephone> userTelephone(Long userId){
		return telDao.read(userId);
	}
	
	public List<Telephone> listAllTelephones(){
		return telDao.getAllPhones();
	}
	
	public void addTelephone(Long userId, String telephone) {
		Telephone tel = new Telephone(userId, telephone);
		
		telDao.create(tel);
	}
	
	public void updateTelephone(Long userId, String telephone) {
		Telephone tel = new Telephone(userId, telephone);
		
		telDao.update(tel);
	}
	
	public void deleteTelephone(String number) {
		telDao.delete(number);
	}
	
}
