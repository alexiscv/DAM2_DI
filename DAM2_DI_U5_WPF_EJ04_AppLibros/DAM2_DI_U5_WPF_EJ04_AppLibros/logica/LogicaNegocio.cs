using DAM2_DI_U5_WPF_EJ04_AppLibros.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_WPF_EJ04_AppLibros.logica
{
    public class LogicaNegocio
    {
        // Attributos
        public ObservableCollection<Libro> listaLibros { get; set; }

        // Constructor
        public LogicaNegocio()
        {
            listaLibros = new ObservableCollection<Libro>();
            listaLibros.Add( new Libro("Memorias de Idhun","Laura Gallego",DateTime.Now));
        }

        // Métodos
        public void addLibro(Libro libro)
        {
            listaLibros.Add(libro);
        }

        public void editLibro(Libro libro, int posicion)
        {

            listaLibros[posicion] = libro;

        }
    }
}
