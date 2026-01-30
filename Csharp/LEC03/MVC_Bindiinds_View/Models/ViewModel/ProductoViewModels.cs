using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Security.Cryptography;
using System.Web.Mvc;
using System.Xml.Linq;

namespace MVC_Bindiinds_View.Models.ViewModel
{
    public class ProductoViewModels
    {
        public int id { get; set; }


        // En vez de mostrar "Name", se mostrará "nombre"
        [Display(Name = "nombre ")]
        public string Name { get; set; } = string.Empty;

        // En vez de "price", se verá "precio"

        // [DataType(DataType.Currency)] indica que este valor representa dinero
        // Razor puede formatearlo como ₡, $, etc. dependiendo de la cultura del sistema

        // [Range] valida que el precio esté dentro de un rango permitido
        // No permite valores negativos ni cero
        // Precio mínimo: 0.001
        // Precio máximo: 999,999
        [Display(Name = "precio"), DataType(DataType.Currency)]
        [Range(0.001, 999_999)]
        public decimal price { get; set; }

    }
}