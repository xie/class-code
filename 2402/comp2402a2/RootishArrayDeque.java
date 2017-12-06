package comp2402a2;

import java.util.AbstractList;
import java.util.List;
//import java.util.ArrayList;
import java.util.Collections;

/**
 */
public class RootishArrayDeque<T> extends AbstractList<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	 protected RootishArrayStack<T> left;
	 protected RootishArrayStack<T> right;
	 Class<T> classT;

	public RootishArrayDeque(Class<T> t) {
		this.classT = t;
		left = new RootishArrayStack<T>(t);
		right = new RootishArrayStack<T>(t);
	}

	@Override
	public T get(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();

		T val;

		if (i < left.size()) {
			val = left.get(left.size() - i - 1);
		} else {
			val = right.get(i - left.size());
		}

		return val;
	}

	@Override
	public T set(int i, T x) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		T val;

		if (i < left.size()) {
			val = left.set(left.size() - i - 1, x);
		} else {
			val = right.set(i - left.size(), x);
		}

		return val;

	}

	@Override
	public void add(int i, T x) {
		if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
		// Put your own code here

		if (i < left.size()) {
			left.add(left.size() - i, x);
		} else {
			right.add(i - left.size(), x);
		}
		balance();
	}

	@Override
	public T remove(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		// Put your own code here

		T val;

		if (i < left.size()) {
			val = left.remove(left.size() - i - 1);
		} else {
			val = right.remove(i - left.size());
		}
		balance();
		return val;

	}

	@Override
	public int size() {
		return (left.size() + right.size());
	}

	public void balance() {

		if (3*left.size() < right.size() || 3*right.size() < left.size()) {
      int n = right.size() + left.size();
      int nf = n/2;
      RootishArrayStack<T> af = new RootishArrayStack<T>(classT);
      for (int i = 0; i < nf; i++) {
        af.add(i, get(i));
      }
      int nb = n - nf;
      RootishArrayStack<T> ab = new RootishArrayStack<T>(classT);
      for (int i = 0; i < nb; i++) {
        ab.add(i, get(nf+i));
      }
			Collections.reverse(af);
      left = af;
			right = ab;
			System.out.print("left: " +left);
			System.out.print(" right: " +right);
			System.out.println("");
    }
	}



	public static void main(String[] args) {
		//List<Integer> rad = new ArrayDeque<Integer>(Integer.class);
		List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);

		System.out.println(rad);

		for(int i = 0; i < 10; i++) {
			rad.add(0, i);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(rad);
			int val = rad.remove(10 - i -1);
			System.out.println("Should be: " + i + " returned: " + val);
			if (val != i) {
				System.out.println("failed");
				break;
			}
		}

		// int K = 20;
		//
		// Stopwatch s = new Stopwatch();
		// System.out.print("Appending " + K + " items...");
		// System.out.flush();
		// s.start();
		// for (int i = 0; i < K; i++) {
		// 	rad.add(i);
		// }
		// System.out.println(rad);
		// s.stop();
		// System.out.println("done (" + s.elapsedSeconds() + "s)");
		//
		// System.out.print("Prepending " + K + " items...");
		// System.out.flush();
		// s.start();
		// for (int i = 0; i < K; i++) {
		// 	rad.add(0, i);
		// }
		// s.stop();
		// System.out.println("done (" + s.elapsedSeconds() + "s)");
		//
		// System.out.print("Removing " + K + " items from the left...");
		// System.out.flush();
		// s.start();
		// for (int i = 0; i < K; i++) {
		// 	rad.remove(rad.size()-1);
		// }
		// s.stop();
		// System.out.println("done (" + s.elapsedSeconds() + "s)");
		//
		// System.out.print("Removing " + K + " items from the right...");
		// System.out.flush();
		// s.start();
		// for (int i = 0; i < K; i++) {
		// 	rad.remove(0);
		// }
		// s.stop();
		// System.out.println("done (" + s.elapsedSeconds() + "s)");
	}



}
