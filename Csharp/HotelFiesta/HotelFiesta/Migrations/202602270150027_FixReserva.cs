namespace HotelFiesta.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FixReserva : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Reservas", "total", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Reservas", "total", c => c.Double(nullable: false));
        }
    }
}
