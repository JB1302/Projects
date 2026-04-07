namespace HotelFiesta.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FixCurrency : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.TipoHabitacions", "CostoBase", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.TipoHabitacions", "CostoBase", c => c.Double(nullable: false));
        }
    }
}
