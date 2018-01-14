using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_WPF_EJ04_AppLibros.dto
{
    public class Libro : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {

        private String titulo;
        public String Titulo
        {
            get
            {
                return titulo;
            }
            set
            {
                this.titulo = value;
                // Esta parte notifica cuando cambia el valor de Titulo
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("Titulo"));
            }
        }

        private String autor;
        public String Autor
        {
            get
            {
                return autor;
            }
            set
            {
                this.autor = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Autor"));
            }
        }

        private DateTime fechaEntrada;
        public DateTime FechaEntrada
        {
            get
            {
                return fechaEntrada;
            }
            set
            {
                this.fechaEntrada = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("FechaEntrada"));
            }
        }

        /**
         * Constructores
         */

        // Constructor para cuando creamos un libro nuevo desde el formulario
        // Necesitamos un constructor vacío, para poder crear un libro vacio y luego
        // cargarle los datos
        public Libro()
        {
            this.fechaEntrada = DateTime.Now;
        }

        // Constructor pasandole toda la información
        public Libro(String titulo, String autor, DateTime fechaEntrada) {
            this.titulo = titulo;
            this.autor = autor;
            this.fechaEntrada = fechaEntrada;
        }

        // Creamos el evento
        public event PropertyChangedEventHandler PropertyChanged;

        // Implementación de la interface ICloneable
        public object Clone()
        {
            // Devuelve una copia identica del objeto.
            return this.MemberwiseClone();
        }

        // Implementación de la interface IDataErrorInfo
        public string Error
        {
            get { return "Error general en el Obj. Libro"; }
        }

        public string this[string columnName]
        {
            get 
            {

                String resultado = "";

                if (columnName == "Titulo")
                {
                    if (string.IsNullOrEmpty(titulo))
                    {
                        resultado = "Debe introducir el título";
                    }
                }

                if (columnName == "Autor")
                {
                    if (string.IsNullOrEmpty(autor))
                    {
                        resultado = "Debe introducir el autor";
                    }
                }

                return resultado;
            
            }
        }
    }
}
