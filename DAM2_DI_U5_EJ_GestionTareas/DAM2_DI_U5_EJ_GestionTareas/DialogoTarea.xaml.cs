using DAM2_DI_U5_EJ_GestionTareas.dto;
using DAM2_DI_U5_EJ_GestionTareas.logica;
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

namespace DAM2_DI_U5_EJ_GestionTareas
{
    /// <summary>
    /// Interaction logic for DialogoTarea.xaml
    /// </summary>
    public partial class DialogoTarea : Window
    {

        // Atributos
        private Logica logica;
        private Tarea tarea;
        private int posicion;
        private Boolean modificar;
        private int errores = 0;

        public DialogoTarea(Logica logica)
        {
            InitializeComponent();
            this.logica = logica;

            modificar = false;

            // Para la creación de Tareas
            tarea = new Tarea();
            DataContext = tarea;

        }

        public DialogoTarea(Logica logica, Tarea tareaModificar, int posicion)
        {
            InitializeComponent();
            this.logica = logica;

            modificar = true;

            // Para la modificación de Tareas
            this.tarea = tareaModificar;
            this.posicion = posicion;
            DataContext = tarea;

        }

        private void BotonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BotonAceptar_Click(object sender, RoutedEventArgs e)
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

        private void validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else
                errores--;

            if (errores == 0)
                BotonAceptar.IsEnabled = true;
            else
                BotonAceptar.IsEnabled = false;
        }
    }
}
