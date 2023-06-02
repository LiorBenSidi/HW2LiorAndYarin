/**
 * A class representing a date and time with day, month, year, hour, and minute components.
 * Inherits from the Date class.
 */
public class DateTime extends Date {
    private int hour, minute;

    /**
     * Constructs a DateTime object with the specified year, month, day, hour, and minute.
     * If the provided values are invalid, default values are used (1/1/0 00:00).
     *
     * @param year the year component of the date and time
     * @param month the month component of the date and time
     * @param day the day component of the date and time
     * @param hour the hour component of the date and time
     * @param minute the minute component of the date and time
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
     * Sets the month component of the date and time to the specified value,
     * if it is a valid month value (between 1 and 12 inclusive).
     *
     * @param month the new month value
     */
    public void setMonth(int month) {
        super.setMonth(month);
    }

    /**
     * Sets the hour component of the date and time to the specified value,
     * if it is a valid hour value (between 0 and 23 inclusive).
     *
     * @param hour the new hour value
     */
    public void setHour(int hour) {
        if(!(hour < 0 || hour > 23)){
            this.hour = hour;
        }
    }

    /**
     * Sets the minute component of the date and time to the specified value,
     * if it is a valid minute value (between 0 and 59 inclusive).
     *
     * @param minute the new minute value
     */
    public void setMinute(int minute) {
        if(!(minute < 0 || minute > 59)){
            this.minute = minute;
        }
    }

    /**
     * Checks if the current date and time is equal to the specified object.
     * Two DateTime objects are considered equal if their date, hour, and minute components are equal.
     *
     * @param other the object to compare
     * @return true if the date and time are equal, false otherwise
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
     * The hash code is calculated using the hash code of the superclass and the hour and minute components.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() { /* The use of multiplication and addition operations to combine the hash codes,
                           for producing a distribution of hash values. */
        return super.hashCode() + 23 * (hour +1) + 59 * (minute + 1);
    }

    /**
     * Returns a string representation of the date and time in the format "DD/MM/YYYY HH:MM".
     *
     * @return the string representation of the date and time
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
