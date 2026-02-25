using System.Data.Entity;
using System.Web.Mvc;

namespace ITSM.Controllers
{
    public class ITSMController : DbContext
    {
       public ITSMController() : base("ITSMConnectionString")
        {
        }
        public DbSet<Models.Cliente> Clientes { get; set; }
        public DbSet<Models.Categoria> Categorias { get; set; }
        public DbSet<Models.Tiquete> Tiquetes { get; set; }
    }
}