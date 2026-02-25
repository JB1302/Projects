using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EF_Demos.Models
{
    public class Producto
    {
        [Key]
        public int ProductoId { get; set; }

        [Required]
        [StringLength(100)]
        public string Nombre { get; set; }

        [Required]
        [Range(0.01, 100000)]
        public decimal Precio { get; set; }

        [Required]
        [Range(0, 10000)]
        public int Cantidad { get; set; }

        public byte[] Imagen { get; set; }
    }
}