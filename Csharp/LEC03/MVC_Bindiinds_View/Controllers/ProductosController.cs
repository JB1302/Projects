using MVC_Bindiinds_View.Models.Repository;
using MVC_Bindiinds_View.Models.ViewModel;
using System.Web.Mvc;


namespace MVC_Bindiinds_View.Controllers
{
    // Controlador para gestionar productos
    [RoutePrefix("Products")]
    public class ProductosController : Controller

    {
        //Repositorio de productos
        private static readonly IProductRepository _repo = new InMemoryProductRepository();

        //Cuando se accede a /Products sin accion
        //Devuelve el index con todos los productos
        [Route("")]
        public ActionResult Index()
        {
            return View(_repo.GetAllProducts());
        }

        [Route("Details/{id:int:min(1)}")]
        public ActionResult Details(int id, bool compact = false)
        {
            var product = _repo.Find(id);
            if (product == null)
            {
                return HttpNotFound();
            }

            //Si es True devuelve Compact y si es falso devuelve detallado
            return View(compact ? "Compact" :"Details", product);
        }

        //GET: Products/Crear
        [Route("Crear")]

        //Muestra el formulario para crear un nuevo producto
        public ActionResult Create()
        {
            return View();
        }

        //POST: Products/Crear
        [HttpPost, ValidateAntiForgeryToken, Route("Crear")]
        public ActionResult Create(ProductoViewModels productVM)
        {
            //Si no se cumple la validacion, se devuelve la vista con el modelo actual
            if (!ModelState.IsValid)
            {
                return View(productVM);
            }

            //Agregar el nuevo producto al repositorio
            _repo.Add(productVM);
            return RedirectToAction("Index");
        }
    }
}