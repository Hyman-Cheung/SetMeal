# 🍔 SetMeal Management System

A comprehensive, console-based Point of Sale (POS) and Customer Relationship Management (CRM) terminal. This system simulates a restaurant's operational environment, allowing staff members to handle customer orders, manage a customer membership database with dynamic discounts, and audit store performance metrics.

---

[![Open in GitHub Codespaces](https://img.shields.io/badge/-Click_to_Run-2ea44f?style=for-the-badge&logo=github)](https://codespaces.new/Hyman-Cheung/SetMeal)

---
## 🎯 Key Application Features

* **Secure Staff Portals:** Restricts operational access behind a secure terminal gatekeeper allowing staff sign-ups, secure authentication, and credentials recovery.
* **Smart Food Ordering Terminal:** An intuitive multi-stage food selection wizard divided into Main Courses, Drinks, and Snacks with immediate real-time price updates.
* **Interactive Shopping Basket:** A review screen that groups distinct customer orders, provides individual totals, and allows specific order removal with automated spacing cleanup.
* **Automated Member Perks:** A CRM utility that registers customers with unique identities, allowing them to redeem a permanent **20% discount** during transactions.
* **Financial Auditing Log:** Keeps an persistent operational history tracking total order numbers, structured billing receipts, and gross store turnover.

---

## 🔄 Core Functional Workflows

The application operates in a continuous loop through three primary user modules:

### 1. Gatekeeper & Access Control
When the program initializes, users are presented with a preliminary screen to manage terminal access:
* **Create Account:** Registers a new store clerk. The system enforces strict layout policies (names must be $\ge 3$ characters with an uppercase initial; passwords must be $\ge 8$ characters, unique, and begin with a specific uppercase/alphabetic sequence).
* **Login:** Validates active clerk credentials before granting access to the system backend.
* **Forgot Password:** Allows locked-out staff members to securely verify their name and overwrite their password under the same security guidelines.

### 2. The Ordering & Basket Terminal
Once logged in, staff can seamlessly run the restaurant checkout line:
* **Placing Orders:** Clerks pick selections across three interactive localized Chinese-menu directories (**Main Courses** like *脆辣雞腿包*, **Drinks** like *凍新鮮檸檬茶*, and **Snacks** like *薯條*). 
* **Order Duplication:** Speed up service by instantly cloning identical orders to a ticket with a single click.
* **The Shopping Basket:** Displays the cumulative grouped transaction ticket, itemized breakdowns, and total amounts. Staff can seamlessly drop a specific order from the list if a customer changes their mind.

### 3. VIP Membership & Checkout Processing
Finalizes transactions while maintaining consumer relationships:
* **Membership Lookup & Creation:** Before taking payment, the terminal checks for a registered membership token. New profiles can be generated instantly, creating a random 6-digit identification number associated with the customer's name.
* **Dynamic Discount Calculation:** Valid members instantly trigger a **20% discount** off the cumulative order amount.
* **Cash Handeling & Receipts:** Processes cash tender inputs, ensures funds are sufficient, handles change distribution math, and generates a structured, live-timestamped (`dd/MM/yyyy HH:mm:ss`) receipt.
* **Turnover Records:** Safely saves finalized transactions into a master archive screen displaying calculated net profits and gross individual receipts.

---

## 📋 Terminal Validation Matrix

| Action | Condition Enforced by System | Operational Result |
| :--- | :--- | :--- |
| **Staff Registration** | Invalid length or lowercase beginnings. | Blocks creation and prints explicit formatting rule requirements. |
| **Staff Sign-In** | Duplicate entries or wrong passwords. | Restricts access and returns the screen back to safety loops. |
| **Order Management** | Item Removal from Basket. | Shifts the remaining list elements upwards to eliminate empty rows. |
| **Checkout Phase** | Input member number matches database. | Displays user name and automatically slices **20% off the total bill**. |
| **Cash Processing** | Customer cash input is less than calculated total. | `Insufficient fund!` prompt blocks order finalization. |

---

## 💻 System Technical Profile

* **Interface Type:** Command Line Interface (CLI) / Terminal App
* **Language/Platform:** Java Runtime Environment
* **Currency Formatting:** Decimal rounded (`#.#`) to prevent floating-point calculation glitches.
* **Time Tracking:** Integrated live system clock for localized timestamp records.

---

## 👤 Credits
Designed and Developed by **Hyman Cheung**.

