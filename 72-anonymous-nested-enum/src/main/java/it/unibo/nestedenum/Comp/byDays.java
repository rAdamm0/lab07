package it.unibo.nestedenum.Comp;

import java.util.Comparator;

import it.unibo.nestedenum.MonthSorterNested.Month;

public class byDays implements Comparator<String>{

    @Override
    public int compare(String arg0, String arg1) {
        Month enum0 = Month.fromString(arg0);
        Month enum1 = Month.fromString(arg1);
        if(enum0.dayNumb == enum1.dayNumb){
            return 0;
        }else if (enum0.dayNumb < enum1.dayNumb){
            return -1;
        }
        return 1;
    }

}
