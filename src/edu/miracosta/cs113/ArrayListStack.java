package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack<E> implements StackInterface<E> {

	// Data fields
	public List<E> myList;

	// Constructor

	public ArrayListStack() {
		myList = new ArrayList<E>();
	}

	@Override
	public E push(E obj) {
		myList.add(obj);
		return obj;
	}

	@Override
	public boolean empty() {

		return myList.isEmpty();
	}

	@Override
	public E peek() {

		if (empty()) {
			throw new EmptyStackException();
		}
		return myList.get(myList.size() - 1);
	}

	@Override
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return myList.remove(myList.size() - 1);
	}

}