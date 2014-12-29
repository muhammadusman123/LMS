package algo;

import gui.Authentication.Display;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class DateCalculator implements DateFunctions {
	private Calendar Today, DateToCheck;
	public static int fine = 0;
	public static int date1 = 0;
	public static int month1 = 0;
	public static int year1 = 0;

	public DateCalculator(int month, int date, int year) {
		super();
		date1 = date;
		month1 = month;
		year1 = year;
		System.out.println(date1);
		System.out.println(month1);
		System.out.println(year1);
		calculating(this);

	}

	// @Override
	@Override
	public long getDate() {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		long diffInMillis = Today.getTimeInMillis()
				- DateToCheck.getTimeInMillis();
		return diffInMillis / (24 * 60 * 60 * 1000);
	}

	public boolean isLeap() {
		if (Today.get(Today.YEAR) % 4 == 0)
			return true;
		return false;
	}

	@Override
	public long getMonth() {
		long months = 0;
		long m1 = Today.get(Today.MONTH);
		long m2 = DateToCheck.get(DateToCheck.MONTH);
		m1 += (Today.get(Today.YEAR) * 12);
		m2 += (DateToCheck.get(DateToCheck.YEAR) * 12);
		months = m2 - m1;
		return months;
	}

	public void calculating(DateCalculator d) {
		Today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		String todaydate = sdf.format(Today.getTime());
		System.out.println(todaydate + "Auto DAte");

		DateTime date12 = new DateTime(d.year1, d.month1, d.date1, 0, 0);
		DateTime date22 = new DateTime(14, Today.get(Today.MONTH) + 1,
				Today.get(Today.DAY_OF_MONTH), 0, 0);
		System.out.println(Today.get(Today.MONTH) + "    595959995");
		int di = Days.daysBetween(date12, date22).getDays();
		System.out.println(di + "hello");
		System.out.println(date12);
		System.out.println(date22);
		System.out.println(di + "date differenece");
		Display obj = new Display("");
		obj.setVisible(true);

		if (di <= 0) {
			Display obj1 = new Display("Fine is 0");
			obj1.setVisible(true);
		} else {
			System.out.println("I am Testing");
			fine = (di * 1) + 10;
			Display obj1 = new Display("fine for late return "
					+ ((di * 1) + 10));
			obj1.setVisible(true);
		}
	}
}
