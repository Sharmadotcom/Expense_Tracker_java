import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    private List<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        this(new Scanner(System.in));
    }

    public ExpenseTracker(Scanner scanner) {
        this.expenses = new ArrayList<>();
        this.scanner = scanner;
    }

    public void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid amount. Please enter a valid number: ");
            scanner.nextLine();
        }
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        Expense newExpense = new Expense(description, amount, category);
        expenses.add(newExpense);

        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("Expenses:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("----------------------");
        }
    }

    public double calculateTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double calculateTotalExpensesByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void saveExpensesToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(expenses);
            System.out.println("Expenses saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadExpensesFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            expenses = (List<Expense>) ois.readObject();
            System.out.println("Expenses loaded from file successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker(scanner);

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Calculate Total Expenses by Category");
            System.out.println("5. Save Expenses to File");
            System.out.println("6. Load Expenses from File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                } else {
                    break;
                }
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    expenseTracker.addExpense();
                    break;
                case 2:
                    expenseTracker.viewExpenses();
                    break;
                case 3:
                    double totalExpenses = expenseTracker.calculateTotalExpenses();
                    System.out.println("Total Expenses: " + totalExpenses);
                    break;
                case 4:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    double totalExpensesByCategory = expenseTracker.calculateTotalExpensesByCategory(category);
                    System.out.println("Total Expenses for Category '" + category + "': " + totalExpensesByCategory);
                    break;
                case 5:
                    System.out.print("Enter file name to save expenses: ");
                    String saveFileName = scanner.nextLine();
                    expenseTracker.saveExpensesToFile(saveFileName);
                    break;
                case 6:
                    System.out.print("Enter file name to load expenses from: ");
                    String loadFileName = scanner.nextLine();
                    expenseTracker.loadExpensesFromFile(loadFileName);
                    break;
                case 7:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
