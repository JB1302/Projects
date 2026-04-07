namespace LoginAppV2.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ReviseMatricula : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Matriculas", "Estado", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Matriculas", "Estado");
        }
    }
}
