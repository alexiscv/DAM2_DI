using DAM2_DI_U5_EJ_Examen.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_Examen.logica
{
    public class Logica
    {

        public ObservableCollection<Persona> listaPersonas { get; set; }
        public Persona personaSeleccionada { get; set; }

        // Constructor
        public Logica()
        {
            listaPersonas = new ObservableCollection<Persona>();
            listaPersonas.Add(new Persona("Alexis", "Castaño Verdes"));
            listaPersonas.Add(new Persona("Marta", "Rasines"));
        }

        // Métodos
        public void addLibro(Persona p)
        {
            listaPersonas.Add(p);
        }

        public void entrar()
        {
            personaSeleccionada.Dentro = true;
        }

        public void salir()
        {
            personaSeleccionada.Dentro = false;
        }


    }
}
