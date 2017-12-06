package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part8 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		Map<String, Integer> a = new HashMap<>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
		 	Integer count = a.get(line);
			if (count == null) {
				count = 1;
			} else {
				++count;
			}
			a.put(line,count);
		}

		List<String> list = new ArrayList<>(a.keySet());
		Collections.sort(list, new Comparator<String>() {
			public int compare(String one, String two) {
				if (a.get(one) > a.get(two)) {
					return -1;
				}	else if (a.get(one) == a.get(two)) {
					return one.compareTo(two);
				} else {
					return 1;
				}
			}
		});
		for (String x : list) {
			w.println(x);
		}
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
