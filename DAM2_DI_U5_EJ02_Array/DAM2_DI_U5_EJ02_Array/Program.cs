using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ02_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            // Números que vamos a pedir por pantalla
            int totalNumeros = 5;

            // Creamos un array para almacenar los números
            int[] numeros = new int[totalNumeros];

            // Aquí almacenaremos el valor de la suma de los números introducidos
            int suma = 0;

            // Solicitamos los números n veces
            for (int i = 0; i < totalNumeros; i++)
            {
                // Solicitamos..
                System.Console.WriteLine("Escribe un número");

                // .. Y añadimos al array
                numeros[i] = Convert.ToInt32(System.Console.ReadLine());
                
            }

            // Recorremos el array para calcular la suma de los valores recogidos
            foreach (var numero in numeros)
            {
                suma = suma + numero;
            }

            // Mostramos la suma
            System.Console.WriteLine("La suma de los números es: {0}", suma);
            
            System.Console.WriteLine("Pulsa una tecla para finalizar...");
            System.Console.ReadKey();            

        }
    }
}
