using MVC_Bindiinds_View.Models;
using System.Web.Mvc;

namespace MVC_Bindiinds_View.Controllers
{
    public class ReporteController : Controller
    {
        [Route("reporte-ventas")]
        public ActionResult Sales(DateRange rango)
        {
            return Content(
                string.Format("Desde {0:d} hasta {1:d}", rango.From, rango.To));
        }
    }
}