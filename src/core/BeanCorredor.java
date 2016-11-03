/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Date;

/**
 *
 * @author Pablo Sierralta
 */
public class BeanCorredor {
    
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private String departamentoOrigen;
    private String departamentoPuntua;
    private String numeroCompetencia;

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the departamentoOrigen
     */
    public String getDepartamentoOrigen() {
        return departamentoOrigen;
    }

    /**
     * @param departamentoOrigen the departamentoOrigen to set
     */
    public void setDepartamentoOrigen(String departamentoOrigen) {
        this.departamentoOrigen = departamentoOrigen;
    }

    /**
     * @return the departamentoPuntua
     */
    public String getDepartamentoPuntua() {
        return departamentoPuntua;
    }

    /**
     * @param departamentoPuntua the departamentoPuntua to set
     */
    public void setDepartamentoPuntua(String departamentoPuntua) {
        this.departamentoPuntua = departamentoPuntua;
    }

    /**
     * @return the numeroCompetencia
     */
    public String getNumeroCompetencia() {
        return numeroCompetencia;
    }

    /**
     * @param numeroCompetencia the numeroCompetencia to set
     */
    public void setNumeroCompetencia(String numeroCompetencia) {
        this.numeroCompetencia = numeroCompetencia;
    }
}
