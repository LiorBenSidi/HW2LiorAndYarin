public class Date {
    protected short day;
    protected byte month;
    protected int year; // A number between -9999 to 9999

    public Date(short day, byte month, int year) {
        if(day<=0 || day>31){
            this.day = 1;
        }else{
            this.day = day;
        }
        if(month<=0 || month > 12){
            this.month = 1;
        }else{
            this.month = month;
        }
        if(year < -9999 || year > 9999){
            this.year = 0;
        }else{
            this.year = year;
        }
    }
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Date) /**|| !(other.getClass() == Date.class) we cant use getClass**/) {
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
