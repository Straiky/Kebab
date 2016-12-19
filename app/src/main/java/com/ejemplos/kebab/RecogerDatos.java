package com.ejemplos.kebab;

/**
 * Created by adminportatil on 16/12/2016.
 */

public class RecogerDatos {
    private String Nombre, Apellido, Direccion;
    private Integer Telefono, Codigo_postal;

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public Integer getCodigo_postal() {
        return Codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        Codigo_postal = codigo_postal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
