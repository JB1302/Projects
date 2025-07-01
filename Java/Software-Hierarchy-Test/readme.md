# PC Manager 🖥️🔒

A Java console application that simulates management of computer hardware, software installation, and user authentication.

## Main Features

- **Hardware Management:** Track devices, RAM, CPU, etc.
- **Software Compatibility:** Check available RAM before installation.
- **User Roles:** Admin and Guest authentication.
- **Modular OOP Design:** SOLID principles applied.

## Technologies

- Java (OOP, Inheritance, Polymorphism)
- Packages and modular class structure

## Example Usage

Laptop laptop1 = new Laptop("Maria", "Intel I5", 16, "LED", 11);
Software software1 = new Software(laptop1, "Teams", 1);
software1.haySuficienteRam();
