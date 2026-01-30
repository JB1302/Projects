using System;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace MVC_Bindiinds_View.Models
{
    public class Producto 
    {
        public int id { get; set; }

        //Esto es mandatorio y con una longitud maxima de 100 caracteres
        [Required, StringLength(100)]
        public string Nombre { get; set; } = string.Empty;

        //Esto es del tipo moneda
        [DataType(DataType.Currency)]
        public decimal precio { get; set; }
        public DateTime ReleaseDate { get; set; }
    }
}