using DAM2_DI_U5_EJ_Agenda.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_Agenda.logica
{
    public class Logica
    {
        // Colección que usaremos para carar TODAS las tareas
        public ObservableCollection<Tarea> listaTareas { get; set; }

        // Colección para las tareas de una determinada fecha
        public ObservableCollection<Tarea> tareasFecha { get; set; }

        // Constructor
        public Logica(){

            listaTareas = new ObservableCollection<Tarea>();
            tareasFecha = new ObservableCollection<Tarea>();

            // Creamos unas entradas de pruebas
            listaTareas.Add(new Tarea("Examen PSP", new DateTime(2018, 02, 24), "Ejercicios pendientes de la asignatura PSP.", "Sotrondio"));
            listaTareas.Add(new Tarea("Examen SGE", new DateTime(2018, 02, 25), "Ejercicios pendientes de la asignatura SGE para el Martes.", "Sotrondio"));
            listaTareas.Add(new Tarea("Examen EIE", new DateTime(2018, 02, 26), "Hacer examen de la primera evaluación de PSP.", "Sotrondio"));

        }

        /**
         * Añadir una tarea nueva
         */
        public void addTarea(Tarea tarea)
        {
            listaTareas.Add(tarea);
        }

        /**
         * Modificar una tarea
         */
        public void modTarea(Tarea tarea, int posicion)
        {

            // Recuperamos la tarea que seleccionamos para editar mediante su posición
            Tarea tareaAEditar = tareasFecha[posicion];

            // Buscamos y modificamos la tarea de la listaTareas
            for (int i = 0; i < listaTareas.Count; i++)
            {
                // Comparamos la tarea antes de ser modificada con la tarea de la ListaTareas
                if (listaTareas.ElementAt(i).Fecha.Equals(tareaAEditar.Fecha) && listaTareas.ElementAt(i).Nombre.Equals(tareaAEditar.Nombre))
                {
                    // Sobreescribimos la tarea de la listaTareas
                    // con los datos actualizados mediante el formulario
                    listaTareas[i] = tarea;
                    Console.WriteLine("MOD. " + tarea.Nombre);
                }
                else
                {
                    Console.WriteLine("NO COINCIDE");
                }
            }

            // Ahora actualizamos las tareas de la lista tareasFecha
            cargarTareas(tarea.Fecha);
        }

        /**
         * Eliminar una tarea
         */
        public void delTarea(Tarea tarea)
        {

            // Buscamos y eliminamos la tarea de la listaTareas
            for (int i = 0; i < listaTareas.Count; i++)
            {
                if (listaTareas.ElementAt(i).Fecha.Equals(tarea.Fecha) && listaTareas.ElementAt(i).Nombre.Equals(tarea.Nombre))
                {
                    listaTareas.RemoveAt(i);                    
                }
            }

            // Ahora actualizamos las tareas de la lista tareasFecha
            cargarTareas(tarea.Fecha);
        }

        /**
         * Cargar las tareas que hay para una fecha determinada
         */
        public void cargarTareas(DateTime fecha)
        {
            
            // Reseteamos la lista
            tareasFecha.Clear();

            // Recorremos TODAS las tareas
            foreach (Tarea tarea in listaTareas)
            {
                // Y añadimos las que coinciden con la fecha seleccionada
                // Gracias al binding del DataGrid, se cogeran automáticamente de la colección
                // Y así al cambiar una fecha en el calendario, se verán las tareas en el DataGrid
                if( tarea.Fecha.Equals(fecha) ){
                    tareasFecha.Add(tarea);
                    //Console.WriteLine("cargarTareas --> " + tarea.Nombre);
                }

            }          

        }
    }
}
