using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_Examen.dto
{
    public class Persona : INotifyPropertyChanged
    {
        private String nombre;
        public String Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                nombre = value;
            }
        }

        private String apellidos;
        public String Apellidos
        {
            get
            {
                return apellidos;
            }
            set
            {
                apellidos = value;
            }
        }

        private Boolean dentro;
        public Boolean Dentro
        {
            get
            {
                return dentro;
            }
            set
            {
                dentro = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Dentro"));
                this.PropertyChanged(this, new PropertyChangedEventArgs("Fuera"));
                this.PropertyChanged(this, new PropertyChangedEventArgs("Estado"));
            }
        }

        private Boolean fuera;
        public Boolean Fuera
        {
            get
            {
                return !this.dentro;
            }
        }

        private String estado;
        public String Estado
        {
            get
            {
                if (dentro)
                {
                    return "Dentro";
                }
                else
                {
                    return "Fuera";
                }
            }
        } 

        /**
         * Constructores
         */
        public Persona()
        {
        }

        public Persona(String nombre, String apellidos)
        {

            this.nombre = nombre;
            this.apellidos = apellidos;

        }

        public override String ToString()
        {
            return Nombre + " " + Apellidos;
        }

        public event PropertyChangedEventHandler PropertyChanged;

    }
}
