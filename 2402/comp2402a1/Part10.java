package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayDeque;

public class Part10 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		List<Integer> leftA = new ArrayList<>();
		List<Integer> leftD = new ArrayList<>();
		List<Integer> rightA = new ArrayList<>();
		List<Integer> rightD = new ArrayList<>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			try {
				dq.add(Integer.parseInt(line));
			} catch (NumberFormatException e){

				}
			}

			if (dq.size()>0) {
				ArrayDeque<Integer> dq2 = dq.clone();

				int length = dq.size();
				Double minLength = Math.floor(Math.sqrt(dq.size()));

				System.out.println(dq);


				int la = dq.remove();
				leftA.add(la);
				int ld = la;
				leftD.add(ld);

				int ra = dq2.removeLast();
				rightA.add(ra);
				int rd = ra;
				rightD.add(rd);

				while(!dq.isEmpty()) {
					int temp = dq.remove();
					int temp2 = dq2.removeLast();
					if (temp > la) {
						leftA.add(temp);
						la = temp;
					}
					if (temp < ld) {
						leftD.add(temp);
						ld = temp;
					}
					if (temp2 > ra) {
						rightA.add(temp);
						ra = temp2;
					}
					if (temp2 < ld) {
						leftD.add(temp);
						ld = temp2;
					}
				}
				if (leftA.size() >= minLength) {
					for (Integer x : leftA) {
						w.println(x);
					}
				}
				if (leftD.size() >= minLength) {
					for (Integer x : leftD) {
						w.println(x);
					}
				}
				if (rightA.size() >= minLength) {
					for (Integer x : rightA) {
						w.println(x);
					}
				}
				if (rightD.size() >= minLength) {
					for (Integer x : rightD) {
						w.println(x);
					}
				}
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
