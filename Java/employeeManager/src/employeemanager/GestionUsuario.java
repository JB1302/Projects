

package employeemanager;
import javax.swing.JOptionPane;
/**
 *
 * @author jstev
 */
public class GestionUsuario {
    
    private Empleado[] listaEmpleados = new Empleado[5];
    private int contadorEmpleados = 0;
    
    //Metodo para agregar al Empleado
    public void agregarEmpleado(Empleado nombre){
        //Si contador de empleados es menor que los espacios en Lista empleados, entonces
        if (this.contadorEmpleados < this.listaEmpleados.length){
            //Almacenar el valor ingresado en el arreglo
            this.listaEmpleados[this.contadorEmpleados] = nombre;
            //aumentar el contador en 1
            ++this.contadorEmpleados;
            //Mensaje en caso de que se agregue con exito
            JOptionPane.showMessageDialog(null, "Se ha agregado el Empleado");
      } else {
            //mensaje en caso de que no tenga espacio
            JOptionPane.showMessageDialog(null, "No se puede agregar mas Empleados, el equipo esta lleno");
        }
    }
    
    public void agregarEdad(Empleado edad){
        //Si contador de empleados es menor que los espacios en Lista empleados, entonces
        if (this.contadorEmpleados < this.listaEmpleados.length){
            //Almacenar el valor ingresado en el arreglo
            this.listaEmpleados[this.contadorEmpleados] = edad;
            //aumentar el contador en 1
            ++this.contadorEmpleados;
            //Mensaje en caso de que se agregue con exito
            JOptionPane.showMessageDialog(null, "Se ha agregado la edad del empleado");
      } else {
            //mensaje en caso de que no tenga espacio
            JOptionPane.showMessageDialog(null, "No se puede agregar mas Empleados, el equipo esta lleno");
        }
    }
    
    public void agregarDepartamento(Empleado departamento){
        //Si contador de empleados es menor que los espacios en Lista empleados, entonces
        if (this.contadorEmpleados < this.listaEmpleados.length){
            //Almacenar el valor ingresado en el arreglo
            this.listaEmpleados[this.contadorEmpleados] = departamento;
            //aumentar el contador en 1
            ++this.contadorEmpleados;
            //Mensaje en caso de que se agregue con exito
            JOptionPane.showMessageDialog(null, "Se ha agregado el departamento del empleado");
      } else {
            //mensaje en caso de que no tenga espacio
            JOptionPane.showMessageDialog(null, "No se puede agregar mas Empleados, el equipo esta lleno");
        }
    }
    
    public void agregarSalario(Empleado Salario){
        //Si contador de empleados es menor que los espacios en Lista empleados, entonces
        if (this.contadorEmpleados < this.listaEmpleados.length){
            //Almacenar el valor ingresado en el arreglo
            this.listaEmpleados[this.contadorEmpleados] = Salario;
            //aumentar el contador en 1
            ++this.contadorEmpleados;
            //Mensaje en caso de que se agregue con exito
            JOptionPane.showMessageDialog(null, "Se ha agregado el salario del empleado");
      } else {
            //mensaje en caso de que no tenga espacio
            JOptionPane.showMessageDialog(null, "No se puede agregar mas Empleados, el equipo esta lleno");
        }
    }
    
    public double salarioPromedio(){
        //En caso de no tener a nadie en el arreglo
        if(this.contadorEmpleados == 0){
            //Mostrar 0
            return 0.0;
        //Si encontramos mas de 1    
        }else{
        //Establecemos nuestra variable
        double allSalary = 0.0;
            //El codigo correra cuando el contador sea menor que 1
            for(int i=0; i < this.contadorEmpleados; ++i){
                //Asignaremos el valor de todos los salarios a la variable
                allSalary += this.listaEmpleados[i].getSalario();
            }
        //Todos los salarios sumados seran divididos entre la cantidad de personas
         double promedio = allSalary / (double)this.contadorEmpleados;
         //Regresamos el resultado
         return promedio;
        }
        
        
    }
    
   public Empleado menorSalario(){
       //Definimos esto como el valor mas pequeño que no sea 0
       double menorSalario = Double.MAX_VALUE;
       //Definimos la varriable que tendra nuestra data
       Empleado peorSalario = null;
       //El codigo correra cuando el contador sea menor que 1
       for(int i = 0; i < this.contadorEmpleados; i++){
           //Mientras el arreglo sea diferente a null y el salario menor
           if(this.listaEmpleados[i] != null && this.listaEmpleados[i].getSalario() < menorSalario){
               //Guardar la nota en el perfil del Empleado
               menorSalario = this.listaEmpleados[i].getSalario();
               //Gurdar la nota para el return
               peorSalario = this.listaEmpleados[i];
           }
       }
       //Regresar el salario mas Bajo
       return peorSalario;
   }
   
   public Empleado mayorSalario(){
       //Definimos esto como el valor mas pequeño que no sea 0
       double menorSalario = Double.MIN_VALUE;
       //Definimos la varriable que tendra nuestra data
       Empleado peorSalario = null;
       //El codigo correra cuando el contador sea menor que 1
       for(int i = 0; i < this.contadorEmpleados; i++){
           //Mientras el arreglo sea diferente a null y el salario mayor
           if(this.listaEmpleados[i] != null && this.listaEmpleados[i].getSalario() > menorSalario){
               //Guardar la nota en el perfil del Empleado
               menorSalario = this.listaEmpleados[i].getSalario();
               //Gurdar la nota para el return
               peorSalario = this.listaEmpleados[i];
           }
       }
       //Regresar el salario mas Bajo
       return peorSalario;
   }
    
    public Empleado nameSearch(String nombre){
        //Repetir por la cantidad de empleados
        for(int i=0; i < this.contadorEmpleados; i++){
            //Verificar si el input esta bien
            if(this.listaEmpleados[i] != null && this.listaEmpleados[i].getNombre().equals(nombre)){
                //Devolver el empleado
                return this.listaEmpleados[i];
            }
        }
        //Regresar que no hay match
        return null;
    }
    
    public void showAll() {
    // Verificar si hay empleados registrados
    if (this.contadorEmpleados == 0) {
        JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
    } else {
        String allEmployeesDetails = "";
        // Recorrer todos los empleados y concatenar los detalles de cada uno
        for (int i = 0; i < this.contadorEmpleados; i++) {
            Empleado empleado = this.listaEmpleados[i];
            allEmployeesDetails += "Nombre: " + empleado.getNombre() + "\n";
            allEmployeesDetails += "Edad: " + empleado.getEdad() + "\n";
            allEmployeesDetails += "Departamento: " + empleado.getDepartamento() + "\n";
            allEmployeesDetails += "Salario: " + empleado.getSalario() + "\n\n";
        }
        // Mostrar todos los detalles de los empleados
        JOptionPane.showMessageDialog(null, allEmployeesDetails);
    }
}

    
    
}
