using DAM2_DI_U5_EJ_GestionTareas.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_GestionTareas.logica
{
    public class Logica
    {

        public ObservableCollection<Tarea> listaTareas { get; set; }

        // Constructor
        public Logica(){

            listaTareas = new ObservableCollection<Tarea>();

            // Creamos unas tareas de pruebas
            listaTareas.Add(new Tarea("Ejercicios PSP", DateTime.Now, false, "Ejercicios pendientes de la asignatura PSP."));
            listaTareas.Add(new Tarea("Ejercicios SGE", DateTime.Now, false, "Ejercicios pendientes de la asignatura SGE para el Martes."));
            listaTareas.Add(new Tarea("Examen 1ª Eval PSP", DateTime.Now, true, "Hacer examen de la primera evaluación de PSP."));

        }

        public void addTarea( Tarea tarea )
        {
            listaTareas.Add(tarea);
        }

        public void modTarea(Tarea tarea, int posicion)
        {
            listaTareas[posicion] = tarea;
        }

    }
}
