import java.io.Serializable;

import javax.management.ObjectName;

public class Date implements Serializable {
private int day;
private int month;
private int year;

public Date(int d,int m,int y){
    this.day = d;
    this.month = m;
    this.year = y;
}
public int getDay(){return day;}
public int getMonth(){return month;}
public int getYear(){return year;}
public String toString(){
    return day+"-"+month+"-"+year;
}
}