using MVC_Bindiinds_View.Models;
using System;
using System.Web.ModelBinding;



namespace MVC_Bindiinds_View.Binders
{
    public class DateRangeBinder : IModelBinder
    {
        // Implementación del método BindModel
        public bool BindModel(ModelBindingExecutionContext modelBindingExecutionContext, ModelBindingContext bindingContext)
        {
            // Obtener el valor del modelo desde el proveedor de valores
            var valueResult = bindingContext.ValueProvider.GetValue(bindingContext.ModelName);
            // Extraer el valor intentado
            var attemptedValue = valueResult == null ? null : valueResult.AttemptedValue;

            // Validar el valor intentado
            if (string.IsNullOrWhiteSpace(attemptedValue) || !attemptedValue.Contains("~"))
            {
                return false;
            }
            {
                return false; // No se pudo enlazar el modelo
            }

            // Dividir el valor intentado en partes
            var parts = attemptedValue.Split('~');
            DateTime from, to;

            // Intentar analizar las partes como fechas
            if (DateTime.TryParse(parts[0], out from) && DateTime.TryParse(parts[1], out to))
            {
                //return new DateRange(from, to);
                return true;
            }
            bindingContext.ModelState.AddModelError(
                bindingContext.ModelName,
                "El rango de fechas debe tener el formato 'yyyy-MM-dd ~ yyyy-MM-dd'."); 

        }
    }
}