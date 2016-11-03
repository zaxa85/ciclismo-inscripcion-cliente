/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import db.DALCorredor;
import java.util.Date;

/**
 *
 * @author Pablo Sierralta
 */
public class ControlCorredor {

    public void guardarCorredor(String dni, String nombre, String apellido, String fechaNac, String categoria, String dptoOrigen, String dptoPuntua, String numero) {
        BeanCorredor beanCorredor = new BeanCorredor();
        beanCorredor.setDni(dni);
        beanCorredor.setNombre(nombre);
        beanCorredor.setApellido(apellido);
        beanCorredor.setEdad(0);
        beanCorredor.setFechaNacimiento(new Date());
        beanCorredor.setDepartamentoOrigen(dptoOrigen);
        beanCorredor.setDepartamentoPuntua(dptoPuntua);
        beanCorredor.setNumeroCompetencia(numero);
        
        DALCorredor dalCorredor = new DALCorredor();
        dalCorredor.agregarCorredor(beanCorredor);
    }
    
}
