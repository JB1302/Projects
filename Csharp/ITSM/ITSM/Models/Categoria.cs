using System.ComponentModel.DataAnnotations;

namespace ITSM.Models
{
    public class Categoria
    {
        [Key]
        [Display(Name = "ID")]
        public int Id { get; set; }

        [Required]
        [StringLength(100)]
        [DataType(DataType.Text)]
        [Display(Name = "Nombre de la Categoría")]
        public string Nombre { get; set; } 
    }
}