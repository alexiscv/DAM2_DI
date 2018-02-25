using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAM2_DI_U5_EJ_Agenda.dto
{
    public class Tarea : ICloneable
    {
        /**
         * Declaramos los atributos con sus métodos get & set
         */
        private String nombre;
        public String Nombre
        {
            get { return nombre; }
            set { this.nombre = value; }
        }

        private DateTime fecha;
        public DateTime Fecha
        {
            get { return fecha; }
            set { 
                
                this.fecha = value;
            
            }
        }

        private String texto;
        public String Texto
        {
            get { return texto; }
            set { this.texto = value; }
        }

        private String lugar;
        public String Lugar
        {
            get { return lugar; }
            set { this.lugar = value; }
        }

        /**
         * Declaramos los constructores
         */
        public Tarea() { }
        public Tarea(String nombre, DateTime fecha, String texto, String lugar) {

            this.nombre = nombre;
            this.fecha = fecha;
            this.texto = texto;
            this.lugar = lugar;
        
        }

        /**
         * Otros métodos que necesitamos para que funcionen ciertas características
         */

        // Nos permite clonar objetos
        public object Clone()
        {
            return this.MemberwiseClone();
        }
    }
}
