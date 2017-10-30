/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_di_ejrepaso2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author angel
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("exoplanetas.csv");  // Archivo para trabajar
        BufferedReader bufferLectura = new BufferedReader(fr);   // Abrir el .csv en buffer de lectura

        ArrayList<Planeta> planetas = new ArrayList<Planeta>(); // Lista de Objetos Planeta

        // Almacenamos todo el fichero en nuestro ArrayList
        try {

            // Cargamos la primera linea
            String linea = bufferLectura.readLine();

            while (linea != null) {

                // Leemos la linea, troceandola
                String[] campos = linea.split(","); // Creamos un array con los campos de esa linea

                // numero de campos que tiene esta fila
                // Lo usamos para no intentar recoger un valor que no existe
                int n_campos = campos.length;

                // Variables para los planetas
                String nombreP = null;
                double eje = 0;
                double excentricidad = 0;
                double periodo = 0;

                // Almacenamos el nombre en una variable
                if (n_campos > 0 && !"".equals(campos[0])) {
                    nombreP = campos[0];
                }

                // Convertimos los valores recogidos como String a valores Double
                try {

                    // Eje
                    if (n_campos > 1 && !"".equals(campos[1])) {
                        eje = Double.parseDouble(campos[1]);
                    }

                    // Periodo
                    if (n_campos > 2 && !"".equals(campos[2])) {
                        periodo = Double.parseDouble(campos[2]);
                    }

                    // Excentricidad
                    if (n_campos > 3 && !"".equals(campos[3])) {
                        excentricidad = Double.parseDouble(campos[3]);
                    }

                } catch (NumberFormatException e) { // handle your exception
                    System.out.println(e.getCause());
                }

                // Creamos y añadimos el planeta al ArrayList
                // A no ser que sea la primera linea, la cabecera del documento
                if (!nombreP.equals("Nombre")) {
                    planetas.add(new Planeta(nombreP, eje, periodo, excentricidad));
                }

                // Siguiente linea
                linea = bufferLectura.readLine();

            }

            // Iniciamos las variables que usarems para contabilizar calculos
            double tamanoMedioEje = 0;
            double sumaEjes = 0;
            int totalEjecConocidos = 0;
            int planetasConExcentricidadDesconocida = 0;
            int planetasOrbitaMayor30d = 0;
            int planetasKepler = 0;

            // Ahora recorremos el array
            // Realizando los calculos que necesitamos
            for (Planeta planeta : planetas) {

                // Calcular la media del EJE de todos los planetas
                // No todos los planetas tienen eje conocido, así que haceos las operaciones 
                // con valores que no son 0
                if (planeta.getEje() > 0) {
                    totalEjecConocidos++;
                    sumaEjes += planeta.getEje();

                }

                // Numero de planetas de los que se conoce la excentricidad
                if (planeta.getExcentricidad() == 0.0) {
                    planetasConExcentricidadDesconocida++;
                    //System.out.println(planeta.getExcentricidad());

                }

                // Numero de planetas con órbita mayor a 30 días
                if (planeta.getPeriodo() > 30) {
                    planetasOrbitaMayor30d++;

                }

                // Numero de planetas KEPLER
                if (planeta.getNombre().startsWith("Kepler")) {
                    planetasKepler++;

                }

            }

            // Calculamos la media de los ejes
            tamanoMedioEje = sumaEjes / totalEjecConocidos;

            System.out.println("Tamaño medio del eje mayor de todos los planetas: " + tamanoMedioEje);
            System.out.println("Se desconoce la exceptricidad de: " + planetasConExcentricidadDesconocida + " planetas");
            System.out.println("Planetas con una órbita mayor a 30 días: " + planetasOrbitaMayor30d + " planetas");
            System.out.println("Planetas descubiertos por la sonda Kepler: " + planetasKepler + " planetas");

            // Creamos un fichero nuevo
            // Ordenado por el EJE de los planeras, de mayor a menor
            // ----
            //Ordenamos la lista
            planetas.sort(new Comparator<Planeta>() {
                @Override
                public int compare(Planeta o1, Planeta o2) {
                    return Double.compare(o2.getEje(), o1.getEje());
                }
            });

            // Creamos el fichero ordenado
            try {
                // Escribimos en el fichero, que se crea si no existe
                // Añadiendo true, comprueba que exista el fichero y si existe, añade contenido
                FileWriter escritura = new FileWriter("exoplanetasOrdenados.csv", false);
                
                // Escribimos la cabecera del documento
                escritura.write("Nombre,EjeMayor,PeriodoDias,Excentricidad\n");

                for (Planeta planeta : planetas) {
                    
                    //System.out.println(planeta.getNombre() + " => " + planeta.getEje());
                    escritura.write(planeta.getNombre() + "," + planeta.getEje() + "," + planeta.getPeriodo() + "," + planeta.getExcentricidad() + "\n"); // imprimimos linea a linea

                }

                escritura.close(); // cerramos el flujo de datos

            } catch (IOException ex) {
                System.out.println("No existe el fichero.");
            }

        } catch (IOException e) {
            System.out.println("Error.");
        }

    }

}
