package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack<E> implements StackInterface<E> {

	// Data fields
	public List<E> myList;
	

	// Constructor

	public ArrayListStack() {
		myList = new ArrayList<E>();
	}

	public E push(E obj) {
		myList.add(obj);
		return obj;
	}

	public boolean empty() {
		return myList.isEmpty();
	}

	public E peek() {

		if (empty()) {
			throw new EmptyStackException();
		}
		return myList.get(myList.size() - 1);
	}

	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return myList.remove(myList.size() - 1);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || o.getClass() != this.getClass())
			return false;

		ArrayListStack<E> other = (ArrayListStack<E>) o;
		
		return myList.equals(other.myList);
	}

}