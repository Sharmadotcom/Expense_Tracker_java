# 5.2 Problem Statement & Scope

## Problem Statement
Managing daily personal finances is a common challenge for individuals across all age groups. Most people spend money across multiple categories—such as food, transportation, utilities, and entertainment—without maintaining a structured record of their transactions. Without clear visibility into spending patterns, individuals struggle to build effective budgets, identify unnecessary expenses, or achieve savings goals.

Existing digital tools (such as complex mobile apps or spreadsheet software) often present drawbacks:
- High setup friction and steep learning curves.
- Requirement for continuous internet access or account creation.
- Privacy concerns associated with uploading personal financial data to third-party cloud servers.

There is a distinct need for a lightweight, offline, and local-first tool that enables quick logging, straightforward categorization, and clear aggregation of daily expenses.

---

## Scope of the Project
The primary scope of the Expense Tracker project is to deliver a functional, command-line interface (CLI) application built in Java that simplifies expense management for local desktop environments.

### In Scope:
- Core CRUD capabilities: Log new expenses (description, amount, category) and view all logged entries.
- Category-based and grand-total calculation using Java Streams.
- Data persistence through Java Object Serialization into local binary files.
- Offline execution with standard command-line interaction.

### Out of Scope:
- Graphical User Interfaces (GUI) or web/mobile platform deployments.
- Multi-user authentication or cloud-based database integration.
- Automated currency conversion, receipt scanning, or direct bank feed synchronization.

---

## Target Users
1. **Students & Young Professionals:** Individuals seeking a simple, zero-friction tool to track daily living expenses without setting up complex software.
2. **Privacy-Conscious Individuals:** Users who prefer keeping financial logs stored locally on their hardware rather than synced to external server databases.
3. **Developers & Java Learners:** Individuals seeking a clean reference codebase showcasing Object-Oriented Design, Java Serialization, and Streams.

---

## High-Level Features
- **Expense Entry Logging:** Capture expense entries with custom descriptions, double-precision amounts, and specific category tags.
- **Structured Data Viewing:** Display all recorded transactions in a clean, readable console format.
- **Stream-Based Aggregation:** Automatically compute total expenditures across all entries or filter calculations by a designated category (case-insensitive).
- **Binary File Persistence:** Save expense states directly to disk and reload previously saved session files using native Java serialization.
- **CLI Navigation Loop:** Interactive, menu-driven navigation loop with proper input buffer handling.
