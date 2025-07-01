# JavaFX + HTML Resource Manager App

A desktop application that combines the power of JavaFX with the flexibility of HTML and CSS for modern UI design.  
Easily manage and visualize financial resources (salary, expenses, extras, and more) using an interactive, web-based interface embedded in a Java application.

---

## 🚀 Main Features

- **Hybrid UI:**  
  Uses JavaFX’s `WebView` to render a responsive HTML/CSS interface as the app window.
- **Financial Management:**  
  Quickly input, categorize, and track salary, extras, surplus, and pending payments.
- **Modern Design:**  
  Stylish, clean UI using Google Fonts (Roboto) and custom CSS for a polished look.
- **Separation of Concerns:**  
  All business logic can be managed in Java, while the interface is handled with HTML/CSS—making it easy to customize and scale.

---

## 🛠️ Technologies Used

- Java 17+  
- JavaFX  
- HTML5, CSS3  
- (Optional) JavaScript for enhanced interactivity

---

## 🗂️ Project Structure

/src/main/java/com/resourcemanager/resourcemanager/
main.java # JavaFX entry point; embeds WebView and loads HTML
/resources/
index.html # Main web UI for the application
style.css # Custom styles for the UI


---

## ⚡ How It Works

1. **Launch the App:**  
   The JavaFX `main` class starts and opens a window using `WebView`.
2. **UI Loading:**  
   The embedded browser loads `index.html` from the `resources` folder, styled via `style.css`.
3. **User Input:**  
   Users fill out salary, extras, surplus, and per-line expenses directly in the UI.
4. **(Optional) Logic & Persistence:**  
   Extend with JavaScript or Java-to-JS bridges for calculations, saving data, or dynamic UI updates.

---

## 🧑‍💻 How to Run

1. Make sure you have Java 17+ and JavaFX set up in your environment.
2. Place `index.html` and `style.css` inside your `resources` directory.
3. Build and run the Java application (`main.java`).


## Example using Maven
mvn clean javafx:run

## 🌟 Why Use This Project?

    Modern UI, Traditional Power:
    Create desktop apps with the look and feel of the modern web.

    Easy to Customize:
    Change the UI with basic HTML/CSS—no need to recompile Java code for every design tweak.

    Extendable:
    Add JavaScript or connect back to Java for business logic, calculations, or database integration.

    Great for Prototyping or Teaching:
    Perfect for quickly mocking up UIs, demos, or teaching Java/HTML integration.

## 📈 Possible Extensions

    Add JavaScript calculations for real-time line totals.

    Implement persistence (e.g., save/load data to a local database).

    Connect with backend APIs for more advanced workflows.

    Add dark/light theme toggling or more advanced CSS transitions.

Clean, modular, and flexible—build modern desktop experiences with the best of both Java and the web!