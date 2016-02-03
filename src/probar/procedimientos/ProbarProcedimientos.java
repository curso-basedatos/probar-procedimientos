/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probar.procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author root
 */
public class ProbarProcedimientos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        
      //1. Nos conectamos
        Connection con=Conexion.conectarse();
      //2. Hacemos una llamada al procedimiento con sus parametros
     CallableStatement callate=con.prepareCall("{call guardar_pelicula(?,?,?,?)}");
     //3. Registramos el parametro de salida que es el primary key
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        //4. Damos el valor del parametro de salida que es el titulo de la peli
        callate.setString(2,"El niño");
        //5. Ajustamos la sinopsis
        callate.setString(3,"Es de un muñeco que supuestamente esta poseido por el chamuco");
        //6. Ajustamos el valor de la classificacion
        callate.setString(4, "B");
      
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("Se guardo la pelicula con ID:"+pk);
    }
    
}
