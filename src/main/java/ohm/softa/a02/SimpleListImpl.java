package ohm.softa.a02;


import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList,Iterable {

    static private class Element{
        Object item;
        Element next;

        public Element(Object item, Element next){
            this.item = item;
            this.next = next;
        }
    }

    Element head = null;


    class SimpleIteratorImpl implements Iterator{

        Element current;
        SimpleListImpl list;

        public SimpleIteratorImpl (SimpleListImpl list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            if(current == null)
                current = list.head;
            else{
                current = current.next;
            }
            return current != null;
        }

        @Override
        public Object next() {
            return current.item;
        }
    }

	// TODO: Implement the required methods.

    //SimpleList methods

    @Override
    public void add(Object o) {
        head = new Element(o, head);
    }

    @Override
    public int size() {
       int count = 0;
       Element current = head;

       while(current != null){
           count++;
           current = current.next;
       }

        return count;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl filtered = new SimpleListImpl();

        Element current = head;

        while(current != null){
            if(filter.include(current.item)){
                filtered.add(current.item);
            }

            current = current.next;
        }

        return filtered;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl(this);
    }





}
