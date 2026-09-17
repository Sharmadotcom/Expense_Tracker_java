# 💰 Expense Tracker — Java Console Application

> **Week 3 Internship Project** | MotionCut  
> A command-line Expense Tracker built in Java that lets users log, view, categorize, and persist their expenses.

---

## Overview

This project is a console-based **Expense Tracker** application developed as part of a Java internship program (Week 3). It demonstrates core Java concepts including object-oriented programming, file I/O with serialization, collections, streams, and interactive console input handling.

---

## Features

- ➕ **Add Expense** — Record an expense with a description, amount, and category
- 📋 **View All Expenses** — Display all recorded expenses in a readable format
- 🧮 **Calculate Total Expenses** — Sum up all recorded expenses
- 🗂️ **Filter by Category** — Calculate the total for a specific category
- 💾 **Save to File** — Persist expenses to a binary file using Java serialization
- 📂 **Load from File** — Restore previously saved expenses from a file
- 🚪 **Exit** — Gracefully exit the application

---

## Project Structure

```
Expense Tracker/
├── Expense.java          # Data model representing a single expense
├── ExpenseTracker.java   # Main application logic and entry point
```

---

## Getting Started

### Prerequisites

- Java 8 or higher
- A terminal / command prompt

### Compile

```bash
javac Expense.java ExpenseTracker.java
```

Or compile all files at once:

```bash
javac *.java
```

### Run

```bash
java ExpenseTracker
```

---

## Usage

Once the application starts, you'll see a menu:

```
1. Add Expense
2. View Expenses
3. Calculate Total Expenses
4. Calculate Total Expenses by Category
5. Save Expenses to File
6. Load Expenses from File
7. Exit
Choose an option:
```

**Example session:**

```
Choose an option: 1
Enter expense description: Lunch
Enter expense amount: 150.00
Enter expense category: Food
Expense added successfully!

Choose an option: 3
Total Expenses: 150.0

Choose an option: 5
Enter file name to save expenses: my_expenses.dat
Expenses saved to file successfully!
```

---

## Classes

### `Expense.java`

A serializable data model representing a single expense entry.

| Member | Type | Description |
|---|---|---|
| `description` | `String` | Short description of the expense |
| `amount` | `double` | Monetary value of the expense |
| `category` | `String` | Category label (e.g., Food, Travel) |

Implements `Serializable` to support file persistence. Provides full getters, setters, and a `toString()` override.

---

### `ExpenseTracker.java`

The main application class that extends `Expense` and drives the console menu.

| Method | Description |
|---|---|
| `addExpense()` | Prompts user for details and adds a new `Expense` to the list |
| `viewExpenses()` | Prints all stored expenses to the console |
| `calculateTotalExpenses()` | Returns the sum of all expense amounts using Java Streams |
| `calculateTotalExpensesByCategory(String)` | Returns the total for a given category (case-insensitive) |
| `saveExpensesToFile(String)` | Serializes the expense list to a binary file |
| `loadExpensesFromFile(String)` | Deserializes and restores expenses from a file |
| `main(String[])` | Entry point; runs the interactive menu loop |

