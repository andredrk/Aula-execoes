package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer roomNumer, Date checkIn, Date checkOlt) {
		
		this.roomNumber = roomNumer;
		this.checkIn = checkIn;
		this.checkOut = checkOlt;
	}
	
	public Integer getRoomNumer() {
		return roomNumber;
	}
	public void setRoomNumer(Integer roomNumer) {
		this.roomNumber = roomNumer;
	}
	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOlt() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checkIn, Date CheckOut) {
		this.checkIn = checkIn;
		this.checkOut = CheckOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ duration()
			+ " nigth";
		
	}
	
}
