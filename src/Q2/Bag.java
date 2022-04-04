/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Iterator;

/**
 *
 * @author Owner
 */
public interface Bag<E> {

    /**
     *
     * @param item
     * @return
     */
    public boolean add(E item);
    
    public E grab();
    public  boolean remove(E item);
    public int size();
    public int capacityRemaining();
    public boolean isFull();
    public boolean isEmpty();
    public void clear();
    public Iterator<E> iterator();
    public E[] toArray();
}
