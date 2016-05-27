package mx.edu.ittepic.judamedranoba.prestap;

/**
 * Created by juanjose on 26/05/2016.
 */
public class Prestamo {
    private  int _id;
    private String nombreobj;
    private String descripcionobj;
    private String fechapres;
    private String fechadev;
    private String status;
    private String prestaviente;

    public Prestamo() {

    }

    public Prestamo(String nombreobj, String descripcionobj, String fechapres, String fechadev, String status, String prestaviente){
        this.nombreobj=nombreobj;
        this.descripcionobj=descripcionobj;
        this.fechapres=fechapres;
        this.fechadev=fechadev;
        this.status=status;
        this.prestaviente=prestaviente;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public void setDescripcionobj(String descripcionobj) {
        this.descripcionobj = descripcionobj;
    }

    public String getDescripcionobj() {
        return descripcionobj;
    }

    public void setFechadev(String fechadev) {
        this.fechadev = fechadev;
    }

    public String getFechadev() {
        return fechadev;
    }

    public void setFechapres(String fechapres) {
        this.fechapres = fechapres;
    }

    public String getFechapres() {
        return fechapres;
    }

    public void setNombreobj(String nombreobj) {
        this.nombreobj = nombreobj;
    }

    public String getNombreobj() {
        return nombreobj;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPrestaviente(String prestaviente) {
        this.prestaviente = prestaviente;
    }

    public String getPrestaviente() {
        return prestaviente;
    }
}
