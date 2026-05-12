package co.edu.uco.treepruning.crosscuting.helper;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public class ObjectHelper {
	private ObjectHelper() {
		
	}
	
	public static <O> boolean isNull(O object) {
		return object == null;
	}
	
	public static <O> O getDefault (final O object,final O defaultValue) {
		
		return isNull (object) ? defaultValue : object;
	}
		
}
