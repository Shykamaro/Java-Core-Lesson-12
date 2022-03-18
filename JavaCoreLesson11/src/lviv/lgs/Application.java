package lviv.lgs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Application {
	public static void main(String[] args) {

		Integer array[] = new Integer[getRandomValueFromRange(24, 69)];

		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomValueFromRange(-100, 100);
		}
		System.out.println("Розмір початкового масиву" + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Відсортовано на зростання"+ Arrays.toString(array));
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println("Відсортовано на спадання"+ Arrays.toString(array));

	}

	public static int getRandomValueFromRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Мінімальне значення повинне бути меньше");

		}

		Random r = new Random();

		return r.nextInt((max - min + 1) + min);
	}
}
