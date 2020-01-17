package by.training.calendar.bean;

import java.io.Serializable;
import java.util.Arrays;

public class MyCalendar implements Serializable {

    final private String[] constantHolidays = {"01/01", "07/01",
            "08/03", "01/05", "09/05", "03/07", "07/11", "25/12"};

    private int numOfYear;

    public MyCalendar() {
    }

    public MyCalendar(int numOfYear) {
        this.numOfYear = numOfYear;
    }

    public String[] getConstantHolidays() {
        return constantHolidays;
    }

    public int getNumOfYear() {
        return numOfYear;
    }

    public void setNumOfYear(int numOfYear) {
        this.numOfYear = numOfYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyCalendar)) return false;

        MyCalendar that = (MyCalendar) o;

        if (getNumOfYear() != that.getNumOfYear()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getConstantHolidays(), that.getConstantHolidays());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getConstantHolidays());
        result = 31 * result + getNumOfYear();
        return result;
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "constantHolidays=" + Arrays.toString(constantHolidays) +
                ", numOfYear=" + numOfYear +
                '}';
    }

    public class TransientHolidays {

        public TransientHolidays(int numOfYear) {
            MyCalendar.this.numOfYear = numOfYear;
        }

        public TransientHolidays() {
        }

    }
}