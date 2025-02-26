import React from 'react';  // Importa React
import { Navbar } from './Navbar';  // Importa el componente Navbar
import BannerBackground from "../Assets/home-banner-background.png";  // Importa la imagen de fondo del banner
import BannerImage from "../Assets/home-banner-image.png";  // Importa la imagen principal del banner
import { FiArrowRight } from 'react-icons/fi';  // Importa el icono de flecha derecha

// Componente Home que representa la página de inicio
export const Home = () => {
  return (
    <div className='home-container'>  {/* Contenedor principal de la página de inicio */}
      <Navbar />  {/* Incluye el componente Navbar (barra de navegación) */}
      {/* Contenedor del banner */}
      <div className='home-banner-container'>
        
        {/* Contenedor para la imagen de fondo */}
        <div className='home-bannerImage-container'>
          <img src={BannerBackground} alt="" />  {/* Muestra la imagen de fondo del banner */}
        </div>
        
        {/* Sección de texto del banner */}
        <div className='home-text-section'>
            <h1 className='primary-heading'>
              Your Favourite Food Delivered Hot & Fresh
            </h1>  {/* Título principal del banner */}
            
            <p className='primary-text'>
              Healthy switcher chefs do all the prep work, like 
              peeling, chopping & marinating, so you can cook
              a fresh food.
            </p>  {/* Descripción debajo del título */}
            
            {/* Botón con el texto "Order Now" y un icono de flecha */}
            <button className='secondary-button'>
              Order Now <FiArrowRight />  {/* Icono de flecha hacia la derecha */}
            </button>
        </div>
        
        {/* Contenedor para la imagen principal del banner */}
        <div className='home-image-container'>
          <img src={BannerImage} alt='' />  {/* Muestra la imagen principal del banner */}
        </div>

      </div>
    </div>
  );
}

export default Home;  // Exporta el componente Home para que pueda ser utilizado en otras partes de la app
