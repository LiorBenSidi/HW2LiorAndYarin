public class DateTime extends Date {
    private int hour, minute;

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

    public void setMonth(int month) {
        super.setMonth(month);
    }

    public void setHour(int hour) {
        if(!(hour < 0 || hour > 23)){
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if(!(minute < 0 || minute > 59)){
            this.minute = minute;
        }
    }

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

    @Override
    public int hashCode() { //The use of multiplication and addition operations to combine the hash codes,
                           // for producing a distribution of hash values.
        return super.hashCode() + 23 * (hour +1) + 59 * (minute + 1);
    }

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
