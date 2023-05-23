public class Date {
    protected short day;
    protected byte month;
    protected int year; // A number between -9999 to 9999

    public Date(short day, byte month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Date) || !(other.getClass() == Date.class)) {
            return false;
        }
        Date otherDate = (Date) other;
        return this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year;
    }
    @Override
    public String toString() {
        Short DD = this.day;
        byte MM = this.month;
        int YYYY = this.year;
        return DD + "/" + MM + "/" + YYYY ;
    }
}
