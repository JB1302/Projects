using ITSM.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using static ITSM.Models.Tiquete;

namespace ITSM.Controllers
{
    public class TiquetesController : Controller
    {
        private ITSMController db = new ITSMController();



        public ActionResult Index(Tiquete.Estado? estado)
        {
            // Crear un SelectList para el filtro de estado
            ViewBag.estado = new SelectList(
                //Obtiene todos los valores del enum
                Enum.GetValues(typeof(Tiquete.Estado))

                    //indica que queremos los valores del enum dentro de la clase Tiquete
                    .Cast<Tiquete.Estado>()

                    //Selecciona el Id y el Nombre para cada valor del enum
                    //Tipo "Valor 1 = 0, Nombre 1 = "Abierto"
                    .Select(e => new
                    {
                        Id = (int)e,
                        Nombre = e.ToString()
                    }),
                //Indica que el valor del SelectList es el Id y el texto es el Nombre
                "Id",
                "Nombre",
                //Mantiene el estado seleccionado en el filtro
                estado
            );

            // Obtiene todos los tiquetes y los convierte en una consulta dinamica
            var tiquetes = db.Tiquetes.AsQueryable();

            // Si se selecciona un estado, se filtra
            if (estado.HasValue)
            {
                // Filtra los tiquetes por el estado seleccionado
                tiquetes = tiquetes.Where(t => t.estado == estado.Value);
            }
            // Convierte la consulta a una lista y la pasa a la vista
            return View(tiquetes.ToList());
        }





        // GET: Tiquetes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Tiquete tiquete = db.Tiquetes.Find(id);
            if (tiquete == null)
            {
                return HttpNotFound();
            }
            return View(tiquete);
        }

        // GET: Tiquetes/Create
        public ActionResult Create()
        {
            ViewBag.categoriaId = new SelectList(db.Categorias, "Id", "Nombre");
            ViewBag.clienteId = new SelectList(db.Clientes, "Id", "NombreCompleto");
            return View();
        }

        // POST: Tiquetes/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Titulo,Descripcion,FechaCreacion,estado,clienteId,categoriaId")] Tiquete tiquete)
        {
            if (ModelState.IsValid)
            {
                tiquete.FechaCreacion = DateTime.Now;

                db.Tiquetes.Add(tiquete);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.categoriaId = new SelectList(db.Categorias, "Id", "Nombre", tiquete.categoriaId);
            ViewBag.clienteId = new SelectList(db.Clientes, "Id", "NombreCompleto", tiquete.clienteId);
            return View(tiquete);
        }

        // GET: Tiquetes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Tiquete tiquete = db.Tiquetes.Find(id);
            if (tiquete == null)
            {
                return HttpNotFound();
            }
            ViewBag.categoriaId = new SelectList(db.Categorias, "Id", "Nombre", tiquete.categoriaId);
            ViewBag.clienteId = new SelectList(db.Clientes, "Id", "NombreCompleto", tiquete.clienteId);
            return View(tiquete);
        }

        // POST: Tiquetes/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que quiere enlazarse. Para obtener 
        // más detalles, vea https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Titulo,Descripcion,FechaCreacion,estado,clienteId,categoriaId")] Tiquete tiquete)
        {
            if (ModelState.IsValid)
            {
                db.Entry(tiquete).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.categoriaId = new SelectList(db.Categorias, "Id", "Nombre", tiquete.categoriaId);
            ViewBag.clienteId = new SelectList(db.Clientes, "Id", "NombreCompleto", tiquete.clienteId);
            return View(tiquete);
        }

        // GET: Tiquetes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Tiquete tiquete = db.Tiquetes.Find(id);
            if (tiquete == null)
            {
                return HttpNotFound();
            }
            return View(tiquete);
        }

        // POST: Tiquetes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Tiquete tiquete = db.Tiquetes.Find(id);
            db.Tiquetes.Remove(tiquete);
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
