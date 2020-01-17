package by.training.calendar.logic.api;

import by.training.calendar.exception.CalendarException;

import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;


public interface MyCalendarUtils {

    ArrayList<Date> constHolAsDate() throws CalendarException;
    SortedSet<Date> allHoliday() throws CalendarException;
    ArrayList<String> allHolToString() throws CalendarException;

    int dayOfYear();
    ArrayList<Date> getWeekEnds();
    Date ortodoxPasqua();
    Date dayOfMemory();
    Date newHoliday(int month, int day);
}
