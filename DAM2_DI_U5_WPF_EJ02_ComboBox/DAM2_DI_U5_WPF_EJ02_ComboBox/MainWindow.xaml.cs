using DAM2_DI_U5_WPF_EJ02_ComboBox.dto;
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

namespace DAM2_DI_U5_WPF_EJ02_ComboBox
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            List<Persona> listaPersonas = new List<Persona>();
            listaPersonas.Add(new Persona("Alexis", "Castaño"));
            listaPersonas.Add(new Persona("Marta", "Rasines"));

            foreach (Persona persona in listaPersonas)
            {

                // Para rellenar el comboBox
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = persona;
                comboBoxPersonas.Items.Add(cbi);

                // Para rellenar la lista
                ListBoxItem lbi = new ListBoxItem();
                lbi.Content = persona;
                ListPersonas.Items.Add(lbi);

            }

        }

        private void comboBoxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBoxItem cbi = (ComboBoxItem)comboBoxPersonas.SelectedItem;
            Persona persona = (Persona)cbi.Content;
            labelNombre.Content = persona.Nombre;
            labelApellido.Content = persona.Apellidos;
        }

        private void ListPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ListBoxItem lbi = (ListBoxItem)ListPersonas.SelectedItem;
            Persona persona = (Persona)lbi.Content;
            labelNombre.Content = persona.Nombre;
            labelApellido.Content = persona.Apellidos;
        }

        
    }
}
