﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ04_ColeccionPersonas
{
    public static class Logica
    {
        
        // Lista de personas
        static List<Persona> listaPersonas = new List<Persona>();

        // Lista de Personas
        public static void listarPersonas(){

            System.Console.WriteLine(" ## LISTADO ## ");

            // Mostrar la lista de personas
            listaPersonas.ForEach(Console.WriteLine);

            System.Console.WriteLine(" ");

        }


        // Añadir una persona a la lista
        public static void addPersona()
        {

            // Solicitamos los datos
            System.Console.WriteLine("Escriba su nombre, apellidos y edad..");

            // Recogemos los datos
            String nombre = System.Console.ReadLine();
            String apellidos = System.Console.ReadLine();
            int edad = Convert.ToInt32(System.Console.ReadLine());

            // Almacenamos la persona
            listaPersonas.Add(new Persona(nombre, apellidos, edad));

            // Notificamos
            System.Console.WriteLine("--> "+ nombre + " ha sido añadido correctamente.");
            System.Console.WriteLine(" ");

        }

        // Borrar una persona de la lista
        public static void delPersona()
        {

            // Solicitamos los datos
            Console.WriteLine("¿Cual de estas personas desea eliminar?");

            // Mostramos los registros
            int i = 0;
            foreach (Persona persona in listaPersonas)
            {

                Console.WriteLine(i+") "+persona.ToString());
                i++;

            }

            // Recogemos la opción seleccionada
            int id = Convert.ToInt32(Console.ReadLine());

            // Eliminamos la persona
            listaPersonas.RemoveAt(id);

            // Notificamos
            Console.WriteLine("--> Registro eliminado correctamente.");
            Console.WriteLine(" ");

        }

        // Ordenar lista
        public static void ordenarLista()
        {

            // Ordenamos
            IEnumerable<Persona> listaOrdenada = listaPersonas.OrderBy(p => p.Nombre);

            // Guardamos en una lista temporal
            List<Persona> listaTemporal = new List<Persona>();

            foreach (Persona persona in listaOrdenada)
            {

                listaTemporal.Add(persona);

            }

            // Sobreescribimos la lista principal
            listaPersonas.Clear();
            listaPersonas = listaTemporal;

            // Notificamos
            Console.WriteLine("--> Listado ordenado correctamente.");
            Console.WriteLine(" ");

        }

        // Guardar Datos
        public static void guardarDatos()
        {

            // Para mas info: 
            // https://docs.microsoft.com/es-es/dotnet/csharp/programming-guide/concepts/serialization/how-to-write-object-data-to-an-xml-file
            // Documentación oficial de MS.

            System.Xml.Serialization.XmlSerializer writer = new System.Xml.Serialization.XmlSerializer(typeof(List<Persona>));
            var path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//listadoPersonas.xml";
            System.IO.FileStream file = System.IO.File.Create(path);

            // Añadimos las personas
            writer.Serialize(file, listaPersonas);

            // Cerramos el fichero
            file.Close();

            // Notificamos
            Console.WriteLine("--> Datos guardados correctamente.");
            Console.WriteLine(" ");

        }

        // Guardar Datos
        public static void cargarDatos()
        {

            String f = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//listadoPersonas.xml";

            if (File.Exists(f))
            {
                // Para mas info: 
                // https://docs.microsoft.com/es-es/dotnet/csharp/programming-guide/concepts/serialization/how-to-write-object-data-to-an-xml-file
                // Documentación oficial de MS.

                // Now we can read the serialized book ...  
                System.Xml.Serialization.XmlSerializer reader = new System.Xml.Serialization.XmlSerializer(typeof(List<Persona>));
                System.IO.StreamReader file = new System.IO.StreamReader(f);
                listaPersonas = (List<Persona>)reader.Deserialize(file);
                file.Close();

                // Notificamos
                Console.WriteLine("--> Datos cargados correctamente.");
                Console.WriteLine(" ");
            }
            else
            {
                Console.WriteLine("-- No hay información que recuperar --");
            }

        }


    }
}
