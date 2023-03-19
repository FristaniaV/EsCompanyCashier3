import java.util.Scanner;

public class Cashier3 {

	Scanner scan = new Scanner(System.in);

	public Cashier3() {
		String name = "", temp = "";
		int stock = 50, choice = 0, qty = 0, disc = 0, checkstock = 0;
		double price = 0, total = 0, pay = 0, change = 0;
		Boolean check = true;

		System.out.println("ES Companies Portal - Cashier App 3");
		System.out.println("==========================================");

		do {
			System.out.print("Input item's name [ 5 - 30 Characters ] : ");
			name = scan.nextLine();
			if (name.length() < 5) {
				System.out.println("Name must be 5 or more characters!");
			} else if (name.length() > 30) {
				System.out.println("Name must be no more than 30 characters!");
			}
		} while (name.length() < 5 || name.length() > 30);

		do {
			System.out.print("Input item's price [ use decimal numbers : 10.0 - 2000.0 ] : $ ");
			temp = scan.nextLine();

			if (!temp.contains(".") || (temp.indexOf(".") != temp.lastIndexOf(".")))
				continue;

			try {
				price = Double.parseDouble(temp);
			} catch (Exception e) {
				price = -1;
			}
		} while (price < 10 || price > 2000);

		System.out.println();
		System.out.println();

		do {
			System.out.println("What will you do?");
			System.out.println("===================");
			System.out.println("1. Sell item");
			System.out.println("2. Restock item");
			System.out.println("3. Exit ");
			System.out.print("Choose : ");
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = -1;
			}
			scan.nextLine();

			switch (choice) {
			case 1:
				if (stock <= 0) {
					System.out.println("The item is out of Stock, please restock!");
					break;
				} else {
					do {
						do {
							try {
								System.out.print("Input item's quantity [1.." + stock + "] : ");
								qty = scan.nextInt();
							} catch (Exception e) {
								check = false;
							}
							scan.nextLine();
							if (check == true)
								break;
						} while (false);

						if (qty > stock) {
							System.out.println("Out of Stock!");
						} else if (qty < 1) {
							System.out.println("Out of Stock!");
						}

					} while (qty > stock || qty < 1);

					do {
						do {
							try {
								System.out.print("Input item's discount [0-50] : ");
								disc = scan.nextInt();
							} catch (Exception e) {
								check = false;
							}
							scan.nextLine();
							if (check == true)
								break;
						} while (false);
					} while (disc < 0 || disc > 50);

					total = price * qty * (100 - disc) / 100;

					System.out.println("ES Companies Portal - Invoice");
					System.out.println("===============================");
					System.out.println("item's name			: " + name);
					System.out.println("item's price 		: " + price);
					System.out.println("item's quantity 	: " + qty);
					System.out.println("item's discount		: " + disc);
					System.out.println();
					System.out.println("You have to pay $" + total);

					do {
						System.out.print("Input item's price [ use decimal numbers : min " + total + "] : ");
						temp = scan.nextLine();

						if (!temp.contains(".") || (temp.indexOf(".") != temp.lastIndexOf(".")))
							continue;

						try {
							pay = Double.parseDouble(temp);
						} catch (Exception e) {
							pay = -1;
						}
					} while (pay < price);

					stock = stock - qty;
					change = pay - price;
					System.out.println("Thanks for Purchasing! ");
					System.out.println("Your change : $" + change);
					System.out.println();
					System.out.println();

				}
				break;
			case 2:
				if (stock == 100) {
					System.out.println("The item's stock is full, please sell it!");
					break;
				} else {
					checkstock = 100 - stock;
					do {
						do {
							try {
								System.out.print("Input stock to add [1.." + checkstock + "] : ");
								stock = scan.nextInt();
							} catch (Exception e) {
								check = false;
							}
							scan.nextLine();
							if (check == true)
								break;
						} while (false);
					} while (stock < 1 || stock > checkstock);

					System.out.println("Success add stock!");
				}
				break;
			case 3:
				System.out.println("Thanks for using this application!");
				break;
			}
		} while (choice != 3);

	}

	public static void main(String[] args) {
		new Cashier3();

	}

}
