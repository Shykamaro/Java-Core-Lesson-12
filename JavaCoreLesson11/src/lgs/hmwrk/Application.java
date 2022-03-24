package lgs.hmwrk;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println();
		System.out.println("Введите 1, чтобы проверить существует ли введенный месяц");
		System.out.println("Введите 2, чтобы вывести все месяцы с такой же порой года");
		System.out.println("Введите 3, чтобы вывести все месяцы с таким же количеством дней");
		System.out.println("Введите 4, чтобы вывести все месяцы с меньшим количеством дней");
		System.out.println("Введите 5, чтобы вывести все месяцы с большим количеством дней");
		System.out.println("Введите 6, чтобы вывести следующую пору года");
		System.out.println("Введите 7, чтобы вывести предыдущую пору года");
		System.out.println("Введите 8, чтобы вывести все месяцы с четным количеством дней");
		System.out.println("Введите 9, чтобы вывести все месяцы с нечетным количеством дней");
		System.out.println("Введите 0, чтобы проверить четное ли количество дней в введенном месяце");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ArrayList<Months> arrayListMonths = new ArrayList<Months>();
		for (Months monthValue : Months.values()) {
			arrayListMonths.add(monthValue);
		}

		ArrayList<Seasons> arrayListSeasons = new ArrayList<Seasons>();
		for (Seasons seasonValue : Seasons.values()) {
			arrayListSeasons.add(seasonValue);
		}

		while (true) {
			menu();

			switch (scanner.nextInt()) {

			case 1: {
				System.out.println("=== Программа проверки существования введенного месяца ===");
				System.out.println("Введите месяц:");
				String month1 = scanner.next();

				boolean flag = isMonthExists(arrayListMonths, month1);

				if (flag == true) {
					System.out.println("Введенный месяц существует!");
				} else
					System.out.println("Такого месяца нет!");

				break;
			}

			case 2: {
				System.out.println("=== Программа вывода всех месяцев с введенной порой года ===");
				System.out.println("Введите пору года:");
				String season2 = scanner.next();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getSeasons().name().equalsIgnoreCase(season2)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Пора года " + season2 + " в следующих месяцах:");

					for (Months months2 : arrayListMonths) {
						if (months2.getSeasons().toString().equalsIgnoreCase(season2)) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Таких месяцев нет!");

				break;
			}

			case 3: {
				System.out.println("=== Программа вывода всех месяцев с введенным количеством дней ===");
				System.out.println("Введите количество дней:");
				int numberOfDays3 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays3) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней " + numberOfDays3 + " в следующих месяцах:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() == numberOfDays3) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Таких месяцев нет!");

				break;
			}

			case 4: {
				System.out.println("=== Программа вывода всех месяцев с количеством дней меньше введенного ===");
				System.out.println("Введите количество дней:");
				int numberOfDays4 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays4 && numberOfDays4 >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней меньше " + numberOfDays4 + " в следующих месяцах:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() < numberOfDays4) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Таких месяцев нет!");

				break;
			}

			case 5: {
				System.out.println("=== Программа вывода всех месяцев с количеством дней больше введенного ===");
				System.out.println("Введите количество дней:");
				int numberOfDays5 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays5 && numberOfDays5 <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Количество дней больше " + numberOfDays5 + " в следующих месяцах:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() > numberOfDays5) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Таких месяцев нет!");

				break;
			}

			case 6: {
				System.out.println("=== Программа вывода следующей поры года ===");
				System.out.println("Введите пору года:");
				String season6 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arrayListSeasons) {
					if (seasons.name().equalsIgnoreCase(season6)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Следующая пора года:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season6.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == (arrayListSeasons.size() - 1)) {
						i = 0;
						System.out.println(arrayListSeasons.get(i));
					} else {
						System.out.println(arrayListSeasons.get(i + 1));
					}
				}

				if (flag == false)
					System.out.println("Такой поры года нет!");

				break;
			}

			case 7: {
				System.out.println("=== Программа вывода предыдущей поры года ===");
				System.out.println("Введите пору года:");
				String season7 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arrayListSeasons) {
					if (seasons.name().equalsIgnoreCase(season7)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Предыдущая пора года:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season7.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == 0) {
						i = (arrayListSeasons.size() - 1);
						System.out.println(arrayListSeasons.get(i));
					} else {
						System.out.println(arrayListSeasons.get(i - 1));
					}
				}

				if (flag == false)
					System.out.println("Такой поры года нет!");

				break;
			}

			case 8: {
				System.out.println("=== Программа вывода месяцев с четным количеством дней ===");

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() % 2 == 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 9: {
				System.out.println("=== Программа вывода месяцев с нечетным количеством дней ===");

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() % 2 != 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 0: {
				System.out.println("=== Программа проверки четности количества дней в введенном месяце ===");
				System.out.println("Введите месяц:");
				String month0 = scanner.next();

				boolean flag = isMonthExists(arrayListMonths, month0);

				if (flag == true) {
					Months month = Months.valueOf(firstUpperCase(month0.toLowerCase()));

					if (month.getNumberOfDays() % 2 == 0) {
						System.out.println("Количество дней в месяце " + month0 + " - " + month.getNumberOfDays()
								+ ". Это число - четное");
					} else {
						System.out.println("Количество дней в месяце " + month0 + " - " + month.getNumberOfDays()
								+ ". Это число - нечетное");
					}
				}

				if (flag == false)
					System.out.println("Такого месяца нет!");

				break;
			}

			default: {
				System.out.println("Введите число от 0 до 9!");

				break;
			}

			}
		}
	}

		
	

	static boolean isMonthExists(ArrayList <Months> arrayListMonths, String month) {
		boolean flag = false;

		for (Months months : arrayListMonths) {
			if (months.name().equalsIgnoreCase(month)) {
				flag = true;
			}
		}

		return flag;
	}

	static String firstUpperCase(String string) {
		if (string == null || string.isEmpty()) {
			return string;
		} else {
			return string.substring(0, 1).toUpperCase() + string.substring(1);
		}
	}

}	