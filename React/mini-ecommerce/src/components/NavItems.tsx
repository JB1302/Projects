import { NavLink } from "react-router-dom";
import type { ReactNode } from "react";

type NavItemProps = {
	to: string;
	children: ReactNode;
	end?: boolean;
};

export default function NavItem({ to, children, end }: NavItemProps) {
	return (
		<li className="nav-item me-3">
			<NavLink
				to={to}
				end={end}
				className={({ isActive }) =>
					"nav-link text-white " + (isActive ? "fw-bold" : "")
				}
			>
				{children}
			</NavLink>
		</li>
	);
}
