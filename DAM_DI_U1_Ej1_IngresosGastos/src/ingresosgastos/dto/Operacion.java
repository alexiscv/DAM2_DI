package ingresosgastos.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Operacion {

    private Date fecha;
    private String concepto;
    private float importe;
    private int tipoOperacion; // 0 = gasto, 1 = ingreso
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    /**
     * Construtor
     *
     * @param fecha
     * @param concepto
     * @param importe
     */
    public Operacion(Date fecha, String concepto, float importe, int tipoOperacion) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.importe = importe;
        this.tipoOperacion = tipoOperacion;
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

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * Método que devuelve un array de Strings
     *
     * @return
     */
    public String[] toArrayString() {

        String[] s = new String[3];
        
        s[0] = sdf.format(fecha);
        s[1] = concepto;
        s[2] = Float.toString(importe);

        return s;

    }

}
