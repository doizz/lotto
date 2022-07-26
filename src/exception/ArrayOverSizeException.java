package exception;

import java.sql.Array;

public class ArrayOverSizeException extends ArrayIndexOutOfBoundsException {
    public ArrayOverSizeException(String message){
        super(message);
    }
}
