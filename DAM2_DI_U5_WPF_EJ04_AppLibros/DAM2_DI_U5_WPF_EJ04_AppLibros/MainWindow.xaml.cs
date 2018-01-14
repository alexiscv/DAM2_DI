using DAM2_DI_U5_WPF_EJ04_AppLibros.dto;
using DAM2_DI_U5_WPF_EJ04_AppLibros.logica;
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

namespace DAM2_DI_U5_WPF_EJ04_AppLibros
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        // Atributos
        private LogicaNegocio logicaNegocio;

        public MainWindow()
        {
            InitializeComponent();
            // Instanciamos la clase LogicaNegocio para poder usar sus métodos
            logicaNegocio = new LogicaNegocio();

            // Especificamos que los datos de la tabla
            // estan en logicaNegocio, en el archivo xaml cuando hagamos el
            // binding especificaremos en que parte de la logica se encuentran los datos
            // en nuestro caso actual será listaLibros
            dataGridLibros.DataContext = logicaNegocio;
            
        }

        private void MenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            // Al crear el dialogo, le pasamos el obj. logicaNegocio para poder
            // usar desde ese dialogo los métodos de la lógica.
            DialogoLibro dialogoLibro = new DialogoLibro(logicaNegocio);
            dialogoLibro.Show();
        }

        private void botonModificar_Click(object sender, RoutedEventArgs e)
        {
            // Comprobamos que hay un libro seleccionado
            if( dataGridLibros.SelectedIndex != -1 )
            {
                // Recuperamos el libro seleccionado
                Libro libroSeleccionado = (Libro)dataGridLibros.SelectedItem;

                // Instanciamos el dialogo
                // Al instanciar pasamos una copia del obj. libro, la cual hay que castear porque Clone devuelve un obj. de tipo Object
                // Esto se hace porque al estar todo enlazado con bindigs, la modificación sería en tiempo real y no podriamos cancelar la operación
                DialogoLibro dialogoLibro = new DialogoLibro(logicaNegocio, (Libro)libroSeleccionado.Clone(), dataGridLibros.SelectedIndex);

                // Mostramos la ventana
                dialogoLibro.Show();

            }
        }
    }
}
