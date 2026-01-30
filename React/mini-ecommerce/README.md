# Mini E-commerce — React + TypeScript Catalog

![React](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?logo=typescript&logoColor=white)
![Vite](https://img.shields.io/badge/Vite-646CFF?logo=vite&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=white)
![React%20Router](https://img.shields.io/badge/React%20Router-CA4245?logo=reactrouter&logoColor=white)

A modern, single-page e-commerce prototype featuring a filterable catalog, product detail view, cart management, and a checkout flow. Built to demonstrate routing, state management, and UI composition in React.

---

## 🧭 Pages & Routes

| Route | Page | Description |
| --- | --- | --- |
| `/` | Home | Hero + feature highlights with quick access to catalog and cart. |
| `/productos` | Product Listing | Search, category filtering, and pagination with URL-synced state. |
| `/productos/:id` | Product Detail | Detailed product view with add-to-cart action. |
| `/carrito` | Cart | Quantity controls, subtotal summary, and checkout link. |
| `/login` | Login | Login UI flow (UI placeholder for auth). |
| `/checkout` | Checkout | Summary and form layout for purchase flow. |

---

## ✨ Key Features

- **URL-driven state** for filters and pagination using query params.
- **Cart context** with add, remove, clear, and quantity updates.
- **Product API layer** abstracted into a dedicated module.
- **Responsive UI** with Bootstrap-based layout and card components.
- **Reusable components** for filtering, pagination, and product cards.

---

## 📁 Project Structure

```
src/
├── api/
├── components/
├── context/
├── layouts/
├── pages/
├── types/
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

## 🧩 Suggested Enhancements

- Connect to a real backend for products and checkout.
- Add authentication and user profiles.
- Persist cart state in localStorage.
- Improve category loading with dedicated API endpoints.

---

**A clean, portfolio-ready storefront prototype that showcases routing, filters, and cart logic.**
