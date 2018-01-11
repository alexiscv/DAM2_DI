using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ03_Persona
{
    class Program
    {
        static void Main(string[] args)
        {

            // Solicitamos los datos y los recogemos
            System.Console.WriteLine("Escriba su nombre");
            String nombre = System.Console.ReadLine();

            System.Console.WriteLine("Escriba sus apellidos");
            String apellidos = System.Console.ReadLine();

            System.Console.WriteLine("Escriba su edad");
            int edad = Convert.ToInt32(System.Console.ReadLine());

            // Creamos el objeto persona
            Persona p = new Persona(nombre, apellidos, edad);

            // Mostramos el nombre por pantalla
            System.Console.WriteLine("----");
            System.Console.WriteLine("Tu nombre es " + p.Nombre);
            System.Console.WriteLine("Tu Apellido es " + p.Apellidos);
            System.Console.WriteLine("Tu Edad es " + p.Edad);

            // Usando el método toString
            System.Console.WriteLine("Tu Edad es " + p.ToString());

            // Fin del programa
            System.Console.WriteLine("Pulsa una tecla para finalizar...");
            System.Console.ReadKey();

        }
    }
}
