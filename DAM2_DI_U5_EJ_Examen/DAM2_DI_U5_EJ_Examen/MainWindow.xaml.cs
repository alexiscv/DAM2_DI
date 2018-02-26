using DAM2_DI_U5_EJ_Examen.dto;
using DAM2_DI_U5_EJ_Examen.logica;
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

namespace DAM2_DI_U5_EJ_Examen
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
            this.DataContext = logica;

        }

        /**
         * Abrir dialogo de nueva Persona
         */
        private void menu_NuevaPersona(object sender, RoutedEventArgs e)
        {

        }

        /**
         * Una persona Entra
         */
        private void botonEntrar_Click(object sender, RoutedEventArgs e)
        {
            logica.entrar();

        }    

        private void botonSalir_Click(object sender, RoutedEventArgs e)
        {
            logica.salir();
        }
    }
}
