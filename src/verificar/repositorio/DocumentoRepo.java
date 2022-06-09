package verificar.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import verificar.conexion.Sqlite;
import verificar.entidad.DocumentoEnti;

public class DocumentoRepo {

    public DocumentoEnti getDocumento(String noFactu, String direcSfs){
        try{
        	
            String sql = "SELECT TIP_DOCU, NUM_DOCU, IND_SITU FROM DOCUMENTO WHERE NUM_DOCU = '"+noFactu+"'";
            Sqlite sqlite = new Sqlite(direcSfs+"\\bd\\BDFacturador.db");
            Connection connection = sqlite.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //DocumentoEnti documentoEnti;
            while (resultSet.next()){
                DocumentoEnti  documentoEnti = new DocumentoEnti(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                return documentoEnti;
            }
            connection.close();
            statement.close();
        }catch (SQLException ex){
            System.out.println("No se pudo hacer la consulta, "+ex.getMessage());
        }
        return null;
    }
}