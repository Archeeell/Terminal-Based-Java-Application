# 🧺 Terminal-Based Java Application

> A console-based laundry management system built with Java to explore and apply fundamental Object-Oriented Programming concepts.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Concept-OOP-4CAF50?style=for-the-badge)
![CLI](https://img.shields.io/badge/Interface-CLI-333333?style=for-the-badge)

## 📌 Overview

**Terminal-Based Java Application** is a Java console application developed as a learning project for implementing Object-Oriented Programming (OOP) concepts through a simple laundry management system.

The project demonstrates how a real-world workflow can be translated into Java classes, objects, methods, enums, collections, and input validation.

The repository contains multiple development phases, showing the progression from a basic implementation toward a more structured OOP-based application.

## ✨ Features

- 👤 Manage customer information
- 🧺 Create new laundry orders
- 🆔 Automatic order ID generation (`LDR-001`, `LDR-002`, etc.)
- 💰 Calculate and display order costs
- 🔄 Update laundry order status
- 🔎 Search orders by ID
- 🏷️ Filter orders by status
- 📊 Display order and revenue summaries
- ⚠️ Input validation and exception handling
- 🖥️ Fully terminal/console based

## 🔄 Order Status

Laundry orders can move through several stages:

```text
STATUS_MASUK
      ↓
STATUS_DICUCI
      ↓
STATUS_DISETRIKA
      ↓
STATUS_SIAP
```

This represents a simplified real-world laundry workflow from order intake until the laundry is ready for collection.

## 🧠 OOP Concepts Demonstrated

| Concept | Implementation |
|---|---|
| **Class & Object** | `Pelanggan`, `Pesanan`, `KasirLaundry`, and other domain classes |
| **Encapsulation** | Attributes are managed through class methods and accessors |
| **Constructor** | Objects are initialized with relevant customer/order data |
| **Enum** | `JenisLayanan` and order status values provide controlled options |
| **Collections** | `ArrayList` stores active laundry orders |
| **Methods** | Business operations are separated into reusable methods |
| **Exception Handling** | `InputMismatchException` handles invalid numeric input |
| **Object Relationships** | Customer, order, and laundry-service concepts interact as domain objects |

## 🏗️ Application Flow

```text
Start Application
       ↓
Main Menu
       ↓
┌──────────────────────────────┐
│ 1. Tambah Pesanan            │
│ 2. Lihat Semua Pesanan       │
│ 3. Update Status             │
│ 4. Cari Pesanan              │
│ 5. Filter by Status          │
│ 6. Ringkasan & Pendapatan    │
│ 0. Keluar                    │
└──────────────────────────────┘
       ↓
Process Data
       ↓
Display Result
```

## 📂 Project Structure

```text
Terminal-Based-Java-Application/
├── fase1/
│   ├── Main.java
│   ├── KasirLaundry.java
│   ├── Pelanggan.java
│   ├── Pesanan.java
│   └── README.md
├── fase2/
│   ├── Main.java
│   ├── KasirLaundry.java
│   ├── JenisLayanan.java
│   ├── Pelanggan.java
│   ├── Pesanan.java
│   └── README.md
├── log-ai/
│   ├── README.md
│   └── logai.txt
├── Refleksi.pdf
└── README.md
```

> The repository is organized into development phases to document the learning and implementation process.

## 🚀 Getting Started

### Prerequisites

Make sure Java Development Kit (JDK) is installed on your computer.

Check your Java installation:

```bash
java -version
javac -version
```

### Run the Application

Navigate to the desired phase, for example:

```bash
cd fase2
```

Compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## 🖥️ Example Menu

```text
=== SISTEM KASIR LAUNDRY ===
1. Tambah Pesanan Baru
2. Lihat Semua Pesanan
3. Update Status Pesanan
4. Cari Pesanan by ID
5. Filter Pesanan by Status
6. Ringkasan & Pendapatan
0. Keluar
```

## 🎯 Learning Objectives

This project was created to strengthen understanding of:

- Java syntax and program structure
- Object-Oriented Programming
- Class design and object interaction
- Enum and collections
- Exception handling
- Input validation
- Basic separation of responsibilities
- Translating real-world processes into software models

## 🔮 Possible Improvements

The current application is intentionally simple and console-based. Possible future improvements include:

- 💾 Database persistence using SQLite/MySQL
- 🌐 REST API backend
- 🖥️ Graphical or web-based interface
- 🔐 User authentication and role management
- 🧾 Printable/downloadable receipts
- 📈 More detailed reporting and analytics
- 🧪 Automated unit testing

## 👨‍💻 Author

**Archellyno**  
Information Technology Student — Universitas Udayana

---

⭐ If you find this project useful, feel free to explore the code and follow its development across the different phases.