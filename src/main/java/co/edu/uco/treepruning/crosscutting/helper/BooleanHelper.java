package co.edu.uco.treepruning.crosscutting.helper;

public class BooleanHelper {
    private BooleanHelper() {
    }
    
    public static boolean getDefault() {
        return false;
    }
    
    public static boolean getDefault(final Boolean value) {
        return ObjectHelper.getDefault(value, getDefault());
    }   
}
