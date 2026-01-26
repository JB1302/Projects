import { NavLink } from "react-router-dom";
import type { ReactNode } from "react";

type NavButtonProps = {
	to: string;
	variant?: string;
	children: ReactNode;
};

export default function NavButton({
	to,
	variant = "primary",
	children,
}: NavButtonProps) {
	return (
		<NavLink
			to={to}
			className={({ isActive }) =>
				`btn btn-${variant} ${isActive ? "fw-bold" : ""}`
			}
		>
			{children}
		</NavLink>
	);
}
