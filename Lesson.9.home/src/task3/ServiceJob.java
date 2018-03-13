package task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceJob {

	private final static String allStr = new String("ABCDEFGHIKLMNOPQRSTVXYZabcdefghiklmnopqrstvxyz");
	private final static char[] chArr = allStr.toCharArray();

	public static void runJob(String fileName) throws FileNotFoundException {

		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("File : <" + fileName + "> not found.");
		}

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);

			if (buffer.length == 0) {
				throw new IllegalArgumentException("File : <" + fileName + "> is empty.");
			}

			List<ArrayManager> list = new ArrayList<ArrayManager>();

			for (byte a : buffer) {
				if (symbolIsEnglish((char) a)) {
					checkOneByte((char) a, list);
				}
			}

			printList(list, "List before sorted.");
			sortList(list);
			printList(list, "List after sorted.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean symbolIsEnglish(char c) {
		for (char a : chArr) {
			if (c == a) {
				return true;
			}
		}
		return false;
	}

	private static void checkOneByte(char a, List<ArrayManager> list) {
		for (ArrayManager array : list) {
			if (a == array.getSymbol()) {
				array.setCount(array.getCount() + 1);
				return;
			}
		}
		list.add(new ArrayManager(a, 1));
	}

	private static void printList(List<ArrayManager> list, String message) {
		System.out.println(message);
		int size = list.size();
		System.out.println("Count elements : " + size);
		int i = 1;
		for (ArrayManager array : list) {
			System.out.println("(" + i + " / " + size + ") char = " + array.getSymbol() + ", count = " + array.getCount());
			i++;
		}
	}

	private static void sortList(List<ArrayManager> list) {
		Collections.sort(list, new SortedByCount());
	}
}

