package task3;

import java.util.Comparator;

public class SortedByCount implements Comparator<ArrayManager>{

	@Override
	public int compare(ArrayManager o1, ArrayManager o2) {
		return (int) (o2.getCount() - o1.getCount());
	}

}
