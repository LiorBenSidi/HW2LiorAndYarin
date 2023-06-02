public class Date {
    protected int day, month, year;

    public Date(int year, int month, int day) {
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
        if(year < -3999 || year > 3999){
            this.year = 0;
        }else{
            this.year = year;
        }
    }

    public void setMonth(int month) {
        if(!(month<=0 || month > 12)){
            this.month = month;
        }
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(!(this.hashCode() == other.hashCode()) || !(other instanceof Date)) { // בעיה מבחינת אם איכשהו אותו מס' גיבוב
            return false;
        }
        Date otherDate = (Date) other;
        return (day == otherDate.day) && (month == otherDate.month) && (year == otherDate.year);
    }

    @Override
    public int hashCode() { //The use of multiplication and addition operations to combine the hash codes,
                           // for producing a distribution of hash values.
        return 31 * (day + 1) + 11 * (month + 1) + 3997 * (year + 1);
    }

    @Override
    public String toString() {
        int DD = this.day;
        int MM = this.month;
        int YYYY = this.year;
        String strDD, strMM, strYYYY;
        if(DD < 10) {
            strDD = "0" + DD;
        } else {
            strDD = String.valueOf(DD);
        }
        if(MM < 10) {
            strMM = "0" + MM;
        } else {
            strMM = String.valueOf(MM);
        }
        if(YYYY > -1) {
            if(YYYY < 10) {
                strYYYY = "000" + YYYY;
            } else if(YYYY < 100) {
                strYYYY = "00" + YYYY;
            } else if(YYYY < 1000) {
                strYYYY = "0" + YYYY;
            } else {
                strYYYY = String.valueOf(YYYY);
            }
        } else {
            YYYY *= (-1);
            if(YYYY < 10) {
                strYYYY = "-000" + YYYY;
            } else if(YYYY < 100) {
                strYYYY = "-00" + YYYY;
            } else if(YYYY < 1000) {
                strYYYY = "-0" + YYYY;
            } else {
                strYYYY = String.valueOf(YYYY);
            }
        }

        return strDD + "/" + strMM + "/" + strYYYY ;
    }
}
