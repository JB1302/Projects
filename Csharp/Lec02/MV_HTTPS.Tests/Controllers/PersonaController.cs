using MV_HTTPS.Models;
using System.Web.Mvc;

namespace MV_HTTPS.Controllers
{
    public class PersonaController : Controller
    {
        // GET: Persona
        public ActionResult Index()
        {
            return View(new Persona()
            {
                Id = 1,
                Nombre = "Juan Perez",
                Edad = 23
            });
        }
    }
}