namespace HotelFiesta.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FixTipoHab : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.TipoHabitacions", "Descripcion", c => c.String(maxLength: 100));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.TipoHabitacions", "Descripcion", c => c.String(nullable: false, maxLength: 100));
        }
    }
}
