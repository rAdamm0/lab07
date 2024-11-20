package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;

import it.unibo.nestedenum.Comp.byDays;
import it.unibo.nestedenum.Comp.byOrder;

import java.util.List;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Month{
        January(31),
        February(28),
        March(31),
        April(30),
        May(31),
        June(30),
        July(31),
        August(31),
        september(30),
        October(31),
        November(30),
        December(31);

        public final int dayNumb;
        

        Month(int i) {
            this.dayNumb = i;
        }
        
     
        public static Month fromString(String s){
            int i;
            List<Month> count = new ArrayList<>();
            for(Month temp : Month.values()){
                i = 0;
                char [] tm = temp.name().toCharArray();
                char [] k = s.toCharArray();
                for(; i < k.length && i < tm.length  && Character.toUpperCase(tm[i]) == Character.toUpperCase(k[i]); i++);
                if(i == k.length){
                    //return temp;
                    count.add(temp);
                }
            }
            if(count.isEmpty()){
                throw new IllegalArgumentException("No Month with such name exists");
            }else if (count.size()>1){
                throw new IllegalArgumentException("Ambiguous input");
            }
            return count.get(0);
        }
       
        
    }

    @Override
    public Comparator<String> sortByDays() {
        return new byDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new byOrder();
    }
}
