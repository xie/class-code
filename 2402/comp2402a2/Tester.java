package comp2402a2;
import java.util.List;


public class Tester {

	//global number of values to test
	protected static int testCount = 100000;

	public static boolean testPart1(List<Integer> ell) {

		Stopwatch s = new Stopwatch();

		//add to end
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.add(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//add to front
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.add(0, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//set values
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.set(i, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//get values
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.get(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//remove from back
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//remove from front
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.remove(0);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}
		return true;
	}

	public static boolean testPart2(List<Integer> ell) {

		Stopwatch s = new Stopwatch();

		//add to end
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.add(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//add to front
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.add(0, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//set values
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.set(i, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//get values
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.get(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//remove from back
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}

		//remove from front
		s.start();
		for (int i = 0; i < testCount; i++) {
			ell.remove(0);
		}
		s.stop();
		if (s.elapsedSeconds() > 0.1) {
			return false;
		}


		return true;
	}

	public static boolean testPart3(AbstractTable<Integer> ell) {

		//skip spots in columns
		for (int r = 0; r < 100; r++) {
			ell.addRow(r);
			for (int c = 0; c < 100; c++) {
				ell.addCol(r);
			}
		}

		return true;


	}

}
