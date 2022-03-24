package lgs.hmwrk;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println();
		System.out.println("������� 1, ����� ��������� ���������� �� ��������� �����");
		System.out.println("������� 2, ����� ������� ��� ������ � ����� �� ����� ����");
		System.out.println("������� 3, ����� ������� ��� ������ � ����� �� ����������� ����");
		System.out.println("������� 4, ����� ������� ��� ������ � ������� ����������� ����");
		System.out.println("������� 5, ����� ������� ��� ������ � ������� ����������� ����");
		System.out.println("������� 6, ����� ������� ��������� ���� ����");
		System.out.println("������� 7, ����� ������� ���������� ���� ����");
		System.out.println("������� 8, ����� ������� ��� ������ � ������ ����������� ����");
		System.out.println("������� 9, ����� ������� ��� ������ � �������� ����������� ����");
		System.out.println("������� 0, ����� ��������� ������ �� ���������� ���� � ��������� ������");
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
				System.out.println("=== ��������� �������� ������������� ���������� ������ ===");
				System.out.println("������� �����:");
				String month1 = scanner.next();

				boolean flag = isMonthExists(arrayListMonths, month1);

				if (flag == true) {
					System.out.println("��������� ����� ����������!");
				} else
					System.out.println("������ ������ ���!");

				break;
			}

			case 2: {
				System.out.println("=== ��������� ������ ���� ������� � ��������� ����� ���� ===");
				System.out.println("������� ���� ����:");
				String season2 = scanner.next();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getSeasons().name().equalsIgnoreCase(season2)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("���� ���� " + season2 + " � ��������� �������:");

					for (Months months2 : arrayListMonths) {
						if (months2.getSeasons().toString().equalsIgnoreCase(season2)) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("����� ������� ���!");

				break;
			}

			case 3: {
				System.out.println("=== ��������� ������ ���� ������� � ��������� ����������� ���� ===");
				System.out.println("������� ���������� ����:");
				int numberOfDays3 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays3) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("���������� ���� " + numberOfDays3 + " � ��������� �������:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() == numberOfDays3) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("����� ������� ���!");

				break;
			}

			case 4: {
				System.out.println("=== ��������� ������ ���� ������� � ����������� ���� ������ ���������� ===");
				System.out.println("������� ���������� ����:");
				int numberOfDays4 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays4 && numberOfDays4 >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("���������� ���� ������ " + numberOfDays4 + " � ��������� �������:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() < numberOfDays4) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("����� ������� ���!");

				break;
			}

			case 5: {
				System.out.println("=== ��������� ������ ���� ������� � ����������� ���� ������ ���������� ===");
				System.out.println("������� ���������� ����:");
				int numberOfDays5 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() == numberOfDays5 && numberOfDays5 <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("���������� ���� ������ " + numberOfDays5 + " � ��������� �������:");

					for (Months months2 : arrayListMonths) {
						if (months2.getNumberOfDays() > numberOfDays5) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("����� ������� ���!");

				break;
			}

			case 6: {
				System.out.println("=== ��������� ������ ��������� ���� ���� ===");
				System.out.println("������� ���� ����:");
				String season6 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arrayListSeasons) {
					if (seasons.name().equalsIgnoreCase(season6)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("��������� ���� ����:");

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
					System.out.println("����� ���� ���� ���!");

				break;
			}

			case 7: {
				System.out.println("=== ��������� ������ ���������� ���� ���� ===");
				System.out.println("������� ���� ����:");
				String season7 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arrayListSeasons) {
					if (seasons.name().equalsIgnoreCase(season7)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("���������� ���� ����:");

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
					System.out.println("����� ���� ���� ���!");

				break;
			}

			case 8: {
				System.out.println("=== ��������� ������ ������� � ������ ����������� ���� ===");

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() % 2 == 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 9: {
				System.out.println("=== ��������� ������ ������� � �������� ����������� ���� ===");

				for (Months months : arrayListMonths) {
					if (months.getNumberOfDays() % 2 != 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 0: {
				System.out.println("=== ��������� �������� �������� ���������� ���� � ��������� ������ ===");
				System.out.println("������� �����:");
				String month0 = scanner.next();

				boolean flag = isMonthExists(arrayListMonths, month0);

				if (flag == true) {
					Months month = Months.valueOf(firstUpperCase(month0.toLowerCase()));

					if (month.getNumberOfDays() % 2 == 0) {
						System.out.println("���������� ���� � ������ " + month0 + " - " + month.getNumberOfDays()
								+ ". ��� ����� - ������");
					} else {
						System.out.println("���������� ���� � ������ " + month0 + " - " + month.getNumberOfDays()
								+ ". ��� ����� - ��������");
					}
				}

				if (flag == false)
					System.out.println("������ ������ ���!");

				break;
			}

			default: {
				System.out.println("������� ����� �� 0 �� 9!");

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