using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SGPT.Models
{
    public class Tarea
    {
        [Key]
        public int idTarea { get; set; }

        [Required]
        [StringLength(100)]
        public string Titulo { get; set; }

        public string Descripcion { get; set; }

        [Required]
        public DateTime FechaCreacion { get; set; }

        public DateTime FechaVencimiento { get; set; }

        public EstadoTarea Estado { get; set; }

        [ForeignKey("Proyecto")]
        public int idProyecto { get; set; }

        //Esta es la relacion con proyecto
        public virtual Proyecto Proyecto { get; set; }


    }
    public enum EstadoTarea
    {
        Baja,
        Media,
        Alta,
    }
}