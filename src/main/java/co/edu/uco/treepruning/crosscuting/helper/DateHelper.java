package co.edu.uco.treepruning.crosscuting.helper;

import java.sql.Date;
import java.time.LocalDate;

public class DateHelper {
private static final DateHelper INSTANCE = new DateHelper ();
	
	private DateHelper() {
	}
	
	public static DateHelper getDateHelper() {
		return INSTANCE;
	}
	
	public LocalDate getDefault() {
		return LocalDate.of(1, 1, 1);
	}
	
	public LocalDate getDefault (final LocalDate value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public LocalDate generateCurrentDate() {
		return LocalDate.now();
	}
	
	public boolean isDefaultDate(final LocalDate date) {
		return getDefault().equals(date);
	}
	
	public LocalDate dateToLocalDate(final Date value) {
		return ObjectHelper.getDefault(value, Date.valueOf(getDefault())).toLocalDate();	
	}
	
	public boolean isLocalDateAfterOrEquals(final LocalDate value) {
		return (value.isAfter(LocalDate.now()) || value.isEqual(LocalDate.now()));
	}
	
	public boolean isLocalDateBefore(final LocalDate value) {
		return (value.isBefore(LocalDate.of(2026, 12, 31)));
	}
	

}
