package telas;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelAlunosEsperaController implements Initializable {

	@FXML
	private Button idButtonEspera;

	@FXML
	void onButtonEspera(ActionEvent event) {
		System.out.println("PASSSEI AQUI !!!!");

		try {
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("JDBC:MYSQL://localhost:3306/gestaoescolar", "root", "1234567");
			String sql = "SELECT * FROM aluno";
			JasperDesign jdesign = JRXmlLoader
					.load("C:\\Users\\jribe\\eclipse-workspace\\MariaLobatoGenteJovem\\src\\JasperReports\\ReportTeste.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			JasperReport jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
			JasperViewer.viewReport(jprint, false);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
