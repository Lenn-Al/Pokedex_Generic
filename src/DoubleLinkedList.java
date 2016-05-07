package pokedex_generic_nb;

import java.util.function.Predicate;

/**
*
* Doppelt verkettete Liste
*
* @author Lennart Almstedt 4633202 Group 11d
* @author Maximilian von Unwerth 4568393 Group 11d
* @author Joshua Heinemann 4701655 Group 11d
*/
public class DoubleLinkedList<T extends Comparable<T>> implements List<T> {
	//Speichert die aktuelle Laenge der Liste.
    private int n  = 0;
	//Speichert das Kopfobjekt.
    private Node head;
	//Speichert das Schwanzobjekt.
    private Node tail;
    /**
	* Die Node-Klasse welche alle
	* wichtigen Variablen beinhaltet.
	* wie Item,prev,next
	*/
    private class Node {
        private T item;
        private Node prev;
        private Node next;
    }
	
	/**
	* Standartkonstruktor der DoubleLinkedList
	*/
	public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
	}
	
	/**
	* Die Liste ist leer, wenn das erste Element das letzte ist.
	*/
	@Override
	public boolean isEmpty() {
            return n == 0;
	}

	/**
	* 
	*/
	@Override
	public int length() {
            return n;
	}

	/**
	* Gibt den Kopf der Liste zurueck
	* @return Das erste Pokemon 
	*/
	@Override
	public T firstItem() {
            return head.next.item; //Kopf der Liste ist das erste Pokemon
	}

	/**
	* Fuegt ein Pokemon sortiert in die Liste ein
	* @param Einzufuegendes Pokemon
	*/
	@Override
	public void insert(T item) {
        Node x = head;
        Node y = head.next;
        Node m = new Node();
        m.item = item;
        while (y != tail && y.item.compareTo(item) <= 0) {
            x = x.next;
            y = y.next;
        }
        x.next = m;
        y.prev = m;
        m.prev = x;
        m.next = y;
        n++;
	}

	/**
	* Loescht ein Pokemon aus der Liste
	*/
	@Override
	public void delete(T item) {
        Node x = head;
        Node y = head.next;
       
        while (y != tail && y.item.compareTo(item) != 0) {
            x = x.next;
            y = y.next;
        }
        y.next.prev = x;
        x.next = y.next;
        n--;
	}
        
        public T delete() {
            Node x = head.next;
            
            delete(x.item);
            return x.item;
        }
	
	/**
	* Gibt die Liste als Stirng zurueck
	* @return Die Liste als String
	*/
	public String toString() {
        Node x = head.next;
        String s = "";
          
        while (x != tail) {
            s += x.item.toString() + "\n";
            x = x.next;
        }
            
        return s;
	}
        
        @Override
        public boolean isInList(T x) {
            Node curr = head.next;
            
            while(curr != tail) {
                if(curr.item.compareTo(x) == 0) {
                    return true;
                }
                
                curr = curr.next;                curr = curr.next;

            }
            
            return false;
        }
        
        public T get(int index) {
            Node x = head.next;
            int i = 1;
            
            if(index < n) {
                throw new IllegalArgumentException();
            }
            
            while(i < index) {
                x = x.next;
                i++;
            }
            return x.item;
        }
        
        public void addAll(List<T> list) {
            Node x = new Node();
            while(!list.isEmpty()) {
                x.item = list.delete();
                
                //Fuege neues Element hinten in die Liste ein
                x.prev = tail.prev;
                x.next = tail;
                tail.prev.next = x;
                tail.prev = x;
            }
        }
        
        public List<T> filter(Predicate<T> predicate) {
            DoubleLinkedList<T> dl = new DoubleLinkedList();
            
            Node x = head.next;
            
            while(x != tail) {
                if(predicate.test(x.item)) {
                    dl.insert(x.item);
                }
            }
            
            return dl;
        }
        
}
