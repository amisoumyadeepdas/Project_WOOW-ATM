# WOOW ATM Project

This repository contains an Automated Teller Machine (ATM) simulation project implemented in Core Java. To enhance user experience, a GUI has been created using Java Swing with WindowBuilder. The project simulates typical ATM operations and uses Oracle 11g RDBMS to store account details.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Usage](#usage)
- [Screenshots](#screenshots)

## Features

- User-friendly GUI with Java Swing (WindowBuilder)
- ATM simulation for performing various banking operations
  - Credit
  - Debit
  - Withdrawal
  - Transfer
  - Block ATM Card
- Oracle 11g RDBMS for storing account details
- Assumes user accounts are pre-created by bank managers

## Technologies Used

- Java (Core Java, Java Swing)
- Oracle 11g RDBMS
- WindowBuilder (for GUI)

## Project Structure

## Usage

1. Run the `Main` class in the `com.woowatm` package to start the application.

2. Use the GUI to perform ATM operations:
   - Credit: Add funds to the account
   - Debit: Deduct funds from the account
   - Withdrawal: Withdraw funds from the account

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/amisoumyadeepdas/Project_WOOW-ATM.git
    cd WOOW_ATM_Project
    ```

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

3. Ensure that Oracle 11g RDBMS is installed and running on your machine.

4. Set up the database by running the provided SQL scripts in the `resources` directory to create the necessary tables and insert sample data.

5. Configure the database connection details in the project.

6. Build the project using your IDE's build tool (e.g., Maven, Gradle).

## Screenshots

### Login Screen

![Login Screen](https://github.com/user-attachments/assets/fad043b6-d89d-4559-a273-d5fd7c81ea22)

### Enter PIN

![Enter PIN](https://github.com/user-attachments/assets/6fc057df-5f4d-4a8a-a3c0-75e44c72fc77)

### Set PIN

![Set PIN](https://github.com/user-attachments/assets/d5835f10-80fb-401c-aaab-16b88e8f25a8)
![Set PIN](https://github.com/user-attachments/assets/29b8568d-ef22-4eaf-aa1f-fbb3479b548c)

### Dashboard

![Dashboard](https://github.com/user-attachments/assets/3328cef9-58d0-4da3-b7d8-ae66381aa2f3)

### Transfer Operation

![Transfer Operation](https://github.com/user-attachments/assets/94b7dbff-1fb8-4f89-a494-4d4ef65706ec)
![Transfer Operation](https://github.com/user-attachments/assets/c4350382-5657-43d6-8f2a-f15623fee41f)

### Debit Operation

![Debit Operation](https://github.com/user-attachments/assets/9f13badc-f62a-459b-ae67-fd061d9909b8)

### Credit Operation

![Withdrawal Operation](https://github.com/user-attachments/assets/60117625-6b11-4abc-a62f-a2054d1a929a)

### Balance Check

![Balance Operation](https://github.com/user-attachments/assets/bdc69fdf-817c-4ae2-b001-7f1d1bb7e1fc)

### Block Operation

![Block Operation](https://github.com/user-attachments/assets/8393034b-3a01-4e41-9a4c-0c256d338e50)

### Transaction History

![Block Operation](https://github.com/user-attachments/assets/9799f596-4f20-4521-9f1d-548565379139)


---

Feel free to contribute to the project by forking the repository and submitting pull requests. For any issues or feature requests, please open an issue in the repository.

---

Happy Banking!
