using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HotelFiesta.Models
{
    public class TipoHabitacion
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(100)]
        [Display(Name = "Tipo de Habitación")]
        [DataType(DataType.Text)]
        public string Nombre { get; set; }

        [StringLength(100)]
        [Display(Name = "Descripción")]
        [DataType(DataType.Text)]
        public string Descripcion { get; set; }

        [Required]
        [Display(Name = "Costo Base")]
        public decimal CostoBase { get; set; }
    }
}