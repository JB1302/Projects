using HotelFiesta.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace HotelFiesta.Models
{

    public class FiestaContext : DbContext
    {
        public FiestaContext() : base("FiestaContext")
        {
        }
        public DbSet<Habitacion> Habitaciones { get; set; }
        public DbSet<TipoHabitacion> TipoHabitaciones { get; set; }
        public DbSet<Reserva> Reservas { get; set; }

    }
}