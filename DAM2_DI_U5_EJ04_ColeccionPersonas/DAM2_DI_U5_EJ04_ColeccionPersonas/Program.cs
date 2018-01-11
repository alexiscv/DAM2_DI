using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ04_ColeccionPersonas
{
    class Program
    {

        static void mostrarMenu()
        {

            System.Console.WriteLine("-- MENU --");
            System.Console.WriteLine("1) Añadir una persona");
            System.Console.WriteLine("2) Borrar una persona");
            System.Console.WriteLine("3) Listar personas");
            System.Console.WriteLine("4) Ordenar personas");
            System.Console.WriteLine("5) Guardar y salir");
            System.Console.WriteLine("---");
            System.Console.WriteLine("¿Que opcion desea ejecutar?");
            System.Console.WriteLine(" ");

        }

        static void Main(string[] args)
        {

            // Ejecutaremos la aplicación en bucle hasta que el usuario quiera guardar y salir.
            bool cerrar = false;

            while (!cerrar)
            {
                // Mostramos el menú
                mostrarMenu();

                // Capturamos la respuesta del usuario
                int op = Convert.ToInt32(System.Console.ReadLine());

                // Recogemos la opción seleccionada
                // Si es válida la ejecutamos y volvemos al comienzo del bucle
                // o cerramos la aplicación
                switch (op)
                {
                    case 1:
                        // Añadir una persona
                        Logica.addPersona();
                        break;

                    case 2:
                        // Eliminar una persona
                        Logica.delPersona();
                        break;

                    case 3:
                        // Listar personas
                        Logica.listarPersonas();
                        break;

                    case 4:
                        // Ordenar personas
                        Logica.ordenarLista();
                        break;

                    case 5:
                        // Guardar y salir
                        System.Console.WriteLine(".. Guardando datos");
                        System.Console.WriteLine(".. Cerrando");
                        cerrar = true;
                        break;

                    default:
                        System.Console.WriteLine("Ups: Opción desconocida...");
                        break;
                }

            }

        }
    }
}
