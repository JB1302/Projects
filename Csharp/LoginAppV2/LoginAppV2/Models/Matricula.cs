using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace LoginAppV2.Models
{
    public class Matricula
    {
        [Key]
        public int MatriculaId { get; set; }

        [Required]
        [Display(Name = "Fecha de matrícula")]
        public DateTime FechaMatricula { get; set; }

        [Required]
        public string ApplicationUserId { get; set; }

        [Required]
        public int CursoId { get; set; }

        [ForeignKey("ApplicationUserId")]
        public virtual ApplicationUser Estudiante { get; set; }

        [ForeignKey("CursoId")]
        public virtual Curso Curso { get; set; }

        [Required]
        [Display(Name = "Estado")]
        public EstadoMatricula Estado { get; set; } = EstadoMatricula.EnRevision;
    
}

    public enum EstadoMatricula
    {
        EnRevision = 0,
        Denegado = 1,
        Aceptado = 2
    }
}