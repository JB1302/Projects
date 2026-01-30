using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MV_HTTPS.Tests.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        //Tipos de HTTPS


        // Para verlos en el navegador:
        // https://localhost:44366/Home/GetJson


        //Jsonificar una persona
        public JsonResult GetJson()
        {
            var data = new { name = "pablo", Apellido = "Rodriguez" };
            return Json(data, JsonRequestBehavior.AllowGet);
        }

        // Redirige al navegador a una URL externa (Google)
        public ActionResult redirectToGoogle()
        {
            return Redirect("http://www.google.com");
        }

        // Redirige a la acción Index del controlador Home
        public RedirectToRouteResult RedirectToHome()
        {
            return RedirectToAction("Index", "Home");
        }

        // Devuelve texto plano como respuesta HTTP
        public ActionResult ReturnString()
        {
            return Content("Hola 2");
        }

        // Devuelve un error HTTP 403 (acceso prohibido)
        public ActionResult Forbidden()
        {
            return new HttpStatusCodeResult(403, "No tienes permiso para acceder a este recurso");
        }

        // Devuelve una vista parcial sin layout
        public ActionResult GetPartialView()
        {
            return PartialView("_vistaParcialView");
        }

    }
}