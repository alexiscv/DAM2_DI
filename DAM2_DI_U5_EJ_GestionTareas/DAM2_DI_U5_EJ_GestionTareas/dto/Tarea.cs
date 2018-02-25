using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_GestionTareas.dto
{
    public class Tarea : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {

        // Atributos y getter & setter
        private String nombre;
        public String Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                this.nombre = value;
                // Esta parte notifica cuando cambia el valor de Nombre
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("Nombre"));
            }
        }

        private bool proxima;
        public bool Proxima
        {
            get
            {
                return proxima;
            }
            set
            {
                this.proxima = value;
                // Esta parte notifica cuando cambia el valor de Proxima
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("Proxima"));
            }
        }

        private DateTime fechaLimite;
        public DateTime FechaLimite
        {
            get
            {
                return fechaLimite;
            }
            set
            {
                this.fechaLimite = value;

                // Calculamos si la fecha es proxima a la del día actual
                isProxima(fechaLimite);

                // Esta parte notifica cuando cambia el valor de Nombre
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("FechaLimite"));
            }
        }

        private Boolean finalizada;
        public Boolean Finalizada
        {
            get
            {
                return finalizada;
            }
            set
            {
                this.finalizada = value;
                // Esta parte notifica cuando cambia el valor de Nombre
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("Finalizada"));
            }
        }

        private String descripcion;
        public String Descripcion
        {
            get
            {
                return descripcion;
            }
            set
            {
                this.descripcion = value;
                // Esta parte notifica cuando cambia el valor de Nombre
                // Sirve para refrescar valores de tablas, combobox, etc... mediante bindings
                this.PropertyChanged(this, new PropertyChangedEventArgs("Descripcion"));
            }
        }

        /**
         * Método para evaluar si una tarea está cercana a día actual y por tanto, si debe marcarse en rojo.
         * 
         */
        private void isProxima(DateTime fechaLimite)
        {
            if (this.fechaLimite.ToString("ddMMyyyy").Equals(DateTime.Now.ToString("ddMMyyyy")) 
                || this.fechaLimite.ToString("ddMMyyyy").Equals(DateTime.Now.AddDays(+1).ToString("ddMMyyyy"))
                || this.fechaLimite.ToString("ddMMyyyy").Equals(DateTime.Now.AddDays(+2).ToString("ddMMyyyy"))
                || this.fechaLimite.ToString("ddMMyyyy").Equals(DateTime.Now.AddDays(+3).ToString("ddMMyyyy"))
                || this.fechaLimite.ToString("ddMMyyyy").Equals(DateTime.Now.AddDays(+4).ToString("ddMMyyyy")))
            {
                this.proxima = true;
            }
            else
            {
                this.proxima = false;
            }
        }

        // Constructor
        public Tarea()
        {
        }

        public Tarea(String nombre, DateTime fechaLimite, Boolean finalizada, String descripcion)
        {
            this.nombre = nombre;
            this.fechaLimite = fechaLimite;
            this.finalizada = finalizada;
            this.descripcion = descripcion;

            // Calculamos si la fecha es proxima a la del día actual
            isProxima(fechaLimite);

        }

        // Creamos el evento
        public event PropertyChangedEventHandler PropertyChanged;


        // Nos permite clonar objetos
        public object Clone()
        {
            return this.MemberwiseClone();
        }

        // Nos permite validar
        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get {

                // Cadena que vamos a retornar
                String resultado = "";

                // Validamos el Nombre
                if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(nombre))
                    { resultado = "Debe introducir el nombbre de la tarea."; }

                    else if (nombre.Length > 50 )
                    { resultado = "Nombre demasiado largo"; }
                }

                // Retornamos el resultado                
                return resultado;
            
            }
        }
    }
}
