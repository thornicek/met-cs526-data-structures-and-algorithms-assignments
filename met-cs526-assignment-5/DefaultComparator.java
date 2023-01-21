package tHornicek_hw5;

import java.util.Comparator;
// Default Comparator class, used for merge and quick sort
public class DefaultComparator<T extends Comparable<T>> implements Comparator<T> {
	public int compare(T a, T b) {
		return a.compareTo(b);
	}
}
