using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PracticaProgramada.Controllers
{
    public class PPController : DbContext
    {
        // GET: PP
        public PPController() : base("PPController")
         {
          }
        public DbSet<Models.Student> Students { get; set; }
        public DbSet<Models.Course> Courses { get; set; }
        public DbSet<Models.Enrollment> Enrollments { get; set; }

    }
}