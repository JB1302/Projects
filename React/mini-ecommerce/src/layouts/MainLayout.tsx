import type { ReactNode } from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";

type MainLayoutProps = {
	children: ReactNode;
};

export default function MainLayout({ children }: MainLayoutProps) {
	return (
		<div
			style={{
				fontFamily: "sans-serif",
				minHeight: "100vh",
				display: "flex",
				flexDirection: "column",
			}}
		>
			<Header></Header>

			<main style={{ flex: 1 }}>
				<div style={{ maxWidth: 1000, margin: "0 auto", padding: 16 }}>
					{children}
				</div>
			</main>

			<Footer></Footer>
		</div>
	);
}
