// Importación de React y otros componentes/archivos necesarios
import React from 'react'
import AboutBackground from "../Assets/about-background.png" // Importa una imagen de fondo
import AboutBackgroundImage from "../Assets/about-background-image.png" // Importa una imagen adicional para la sección 'about'
import { BsFillPlayCircleFill } from 'react-icons/bs' // Importa el ícono de un círculo de reproducción desde react-icons

// Función del componente 'about', que es una sección de la página
function about() {
  return (
    <div className='about-section-container'> {/* Contenedor principal de la sección 'about' */}
      
      {/* Contenedor para la imagen de fondo */}
      <div className='about-background-image-container'>
        <img src={AboutBackground} alt="" /> {/* Se muestra la imagen de fondo importada */}
      </div>
      
      {/* Contenedor para la imagen destacada dentro de la sección */}
      <div className='about-section-image-container'>
        <img src={AboutBackgroundImage} alt='' /> {/* Se muestra la imagen secundaria importada */}
      </div>

      {/* Contenedor de texto para la sección 'about' */}
      <div className='about-section-text-container'>
        <p className='primary-subheading'>About</p> {/* Subtítulo que indica de qué trata la sección */}
        <h1 className='primary-heading'>
           Food Is An Important Part Of A Balanced Diet {/* Título principal */}
        </h1>
        <p className='primary-Text'>
          Lorem ipsum dolor sit amet consectetur. Non tincidunt 
          magna non et elit. Dolor  turpis molestie dui
          magnis facilisis at fringilla quam.
        </p>
        <p className='primary-Text'>
          Non tincidunt magna non et elit. Dolor turpis molestie 
          dui magnis facilisis at fringilla quam.
        </p>
        
        {/* Contenedor de los botones en la sección */}
        <div className='about-buttons-container'>
          <button className='secondary-button'>Learn More</button> {/* Botón para aprender más */}
          <button className='watch-video-button'> 
            <BsFillPlayCircleFill/> {/* Ícono de reproducción para el botón de video */}
            Watch Video {/* Texto en el botón */}
          </button>
        </div>
      </div>

    </div>
  )
}

// Exportación del componente 'about' para que pueda ser usado en otras partes de la aplicación
export default about
