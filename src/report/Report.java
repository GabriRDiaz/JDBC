package report;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablePattern.Pattern;

public class Report extends JDialog {
	private ResultSet rs;
	
	public Report(ResultSet rs) {
		super();
		this.rs = rs;
		setSize(1300, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			String tableName = rsmd.getTableName(1);
			setTitle(tableName.substring(0, 1).toUpperCase() + tableName.substring(1));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al obtener los metadatos", JOptionPane.ERROR_MESSAGE);
		}
		setLayout(new BorderLayout());
		crearTabla();
	}

	private void crearTabla() {
		Pattern pattern = new Pattern(rs);
		JTable tabla = new JTable(pattern);
		tabla.setFillsViewportHeight(true);
		tabla.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane, BorderLayout.CENTER);
	}
}

