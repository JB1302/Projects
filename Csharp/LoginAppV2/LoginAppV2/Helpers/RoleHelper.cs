using LoginAppV2.Models;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;

namespace LoginAppV2.Helpers
{
    public class RoleHelper
    {
        public static void CrearRoles()
        {
            using (var context = new ApplicationDbContext())
            {
                var roleManager = new RoleManager<IdentityRole>(new RoleStore<IdentityRole>(context));

                if (!roleManager.RoleExists("Admin"))
                {
                    roleManager.Create(new IdentityRole("Admin"));
                }

                if (!roleManager.RoleExists("Estudiante"))
                {
                    roleManager.Create(new IdentityRole("Estudiante"));
                }
            }
        }
    }
}