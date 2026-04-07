using System.ComponentModel.DataAnnotations;

namespace ITSM.Models
{
    public class Cliente
    {
        [Key]
        [Display(Name = "ID")]
        public int Id { get; set; }

        [Required]
        [StringLength(100)]
        [DataType(DataType.Text)]
        [Display(Name = "Nombre Completo")]
        public string NombreCompleto { get; set; }

        [Required]
        [StringLength(100)]
        [DataType(DataType.Text)]
        [Display(Name = "Correo Electrónico")]
        public string CorreoElectronico { get; set; }

        [StringLength(20)]
        [DataType(DataType.Text)]
        [Display(Name = "Número de Teléfono")]
        public string Telefono { get; set; }   
    }
}