namespace SGPT.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Proyecto : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Proyectoes",
                c => new
                    {
                        idProyecto = c.Int(nullable: false, identity: true),
                        Nombre = c.String(nullable: false, maxLength: 100),
                        Descripcion = c.String(maxLength: 500),
                        FechaInicio = c.DateTime(nullable: false),
                        FechaFin = c.DateTime(nullable: false),
                        Estado = c.Int(nullable: false),
                        Responsable = c.String(nullable: false, maxLength: 120),
                    })
                .PrimaryKey(t => t.idProyecto);
            
            CreateTable(
                "dbo.Tareas",
                c => new
                    {
                        idTarea = c.Int(nullable: false, identity: true),
                        Titulo = c.String(nullable: false, maxLength: 100),
                        Descripcion = c.String(),
                        FechaCreacion = c.DateTime(nullable: false),
                        FechaVencimiento = c.DateTime(nullable: false),
                        Estado = c.Int(nullable: false),
                        idProyecto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.idTarea)
                .ForeignKey("dbo.Proyectoes", t => t.idProyecto, cascadeDelete: true)
                .Index(t => t.idProyecto);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Tareas", "idProyecto", "dbo.Proyectoes");
            DropIndex("dbo.Tareas", new[] { "idProyecto" });
            DropTable("dbo.Tareas");
            DropTable("dbo.Proyectoes");
        }
    }
}
