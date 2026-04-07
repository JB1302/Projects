namespace HotelFiesta.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Habitacions",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NumeroHabitacion = c.String(nullable: false, maxLength: 10),
                        Piso = c.Int(nullable: false),
                        ImagePath = c.String(),
                        TipoHabitacionId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.TipoHabitacions", t => t.TipoHabitacionId, cascadeDelete: true)
                .Index(t => t.TipoHabitacionId);
            
            CreateTable(
                "dbo.TipoHabitacions",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nombre = c.String(nullable: false, maxLength: 100),
                        Descripcion = c.String(nullable: false, maxLength: 100),
                        CostoBase = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Reservas",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        HabitacionId = c.Int(nullable: false),
                        NombreCliente = c.String(nullable: false, maxLength: 150),
                        DocumentoCliente = c.String(nullable: false, maxLength: 30),
                        FechaEntrada = c.DateTime(nullable: false),
                        FechaSalida = c.DateTime(nullable: false),
                        estado = c.Int(nullable: false),
                        total = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Habitacions", t => t.HabitacionId, cascadeDelete: true)
                .Index(t => t.HabitacionId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Reservas", "HabitacionId", "dbo.Habitacions");
            DropForeignKey("dbo.Habitacions", "TipoHabitacionId", "dbo.TipoHabitacions");
            DropIndex("dbo.Reservas", new[] { "HabitacionId" });
            DropIndex("dbo.Habitacions", new[] { "TipoHabitacionId" });
            DropTable("dbo.Reservas");
            DropTable("dbo.TipoHabitacions");
            DropTable("dbo.Habitacions");
        }
    }
}
