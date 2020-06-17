package utilities;

import java.lang.reflect.Type;

/**
 * Created by itzhak on 15-Mar-19.
 * Validate utils used to validate input across the program
 */
public class ValidationUtils {
    private ValidationUtils(){} // Can not create an instance of a util class

    public static void assertNotNull(Object o){
        if(o == null){
            throw new IllegalArgumentException("Argument can not be null");
        }
    }

    public static void assertNotNegative(double n){
        if(n < 0){
            throw new IllegalArgumentException("Argument can not be negative argument = " + n);
        }
    }


    public static void assertPositive(double n){
        if(n <= 0){
            throw new IllegalArgumentException("Argument can not be negative or zero argument = " + n);
        }
    }

    public static void assertInRange(double n, double start, double end){
        if(n > end || n < start){
            throw new IllegalArgumentException("Argument must be in range ["+ start + "," + end + "] argument=" + n);
        }
    }

    public static void assertNotNullOrEmptyString(String text){
        if(text == null || text.trim().equals("")){
            throw new IllegalArgumentException("String can not be null or empty");
        }
    }

}
