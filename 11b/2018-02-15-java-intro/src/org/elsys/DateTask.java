package org.elsys;

import java.time.LocalDate;
import java.util.Scanner;

public class DateTask {

	public static String getDay(String day, String month, String year) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		System.err.println("y: " + y + ", m: " + m + ", d: " + d);
		LocalDate date = LocalDate.of(y, m, d);

		return date.getDayOfWeek().name();
	}
	
	static public void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String month = scan.next();
		String day = scan.next();
		String year = scan.next();
		scan.close();
		
		System.out.println(getDay(day,month,year));
	}
}
