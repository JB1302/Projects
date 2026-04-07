using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Security.Claims;
using System.Threading.Tasks;

namespace LoginAppV2.Models
{
    public enum CarreraUsuario
    {
        IngenieriaEnSistemas,
        Derecho,
        Administracion,
        Contaduria,
        Psicologia,
        DisenoGrafico
    }

    public class ApplicationUser : IdentityUser
    {
        [Required]
        [StringLength(150)]
        public string NombreCompleto { get; set; }

        [Required]
        public CarreraUsuario Carrera { get; set; }
        public virtual ICollection<Matricula> Matriculas { get; set; }

        public async Task<ClaimsIdentity> GenerateUserIdentityAsync(UserManager<ApplicationUser> manager)
        {
            var userIdentity = await manager.CreateIdentityAsync(this, DefaultAuthenticationTypes.ApplicationCookie);
            return userIdentity;
        }



    }

    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext()
            : base("DefaultConnection", throwIfV1Schema: false)
        {
        }

        public DbSet<Matricula> Matriculas { get; set; }
        public DbSet<Curso> Cursos { get; set; }

        public static ApplicationDbContext Create()
        {
            return new ApplicationDbContext();
        }
    }
}