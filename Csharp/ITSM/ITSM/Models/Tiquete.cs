using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ITSM.Models
{
    public class Tiquete
    {
        [Key]
        [Display(Name = "ID")]
        public int Id { get; set; }

        [Required]
        [StringLength(100)]
        [DataType(DataType.Text)]
        [DisplayName("Título del Problema")]
        public string Titulo { get; set; }

        [Required]
        [StringLength(500)]
        [DataType(DataType.Text)]
        [DisplayName("Descripción del Problema")]
        public string Descripcion { get; set; }

        [Required]
        [DataType(DataType.DateTime)]
        [DisplayName("Fecha de Creación")]
        public DateTime FechaCreacion { get; set; }

        [Required]
        [DisplayName("Estado del Tiquete")]
        [DataType(DataType.Text)]
        public Estado estado { get; set; }


        /* Relacion con Cliente y Navegacion */
        [ForeignKey("Cliente")]
        public int clienteId { get; set; }

        public virtual Cliente Cliente { get; set; }
        
        /* Relacion con Categoria y Navegacion */
        [ForeignKey("Categoria")]
        public int categoriaId { get; set; }

        public virtual Categoria Categoria { get; set; }


        public enum Estado
        {
            Abierto,
            EnProceso,
            Cerrado
        }
    }
}