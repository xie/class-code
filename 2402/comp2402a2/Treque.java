package comp2402a2;

import java.util.AbstractList;
import java.util.List;

/**
 */
public class Treque<T> extends AbstractList<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	ArrayDeque<T> left;
	ArrayDeque<T> right;

	public Treque(Class<T> t) {
		left = new ArrayDeque<T>(t);
		right = new ArrayDeque<T>(t);
	}

	public T get(int i) {

		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();

		if (i < left.size()) {
			return left.get(i);
		} else {
			return right.get(i - left.size());
		}
		// Put your own code here instead of throwing this exception
	}

	public T set(int i, T x) {

		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();

		if (i < left.size()) {
			return left.set(i, x);
		} else {
			return right.set(i - left.size(), x);
		}

	}

	public void add(int i, T x) {

		if (i < 0 || i > size()) throw new IndexOutOfBoundsException();


		if (i < left.size()) {
			left.add(i, x);
		} else {
			right.add(i - left.size(), x);
		}
		rebuild();

	}

	public T remove(int i) {

		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();

		T val;

		if (i < left.size()) {
			val = left.remove(i);
		} else {
			val = right.remove(i - left.size());
		}
		rebuild();
		return val;
	}

	public int size() {
		return (left.size() + right.size());
	}

	public void rebuild() {
		if ((left.size() - right.size()) > 1) {
			right.add(0, left.remove(left.size()-1));
		} else if ((right.size() - left.size()) > 1) {
			left.add(left.size(), right.remove(0));
		}
	}

	public static void main(String[] args) {
		//List<Integer> tr = new ArrayDeque<Integer>(Integer.class);
		List<Integer> tr = new Treque<Integer>(Integer.class);



		int K = 1000000;
		Stopwatch s = new Stopwatch();
		System.out.print("Appending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Prepending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(0, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Midpending(?!) " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(tr.size()/2, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");


		System.out.print("Removing " + K + " items from the back...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(tr.size()-1);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the front...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the middle...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(tr.size()/2);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
	}



}
