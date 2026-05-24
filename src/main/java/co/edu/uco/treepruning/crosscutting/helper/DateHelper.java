package co.edu.uco.treepruning.crosscutting.helper;

import java.sql.Date;
import java.time.LocalDate;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;

public final class DateHelper {

    private static final LocalDate DEFAULT_DATE = LocalDate.of(1, 1, 1);

    private DateHelper() {
    }

    public static LocalDate getDefault() {
        return DEFAULT_DATE;
    }

    public static LocalDate getDefault(final LocalDate value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static LocalDate generateCurrentDate() {
        return LocalDate.now();
    }

    public static boolean isDefaultDate(final LocalDate date) {
        return DEFAULT_DATE.equals(date);
    }

    public static LocalDate dateToLocalDate(final Date value) {
        return ObjectHelper.getDefault(value, Date.valueOf(getDefault())).toLocalDate();
    }

    public static boolean isLocalDateAfterOrEquals(final LocalDate value) {
        return value.isAfter(LocalDate.now()) || value.isEqual(LocalDate.now());
    }

    /** Validates that the date does not exceed the configured scheduling horizon. */
    public static boolean isLocalDateBefore(final LocalDate value) {
        return value.isBefore(CrossCuttingConstants.maxSchedulingDate());
    }
    public static boolean isLocalDateBefore(final LocalDate value, int horizonMonths) {
        return value.isBefore(LocalDate.now().plusMonths(horizonMonths));
    }
}
