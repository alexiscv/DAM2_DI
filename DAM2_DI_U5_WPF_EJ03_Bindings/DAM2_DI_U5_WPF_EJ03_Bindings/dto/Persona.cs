using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_WPF_EJ03_Bindings.dto
{
    public class Persona : INotifyPropertyChanged 
    {
        private String nombre;
        public String Nombre {
            get { return nombre; }
            set 
            { 
                this.nombre = value;
                // Llamamos al evento y le decimos que variable está cambiando
                this.PropertyChanged(this, new PropertyChangedEventArgs("Nombre"));

            } 
        }
        public String Apellidos { get; set; }

        public Persona(String nombre, String apellidos)
        {
            this.nombre = nombre;
            this.Apellidos = apellidos;
        }

        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }

        // Creamos un evento
        // Al que llamaremos cuando se modifique algun campo
        public event PropertyChangedEventHandler PropertyChanged;

    }
}
