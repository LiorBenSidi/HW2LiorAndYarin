/**
 * A class representing a date and time with day, month, year, hour, and minute attributes.
 * Inherits from the Date class.
 */
public class DateTime extends Date {
    private int hour, minute;

    /**
     * Constructs a DateTime object with the specified year, month, day, hour, and minute.
     * If the provided values are invalid, default values are used (1/1/0 00:00).
     *
     * @param year The year attribute of the date and time
     * @param month The month attribute of the date and time
     * @param day The day attribute of the date and time
     * @param hour The hour attribute of the date and time
     * @param minute The minute attribute of the date and time
     */
    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if(hour < 0 || hour > 23){
            this.hour = 0;
        }else{
            this.hour = hour;
        }
        if(minute < 0 || minute > 59){
            this.minute = 0;
        }else{
            this.minute = minute;
        }
    }

    /**
     * Sets the month attribute of the date and time to the specified value,
     * if it is a valid month value (between 1 and 12).
     *
     * @param month The given month value
     */
    public void setMonth(int month) {
        super.setMonth(month);
    }

    /**
     * Sets the hour attribute of the date and time to the specified value,
     * if it is a valid hour value (between 0 and 23).
     *
     * @param hour The given hour value
     */
    public void setHour(int hour) {
        if(!(hour < 0 || hour > 23)){
            this.hour = hour;
        }
    }

    /**
     * Sets the minute attribute of the date and time to the specified value,
     * if it is a valid minute value (between 0 and 59).
     *
     * @param minute The given minute value
     */
    public void setMinute(int minute) {
        if(!(minute < 0 || minute > 59)){
            this.minute = minute;
        }
    }

    /**
     * Checks if the current date and time is equal(according the terms) to the object provided.
     * Two DateTime objects are considered equal if all fields are equal(their date, hour, and minute fields).
     *
     * @param other The object we compare to
     * @return 'true' if the dates are equal, else - 'false'
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(!(this.hashCode() == other.hashCode()) || !(other instanceof DateTime)) {
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        return super.equals(otherDateTime) && hour == otherDateTime.hour && minute == otherDateTime.minute;
    }

    /**
     * Generates a hash code for the current DateTime object.
     * The hash code is calculated using the hash code of the superclass and the hour and minute attributes.
     * We use multiplication and addition operations to combine the hash codes,
     * for producing a distribution of hash values.
     *
     * @return The hash code value
     */

    @Override
    public int hashCode() {
        return -(super.hashCode() + 23 * (hour +1) + 59 * (minute + 1));
    }

    /**
     * Returns a string representation of the date and time in the required format "DD/MM/YYYY HH:MM".
     *
     * @return The string representation of the date and time
     */
    @Override
    public String toString() {
        int hh = this.hour;
        int mm = this.minute;
        String strHh;
        String strMm;
        if(hh < 10) {
            strHh = "0" + hh;
        } else {
            strHh = String.valueOf(hh);
        }
        if(mm < 10) {
            strMm = "0" + mm;
        } else {
            strMm = String.valueOf(mm);
        }

        return super.toString() + " " + strHh + ":" + strMm;
    }
}
