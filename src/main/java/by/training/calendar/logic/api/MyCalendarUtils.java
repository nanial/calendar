package by.training.calendar.logic.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;


public interface MyCalendarUtils {

    ArrayList<Date> constHolAsDate();
    SortedSet<Date> allHoliday();
    ArrayList<String> allHolToString();

    int dayOfYear();
    ArrayList<Date> getWeekEnds();
    Date ortodoxPasqua();
    Date dayOfMemory();
}
