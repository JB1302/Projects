using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Threading;

namespace SGPT.Models
{

    public class Proyecto
    {
        [Key]
        public int idProyecto { get; set; }

        [Required]
        [StringLength(100)]
        public string Nombre { get; set; }

        [StringLength(500)]
        public string Descripcion { get; set; }

        [Required]
        public DateTime FechaInicio { get; set; }

        public DateTime? FechaFin { get; set; }

        public EstadoProyecto Estado { get; set; }

        [Required]
        [StringLength(120)]
        public string Responsable { get; set; }


        // Relación 1-N (Un proyecto tiene muchas tareas)
        public virtual ICollection<Tarea> Tareas { get; set; }


    }

    public enum EstadoProyecto
    {
        Activo,
        En_Pausa,
        Finalizado
    }

}