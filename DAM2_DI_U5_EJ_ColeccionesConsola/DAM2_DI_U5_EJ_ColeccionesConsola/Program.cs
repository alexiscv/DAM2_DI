using DAM2_DI_U5_EJ_ColeccionesConsola.logica;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_ColeccionesConsola
{
    class Program
    {
        static void Main(string[] args)
        {

            bool salir = false;

            // Mostrar menú
            while (!salir)
            {

                // Mostramos el menú
                Logica.mostrarMenu();

                // Capturamos y ejecutamos la opción elegida
                int op = Convert.ToInt32(System.Console.ReadLine());

                switch (op)
                {
                    case 1:
                        Logica.addTermino();
                        break;

                    case 2:
                        Logica.buscarDefinicion();
                        break;

                    case 3:
                        Logica.listarDefiniciones();
                        break;

                    case 4:
                        salir = true;
                        break;

                    default:
                        break;
                }

            }

        }
    }
}
