package ingresosgastos.dto;

import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Operacion {
    
    private Date fecha;
    private String concepto;
    private double importe;

    /**
     * COntrutor
     * @param fecha
     * @param concepto
     * @param importe 
     */
    public Operacion(Date fecha, String concepto, double importe) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Método que devuelve un array de Strings
     * @return 
     */
    public String[] toArrayString(){
        
        String[] s = new String[3];
        s[0] = fecha.toString();
        s[1] = concepto;
        //s[2] = importe;
        
        return s;
        
    }
    
}
