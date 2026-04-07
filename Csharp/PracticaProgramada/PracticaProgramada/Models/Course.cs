using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace PracticaProgramada.Models
{
    public class Course
    {
        [Key]
        public int Id { get; set; }
        [Required]

        public string Name { get; set; }
        [Required]
        public string Title { get; set; }
        [Required]
        public int Credits { get; set; }
        [Required]
        public string Instructor { get; set; }


        // Navigation property for Enrollments
        public virtual ICollection<Enrollment> Enrollments { get; set; }

    }
}