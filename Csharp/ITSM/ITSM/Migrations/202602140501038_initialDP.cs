namespace ITSM.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initialDP : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Categorias",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nombre = c.String(nullable: false, maxLength: 100),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NombreCompleto = c.String(nullable: false, maxLength: 100),
                        CorreoElectronico = c.String(nullable: false, maxLength: 100),
                        Telefono = c.String(maxLength: 20),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Tiquetes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Titulo = c.String(nullable: false, maxLength: 100),
                        Descripcion = c.String(nullable: false, maxLength: 500),
                        FechaCreacion = c.DateTime(nullable: false),
                        estado = c.Int(nullable: false),
                        clienteId = c.Int(nullable: false),
                        categoriaId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Categorias", t => t.categoriaId, cascadeDelete: true)
                .ForeignKey("dbo.Clientes", t => t.clienteId, cascadeDelete: true)
                .Index(t => t.clienteId)
                .Index(t => t.categoriaId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Tiquetes", "clienteId", "dbo.Clientes");
            DropForeignKey("dbo.Tiquetes", "categoriaId", "dbo.Categorias");
            DropIndex("dbo.Tiquetes", new[] { "categoriaId" });
            DropIndex("dbo.Tiquetes", new[] { "clienteId" });
            DropTable("dbo.Tiquetes");
            DropTable("dbo.Clientes");
            DropTable("dbo.Categorias");
        }
    }
}
