/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Donante implements Serializable{
    private String Nombre;
    private String Apellido;
    private int Cedula;
    private String Telefono;
    private String Sexo;
    private int Peso;
    private String TipoSangre;
    private Date FechaNac;
    private String Direccion;
    private Date UltDonacion;
    private Boolean Pircing;
    private Date UltPircing;

    public Donante(String nombres, String apellidos, int cedula, String telefono, String sexo, String tipoSangre, Date fechaNac, String direccion, int peso, Date ultimaDonacion, boolean pircing) {
        this.Nombre = nombres;
        this.Apellido = apellidos;
        this.Cedula = cedula;
        this.Telefono = telefono;
        this.Sexo = sexo;
        this.Peso = peso;
        this.TipoSangre =tipoSangre;
        this.FechaNac = fechaNac;
        this.Direccion = direccion;
        this.UltDonacion = ultimaDonacion;
        this.Pircing = pircing;
    }

    public Donante(String nombres, String apellidos, int cedula, String telefono, String sexo, String tipoSangre, Date fechaNac, String direccion, int peso, Date ultimaDonacion, boolean pircing, Date fechaTatuaje) {
        this.Nombre = nombres;
        this.Apellido = apellidos;
        this.Cedula = cedula;
        this.Telefono = telefono;
        this.Sexo = sexo;
        this.Peso = peso;
        this.TipoSangre =tipoSangre;
        this.FechaNac = fechaNac;
        this.Direccion = direccion;
        this.UltDonacion = ultimaDonacion;
        this.Pircing = pircing;
        this.UltPircing = fechaTatuaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public String getTipoSangre() {
        return TipoSangre;
    }

    public void setTipoSangre(String TipoSangre) {
        this.TipoSangre = TipoSangre;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Date getUltDonacion() {
        return UltDonacion;
    }

    public void setUltDonacion(Date UltDonacion) {
        this.UltDonacion = UltDonacion;
    }

    public Boolean getPircing() {
        return Pircing;
    }

    public void setPircing(Boolean Pircing) {
        this.Pircing = Pircing;
    }

    public Date getUltPircing() {
        return UltPircing;
    }

    public void setUltPircing(Date UltPircing) {
        this.UltPircing = UltPircing;
    }
    
    
}

