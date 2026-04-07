using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EF_Demos.Models
{
    public class BazarContext : DbContext
    {
        public BazarContext() : base("BazarDbConnection")
        {
        }

        public DbSet<Producto> Productos { get; set; }
    }
}