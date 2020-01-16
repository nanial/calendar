package by.training.calendar.runner;

//Создать класс Календарь с внутренним классом, с помощью объектов которого
// можно хранить информацию о выходных и праздничных днях.

import by.training.calendar.bean.MyCalendar;
import by.training.calendar.logic.api.MyCalendarUtils;
import by.training.calendar.logic.impl.MyCalendarUtilsImpl;


public class Main {

    public static void main(String[] args) {

        MyCalendarUtils myCalendar = new MyCalendarUtilsImpl(new MyCalendar(2026));
        System.out.println(myCalendar.allHolToString());
    }
}
