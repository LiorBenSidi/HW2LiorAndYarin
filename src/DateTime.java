public class DateTime extends Date {
    private short hour; // A number between 0 and 23
    private short minute; // A number between 0 and 59
    public DateTime(short day, byte month, int year, short hour, short minute) {
        super(day, month, year);
        this.hour = hour;
        this.minute = minute;
    }
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof DateTime) || !(other.getClass() == DateTime.class)) {
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        return this.day == otherDateTime.day && this.month == otherDateTime.month && this.year == otherDateTime.year
                && this.hour == otherDateTime.hour && this.minute == otherDateTime.minute;
    }
    @Override
    public String toString() {
        return super.toString() + " " + hh + ":" + mm;
    }
}
