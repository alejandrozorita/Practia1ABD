package p1admin;

import java.sql.SQLException;

import javax.swing.DefaultListModel;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import p1admin.adminDB.FauxDBFacade;
import p1admin.adminDB.GenericDBFacade;
import p1admin.admincontroller.AllQuestionsController;
import p1admin.adminview.AllQuestionsEditor;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class Main {
	public static void main(String[] args) throws SQLException {
		// TODO Inicializar DataSource
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost/abdp1");
		ds.setUser("Jorge");
		ds.setPassword("jorge");
		ds.setAcquireRetryAttempts(1);
		ds.setAcquireRetryDelay(1);
		ds.setBreakAfterAcquireFailure(true);

		GenericDBFacade<Pregunta, Opcion> facade = new FauxDBFacade();
		
		DefaultListModel<Pregunta> model = new DefaultListModel<>();
		AllQuestionsController controller = new AllQuestionsController(model, facade);
		AllQuestionsEditor ed = new AllQuestionsEditor(model, controller);
		ed.setModal(true);
		ed.setVisible(true);
		
		// TODO: Cerrar pool de conexiones
		ds.close();
	}
}
