package br.com.ufc.si.Controller;

import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Dao.TripDAO;
import br.com.ufc.si.Entity.Trip;

public class TripController {
	
	ConnectionPostgres connPostgres = new ConnectionPostgres();
	TripDAO tripDao = new TripDAO(connPostgres);
	
	public Trip searchTripById(Long tripId) {
		return tripDao.read(tripId);
	}
	
	public void createTrip(String departureDate, String returnDate, double price, Long userId, Long placeId) {
		Trip trip = new Trip (departureDate, returnDate, price, userId, placeId);
		tripDao.create(trip);
	}
	
	public void updateTrip(Long tripId, String departureDate, String returnDate, double price, Long userId, Long placeId) {
		Trip trip = new Trip (departureDate, returnDate, price, userId, placeId);
		trip.setTripId(tripId);
		tripDao.update(trip);
	}
	
	public void deleteTrip(Long tripId) {
		tripDao.delete(tripId);
	}
	
	public List<Trip> listUserTrips(Long userId){
		return tripDao.getUserTrips(userId);
	}
	
	public List<Trip> listAllTrips() {
		return tripDao.getAllTrips();
	}
	
}
