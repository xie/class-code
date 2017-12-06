package comp2402a2;

import java.util.*;

/**
 */
public class Table<T> implements AbstractTable<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	 protected ArrayList<ArrayList<T>> table;
	 protected int rows;
	 protected int cols;
	 Class<T> classT;

	public Table(Class<T> t) {
		this.classT = t;
		table = new ArrayList<ArrayList<T>>();
		rows = 0;
		cols = 0;
	}

	public int rows() {
		return rows;
	}

	public int cols() {
		// Put your own code here instead of throwing this exception
		return cols;
	}

	public T get(int i, int j) {
		T val;
		val = table.get(i).get(j);
		return val;
	}

	public T set(int i, int j, T x) {

		T val;

		val = table.get(i).set(j, x);

		return val;
	}

	public void addRow(int i) {
		if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
		rows += 1;
		ArrayList<T> row = new ArrayList<T>();
		for (int x = 0; x < cols; x++) {
			row.add(x, null);
		}
		table.add(i, row);
	}

	public void removeRow(int i) {
		if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();
		rows -= 1;
		table.remove(i);
	}

	public void addCol(int j) {
		if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
		cols += 1;
		for (int i = 0; i < rows; i++) {
			table.get(i).add(j, null);
		}
	}

	public void removeCol(int j) {
		if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
		cols -= 1;
		for (int x = 0; x < rows; x++) {
			table.get(x).remove(j);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows(); i++) {
			for (int j = 0; j < cols(); j++) {
				sb.append(String.valueOf(get(i, j)));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/* Here is the expected output from this main function:
		1111 null null null null null
		null 2222 null null null null
		null null 3333 null null null
		null null null 4444 null null
		null null null null 5555 null
		null null null null null 6666
		7777 null null null null null
		null 8888 null null null null
		null null 9999 null null null

		1111 null null null null null null
		null 2222 null null null null null
		null null null 3333 null null null
		null null null null null null null
		null null null null 4444 null null
		null null null null null 5555 null
		null null null null null null 6666
		7777 null null null null null null
		null 8888 null null null null null
		null null null 9999 null null null
	*/
	public static void main(String[] args) {
		int nrows = 9, ncols = 6;
		Table<Integer> t = new Table<Integer>(Integer.class);
		for (int i = 0; i < ncols; i++) {
			t.addCol(t.cols());
		}
		for (int i = 0; i < nrows; i++) {
			t.addRow(t.rows());
		}
		for (int i = 1; i <= nrows; i++) {
			t.set(i-1, (i-1)%t.cols(), 1111*i);
		}
		System.out.println(t.toString());
		t.addCol(2);
		t.addRow(3);
		System.out.println(t.toString());
	}
}
