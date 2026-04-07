using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LoginAppV2.Models
{
    public class Curso
    {
        [Key]
        public int CursoId { get; set; }

        [Required]
        [StringLength(20)]
        [Display(Name = "Código del curso")]
        public string Codigo { get; set; }

        [Required]
        [StringLength(150)]
        [Display(Name = "Nombre del curso")]
        public string Nombre { get; set; }

        [Display(Name = "Créditos")]
        public int Creditos { get; set; }

        [StringLength(500)]
        [Display(Name = "Descripción")]
        public string Descripcion { get; set; }

        public virtual ICollection<Matricula> Matriculas { get; set; }
    }
}