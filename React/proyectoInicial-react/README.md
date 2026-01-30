# Proyecto Inicial — React + TypeScript Starter

![React](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?logo=typescript&logoColor=white)
![Vite](https://img.shields.io/badge/Vite-646CFF?logo=vite&logoColor=white)
![React%20Router](https://img.shields.io/badge/React%20Router-CA4245?logo=reactrouter&logoColor=white)

A compact React + TypeScript project that demonstrates routing, layout composition, and API data fetching.
This starter is ideal for practicing page structure, shared layouts, and component-driven UI.

---

## 🧭 Pages & Routes

| Route | Page | Highlights |
| --- | --- | --- |
| `/` | Home | Local state example with a reusable Card component. |
| `/api` | API | Fetches users from JSONPlaceholder with loading/error states. |

---

## ✨ Key Features

- **Shared Layout** using a main layout wrapper for consistent structure.
- **React Router** setup with nested routes and an `Outlet` for child views.
- **API Integration** using `fetch` and typed DTOs for user data.
- **Reusable UI Components** such as cards for consistent presentation.

---

## 📁 Project Structure

```
src/
├── components/
│   ├── pages/
│   │   ├── HomePage.tsx
│   │   └── ApiPage.tsx
│   └── Card.tsx
├── layouts/
│   └── MainLayout.tsx
├── App.tsx
└── main.tsx
```

---

## 🚀 Getting Started

```sh
npm install
npm run dev
```

The app will be available at `http://localhost:5173` by default.

---

## 🧩 Ideas to Extend

- Add a profile details page using a dynamic route like `/users/:id`.
- Introduce a global theme or layout variant per route group.
- Swap JSONPlaceholder for a local API to practice backend integration.

---

**Clean, focused, and practical—perfect for practicing React Router, layouts, and data fetching.**
