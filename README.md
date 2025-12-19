# Online Course Registration System

A simple platform that allows students to register for available courses, instructors to manage their course details, and administrators to control course offerings and registration rules.

This project focuses on **Applying object-oriented principles**.

## 📋 Project Overview

The Online Course Registration System is a Java-based console application that simulates a university course registration platform. The system implements core object-oriented programming principles including encapsulation, inheritance, and polymorphism.

**Key Components:**
- **User Management**: Students, Instructors, and Administrators with role-based access
- **Course Management**: Courses with multiple sections and enrollment capacity
- **Schedule System**: Personal schedules for students with conflict detection
- **Section Management**: Course sections with instructor assignments and seat availability

**Technologies Used:**
- Java (JDK 11+)
- Object-Oriented Design Patterns
- Console-based UI

## 🚀 Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- A text editor or IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)
- Command line terminal

### Installation Steps

1. **Clone or Download the Repository**
   ```bash
   git clone <repository-url>
   cd Online-Course-Registration
   ```

2. **Navigate to Phase 4 Code Directory**
   ```bash
   cd "Phase 4/Code"
   ```

3. **Verify Java Installation**
   ```bash
   java -version
   javac -version
   ```

## ▶️ How to Run

### Compile the Project
```bash
javac Main.java
```

### Run the Application
```bash
java Main
```

### Using the System

1. **Main Menu**: Select your role (Student, Instructor, or Administrator)
2. **User Selection**: Choose which user account to login with
3. **Role Menu**: Access features specific to your role
4. **Navigation**: Follow on-screen prompts to perform actions

### Pre-loaded Test Data
The system comes with sample data:
- **Students**: Ahmad, Sameh, Seif, anyName
- **Instructors**: Dr. Ahmed, Dr. Sara, Dr. Sameh
- **Administrator**: System Admin
- **Courses**: CS101, CS102, SW301
- **Sections**: S1, S2, S3

## Features

**Phase 4**

### 🎓 Student Features
- View available courses and sections
- Register for courses
- View personal schedule
- User selection: Choose which student account to login with

### 👨‍🏫 Instructor Features
- View assigned sections
- View enrolled students in their sections
- User selection: Choose which instructor account to login with

### 🔧 Administrator Features
- **Course Management:**
  - Add new courses
  - View all courses
- **Section Management:**
  - Add new sections
  - Assign instructors to sections
- **User Management:**
  - Add new students (ID, Name, Email, Program)
  - Add new instructors (ID, Name, Email)
  - Add new administrators (ID, Name, Email)
  - View all users in the system
  - Remove users (students, instructors, administrators)
  - Safety feature: Cannot remove the last administrator
- User selection: Choose which administrator account to login with

### 🔑 Authentication
- Role-based login system
- User selection screen for each role
- Multiple users per role support

## 👥 Development Team

<p align="center">
<table align="center" style="margin:0 auto; text-align:center;">
<tr>
<th align="center">Full-Stack Developer</th>
<th align="center">Full-Stack Developer</th>
<th align="center">Full-Stack Developer</th>
</tr>
<tr>

<td align="center"><img src="https://avatars.githubusercontent.com/u/141459078?s=100&v=4" width="100" height="100"><br>Seif Amr</td>
<td align="center"><img src="https://avatars.githubusercontent.com/u/154564347?s=100&v=4" width="100" height="100"><br>Ahmed Sameh</td>
<td align="center"><img src="https://avatars.githubusercontent.com/u/133889737?s=100&v=4" width="100" height="100"><br>Ahmed Wael</td>
</tr>
<tr>

<td align="center">Full-Stack Development</td>
<td align="center">Full-Stack Development</td>
<td align="center">Full-Stack Development</td>
</tr>
</table>
</p>
