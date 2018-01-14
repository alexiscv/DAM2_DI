using DAM2_DI_U5_WPF_EJ03_Bindings.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace DAM2_DI_U5_WPF_EJ03_Bindings
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        // Atributos
        public ObservableCollection<Persona> listaPersonas { get; set; }

        public MainWindow()
        {
            InitializeComponent();

            listaPersonas = new ObservableCollection<Persona>();
            listaPersonas.Add(new Persona("Alexis", "Castaño"));
            listaPersonas.Add(new Persona("Marta", "Rasines"));

            // Estamos diciendo que cuando hagamos una referencia desde
            // un binding, buscará dentro de this, este objeto, es decir, el main
            // entonces buscará dentro de ese objeto el atributo indicado,
            // en nuestro caso buscará listaPersonas dentro del Main
            this.DataContext = this;
        }

        private void botonNuevo_Click(object sender, RoutedEventArgs e)
        {
            listaPersonas.Add(new Persona("Nueva","Persona"));
        }

        private void botonEliminar_Click(object sender, RoutedEventArgs e)
        {
            listaPersonas.RemoveAt(0);
        }

        private void botonModificar_Click(object sender, RoutedEventArgs e)
        {
            // Para que esto funcione, hay que modificar el obj Persona
            // para que notifique al ser modificada
            listaPersonas.ElementAt(0).Nombre = "Gandalf";
        }

    }
}
