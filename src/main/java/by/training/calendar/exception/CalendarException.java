package by.training.calendar.exception;

import org.apache.log4j.Logger;

public class CalendarException extends Exception{

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CalendarException.class);

    public CalendarException() {
        super();
    }

    public CalendarException(String message) {
       logger.info(message);
    }

    public CalendarException(Exception e) {
        super(e);
    }

    public CalendarException(String message, Exception e) {
        super(message, e);
    }

}
