package mid.lang.immutable.test;

public class ImmutableMyDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //불변객체 새롭게 반환
    public ImmutableMyDate withYear(int newYear) {
        return new ImmutableMyDate(newYear,this.month,this.day);
    }
    public ImmutableMyDate setMonth(int newMonth) {
        return new ImmutableMyDate(this.year,newMonth,this.day);
    }
    public ImmutableMyDate setDay(int newDay) {
        return new ImmutableMyDate(this.year,this.month,newDay);
    }

    @Override
    public String toString() {
        return "ImmutableMyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
