package com.basu.work;

import java.io.IOException;
import java.util.Scanner;

public class ConvertAMPMTo24HourClock {

	static String timeConversion(String s) {
/*		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm:ssa");
		System.out.println(s);
		Date date;
		try {
			date = parseFormat.parse(s);
			return displayFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		String[] temp = s.split(":");
		StringBuilder result = new StringBuilder();
		if (s.contains("PM")) {
			int hours = Integer.valueOf(temp[0]) ;
			if (hours == 12) {
				result.append(s.replace("PM", ""));
			} else {
				result.append(hours+12)
				.append(":").append(temp[1])
				.append(":").append(temp[2].replace("PM", ""));
			}
		} else {
			if (Integer.valueOf(temp[0]) == 12) {
				result.append("00");
			} else {
				result.append(temp[0]);
			}
			result.append(":").append(temp[1])
			.append(":").append(temp[2].replace("AM", ""));
		}
		return result.toString();
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scan.nextLine();

		String result = timeConversion(s);
		System.out.println(result);
	}

}
