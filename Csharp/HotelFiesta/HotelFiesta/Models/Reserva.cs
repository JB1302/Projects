using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace HotelFiesta.Models
{
    public class Reserva
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public int HabitacionId { get; set; }

        public virtual Habitacion Habitacion { get; set; }

        [Required]
        [StringLength(150)]
        [Display(Name = "Nombre del Cliente")]
        [DataType(DataType.Text)]
        public string NombreCliente { get; set; }

        [Required]
        [StringLength(30)]
        [Display(Name = "Cédula")]
        [DataType(DataType.Text)]
        public string DocumentoCliente { get; set; }

        [Required]
        [Display(Name = "Fecha de Entrada")]
        [DataType(DataType.DateTime)]
        public DateTime FechaEntrada { get; set; }

        [Required]
        [Display(Name = "Fecha de Salida")]
        [DataType(DataType.DateTime)]
        public DateTime FechaSalida { get; set; }
        public Estado estado { get; set; } = Estado.Pendiente;

        [Required]
        [Display(Name = "Total")]
        [DataType(DataType.Currency)]
        public decimal total { get; set; }

    }

    public enum Estado
    {
        Pendiente,
        Confirmada,
        Cancelada
    }
}