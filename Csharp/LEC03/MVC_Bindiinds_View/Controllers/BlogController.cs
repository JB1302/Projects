using System.Web.Mvc;

namespace MVC_Bindiinds_View.Controllers
{
    [RoutePrefix("blog")]
    public class BlogController : Controller
    {
        [Route("{year:int:min(2020)}/{month:int:range(1,12)}/{slug:regex(^[a-z0-9-]+$)}")]
        public ActionResult Details(int year, int month, string slug)
        {
            return Content(string.Format("Post {0} ({1}/{2})", slug, year, month));
        }


    }
}