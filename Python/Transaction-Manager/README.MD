# Financial Transaction Manager 💸📊

![Python](https://img.shields.io/badge/Python-3776AB?logo=python&logoColor=white)
![PyWebView](https://img.shields.io/badge/PyWebView-111827?logo=python&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=000)

A cross-platform desktop application for managing personal finances—built with **Python (PyWebView)**, **HTML5**, **CSS3**, and **vanilla JavaScript**. Track income and expenses with a clean UI and persist data locally in JSON.

---

## 🗂️ Project Overview

| Component | Description |
| --- | --- |
| Python Backend (API) | Saves and loads data from a local JSON file. |
| PyWebView | Hosts the HTML UI in a lightweight native window. |
| HTML/CSS UI | Form-based layout for salary, extras, and expenses. |
| JavaScript Logic | Real-time calculations and UI updates. |

---

## 🚀 Features

- **Cross-platform Desktop App** for Windows, macOS, and Linux.
- **Local Persistence** in `datos.json` with offline-first behavior.
- **Interactive Expense Rows** with enable/disable toggles.
- **Real-time Calculations** for totals, balances, and due amounts.
- **Simple, Extendable Codebase** for personal or business use.

---

## 🛠️ Technologies Used

- **Backend:** Python 3.x, PyWebView, JSON
- **Frontend:** HTML5, CSS3, JavaScript (ES6+)
- **Typography:** Google Fonts (Roboto)

---

## 📁 Project Structure

```
/
├── main.py           # Python entry point (PyWebView + API)
├── datos.json        # Local persistent data file (auto-created)
├── frontend/
│   ├── index.html    # Main UI page
│   ├── styles.css    # Custom styles
│   └── scripts.js    # Frontend logic
└── README.md
```

---

## ⚡ How It Works

1. **Launch the app:** `main.py` opens the HTML UI in a native window.
2. **Enter financial data:** Salary, extra income, and up to 12 expenses.
3. **Real-time updates:** Totals update instantly as you type.
4. **Data persistence:** Changes are saved to `datos.json` (or `localStorage` in browser mode).

---

## 🧑‍💻 Quick Start

```sh
pip install pywebview
python main.py
```

*(Optional)* Open `frontend/index.html` directly for browser-only mode.

---

## 🌟 Why This Project Stands Out

- Offline-first, privacy-friendly, and lightweight.
- Perfect as a personal budgeting tool or a base for business finance dashboards.
- Easy to extend with analytics, export options, or multi-user profiles.

---

**A practical, desktop-ready finance tracker built with Python and web tech.**
