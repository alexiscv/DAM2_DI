using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM_DI_U5_HolaMundo
{
    class Program
    {
        static void Main(string[] args)
        {
            String hola = "Hola";
            String mundo = "mundo";
            System.Console.WriteLine("Esto es un {0} {1} con variables!", hola, mundo);

            // Keep the console window open in debug mode.
            System.Console.WriteLine("Press any key to exit.");
            System.Console.ReadKey();
        }
    }
}
