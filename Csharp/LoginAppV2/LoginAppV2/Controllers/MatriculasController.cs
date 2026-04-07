using LoginAppV2.Models;
using Microsoft.AspNet.Identity;
using System;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;

namespace LoginAppV2.Controllers
{
    [Authorize]
    public class MatriculasController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: Matriculas
        public ActionResult Index()
        {
            var matriculas = db.Matriculas
                .Include(m => m.Curso)
                .Include(m => m.Estudiante)
                .AsQueryable();

            if (!User.IsInRole("Admin"))
            {
                var userId = User.Identity.GetUserId();
                matriculas = matriculas.Where(m => m.ApplicationUserId == userId);
            }

            return View(matriculas.ToList());
        }

        // GET: Matriculas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);

            var matricula = db.Matriculas
                .Include(m => m.Curso)
                .Include(m => m.Estudiante)
                .FirstOrDefault(m => m.MatriculaId == id);

            if (matricula == null)
                return HttpNotFound();

            if (!User.IsInRole("Admin") && matricula.ApplicationUserId != User.Identity.GetUserId())
                return new HttpStatusCodeResult(HttpStatusCode.Forbidden);

            return View(matricula);
        }

        // GET: Matriculas/Create
        public ActionResult Create()
        {
            ViewBag.CursoId = new SelectList(db.Cursos.ToList(), "CursoId", "Nombre");
            return View();
        }

        // POST: Matriculas/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "CursoId,ApplicationUserId")] Matricula matricula)
        {
            if (!User.IsInRole("Admin"))
            {
                matricula.ApplicationUserId = User.Identity.GetUserId();
            }

            matricula.FechaMatricula = DateTime.Now;
            matricula.Estado = EstadoMatricula.EnRevision;

            ModelState.Remove("FechaMatricula");
            ModelState.Remove("Estado");
            ModelState.Remove("Estudiante");
            ModelState.Remove("Curso");

            if (ModelState.IsValid)
            {
                var usuarioExiste = db.Users.Any(u => u.Id == matricula.ApplicationUserId);

                if (!usuarioExiste)
                {
                    ModelState.AddModelError("ApplicationUserId", "El usuario indicado no existe.");
                }
                else
                {
                    db.Matriculas.Add(matricula);
                    db.SaveChanges();
                    return RedirectToAction("Index");
                }
            }

            ViewBag.CursoId = new SelectList(db.Cursos.ToList(), "CursoId", "Nombre", matricula.CursoId);
            return View(matricula);
        }

        // GET: Matriculas/Edit/5
        [Authorize(Roles = "Admin")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);

            var matricula = db.Matriculas
                .Include(m => m.Curso)
                .Include(m => m.Estudiante)
                .FirstOrDefault(m => m.MatriculaId == id);

            if (matricula == null)
                return HttpNotFound();

            return View(matricula);
        }

        // POST: Matriculas/Edit/5
        [HttpPost]
        [Authorize(Roles = "Admin")]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "MatriculaId,Estado")] Matricula model)
        {
            var matricula = db.Matriculas.Find(model.MatriculaId);

            if (matricula == null)
                return HttpNotFound();

            matricula.Estado = model.Estado;

            db.Entry(matricula).State = EntityState.Modified;
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