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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DAM2_DI_U5_EJ_Agenda
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

            // Pintamos los días
            pintarDias();
        }

        /**
         * Pintar dias
         */
        public void pintarDias()
        {
            foreach (Tarea tarea in logica.listaTareas)
            {
               calendario.SelectedDates.Add(tarea.Fecha); 
            }            
        }

        /**
         * Método que se ejecuta cuando seleccionamos una fecha
         * Mirar llamada en el XAML
         */
        public void actualizarTareas(object sender, SelectionChangedEventArgs e)
        {
            // Tomamos la fecha seleccionada en el calendario
            DateTime fecha = (DateTime)calendario.SelectedDate;

            // Llamamos al método que cargará, el listado de dateas en el DataGrid
            // Para ello le pasamos la fecha seleccionada
            logica.cargarTareas(fecha);

        }

        public void abrirEditarEliminar(object sender, RoutedEventArgs e)
        {
            // Si hay un elemento seleccionado
            if (DataGridTareas.SelectedIndex != -1)
            {
                // Recogemos el valor seleccionado
                Tarea tarea = (Tarea)DataGridTareas.SelectedItem;
                int posicion = DataGridTareas.SelectedIndex;

                // Instanciamos el dialogo, pasandole los valores
                DialogoEditar dialogoEditar = new DialogoEditar(logica, (Tarea)tarea.Clone(), posicion);
                dialogoEditar.Show();
            }
        }

        /**
         * Para añadir una nueva tarea
         */
        private void botonNuevo_Click(object sender, RoutedEventArgs e)
        {
            // Instanciamos el dialogo, usando el constructor adecuado
            DialogoEditar dialogoEditar = new DialogoEditar(logica);

            // Mostramos el dialogo
            dialogoEditar.Show();        
        }
    }
}
