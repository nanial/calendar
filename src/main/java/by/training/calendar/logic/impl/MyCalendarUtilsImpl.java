package by.training.calendar.logic.impl;


import by.training.calendar.bean.MyCalendar;
import by.training.calendar.logic.api.MyCalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class MyCalendarUtilsImpl implements MyCalendarUtils {

    private MyCalendar myCalendar;
    private MyCalendar.TransientHolidays transientHolidays;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM");

    public MyCalendarUtilsImpl(MyCalendar myCalendar) {
        this.myCalendar = myCalendar;
    }

    public MyCalendar getMyCalendar() {
        return myCalendar;
    }

    public void setMyCalendar(MyCalendar myCalendar) {
        this.myCalendar = myCalendar;
    }

    public MyCalendar.TransientHolidays getTransientHolidays() {
        return transientHolidays;
    }

    public void setTransientHolidays(MyCalendar.TransientHolidays transientHolidays) {
        this.transientHolidays = transientHolidays;
    }

    public ArrayList<Date> constHolAsDate(){

        ArrayList<Date> constHol = new ArrayList<>();

        for (String s : myCalendar.getConstantHolidays()) {
            try {
                constHol.add(format.parse(s));
            }
            catch (ParseException pe){
                System.out.println(pe.getMessage());
            }

        }
        return constHol;
    }
    public SortedSet<Date> allHoliday(){

        SortedSet<Date> holidays = new TreeSet<>();

        holidays.addAll(this.constHolAsDate());
        holidays.addAll(this.getWeekEnds());
        holidays.add(this.dayOfMemory());

        return holidays;
    }

    public ArrayList<String> allHolToString(){

        ArrayList<String> allHolToString = new ArrayList<>();

        for (Date d : this.allHoliday()) {

            allHolToString.add(format.format(d));
        }
        return allHolToString;
    }
    public int dayOfYear(){

        if(this.getMyCalendar().getNumOfYear() % 4 == 0){
            return 366;
        }
        else {
            return 365;
        }
    }

    public ArrayList<Date> getWeekEnds() {

        ArrayList<String> weekEnds = new ArrayList<>();
        ArrayList<Date>   weekEnd = new ArrayList<>();

        for (int i = 1; i < this.dayOfYear(); i++) {

            LocalDate date = LocalDate.ofYearDay(this.getMyCalendar().getNumOfYear(), i);

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekEnds.add(date.getDayOfMonth() + "/" + date.getMonthValue());
            }
        }
        for (String s : weekEnds) {
            try {
                weekEnd.add(this.format.parse(s));
            } catch (ParseException pe){
                System.out.println(pe.getMessage());
            }
        }
        return weekEnd;
    }

    public Date ortodoxPasqua() {

        this.getMyCalendar().getNumOfYear();
        Date easterDate = new Date();
        int a = this.getMyCalendar().getNumOfYear() % 4;
        int b = this.getMyCalendar().getNumOfYear() % 7;
        int c = this.getMyCalendar().getNumOfYear() % 19;
        int d = (19 * c + 15) % 30;
        int e = (2 * a + 4 * b - d + 34) % 7;
        int month = (d + e + 114) / 31 - 1;
        int day = ((d + e + 114) % 31) + 14;

        easterDate.setMonth(month);
        easterDate.setDate(day);
        return easterDate;
    }

    public Date dayOfMemory() {

        Date mem = new Date();
        Date easter = this.ortodoxPasqua();

        if (easter.getMonth() == 3 && (easter.getDate() + 9) > 30) {

            mem.setMonth(4);
            mem.setDate((easter.getDate() + 9) - 30);

        } else if ((easter.getDate() + 9) > 31) {
            mem.setMonth(easter.getMonth() + 1);
            mem.setDate((easter.getDate() + 9) - 31);
        }
        else {
            mem.setMonth(easter.getMonth());
            mem.setDate(easter.getDate() + 9);
        }
        mem.setYear(70);
        return mem;
    }
}
/*int a = (19 * (this.getMyCalendar().getNumOfYear() % 19) + 15) % 30;
        int b = ((2 * (this.getMyCalendar().getNumOfYear() % 4) + 4 *
                (this.getMyCalendar().getNumOfYear() % 7) + 6 * a + 6) % 7);

        if(a + b > 10)
            easterDate = new Date(this.getMyCalendar().getNumOfYear(), 3, a + b - 9);
        else
            easterDate = new Date(this.getMyCalendar().getNumOfYear(), 2, 22 + a + b);

        easterDate.setDate(easterDate.getDate() + 13);
        return easterDate;*/