using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace HotelFiesta.Models
{
    public class Habitacion
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(10)]
        [Display(Name = "Numero de Habitación")]
        [DataType(DataType.Text)]
        public string NumeroHabitacion { get; set; }

        [Required]
        [Display(Name = "Piso")]
        public int Piso { get; set; }


        [Display(Name = "Referencia de la Habitacion")]
        [DataType(DataType.ImageUrl)]
        public string ImagePath { get; set; }


        [Required]
        [Display(Name = "Tipo de Habitación")]
        public int TipoHabitacionId { get; set; }

        [ForeignKey(nameof(TipoHabitacionId))]
        public virtual TipoHabitacion TipoHabitacion { get; set; }
    }

}