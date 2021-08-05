package edu.miracosta.cs113;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

	private int front;
	private int rear;

	private int size;
	private int capacity;

	private static final int DEFAULT_CAPACITY = 10;
	private E[] theData;

	public CircularArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity) {
		capacity = initialCapacity;
		theData = (E[]) new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;
	}

	public boolean add(E addition) {
		//need to do first the reallocate to check the size if you can add
		// inserts element, addition to the queue, if successful true else Exception
		// thrown
		if (size == capacity) {
			reallocate();
		}
		size++;
		// increase by 1
		rear = (rear + 1) % capacity;
		theData[rear] = addition;
		return true;
	}

	private void reallocate() {
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];

		System.arraycopy(theData, front, newData, 0, capacity - front);
		// copies from beginning of array to the end of the array, which is rear
		System.arraycopy(theData, 0, newData, capacity - front, rear);
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		theData = newData;
		// see Stack notes on GitHub
		// copies circular array from front to capacity minus the value of front because
		// front could be in the middle of
		// the array and sub front from capacity it finds the end of where front loops
	}

	@Override
	public boolean offer(E e) {
		return add(e);
		// Inserts the element into queue if possible, hint no exception here
	}

	@Override
	public E poll() {
		// retrieves & removes queue head || returns null for empty queue
		if (size == 0) {
			return null;
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}

	@Override
	// same as poll but doesn't remove the head from queue
	public E peek() {
		if (size == 0)
			return null;
		else
			return theData[front];
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iterator = Arrays.asList(theData).iterator();
		return iterator;
	}

	@Override
	public int size() {
		return size;
	}

	public E remove() {
		// gets the head and removes it from queue
		if (size == 0) {
			throw new NoSuchElementException();
		}

		E result = theData[front];

		front = (front + 1) % capacity;
		size--;
		return result;
	}

}