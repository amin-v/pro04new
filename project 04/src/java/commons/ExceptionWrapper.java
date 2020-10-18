package commons;

import commons.exceptions.BusinessException;

public class ExceptionWrapper {
    public static String getMessage(Exception e) {
        e.printStackTrace();
        if(e instanceof BusinessException){
            return e.getMessage();
        }

        else {
            return "there is some problem , please contact us";
        }
    }
}
