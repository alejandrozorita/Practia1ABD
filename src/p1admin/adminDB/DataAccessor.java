package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

public class DataAccessor {
	private DataSource ds;

	public DataAccessor(DataSource ds) {
		this.ds = ds;
	}

	public Object insertRow(String tableName, String[] fields, Object[] values) {
		String sql = generateInsertStatement(tableName, fields);
		try (Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
                return rs.getObject(1);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Object updateRow(String tableName, String[] columna, Object[] values, String[] nombreKey, Object key) {
		String sql = generateUpdateStatement(tableName, columna, values, nombreKey, key);
		try (Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
                return rs.getObject(1);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Object deleteRow(String tableName, String[] fields, Object[] values) {
		String sql = generateInsertStatement(tableName, fields);
		try (Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
                return rs.getObject(1);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String generateInsertStatement(String tableName, String[] fields) {
		String fieldList = String.join(",",fields);
		String[] marks = new String[fields.length];
		Arrays.fill(marks, "?");
		String markList = String.join(",", marks);
		return "INSERT INTO " + tableName + " (" + fieldList + ") VALUES (" + markList + ")";
	}
	

	private String generateUpdateStatement(String tableName, String[] columna, Object valor, String[] nombreKey, Object key) {
		return "UPDATE " + tableName + "SET " + columna + " = " + valor + " WHERE " + nombreKey + " = " + key;
	}
	
	
	 public boolean deleteRows (String tableName, String[] keys, Object[] keysVals) {
	        String sql = getDeleteStatement(tableName, keys);
	        try(Connection con = ds.getConnection();
	            PreparedStatement pst = con.prepareStatement(sql)) {
	            for (int i = 0; i < keysVals.length; i++) {
	                try {
	                    pst.setObject(i + 1, keysVals[i]);
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            int numRows = pst.executeUpdate();
	            return (numRows >= 1);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	private String getDeleteStatement(String tableName, String[] cols) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM " + tableName);
        if (cols != null) {
            sb.append(" WHERE (");
            String columnsMarks = String.join("=? AND ", cols);
            sb.append(columnsMarks);
            sb.append("=?)");
        }
        return sb.toString();
    }
	
	
	/**
	 * Realiza una consulta en la BD a partir de una conjunción de condiciones simples
	 * 
	 * @param tableName Nombre de la tabla a consultar
	 * @param columns Nombre de las columnas a devolver
	 * @param conditions Condiciones sobre los resultados devueltos
	 * @return Lista con las filas devueltas por la consulta. Las columnas de cada fila
	 * se representan mediante un array de Object.
	 */
	public List<Object[]> query(String tableName, 
			String[] columns, 
			QueryCondition[] conditions) {
		List<Object[]> result = new LinkedList<>();
		
		String sql = generateSelectStatement(tableName, columns, conditions);
		
		try(Connection con = ds.getConnection();
		    PreparedStatement st = con.prepareStatement(sql)) {
			
			for (int i = 0; i < conditions.length; i++) {
				st.setObject(i + 1, conditions[i].getValue());
			}
			
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Object[] obj = new Object[columns.length];
					for (int i = 0; i < obj.length; i++) {
						obj[i] = rs.getObject(columns[i]);
					}
					
					result.add(obj);		
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(sql);
		
		return result;
	}
	
	
	private String generateSelectStatement(String tableName, String[] columns, QueryCondition[] conditions) {
		String[] conditionStrings = new String[conditions.length];
		
		for(int i = 0; i < conditionStrings.length; i++) {
			conditionStrings[i] = conditions[i].getColumnName() + " " +
					conditions[i].getOperator() + " ?";
					
		}
		
		String sql = "SELECT " + String.join(", ", columns) +
				" FROM " + tableName +
				" WHERE " + String.join(" AND ", conditionStrings);
		return sql;
	}
	
	
	/*
	 * FALTA UPDATE!!!!!!
	 * */
	public DataSource getDataSource() {
        return this.ds;
    }

}
