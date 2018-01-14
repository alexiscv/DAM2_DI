using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_ColeccionesConsola.logica
{
    public static class Logica
    {

        // Atributos
        private static Dictionary<string, string> diccionario = new Dictionary<string, string>();

        // Métodos
        public static void addTermino()
        {
            // Donde almacenaremos la clave/valor
            String clave = "";
            String valor = "";

            // Solitamos la clave y el valor
            Console.WriteLine("Introduce una clave para el término:");
            clave = Console.ReadLine();

            Console.WriteLine("Introduce la definición para el término:");
            valor = Console.ReadLine();

            // Intentamos añadir
            // Comprobando que no exista ya la clave en la coleccion
            if( !clave.Equals("") && !valor.Equals("") )
            {
                try
                {
                    diccionario.Add(clave, valor);
                }
                catch (ArgumentException)
                {
                    Console.WriteLine("Ya existe un elemento con la clave = \"clave\".");
                }
            }
            else{
                Console.WriteLine("Error: Ni la clave ni el valor pueden estar vacios. Vuelva a intentar añadir el termino.");
            }

        }

        public static void buscarDefinicion()
        {

            // Donde almacenaremos la clave/valor
            String clave = "";
            String valor = "";

            // Solitamos la clave para poder buscar el valor
            Console.WriteLine("¿Qué palabra desea buscar?:");
            clave = Console.ReadLine();

            // Buscamos el valor
            if (diccionario.TryGetValue(clave, out valor))
            {
                Console.WriteLine("--> La definición de: \"{0}\", es = {1}.", clave, valor);
            }
            else
            {
                Console.WriteLine("Ups: La Clave \"{0}\" no ha sido encontrada.", clave);
            }

        }

        public static void listarDefiniciones()
        {

            foreach (KeyValuePair<string, string> termino in diccionario)
            {

                Console.WriteLine("--> Clave = {0}, Valor = {1}", termino.Key, termino.Value);
                
            }

        }

        public static void mostrarMenu()
        {
            Console.WriteLine("");
            Console.WriteLine("#### MENU ####");
            Console.WriteLine("1) Añadir un termino al diccionario");
            Console.WriteLine("2) Buscar un termino");
            Console.WriteLine("3) Enumerar terminos");
            Console.WriteLine("4) Salir");
            Console.WriteLine("");
        }

    }
}
