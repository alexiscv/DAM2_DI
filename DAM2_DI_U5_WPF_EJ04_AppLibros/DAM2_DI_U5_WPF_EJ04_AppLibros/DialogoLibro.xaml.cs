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
using System.Windows.Shapes;

namespace DAM2_DI_U5_WPF_EJ04_AppLibros
{
    /// <summary>
    /// Interaction logic for DialogoLibro.xaml
    /// </summary>
    public partial class DialogoLibro : Window
    {
        // Creamos un atributo LogicaNegocio
        // Para poder acceder a sus métodos
        private LogicaNegocio logicaNegocio;
        private Libro libro;
        private int posicion;
        private bool modificar;
        private int errores;

        // Declaramos en el constructor de este dialogo que vamos a recibir
        // un obj. LogicaNegocio cuando se crea la ventana desde el Main
        public DialogoLibro(LogicaNegocio logica)
        {
            InitializeComponent();
            this.logicaNegocio = logica;

            // Creamos un Obj. Libro al crear la ventana
            // Cuando creemos un libro, lo que haremos será
            // Rellenar los campos Nombre y Autor
            libro = new Libro();

            // Como contexto de este dialogo establecemos el Libro
            // Porque vamos a hacer los bindings contra el Libro
            this.DataContext = libro;

            // Establecemos que vamos a hacer un alta nueva
            modificar = false;

        }

        // Constructor para cuando queremos hacer una modificación
        public DialogoLibro(LogicaNegocio logica, Libro libro, int posicion)
        {
            InitializeComponent();
            this.logicaNegocio = logica;

            // Guardamos los datos decibidos en nuestro obj. Libro
            this.libro = libro;
            this.posicion = posicion;

            // Como contexto de este dialogo establecemos el Libro
            // Porque vamos a hacer los bindings contra el Libro
            this.DataContext = libro;

            // Establecemos que se trata de una modificación
            modificar = true;

        }

        private void botonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void botonAceptar_Click(object sender, RoutedEventArgs e)
        {

            if (!modificar)
            {
                // Creamos un nuevo libro
                // Con los bindings, los datos se habrán añadido al objeto libro
                // automáticamente
                logicaNegocio.addLibro(libro);
            }
            else
            {
                // Modificar
                logicaNegocio.editLibro(libro, posicion);
            }

            // Tras las operaciones, cerramos la ventana
            this.Close();
        }

        // Método para saber cuantos errores estamos detectando
        // Y así habilitar o deshabilitar el botón de aceptar
        private void validation_Error( object sender, ValidationErrorEventArgs e ) 
        {
            // Detectar errores
            if (e.Action == ValidationErrorEventAction.Added)
            { 
                errores++; 
            }
            else 
            { 
                errores--; 
            }

            // Habilitar / deshabilitar botón aceptar
            if (errores == 0)
            {
                botonAceptar.IsEnabled = true;
            }
            else
            {
                botonAceptar.IsEnabled = false;
            }

        }
    }
}
