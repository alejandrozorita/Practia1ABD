package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import p1admin.model.Opcion;
import p1admin.model.Pregunta;


public class PreguntasMapper extends AbstractMapper<Pregunta, Integer> {

	public PreguntasMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		return "preguntas";
	}

	@Override
	protected String[] getKeyColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "Id" };
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "Id", "Texto" };
	}

	@Override
	protected Pregunta buildObjectFromResultSet(ResultSet rs) throws SQLException {
		return new Pregunta(rs.getInt("Id"),
				rs.getString("texto"));
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Pregunta buildObject(ResultSet rs) {
		try {
			return new Pregunta(rs.getInt(0),rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected Object[] decomposeObject(Pregunta object) {
		return new Object[] {
				object.getId(),
				object.getEnunciado()
		};
	}

	@Override
	protected Integer getKey(Pregunta object) {
		return object.getId();
	}

	@Override
	protected String[] getTableColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getValues(Pregunta object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getKeyColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getKeyValues(Pregunta object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setID(Pregunta object, Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Pregunta buildObject(Object[] o) {
		// TODO Auto-generated method stub
		return null;
	}
	  public List<Pregunta> getTodasPreguntas() {

	        String tableNamePreguntas = "preguntas";
	        String tableNameOpciones = "opciones";
	        
	        String sql  = "SELECT * FROM " + tableNamePreguntas + " t1" +
	                " LEFT JOIN " + tableNameOpciones + " t2" +
	                " ON t1.idpregunta = t2.idpregunta" +
	                " ORDER BY t1.idpregunta DESC";
	        return getPreguntas(sql,null);
	    }
	    private List<Pregunta> getPreguntas(String sql, String text) {
	        ResultSet rs = null;
	        Pregunta p;
	        int idPregunta = -1;
	        List<Pregunta> preguntas = new ArrayList<>();

	        try (Connection con = this.dataAccesor.getDataSource().getConnection();
	            PreparedStatement pst = con.prepareStatement(sql)){
	            if(text != null)
	                pst.setObject(1, "%"+text+"%");
	            rs = pst.executeQuery();
	            if (!rs.isClosed()) {
	                while (rs.next()) {
	                    if (idPregunta != rs.getInt(1)) {
	                        /*New question*/
	                        p = new Pregunta();
	                        idPregunta = rs.getInt(1);
	                        p.setId(idPregunta);
	                        p.setEnunciado(rs.getString(2));
	                        preguntas.add(p);
	                    }
	                    else {
	                        p = preguntas.get(preguntas.size() - 1);
	                    }
	                    Opcion opcion = new Opcion();
	                    int id = 0;
	                    int numeroOrden = 0;
	                    String respuesta = null;
	                    try {
	                        id = rs.getInt(3);
	                        numeroOrden = rs.getInt(4);
	                        respuesta = rs.getString(6);
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                    opcion.setIdRespuesta(id);
	                    opcion.setTexto(respuesta);
	                    opcion.setPreguntaMadre(p);
	                    opcion.setNumeroOrden(numeroOrden);
	                    p.addOpcion(opcion);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return preguntas;
	    }
	    
	    public List<Pregunta> getQuestionsContaining(String text) {

	        String Preguntas = "preguntas";
	        String Opciones = "opciones";

	        String sql  = "SELECT * FROM " + Preguntas + " t1" +
	                " LEFT JOIN " + Opciones + " t2" +
	                " ON t1.idpregunta = t2.idpregunta" +
	                " WHERE LOWER(enunciado) LIKE LOWER(?)" +
	                " ORDER BY t1.idpregunta DESC";
	        return getPreguntas(sql,text);
	    }


}
