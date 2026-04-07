using LoginAppV2.Helpers;
using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(LoginAppV2.Startup))]
namespace LoginAppV2
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
            RoleHelper.CrearRoles();
        }
    }
}
