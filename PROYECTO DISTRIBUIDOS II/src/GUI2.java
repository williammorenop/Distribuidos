import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUI2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField de;
	private JTextField a;
	private JTextField monto;
	private JTextField identificador;
	private JTextField operacion;
	private List<Movimiento> Movimientos;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 frame = new GUI2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI2() {
		Movimientos= new ArrayList<Movimiento>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		scrollPane.setBounds(70, 59, 226, 100);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"9827", "Ahorros", "0"},
				{"5689", "Credito", "1000000"},
				{"4512", "Visa", "500000"},
				{"7845", "MasterdCard", "5000000"},
			},
			new String[] {
				"Cuenta", "Tipo", "Saldo"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblSusProductos = new JLabel("SUS PRODUCTOS");
		lblSusProductos.setBounds(70, 33, 118, 14);
		contentPane.add(lblSusProductos);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(405, 50, 498, 320);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblConsultas = new JLabel("CONSULTAS");
		lblConsultas.setBounds(419, 28, 140, 14);
		contentPane.add(lblConsultas);
		
		JButton btnTransaccion = new JButton("Transaccion");
		btnTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnTransaccion.setBounds(179, 253, 209, 59);
		contentPane.add(btnTransaccion);
		
		de = new JTextField();
		de.setBounds(6, 216, 74, 25);
		contentPane.add(de);
		de.setColumns(10);
		
		a = new JTextField();
		a.setColumns(10);
		a.setBounds(83, 216, 74, 25);
		contentPane.add(a);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setBounds(17, 188, 55, 16);
		contentPane.add(lblDe);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(86, 188, 55, 16);
		contentPane.add(lblA);
		
		monto = new JTextField();
		monto.setColumns(10);
		monto.setBounds(274, 216, 114, 25);
		contentPane.add(monto);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(278, 188, 55, 16);
		contentPane.add(lblMonto);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(23, 289, 93, 16);
		contentPane.add(lblIdentificador);
		
		identificador = new JTextField();
		identificador.setBounds(23, 308, 114, 20);
		contentPane.add(identificador);
		identificador.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (identificador.getText().equals("9827"))
				{
				
						for (Movimiento movimiento : Movimientos) {
							if(movimiento.getIDOrigen()==9827)
							{
								System.out.println(movimiento.toString());
							}
						}
						
						Calendar calendario = new GregorianCalendar();
						int hora, minutos, segundos;
						hora =calendario.get(Calendar.HOUR_OF_DAY);
						minutos = calendario.get(Calendar.MINUTE);
						segundos = calendario.get(Calendar.SECOND);
						String tiempo=hora+":"+minutos+":"+segundos;
						
						Movimiento mov=new Movimiento(tiempo, 9827, 00000, "Intento Consulta", 00000);
						Movimientos.add(mov);
						//InterfaceCuenta i = (InterfaceCuenta) Naming.lookup("rmi://localhost:5000//setMovimientos");
						
						Vector<List<String>> columnaip = new Vector<List<String>>();
						
						
						for (Movimiento movimiento : Movimientos) {
							Vector<String> fila=new Vector<String>();
							fila.add(movimiento.getFecha());
							fila.add(String.valueOf(movimiento.IDOrigen));
							fila.add(String.valueOf(movimiento.IDDestino));
							fila.add(movimiento.tipo);
							fila.add(String.valueOf(movimiento.valor));
							columnaip.add(fila);						
						}
					
					
					Vector<String> name = new Vector<String>();
					name.add("Hora");
					name.add("IDOrigen");
					name.add("IDDestino");
					name.add("tipo");
					name.add("valor");
					
					
					TableModel juliantia=new DefaultTableModel( columnaip,name);

					table_1.setModel(juliantia);
					
						
	
				}
				//////////////////////
			}
		});
		btnConsultar.setBounds(23, 334, 86, 36);
		contentPane.add(btnConsultar);
		
		JLabel lblOperacion = new JLabel("Operacion");
		lblOperacion.setBounds(169, 188, 86, 16);
		contentPane.add(lblOperacion);
		
		operacion = new JTextField();
		operacion.setBounds(169, 216, 93, 25);
		contentPane.add(operacion);
		operacion.setColumns(10);
	}
}
