package verificar.repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import verificar.conexion.Oracle;

public class ArfafeRepo {


    public List<String> listaCias(String f1, String f2){
        try {
            String sql            = "SELECT DISTINCT TRIM(NO_CIA) FROM FACTU.ARFAFE WHERE NVL(ESTADO_SUNAT,'0') = '0' "
            		              + "AND SUBSTR(NO_FACTU,0,1) IN('F','B') AND ESTADO NOT IN('A') "
            		              + "AND FECHA BETWEEN TO_DATE('"+f1+"','DD/MM/YYYY') AND TO_DATE('"+f2+"','DD/MM/YYYY')";
            Oracle oracle         = new Oracle();
            Connection connection = oracle.conexion();
            Statement statement   = connection.createStatement();
            ResultSet resultSet   = statement.executeQuery(sql);
            List<String> cias     = new ArrayList<String>();
            while (resultSet.next()){
                cias.add(resultSet.getString(1));
            }
            connection.close();
            statement.close();
            resultSet.close();
            return cias;
        }catch (SQLException ex){
            System.out.println("No se pudo hacer la consulta "+ex.getMessage());
        }
        return null;
    }

    public List<String> listaDocumentoElectronico(String cia,String f1, String f2){
        try {
            String sql = "SELECT SUBSTR(NO_FACTU,1,4)||'-'||SUBSTR(NO_FACTU,5) NOFACTU FROM FACTU.ARFAFE WHERE NO_CIA = '"+cia+"' "
                    + "AND NVL(ESTADO_SUNAT,'0') = '0' AND SUBSTR(NO_FACTU,0,1) IN('F','B') AND ESTADO NOT IN('A')"
                    + "AND FECHA BETWEEN TO_DATE('"+f1+"','DD/MM/YYYY') AND TO_DATE('"+f2+"','DD/MM/YYYY')";
            Oracle oracle = new Oracle();
            Connection connection = oracle.conexion();
            Statement statement   = connection.createStatement();
            ResultSet resultSet   = statement.executeQuery(sql);
            List<String> noFactus = new ArrayList<String>();
            while (resultSet.next()){
                noFactus.add(resultSet.getString(1));
            }
            connection.close();
            statement.close();
            resultSet.close();
            return noFactus;
            
        }catch (SQLException ex){
            System.out.println("No se pudo hacer la consulta "+ex.getMessage());
        }
        return null;
    }

    public void actuEstadoSunatDocuElec(String cia, String noFactu, String estadoSunat){
        try {
            String sql = "{call FACTU.ACTUALIZAR_DOCU_ELECT (?,?,?)}";
            Oracle oracle = new Oracle();
            Connection connection = oracle.conexion();
            CallableStatement cst = connection.prepareCall(sql);
            cst.setString(1, cia);
            cst.setString(2, noFactu);
            cst.setString(3, estadoSunat);
            cst.execute();
            
            connection.close();
            cst.close();
        }catch (SQLException ex){
            System.out.println("No se pudo hacer la consulta "+ex.getMessage());
        }
    }

}
