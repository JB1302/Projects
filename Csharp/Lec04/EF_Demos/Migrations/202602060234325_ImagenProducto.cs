namespace EF_Demos.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ImagenProducto : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Productoes", "Imagen", c => c.Binary());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Productoes", "Imagen");
        }
    }
}
