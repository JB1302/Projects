using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace PracticaProgramada.Models
{
    public class Enrollment
    {
        [Key]
        public int EnrollmentId { get; set; }


        // Foreign key for Course
        public int CourseID { get; set; }

        //Navegacion
        public virtual Course Course { get; set; }

        //Foreign key for Student
        public int StudentID {  get; set; }
        //Navegacion
        public virtual Student Student { get; set; }


        public int Grade { get; set; }
    }
}