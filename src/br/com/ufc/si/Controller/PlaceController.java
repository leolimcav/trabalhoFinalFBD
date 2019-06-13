package br.com.ufc.si.Controller;

import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Dao.PlaceDAO;
import br.com.ufc.si.Entity.Place;

public class PlaceController {
	
	ConnectionPostgres connPostgres = new ConnectionPostgres();
	PlaceDAO placeDao = new PlaceDAO(connPostgres);
	
	public Place searchPlaceById(Long placeId) {
		return placeDao.read(placeId);
	}
	
	public List<Place> userPlaces(Long userId){
		return placeDao.getUserPlaces(userId);
	}
	
	public List<Place> listAllPlaces(){
		return placeDao.getAllPlaces();
	}
	
	public void addPlace(String city, String country, String description, Long ownerId) {
		Place place = new Place(city, country, description, ownerId);
		placeDao.create(place);
	}
	
	public void updatePlace(String city, String country, String description, Long ownerId) {
		Place place = new Place(city, country, description, ownerId);
		placeDao.update(place);
	}
	
	public void deletePlace(Long placeId) {
		placeDao.delete(placeId);
	}
	
}
