using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_WPF_EJ02_ComboBox.dto
{
    class Persona
    {
        public String Nombre { get; set; }
        private String apellidos;
        public String Apellidos 
        {
            get {
                return apellidos;
            }
            set {
                apellidos = value;
            }
        }

        // Constructor
        public Persona(String nombre, String apellidos)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
        }

        // To String
        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }

    }
}
