package it.unibo.nestedenum.Comp;

import java.util.Comparator;

import it.unibo.nestedenum.MonthSorterNested.Month;

public class byOrder implements Comparator<String>{

    @Override
    public int compare(String arg0, String arg1) {
        Month enum0 = Month.fromString(arg0);
        Month enum1 = Month.fromString(arg1);
        return enum0.compareTo(enum1);
    }

}
