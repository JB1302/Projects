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
    public class ReservasController : Controller
    {
        private FiestaContext db = new FiestaContext();

        // GET: Reservas
        public ActionResult Index()
        {
            var reservas = db.Reservas.Include(r => r.Habitacion);
            return View(reservas.ToList());
        }

        // GET: Reservas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Reserva reserva = db.Reservas.Find(id);
            if (reserva == null)
            {
                return HttpNotFound();
            }
            return View(reserva);
        }

        // GET: Reservas/Create
        public ActionResult Create()
        {
            ViewBag.HabitacionId = new SelectList(db.Habitaciones, "Id", "NumeroHabitacion");
            return View();
        }

        // POST: Reservas/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,HabitacionId,NombreCliente,DocumentoCliente,FechaEntrada,FechaSalida,estado")] Reserva reserva)
        {
            if (reserva.FechaSalida.Date < reserva.FechaEntrada.Date)
                ModelState.AddModelError("FechaSalida", "La salida no puede ser antes que la entrada.");

            if (db.Reservas.Any(r =>
                r.HabitacionId == reserva.HabitacionId &&
                r.estado != Estado.Cancelada &&
                reserva.FechaEntrada < r.FechaSalida &&
                reserva.FechaSalida > r.FechaEntrada))
            {
                ModelState.AddModelError("", "Esa habitación ya está reservada en ese rango.");
            }

            if (ModelState.IsValid)
            {
                int noches = (reserva.FechaSalida.Date - reserva.FechaEntrada.Date).Days;

                var costoBase = db.Habitaciones
                    .Where(h => h.Id == reserva.HabitacionId)
                    .Select(h => h.TipoHabitacion.CostoBase)
                    .FirstOrDefault();

                reserva.total = noches * costoBase;

                db.Reservas.Add(reserva);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.HabitacionId = new SelectList(db.Habitaciones, "Id", "NumeroHabitacion", reserva.HabitacionId);
            return View(reserva);
        }

        // GET: Reservas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Reserva reserva = db.Reservas.Find(id);
            if (reserva == null)
            {
                return HttpNotFound();
            }
            ViewBag.HabitacionId = new SelectList(db.Habitaciones, "Id", "NumeroHabitacion", reserva.HabitacionId);
            return View(reserva);
        }

        // POST: Reservas/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,HabitacionId,NombreCliente,DocumentoCliente,FechaEntrada,FechaSalida,estado")] Reserva reserva)
        {
            if (reserva.FechaSalida.Date < reserva.FechaEntrada.Date)
                ModelState.AddModelError("FechaSalida", "La salida no puede ser antes que la entrada.");

            //Excluir esta reserva que estoy configurando.
            if (db.Reservas.Any(r =>
                r.Id != reserva.Id &&
                r.HabitacionId == reserva.HabitacionId &&
                r.estado != Estado.Cancelada &&
                reserva.FechaEntrada < r.FechaSalida &&
                reserva.FechaSalida > r.FechaEntrada))
            {
                ModelState.AddModelError("", "Esa habitación ya está reservada en ese rango.");
            }

            if (ModelState.IsValid)
            {
                int noches = (reserva.FechaSalida.Date - reserva.FechaEntrada.Date).Days;

                var costoBase = db.Habitaciones
                    .Where(h => h.Id == reserva.HabitacionId)
                    .Select(h => h.TipoHabitacion.CostoBase)
                    .FirstOrDefault();

                reserva.total = noches * costoBase;

                db.Entry(reserva).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.HabitacionId = new SelectList(db.Habitaciones, "Id", "NumeroHabitacion", reserva.HabitacionId);
            return View(reserva);
        }

        // GET: Reservas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Reserva reserva = db.Reservas.Find(id);
            if (reserva == null)
            {
                return HttpNotFound();
            }
            return View(reserva);
        }

        // POST: Reservas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Reserva reserva = db.Reservas.Find(id);
            db.Reservas.Remove(reserva);
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
