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
    public class HabitacionsController : Controller
    {
        private FiestaContext db = new FiestaContext();

        // GET: Habitacions
        // GET: Habitacions
        public ActionResult Index()
        {
            //Habitaciones (con TipoHabitacion)
            var habitaciones = db.Habitaciones
                .Include(h => h.TipoHabitacion)
                .ToList();

            //Conteo de reservas activas por habitación
            var reservasActivas = db.Reservas
                .Where(r => r.estado == Estado.Pendiente || r.estado == Estado.Confirmada)
                .GroupBy(r => r.HabitacionId)
                .Select(g => new { HabitacionId = g.Key, Cantidad = g.Count() })
                .ToDictionary(x => x.HabitacionId, x => x.Cantidad);

            //Se lo pasás a la vista
            ViewBag.ReservasActivas = reservasActivas;

            return View(habitaciones);
        }

        // GET: Habitacions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Habitacion habitacion = db.Habitaciones.Find(id);
            if (habitacion == null)
            {
                return HttpNotFound();
            }
            return View(habitacion);
        }

        // GET: Habitacions/Create
        public ActionResult Create()
        {
            ViewBag.TipoHabitacionId = new SelectList(db.TipoHabitaciones, "Id", "Nombre");
            return View();
        }

        // POST: Habitacions/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,NumeroHabitacion,Piso,ImagePath,TipoHabitacionId")] Habitacion habitacion)
        {
            if (ModelState.IsValid)
            {
                db.Habitaciones.Add(habitacion);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.TipoHabitacionId = new SelectList(db.TipoHabitaciones, "Id", "Nombre", habitacion.TipoHabitacionId);
            return View(habitacion);
        }

        // GET: Habitacions/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Habitacion habitacion = db.Habitaciones.Find(id);
            if (habitacion == null)
            {
                return HttpNotFound();
            }
            ViewBag.TipoHabitacionId = new SelectList(db.TipoHabitaciones, "Id", "Nombre", habitacion.TipoHabitacionId);
            return View(habitacion);
        }

        // POST: Habitacions/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,NumeroHabitacion,Piso,ImagePath,TipoHabitacionId")] Habitacion habitacion)
        {
            if (ModelState.IsValid)
            {
                db.Entry(habitacion).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.TipoHabitacionId = new SelectList(db.TipoHabitaciones, "Id", "Nombre", habitacion.TipoHabitacionId);
            return View(habitacion);
        }

        // GET: Habitacions/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Habitacion habitacion = db.Habitaciones.Find(id);
            if (habitacion == null)
            {
                return HttpNotFound();
            }
            return View(habitacion);
        }

        // POST: Habitacions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Habitacion habitacion = db.Habitaciones.Find(id);
            db.Habitaciones.Remove(habitacion);
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
