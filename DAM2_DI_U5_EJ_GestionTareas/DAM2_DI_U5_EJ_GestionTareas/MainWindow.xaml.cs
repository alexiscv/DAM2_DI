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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DAM2_DI_U5_EJ_GestionTareas
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        // Atributos
        private Logica logica;

        public MainWindow()
        {
            InitializeComponent();

            // Instanciamos la clase LogicaNegocio para poder usar sus métodos
            logica = new Logica();

            // Especificamos que los datos de la tabla
            // estan en la "logica". En el archivo xaml cuando hagamos el
            // binding especificaremos en que parte de la logica se encuentran los datos
            // en nuestro caso actual será el collection
            DataGridTareas.DataContext = logica;

        }

        private void botonNuevo_Click(object sender, RoutedEventArgs e)
        {
            DialogoTarea dialogoTarea = new DialogoTarea(logica);
            dialogoTarea.Show();
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            // Si hay un elemento seleccionado
            if( DataGridTareas.SelectedIndex != -1)
            {
                // Recogemos el valor seleccionado
                Tarea tarea = (Tarea)DataGridTareas.SelectedItem;
                int posicion = DataGridTareas.SelectedIndex;

                // Instanciamos el dialogo, pasandole los valores
                DialogoTarea dialogoTarea = new DialogoTarea(logica, (Tarea)tarea.Clone(), posicion);
                dialogoTarea.Show();
            }
        }

        private void DataGridTareas_EditarTarea(object sender, RoutedEventArgs e)
        {
            // Si hay un elemento seleccionado
            if (DataGridTareas.SelectedIndex != -1)
            {
                // Recogemos el valor seleccionado
                Tarea tarea = (Tarea)DataGridTareas.SelectedItem;
                int posicion = DataGridTareas.SelectedIndex;

                // Instanciamos el dialogo, pasandole los valores
                DialogoTarea dialogoTarea = new DialogoTarea(logica, (Tarea)tarea.Clone(), posicion);
                dialogoTarea.Show();
            }
        }
    }
}
