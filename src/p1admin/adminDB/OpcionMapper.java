package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import p1admin.model.Opcion;


public class OpcionMapper extends AbstractMapper<Opcion, Integer> {

	public OpcionMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		return "opciones";
	}

	@Override
	protected String[] getKeyColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "id_opcion" };
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "id_opcion", "id_preguntas","num","texto" };
	}

	@Override
	protected Opcion buildObjectFromResultSet(ResultSet rs) throws SQLException {
		return new Opcion(rs.getInt(1), null, rs.getInt(3), rs.getString(4));
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Object[] decomposeObject(Opcion object) {
		return null;
	}

	@Override
	protected Integer getKey(Opcion object) {
		return null;
	}

	@Override
	protected String[] getTableColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getValues(Opcion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getKeyColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getKeyValues(Opcion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setID(Opcion object, Object key) {
		// TODO Auto-generated method stub
		int id =  Integer.parseInt(key.toString());
        object.setIdOpcion(id);
		
	}

	@Override
	protected Opcion buildObject(Object[] o) {
		// TODO Auto-generated method stub
		return null;
	}



}
