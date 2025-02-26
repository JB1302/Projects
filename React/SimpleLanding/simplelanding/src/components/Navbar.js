import React, { useState } from 'react';  // Importa React y el hook useState
import Logo from "../Assets/Logo.svg";  // Importa el logo de la aplicación
import { BsCart2 } from 'react-icons/bs';  // Importa el icono del carrito de compras
import { HiOutlineBars3 } from 'react-icons/hi2';  // Importa el icono de barra de menú
import { 
  Box,
  Drawer,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText, 
} from '@mui/material';  // Importa componentes de Material UI para el diseño del menú lateral

// Cargar los iconos de Material UI
import InfoIcon from '@mui/icons-material/Info';  // Icono de información
import CommentRoundedIcon from '@mui/icons-material/CommentBankRounded';  // Icono de comentarios
import PhoneRoundedIcon from '@mui/icons-material/PhoneRounded';  // Icono de teléfono
import ShoppingCartRoundedIcon from '@mui/icons-material/ShoppingCart';  // Icono de carrito de compras
import HomeIcon from '@mui/icons-material/Home';  // Icono de inicio

// Función para ejecutar el componente Navbar (barra de navegación)
export const Navbar = () => {
  // Estado para controlar la visibilidad del menú lateral (hamburguesa)
  const [openMenu, setOpenMenu] = useState(false);

  // Opciones del menú (con texto y icono)
  const menuOptions = [
    { text: "Home", icon: <HomeIcon /> },  // Opción de inicio
    { text: "About", icon: <InfoIcon /> },  // Opción de acerca de
    { text: "Testimonials", icon: <CommentRoundedIcon /> },  // Opción de testimonios
    { text: "Contact", icon: <PhoneRoundedIcon /> },  // Opción de contacto
    { text: "Cart", icon: <ShoppingCartRoundedIcon /> },  // Opción de carrito
  ];

  return ( 
    <nav>  {/*Contenedor principal de la barra de navegación*/}
      <div className='nav-logo-container'>
        <img src={Logo} alt='' />  {/* Logo de la aplicación */}
      </div>
      <div className='navbar-links-container'>
        {/* Enlaces de navegación */}
        <a href=''>Home</a>
        <a href=''>About</a>
        <a href=''>Testimonials</a>
        <a href=''>Contact</a>
        <a href=''>
          <BsCart2 className='navbar-cart-icon' />  {/* Icono del carrito */}
          <button className='primary-button'>Booking Now</button>  {/* Botón de reserva */}
        </a>
        
        {/* Icono de menú para pantallas pequeñas */}
        <div className='navbar-menu-container'>
          <HiOutlineBars3 onClick={() => setOpenMenu(true)} />  {/* Abre el menú lateral */}
        </div>

        {/* Menú lateral */}
        <Drawer 
         open={openMenu} 
         onClose={() => setOpenMenu(false)} 
         anchor='right
        '>
          <Box sx=
            {{ width: 250 }} 
            role="presentation" 
            onClick={() => setOpenMenu(false)} 
            onKeyDown={() => setOpenMenu(false)}
          >

            {/* Lista de opciones de menú */}
            <list>
              {menuOptions.map((item) => (
                <ListItem key={item.text} disablePadding>
                  <ListItemButton>
                    <ListItemIcon>{item.icon}</ListItemIcon>  {/* Muestra el icono */}
                    <ListItemText primary={item.text}></ListItemText>  {/* Muestra el texto */}
                  </ListItemButton>
                </ListItem>
              ))}
            </list>
          </Box>
        </Drawer>
      </div>
    </nav>
  );
};

export default Navbar;  // Exporta el componente Navbar 