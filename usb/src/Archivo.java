import java.time.LocalDate;

public class Archivo
{
    private String nomArchivo, extension, unidadByte,msg,fecha;
    private int tamaño;
   public Archivo(String nomArchivo,String extension,int tamaño,String unidadByte)
   {
       LocalDate fechaActual = LocalDate.now();
       this.extension=extension;
       this.unidadByte =unidadByte;
       this.tamaño=tamaño;
       this.nomArchivo=nomArchivo;
       fecha= String.valueOf(fechaActual);
   }


    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getUnidadByte() {
        return unidadByte;
    }

    public void setUnidadByte(String unidadByte) {
        this.unidadByte = unidadByte;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
