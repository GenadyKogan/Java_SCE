import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueAsList implements Queue<Object> {
	private LinkedList<Object> lst;

	public QueueAsList() {
		lst = new LinkedList<Object>();
	}

	public boolean isEmpty() {
		return false;
		 // TODO
	}
	
	public Object dequeue() throws NoSuchElementException {
		return lst;
		 // TODO
	}

	public void enqueue(Object o) {
		 // TODO
	}

	@Override
	public boolean addAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}

	@Override
	public boolean add(Object arg0) {
		return false;
	}

	@Override
	public Object element() {
		return null;
	}

	@Override
	public boolean offer(Object arg0) {
		return false;
	}

	@Override
	public Object peek() {
		return null;
	}

	@Override
	public Object poll() {
		return null;
	}

	@Override
	public Object remove() {
		return null;
	}
}
