package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date ");
		}
		else {
			Reservation reservaion = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservaion);
			
			System.out.println();
			System.out.print("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update be future dates");
				
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Error in reservation: Check-out date must be after check-in date ");
			}
			else {
				reservaion.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservaion);
			}
			

		}
		
		
		sc.close();
	}

}
