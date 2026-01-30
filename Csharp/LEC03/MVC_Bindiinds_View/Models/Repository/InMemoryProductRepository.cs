using MVC_Bindiinds_View.Models.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;

namespace MVC_Bindiinds_View.Models.Repository
{
    public interface IProductRepository
    {
        //Devolver la lista de productos
        IEnumerable<Producto> GetAllProducts();

        //Encontrar Producto por ID
        Producto Find(int id);

        //Agregar un nuevo DTO a la lista
        void Add(ProductoViewModels productoVM);
    }

    public class InMemoryProductRepository : IProductRepository
    {

        private static readonly List<Producto> _store = new List<Producto>()
        {
            new Producto(){id=1, Nombre="Teclado", precio=570000, ReleaseDate = DateTime.Today},
            new Producto(){id=2, Nombre="Mouse", precio=150000, ReleaseDate = DateTime.Today},
            new Producto(){id=3, Nombre="Monitor", precio=1250000, ReleaseDate = DateTime.Today},
            new Producto(){id=4, Nombre="CPU", precio=2250000, ReleaseDate = DateTime.Today},
        };


        //Agregar un nuevo DTO a la lista
        public void Add(ProductoViewModels productoVM)
        {
            // Obtener el siguiente ID disponible
            var nextId = _store.Max(p => p.id) + 1;

            // Mapear ProductoViewModels a Producto y agregarlo a la lista
            _store.Add(new Producto
            {
                id = nextId,
                Nombre = productoVM.Name,
                precio = productoVM.price,
                ReleaseDate = DateTime.Today
            }); 
        }

        //Encontrar Producto por ID
        public Producto Find(int id)
        {
            //Devolver el producto que coincida con el ID
            return _store.FirstOrDefault(p => p.id == id);
        }

        //Devolver la lista de productos
        public IEnumerable<Producto> GetAllProducts()
        {
            return _store;
        }
    }
}