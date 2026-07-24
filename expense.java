import java.util.*;
class main {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> expenseNames = new ArrayList<>();
        ArrayList<Double> expenseAmounts = new ArrayList<>();

        boolean running = true;

        System.out.println("=== Personal Expense Tracker ===");

        while (running) {
            System.out.println("\n1. Add an Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total & Highest Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            if (choice == 1) {
                System.out.print("Enter expense description (e.g., Food, Books): ");
                String name = sc.nextLine();

                System.out.print("Enter amount: $");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    expenseNames.add(name);
                    expenseAmounts.add(amount);
                    System.out.println("Expense logged successfully!");
                } else {
                    System.out.println("Amount must be greater than 0.");
                }
            } 
            else if (choice == 2) {
                if (expenseNames.isEmpty()) {
                    System.out.println("No expenses logged yet.");
                } else {
                    System.out.println("\n--- Expense Log ---");
                    for (int i = 0; i < expenseNames.size(); i++) {
                        System.out.println((i + 1) + ". " + expenseNames.get(i) + " - $" + expenseAmounts.get(i));
                    }
                }
            } 
            else if (choice == 3) {
                if (expenseNames.isEmpty()) {
                    System.out.println("No expenses to calculate.");
                } else {
                    double total = 0;
                    double highest = expenseAmounts.get(0);
                    String highestExpense = expenseNames.get(0);

                    for (int i = 0; i < expenseAmounts.size(); i++) {
                        total += expenseAmounts.get(i); 

                        if (expenseAmounts.get(i) > highest) {
                            highest = expenseAmounts.get(i);
                            highestExpense = expenseNames.get(i);
                        }
                    }

                    System.out.println("\n--- Expense Summary ---");
                    System.out.printf("Total Spent: $%.2f\n", total);
                    System.out.println("Most Expensive: " + highestExpense + " ($" + highest + ")");
                }
            } 
            else if (choice == 4) {
                running = false;
                System.out.println("Exiting Expense Tracker. Have a great day!");
            } 
            else {
                System.out.println("Invalid choice! Please select 1-4.");
            }
        }

        sc.close();
    }
}