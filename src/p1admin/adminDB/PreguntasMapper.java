package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import p1admin.model.Pregunta;


public class PreguntasMapper extends AbstractMapper<Pregunta, Integer> {

	public PreguntasMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
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
				rs.getString("texto");
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Pregunta buildObject(Object[] o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] decomposeObject(Pregunta object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer getKey(Pregunta object) {
		// TODO Auto-generated method stub
		return null;
	}


}
