// Importación de React y otros componentes necesarios
import React from 'react';
import ProfilePic from '../Assets/john-doe-image.png'; // Importa la imagen de perfil de 'John Doe'
import { AiFillStar } from 'react-icons/ai'; // Importa el ícono de estrella desde react-icons para calificaciones

// Componente funcional 'Testimonials', que representa una sección de testimonios en la página
const Testimonials = () => {
  return (
    <div className='work-section-wrapper'> {/* Contenedor principal de la sección de testimonios */}
      
      {/* Parte superior de la sección de testimonios */}
      <div className='work-section-top'>
        <p className='primary-subheading'>Testimonials</p> {/* Subtítulo de la sección */}
        <h1 className='primary-heading'>What They Are Saying</h1> {/* Título principal de la sección */}
        <p className='primary-text'>
          Lorem ipsum dolor sit amet consectetur. Non tincidunt 
          magna non et elit. Dolor  turpis molestie dui
          magnis facilisis at fringilla quam.
        </p> {/* Descripción introductoria para la sección */}
      </div>

      {/* Parte inferior de la sección de testimonios que contiene el testimonio real */}
      <div className='testimonial-section-bottom'>
        <img src={ProfilePic} alt="" /> {/* Imagen de perfil de 'John Doe' */}
        <p>
          Lorem ipsum dolor sit amet consectetur. Non tincidunt 
          magna non et elit. Dolor  turpis molestie dui
          magnis facilisis at fringilla quam.
        </p> {/* Testimonio del usuario (aquí es texto de ejemplo) */}
        
        {/* Contenedor de estrellas de calificación */}
        <div className='testimonials-stars-container'>
          <AiFillStar /> {/* Estrella de calificación llena */}
          <AiFillStar />
          <AiFillStar />
          <AiFillStar />
          <AiFillStar />
        </div>
        
        <h2>John Doe</h2> {/* Nombre del autor del testimonio */}
      </div>
    </div>
  )
}

// Exportación del componente 'Testimonials' para su uso en otras partes de la aplicación
export default Testimonials;
