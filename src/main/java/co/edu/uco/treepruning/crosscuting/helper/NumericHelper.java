package co.edu.uco.treepruning.crosscuting.helper;

public class NumericHelper {
	private NumericHelper() {
	}
	
	public static int getDefaultInt() {
		return 0;
	}
	
	public static int getDefaultInt(final Integer value) {
		return ObjectHelper.getDefault(value, getDefaultInt());
	}
	
	public static double getDefaultDouble() {
		return 0.0;
	}
	
	public static double getDefaultDouble(final Double value) {
		return ObjectHelper.getDefault(value, getDefaultDouble());
	}
	
	public static long getDefaultLong() {
		return 0L;
	}
	
	public static long getDefaultLong(final Long value) {
		return ObjectHelper.getDefault(value, getDefaultLong());
	}
}
