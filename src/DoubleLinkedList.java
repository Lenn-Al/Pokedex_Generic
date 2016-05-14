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
	* Die Länge der Liste
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
	* @param item das Pokemon
	*/
	@Override
	public void insert(T item) {
        Node prevNode = head;
        Node currentNode = head.next;
        Node m = new Node();
        m.item = item;
        //Durchlaufe die Liste solange, bis entweder das Ende der Liste oder ein Element groesser als das einzufuegende Element gefunden wird.
        //Fuege das neue Element dann vor diesem ein.
        while (currentNode != tail && currentNode.item.compareTo(item) <= 0) {
            prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        //Aendere die Zeiger der Knoten entsprechend, um das neue Element in die Liste zu integrieren.
        prevNode.next = m;
        currentNode.prev = m;
        m.prev = prevNode;
        m.next = currentNode;
        n++;
	}

	/**
	* Loescht ein Pokemon aus der Liste
	*/
	@Override
	public void delete(T item) {
        Node prevNode = head;
        Node currentNode = head.next;
        //Durchlaufe die Liste solange, bis entweder das Ende der Liste erreicht wird, oder bis das gesuchte Element gefunden wird
        //Loesche dieses Element dann.
        while (currentNode != tail && currentNode.item.compareTo(item) != 0) {
            prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        currentNode.next.prev = prevNode;
        prevNode.next = currentNode.next;
        n--;
	}

    /**
     * Löscht das erste Element der Liste
     * @return Das Item des Gelöschten Elements
     */
    public T delete() {
        Node currentNode = head.next;
        delete(currentNode.item);
        return currentNode.item;
    }
	
	/**
	* Gibt die Liste als Stirng zurueck
	* @return Die Liste als String
	*/
	public String toString() {
        Node currNode = head.next;
        String listString = "";
        while (currNode != tail) {
            listString += currNode.item.toString() + "\n";
            currNode = currNode.next;
        }
        return listString;
	}

    /**
    * is Element in the list?
    * @param x element whose presence in this list is to be tested
    * @return is Element in the list?
    */
    @Override
    public boolean isInList(T x) {
        Node curr = head.next;
        //Durchlaufe die Liste, bis das Ende erreicht ist
        while (curr != tail) {
            //Falls gesuchtes Element gefunden, gebe sofort wahr zurueck
            if (curr.item.compareTo(x) == 0) {
                return true;
            }
        curr = curr.next;
        }
        return false;
    }

    /**
     * Get the element with index "index"
     * @param index - index of the element to return
     * @return The Element with index "index"
     */
    public T get(int index) {
        Node currNode = head.next;
        int i = 1;
        //Exepton bei ungueltigem Index
        if(index > n || index < 1) {
            throw new IllegalArgumentException();
        }
        //Durchlaufe die Liste, bis Element mit Nummer "Index" erreicht ist. 
        while(i < index) {
            currNode = currNode.next;
            i++;
        }
        return currNode.item;
    }

    /**
     * Haenge die Liste "list" an die Liste an
     *
     * @param list Anzuhaengende Liste
     *     
     */
    public void addAll(List<T> list) {
        Node currNode;

        while(!list.isEmpty()) {
            currNode = new Node(); //Reset currNode
            currNode.item = list.delete();
            
            //Fuege neues Element hinten in die Liste ein
            currNode.next = tail;
            currNode.prev = tail.prev;
            tail.prev.next = currNode;
            tail.prev = currNode;

            n++;
            }
        }
    
    /**
     * Filtert die Liste nach dem uebergebenen Predikat
     *
     * @param predcate Das Predikat, nach dem gefiltert werden soll
     */
    public List<T> filter(Predicate<T> predicate) {
        DoubleLinkedList<T> filteredList = new DoubleLinkedList<>(); //DoubleLinkedList<T> filteredList = new DoubleLinkedList();
        
        Node currNode = head.next;
        
        while(currNode != tail) {
            if(predicate.test(currNode.item)) {
                filteredList.insert(currNode.item);
            }
            currNode = currNode.next;
        }
        return filteredList;
    }
        
}
