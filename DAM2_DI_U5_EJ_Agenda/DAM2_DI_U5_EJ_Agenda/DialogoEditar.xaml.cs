using DAM2_DI_U5_EJ_Agenda.dto;
using DAM2_DI_U5_EJ_Agenda.logica;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace DAM2_DI_U5_EJ_Agenda
{
    /// <summary>
    /// Interaction logic for DialogoEditar.xaml
    /// </summary>
    public partial class DialogoEditar : Window
    {
        // Atributos
        private Logica logica;
        private Tarea tarea;
        private int posicion;
        private Boolean modificar;

        /**
         * Constructor para añadir
         */
        public DialogoEditar(Logica logica)
        {
            InitializeComponent();

            this.logica = logica;

            modificar = false;

            // Para la creación de Tareas
            tarea = new Tarea();
            // Especificamos la fecha de hoy, para que no empiece en 2001
            tarea.Fecha = DateTime.Now;
            // Especificamos el DataContext para que funcionen los bindings
            DataContext = tarea;

        }

        /**
         * Constructor para editar o eliminar
         */
        public DialogoEditar(Logica logica, Tarea tareaModificar, int posicion)
        {
            InitializeComponent();
            this.logica = logica;

            modificar = true;

            // Para la modificación de Tareas
            this.tarea = tareaModificar;
            this.posicion = posicion;
            DataContext = tarea;

        }


        /**
         * Al pulsar en GUARDAR
         */
        private void botonGuardar_Click(object sender, RoutedEventArgs e)
        {

            if (!modificar)
            {
                // Añadimos
                logica.addTarea(tarea);
            }
            else
            {
                // Modificamos
                logica.modTarea(tarea, posicion);
            }

            this.Close();

        }

        /**
         * Al pulsar en eliminar
         */
        private void botonEliminar_Click(object sender, RoutedEventArgs e)
        {
            logica.delTarea(tarea);
            this.Close();
        }
    }
}
