public class Date {
    protected int day;
    protected int month;
    protected int year; // A number between -9999 to 9999

    public Date(int day, int month, int year) {
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
        // instance of
        if(!(this.hashCode() == other.hashCode())) {
            return false;
        }
        Date otherDate = (Date) other;
        return this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year;
    }
    @Override
    public int hashCode() {
        return 31 * day + 12 * month + 9999 * year;
    }
    @Override
    public String toString() {
        // להוסיף 0 לפני מס' דו-ספרתי
        int DD = this.day;
        int MM = this.month;
        int YYYY = this.year;
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
        return DD + "/" + MM + "/" + YYYY ;
    }
}
