package it.unibo.inner.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePolicy<T> implements IterableWithPolicy<T> {

    private ArrayList<T> n = new ArrayList<>();
    private Predicate<T> p;
    private int count = 0;

    public IterablePolicy(T[] elem, Predicate<T> pred){
        this.p = pred;
        for(T k : elem){
            if(pred.test(k)){
                this.n.add(k);
                count++;
            }
        }
    }


    public IterablePolicy(T[] elem){
        this(elem, new Predicate<T>() {
            public boolean test(T elem) {
                return true;
            }
        });
    }

    private class PolicyIter implements Iterator<T>{

        private int length=0;

        public boolean hasNext() {
            if (this.length >= n.size()) {
                return false;
            }
            return true;
           }

        public T next() {
            while(this.hasNext()){
                if(p.test(n.get(this.length))){
                return n.get(this.length++);
                }
                this.length++;
            }
            return null;
        }

    }
    
    @Override
    public Iterator<T> iterator() {
        if(count != 0){
            return new PolicyIter();
        }
        return Collections.emptyListIterator();
    }

    private int checkCount(){
        int a = 0;
        for(T k : this.n){
            if(this.p.test(k)){
                a++;
            }
        }
        return a;
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.p = filter;
        count = checkCount();
    }

    
}


    

