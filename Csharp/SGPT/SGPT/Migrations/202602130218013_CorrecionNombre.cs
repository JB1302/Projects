namespace SGPT.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CorrecionNombre : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Proyectoes", "FechaFin", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Proyectoes", "FechaFin", c => c.DateTime(nullable: false));
        }
    }
}
