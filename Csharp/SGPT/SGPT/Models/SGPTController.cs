using System.Data.Entity;

namespace SGPT.Models
{
    public class SGPTController : DbContext
    {
        public SGPTController() : base("SGPTController")
        {
        }

        public DbSet<Proyecto> Proyectos { get; set; }
        public DbSet<Tarea> Tareas { get; set; }
    }
}