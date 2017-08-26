package com.sqa.td;

import com.sqa.td.helpers.*;

public class JoggedHoursProject
{

	public static void main(String[] args)
	{
		String name = AppBasics.greetUserAndGetName("Jogged Hours");
		String registerUsers = AppBasics.requestString("Let's start with your registration! Please enter your name:");
		while (!registerUsers.equalsIgnoreCase("exit"))
		{
			float joggersLog = AppBasics.requestFloat("How many days have you been jogging this week?", 0, 7);
			float totalHoursJogged = 0;
			float avgHoursJogged = 0;
			for (int i = 1; i <= joggersLog; i++)
			{
				int hoursLog = AppBasics.requestInt("How many hours have you been jogging on day[" + i + "]", 0, 7);
				totalHoursJogged += hoursLog;
			}
			System.out
					.println(registerUsers + ", you have logged " + totalHoursJogged + " hours this week! Keep it up.");
			avgHoursJogged = totalHoursJogged / joggersLog;
			System.out
					.println(registerUsers + ", your average number of hours jogged is " + avgHoursJogged + " hours.");
			System.out.print("Your status is:" + joggerStatus(totalHoursJogged));
			registerUsers = AppBasics.requestString("\nWhat other users would you like to log? Type 'exit' to quit.");
		}
		AppBasics.farewellUser(name);
	}

	/**
	 * Distinguish if the jogger is an Amateur Jogger/ Efficient Jogger/ or
	 * Extremist Jogger.Amateur is under 15 hours, Efficient is 15-40 hours, and
	 * an Extremist is over 40.
	 */
	private static String joggerStatus(float hours)
	{
		String status = "Amateur Jogger";
		if (hours < 15)
		{
			System.out.println("Keep going, you are doing great!");
			return status;
		} else if (hours <= 40)
		{
			status = "Efficient Jogger";
			System.out.println("Now we are talking!");
			return status;
		} else
		{
			status = "Extremist Jogger";
			System.out.println("Wow! You are ready for a marathon.");
			return status;
		}
	}
}
