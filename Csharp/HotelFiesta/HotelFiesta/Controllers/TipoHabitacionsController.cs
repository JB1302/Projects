using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using HotelFiesta.Models;

namespace HotelFiesta.Controllers
{
    public class TipoHabitacionsController : Controller
    {
        private FiestaContext db = new FiestaContext();

        // GET: TipoHabitacions
        public ActionResult Index()
        {
            return View(db.TipoHabitaciones.ToList());
        }

        // GET: TipoHabitacions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TipoHabitacion tipoHabitacion = db.TipoHabitaciones.Find(id);
            if (tipoHabitacion == null)
            {
                return HttpNotFound();
            }
            return View(tipoHabitacion);
        }

        // GET: TipoHabitacions/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: TipoHabitacions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Nombre,Descripcion,CostoBase")] TipoHabitacion tipoHabitacion)
        {
            if (ModelState.IsValid)
            {
                if (tipoHabitacion.CostoBase <= 0)
                {
                    ModelState.AddModelError("CostoBase", "El costo base no puede ser 0.");
                    return View(tipoHabitacion);
                }   
                db.TipoHabitaciones.Add(tipoHabitacion);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(tipoHabitacion);
        }

        // GET: TipoHabitacions/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TipoHabitacion tipoHabitacion = db.TipoHabitaciones.Find(id);
            if (tipoHabitacion == null)
            {
                return HttpNotFound();
            }
            return View(tipoHabitacion);
        }

        // POST: TipoHabitacions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Nombre,Descripcion,CostoBase")] TipoHabitacion tipoHabitacion)
        {
            if (ModelState.IsValid)
            {
                db.Entry(tipoHabitacion).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(tipoHabitacion);
        }

        // GET: TipoHabitacions/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TipoHabitacion tipoHabitacion = db.TipoHabitaciones.Find(id);
            if (tipoHabitacion == null)
            {
                return HttpNotFound();
            }
            return View(tipoHabitacion);
        }

        // POST: TipoHabitacions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            TipoHabitacion tipoHabitacion = db.TipoHabitaciones.Find(id);
            db.TipoHabitaciones.Remove(tipoHabitacion);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
