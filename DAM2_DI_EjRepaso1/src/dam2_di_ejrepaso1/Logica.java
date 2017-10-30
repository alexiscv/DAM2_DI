/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2_di_ejrepaso1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author angel
 */
public class Logica {

    // Creamos la colección que almacenará los partidos
    private LinkedList<Partido> partidos = new LinkedList<>();
    private String fichero = null;
    private File f = new File("fichero.dat");
    private Scanner teclado = new Scanner(System.in);
    private boolean run = true;

    /**
     * Función que realiza las tareas necesarias para el correcto funcionamiento
     * de la app
     *
     * @throws java.io.IOException
     */
    public void init() throws IOException {

        System.out.println("Iniciando aplicación");

        // Comprobamos si existe un fichero para leer y guardar información
        // si no existe, lo creamos
        if (!this.f.exists()) {
            this.f.createNewFile();

        }

        // Cargamos el contenido del fichero en memoria
        if (this.f.exists()) {

            try {

                // Lo primero es indicar que fichero queremos leer
                FileInputStream fichero = new FileInputStream(this.f);

                // Ahora cargamos el ontenido del fichero en un flujo de datos
                ObjectInputStream contenidoFichero = new ObjectInputStream(fichero);

                // Como el contenido del fichero es un LinkedList de Partidos,
                // Creamos un objeto de ese tipo para guardar el contenido y poder leerlo
                // de la misma forma en la que fue guardado
                // Hay que destacar que ObjectInputStream devuelve un objeto de tipo Object
                // Por eso, hay que usar un cast para pasarlo a una LinkedList de Partidos
                LinkedList<Partido> partidosRecuperados = (LinkedList<Partido>) contenidoFichero.readObject();
                
                this.partidos = partidosRecuperados;

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    /**
     * Devuelve el estado de run. Run se usa para detener el programa
     *
     * @return
     */
    public boolean isRun() {
        return run;
    }

    /**
     * Función que pinta el menú de la app.
     *
     * @throws java.text.ParseException
     */
    public void mostrarMenu() throws ParseException {

        System.out.println("--- Menú --");
        System.out.println("1. Alta de un nuevo partido.");
        System.out.println("2. Mostrar un listado de partidos.");
        System.out.println("3. Borrar un partido.");
        System.out.println("4. Mostrar los partidos ordenados.");
        System.out.println("5. Mostrar los partidos de una división.");
        System.out.println("6. Salir.");

        this.procesarPeticion(teclado.nextInt());

    }

    /**
     * Recoge una opción y ejecuta la acción pertinente, funciona como
     * controlador
     *
     * @param op
     * @return
     * @throws java.text.ParseException
     */
    public boolean procesarPeticion(int op) throws ParseException {

        switch (op) {
            case 1:
                this.nuevoPartido();
                break;
            case 2:
                this.mostrarPartidos();
                break;
            case 3:
                this.eliminarPartido();
                break;
            case 4:
                this.mostrarPartidosOrdenados("");
                break;
            case 5:
                System.out.println("¿De que división quieres ver los aprtidos?");
                System.out.println("División: (1)Primera (2)Segunda (3)Tercera");
                int division = teclado.nextInt();
                boolean correcta = true;   // con esta variable entramos en un bucle infinito hasta que el usuario pulse 1, 2 o 3.

                while (correcta == true) {

                    if (division == 1 || division == 2 || division == 3) {
                        // la opción elegida es correcta, la cargamos en el objeto y salimos el bucle
                        this.mostrarLinkedList(partidos,division);
                        correcta = false; // devolvemos false para romper el bucle

                    } else {
                        // La opción no es correcta, avisamos al usuario y volvemos a solicitar un valor correcto.
                        System.out.println("División: (1)Primera (2)Segunda (3)Tercera");
                        division = teclado.nextInt();   // recogemos el valor escrito por el usuario

                    }

                }                
                
                break;
            case 6:
                try {
                    this.guardarSalir();
                    System.out.println("Guardando...");
                    System.out.println("Cerrando...");
                } catch (Exception e) {
                    System.out.println("Error al guardar");

                }
                System.out.println("-- Fin de Programa --");
                // Paramos el programa
                this.run = false;
                break;

            default:
                System.out.println("No se reconoce la opción seleccionada, porfavor, vuelva a intentarlo");
                this.mostrarMenu(); // volvemos a pintar el menú
                break;
        }
        return true;

    }

    /**
     * Nos permite crear un nuevo partido
     *
     * @throws java.text.ParseException
     */
    public void nuevoPartido() throws ParseException {

        // Creamos el obj.
        Partido partido = new Partido();

        // Creamos el formato para Date
        // Más adelante parsearemos la fecha tipo String usando formatoFecha y el método parse()
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");

        // Solicitamos los datos y los vamos almacenando en el obj.
        System.out.println("---- AÑADIR PARTIDO ----");
        System.out.println("Equipo local:");
        teclado.nextLine(); // Limpiar el buffer
        partido.setEquipoLocal(teclado.nextLine());

        System.out.println("Equipo visitante:");
        partido.setEquipoVisitante(teclado.nextLine());

        System.out.println("División: (1)Primera (2)Segunda (3)Tercera");
        int division = teclado.nextInt();
        boolean correcta = true;   // con esta variable entramos en un bucle infinito hasta que el usuario pulse 1, 2 o 3.

        while (correcta == true) {

            if (division == 1 || division == 2 || division == 3) {
                // la opción elegida es correcta, la cargamos en el objeto y salimos el bucle
                partido.setDivision(division);
                correcta = false; // devolvemos false para romper el bucle

            } else {
                // La opción no es correcta, avisamos al usuario y volvemos a solicitar un valor correcto.
                System.out.println("División: (1)Primera (2)Segunda (3)Tercera");
                division = teclado.nextInt();   // recogemos el valor escrito por el usuario

            }

        }

        System.out.println("Resultado: 00-00");
        partido.setResultado(teclado.next());

        System.out.println("Fecha:(dd/MM/yy)");
        teclado.nextLine(); // Limpiar el buffer
        String fecha_escrita = teclado.nextLine();  // recogemos el valor
        Date fecha = null;                          // Creamos una variable tipo fecha para guardar la fecha parseada

        try {
            fecha = formatoFecha.parse(fecha_escrita); // Parseamos
            partido.setFecha(fecha);                // Guardamos la fecha en el obj.

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Añadimos el partido a la colección
        partidos.add(partido);

        // Notificamos
        System.out.println("// Partido creado correctamente //");

    }

    /**
     * Mostrar partidos
     */
    public void mostrarPartidos() {

        int contador = 0;

        for (Partido partido : partidos) {

            System.out.print("Partido #" + contador + " - ");
            System.out.println(partido);
            contador++;

        }

    }
    
    /**
     * Mostrar partidos, pasando un LinkedList
     * @param lista
     * @param division
     */
    public void mostrarLinkedList( LinkedList<Partido> lista, int division ) {

        int contador = 0;

        for (Partido partido : lista) {

            // Filtramos por división, si división != 0
            if( division == 0 ){
                System.out.print("Partido #" + contador + " - ");
                System.out.println(partido);
                contador++;
            }else{
                if(partido.getDivision() == division ){
                    System.out.print("Partido #" + contador + " - ");
                    System.out.println(partido);
                    contador++;                
                }
            }

        }

    }    

    /**
     * Eliminar partidos
     */
    public void eliminarPartido() {

        System.out.println("¿Que partido desea eliminar? Escriba el identificador del partido:");
        this.mostrarPartidos();
        int partidoSeleccionado = teclado.nextInt();

        // Para eliminar necesitamos recorrer la colección con un iterator
        // Creamos el iterador
        Iterator<Partido> iterador = partidos.iterator();

        // Recorremos la colección y buscamos el ID (posicion) del partido a eliminar.
        int contador = 0;
        while (iterador.hasNext()) {

            Partido partidoActual = iterador.next();
            if (contador == partidoSeleccionado) {
                iterador.remove(); // Eliminamos

            }
            contador++;

        }

    }

    /**
     * Mostrar partidos ordenados por fecha de manera adcendente o descendente
     *
     * @param orden
     */
    public void mostrarPartidosOrdenados(String orden) {

        if (orden.equals("asc")) {
            try {
                // Creamos un copia de la lista que queremos ordenar
                LinkedList<Partido> copia = new LinkedList<>(partidos);
                
                // Y la ordenamos
                Collections.sort(copia);
                
                // Para finalizar, la mostramos por pantalla
                this.mostrarLinkedList(copia, 0);
                
            } catch (Exception e) {
                System.out.println(e.initCause(e));

            }

        } else if (orden.equals("desc")) {
            try {
                // Creamos un copia de la lista que queremos ordenar
                LinkedList<Partido> copia = new LinkedList<>(partidos);
                
                // Y la ordenamos
                Collections.sort( copia, new Comparator<Partido>() {
                    @Override
                    public int compare(Partido p1, Partido p2) {
                        return p2.getFecha().compareTo(p1.getFecha());
                    }
                }); 
                
                // Para finalizar, la mostramos por pantalla
                this.mostrarLinkedList(copia, 0);
                
            } catch (Exception e) {
                System.out.println("Error al ordenar los partidos DESC.");

            }

        } else {
            System.out.println("¿Como desea ordenar los partidos? asc/desc");
            String opSeleccioanda = teclado.next();

            int opCorrecta = 0;
            while (opCorrecta == 0) {

                if ("asc".equals(opSeleccioanda.toLowerCase()) || "desc".equals(opSeleccioanda.toLowerCase())) {
                    opCorrecta = 1;

                } else {
                    System.out.println("Comando no reconocida, escriba asc o desc:");
                    opSeleccioanda = teclado.next();

                }

            }

            this.mostrarPartidosOrdenados(opSeleccioanda);

        }

    }

    /**
     * Guardar y Salir
     *
     * @return
     */
    public boolean guardarSalir() {

        try {

            // Volcamos el contenido de la memoria en el fichero
            // Lo primero es indicar donde se almacenará la información
            FileOutputStream fSalida = new FileOutputStream("fichero.dat");

            // Ahora creamos un flujo de datos donde almacenaremos la información
            // Una vez almacenada, con el método ObjectWrite, escribiremos en el fichero
            ObjectOutputStream oos = new ObjectOutputStream(fSalida);

            // Volcamos el contenido del flujo de datos en el fichero
            oos.writeObject(this.partidos);

            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
