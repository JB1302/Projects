function Contact(){
  return(
    <section className="contact">
      <h2>Contactos</h2>
      <form>
        <input type="text" placeholder="Nombre" />
        <input type="email" placeholder="Email" />
        <button type="submit">Enviar</button>
      </form>
    </section>
  )
}

export default Contact;