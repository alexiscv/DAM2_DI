using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ04_ColeccionPersonas
{
    public class Persona
    {

        private String _nombre;
        public String Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }
        private String _apellidos;
        public String Apellidos
        {
            get { return _apellidos; }
            set { _apellidos = value; }
        }
        private int _edad;
        public int Edad
        {
            get { return _edad; }
            set { _edad = value; }
        }

        // Contructores
        public Persona() { } // Es contructor es para poder persistir la información

        public Persona(String nombre, String apellidos, int edad)
        {

            this._nombre = nombre;
            this._apellidos = apellidos;
            this._edad = edad;

        }

        // ToString
        public override string ToString()
        {
            return "--> Nombre: " + _nombre + " | Apellidos: " + _apellidos + " | Edad: " + _edad;
        }

    }
}
