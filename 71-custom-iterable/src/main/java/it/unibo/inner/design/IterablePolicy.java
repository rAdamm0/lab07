package it.unibo.inner.design;

import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePolicy<T> implements IterableWithPolicy<T> {

    private ArrayList<T> n = new ArrayList<>();

    public IterablePolicy(T[] elem, Predicate<T> pred){
        for(T k : elem){
            if(pred.test(k)){
                this.n.add(k);
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
            if (length>= n.size()) {
                return false;
            }
            return true;
           }

        public T next() {
            return n.get(this.length++);
        }

    }
    
    @Override
    public Iterator<T> iterator() {
        PolicyIter n = new PolicyIter();
        return n;
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    
}

