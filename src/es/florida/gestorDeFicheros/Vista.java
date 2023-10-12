package es.florida.gestorDeFicheros;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.Font;

public class Vista {

	private JFrame frame;
	private JTextField txtDirectorio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textBuscarPor;
	private JTextField textArchivo;
	private JTextField textNombreArchComb;
	
	File directorioTrabajo = new File(System.getProperty("user.home")); // El directorio de trabajo se inicializará en el home del usuario.
	List<File> archivosACombinar = new ArrayList<File>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 870, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gestor de ficheros");
		
		JPanel panelControl = new JPanel();
		panelControl.setBounds(36, 30, 784, 114);
		panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panelControl);
		panelControl.setLayout(null);
		
		JLabel lblSelecDirec = new JLabel("Selecciona un directorio de trabajo:");
		lblSelecDirec.setBounds(21, 14, 207, 13);
		panelControl.add(lblSelecDirec);
		
		txtDirectorio = new JTextField();
		txtDirectorio.setBounds(391, 11, 226, 19);
		panelControl.add(txtDirectorio);
		txtDirectorio.setColumns(10);
		txtDirectorio.setText(directorioTrabajo.getAbsolutePath());
		
		JButton btnMostrarFich = new JButton("Mostrar ficheros");
		btnMostrarFich.setBounds(627, 10, 130, 21);
		panelControl.add(btnMostrarFich);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(21, 48, 88, 13);
		panelControl.add(lblOrdenarPor);
		
		JPanel panelOrdenar1 = new JPanel();
		panelOrdenar1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrdenar1.setBounds(102, 37, 366, 35);
		panelControl.add(panelOrdenar1);
		panelOrdenar1.setLayout(null);
		
		JRadioButton rdbtnNombre = new JRadioButton("Nombre");
		rdbtnNombre.setSelected(true);
		rdbtnNombre.setBounds(6, 6, 87, 21);
		panelOrdenar1.add(rdbtnNombre);
		buttonGroup.add(rdbtnNombre);
		
		JRadioButton rdbtnTamanyo = new JRadioButton("Tamaño");
		rdbtnTamanyo.setBounds(95, 6, 87, 21);
		panelOrdenar1.add(rdbtnTamanyo);
		buttonGroup.add(rdbtnTamanyo);
		
		JRadioButton rdbtnFechaMod = new JRadioButton("Fecha de modificación");
		rdbtnFechaMod.setBounds(197, 6, 163, 21);
		panelOrdenar1.add(rdbtnFechaMod);
		buttonGroup.add(rdbtnFechaMod);
		
		JPanel panelOrdenar2 = new JPanel();
		panelOrdenar2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrdenar2.setBounds(478, 37, 279, 35);
		panelControl.add(panelOrdenar2);
		panelOrdenar2.setLayout(null);
		
		JRadioButton rdbtnAscendente = new JRadioButton("Ascendente");
		rdbtnAscendente.setSelected(true);
		buttonGroup_1.add(rdbtnAscendente);
		rdbtnAscendente.setBounds(6, 6, 102, 21);
		panelOrdenar2.add(rdbtnAscendente);
		
		JRadioButton rdbtnDescendente = new JRadioButton("Descendente");
		buttonGroup_1.add(rdbtnDescendente);
		rdbtnDescendente.setBounds(142, 6, 102, 21);
		panelOrdenar2.add(rdbtnDescendente);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(21, 86, 75, 13);
		panelControl.add(lblBuscarPor);
		
		textBuscarPor = new JTextField();
		textBuscarPor.setBounds(102, 83, 181, 19);
		panelControl.add(textBuscarPor);
		textBuscarPor.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 167, 784, 114);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 341, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textArchivo = new JTextField();
		textArchivo.setBounds(10, 35, 226, 19);
		panel_1.add(textArchivo);
		textArchivo.setColumns(10);
		
		JLabel lblArchivo = new JLabel("Archivo:");
		lblArchivo.setBounds(10, 14, 70, 13);
		panel_1.add(lblArchivo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(361, 10, 303, 64);
		panel.add(scrollPane_1);
		
		JTextArea textAreaArchivos = new JTextArea();
		scrollPane_1.setViewportView(textAreaArchivos);
		textAreaArchivos.setFont(new Font("Monospaced", Font.PLAIN, 9));
		textAreaArchivos.setEditable(false);
		
		JLabel lblFiltrarArchivos = new JLabel("Filtrar archivos");
		lblFiltrarArchivos.setBounds(36, 10, 116, 19);
		lblFiltrarArchivos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblFiltrarArchivos);
		
		JLabel lblCombinarArchivos = new JLabel("Combinar archivos");
		lblCombinarArchivos.setBounds(36, 148, 159, 19);
		lblCombinarArchivos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblCombinarArchivos);
		
		JLabel lblNombreArchComb = new JLabel("Nombre del nuevo archivo combinado:");
		lblNombreArchComb.setBounds(20, 88, 219, 13);
		panel.add(lblNombreArchComb);
		
		textNombreArchComb = new JTextField();
		textNombreArchComb.setBounds(249, 85, 194, 19);
		panel.add(textNombreArchComb);
		textNombreArchComb.setColumns(10);
		
		JLabel lblpuntotxt = new JLabel(".txt");
		lblpuntotxt.setBounds(446, 88, 45, 13);
		panel.add(lblpuntotxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 290, 784, 306);
		frame.getContentPane().add(scrollPane);
		
		JButton btnSelecCarpe = new JButton("Seleccionar carpeta");
		btnSelecCarpe.setBounds(230, 10, 151, 21);
		panelControl.add(btnSelecCarpe);
		// Al hacerle click a un botón sale un modal que pide que elijas el directorio.
		btnSelecCarpe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(directorioTrabajo);
				
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int resultado = fileChooser.showDialog(frame, "Seleccionar carpeta");

				if (resultado == JFileChooser.APPROVE_OPTION) {
					txtDirectorio.setText(fileChooser.getSelectedFile().getAbsolutePath());
					directorioTrabajo = new File(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		JButton btnSelecArchivo = new JButton("Seleccionar archivo");
		// Se mostrará un modal para elegir solo ficheros con extensión txt.
		btnSelecArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(directorioTrabajo);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
			    fileChooser.setFileFilter(filter);
			    
				int resultado = fileChooser.showDialog(frame, "Seleccionar archivo");
				
				if (resultado == JFileChooser.APPROVE_OPTION) {
					textArchivo.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnSelecArchivo.setBounds(80, 10, 156, 21);
		panel_1.add(btnSelecArchivo);
		
		// Este botón servirá para añadir a la lista archivosACombinar el fichero seleccionado
		// y mostrará todos los ficheros a combinar en el textArea de al lado.
		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File archivo = new File(textArchivo.getText());
				if (archivo.exists() && !textArchivo.getText().isBlank()) {
					archivosACombinar.add(archivo);
					String archivosAnyadidos = "";
					for (File txt : archivosACombinar) {
						archivosAnyadidos += txt.getAbsolutePath() + "\n";
					}
					textArchivo.setText("");
					textAreaArchivos.setText(archivosAnyadidos);
				}
			}
		});
		btnAnyadir.setBounds(246, 10, 85, 44);
		panel_1.add(btnAnyadir);
		
		JButton btnCombinar = new JButton("Combinar");
		btnCombinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (archivosACombinar.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "No se ha añadido ningún archivo");
					} else {
						if (textNombreArchComb.getText().isBlank()) {
							JOptionPane.showMessageDialog(frame, "El nombre del nuevo archivo combinado está en blanco.");
						} else {
							// Comprobamos si ya existe un fichero con el mismo nombre.							
							boolean nombreExiste = archivoExiste(directorioTrabajo, (textNombreArchComb.getText() + ".txt"));
							if (nombreExiste) {
								int	resultado = JOptionPane.showConfirmDialog(frame, "El archivo ya existe, ¿quieres sobreescribirlo?", "Advertencia", JOptionPane.YES_NO_OPTION);
								
								if (resultado == JOptionPane.YES_OPTION) {
									// Se sobreescribe el fichero existente.
									File archivoCombinado = new File(directorioTrabajo.getAbsolutePath() + System.getProperty("file.separator") + textNombreArchComb.getText() + ".txt");
									
									combinarArchivos(archivoCombinado, archivosACombinar);
									
									textNombreArchComb.setText("");
									textAreaArchivos.setText("");
									archivosACombinar.clear();
								}
								
							} else {
								// Se crea el archivo donde se van a combinar los contenidos de los archivos seleccionados.
								File archivoCombinado = new File(directorioTrabajo.getAbsolutePath() + System.getProperty("file.separator") + textNombreArchComb.getText() + ".txt");
								
								// El archivo se guardará en el directorio de trabajo.
								combinarArchivos(archivoCombinado, archivosACombinar);

								textNombreArchComb.setText("");
								textAreaArchivos.setText("");
								archivosACombinar.clear();
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getStackTrace());
				}
			}
		});
		btnCombinar.setBounds(674, 10, 100, 64);
		panel.add(btnCombinar);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		btnMostrarFich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				directorioTrabajo = new File(txtDirectorio.getText());
				if (directorioTrabajo.exists()) {
					// Convertimos el tipo de array a List<> para hacer uso de los métodos de List<>.
					List<File> listaArchivos = Arrays.asList(directorioTrabajo.listFiles());
					
					if (rdbtnNombre.isSelected()) ordenarListaPorNombre(listaArchivos);
					else if (rdbtnTamanyo.isSelected()) ordenarListaPorTamanyo(listaArchivos);
					else ordenarListaPorFecha(listaArchivos);
					
					// En caso de estar seleccionado el boton de radio de orden Descendente, Revertir el array usando 
					// el metodo reverse de la clase Collections para que posteriormente se muestre descendentemente.
					if (rdbtnDescendente.isSelected()) Collections.reverse(listaArchivos);
					
					// Mostrar los ficheros que contengan la cadena de caracteres que haya escrita en "buscar por" al darle al botón de Mostrar ficheros.
					if (!textBuscarPor.getText().isEmpty()) {
						listaArchivos = filtrarArchivosPorNombre(listaArchivos);
					}
					
					// Se visualiza el contenido en el textArea principal de la aplicación.
					textArea.setText(generarContenido(listaArchivos));
				} else {
					JOptionPane.showMessageDialog(frame, "Este directorio no existe", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Combina el contenido de una lista de archivos en un archivo nuevo o sobreescribe el existente.
	 *
	 * @param archivoNuevo El archivo en el que se combinará el contenido.
	 * @param archivosACombinar La lista de archivos cuyo contenido se combinará en el archivoNuevo.
	 * @throws Exception Si ocurre un error durante la combinación de archivos, se lanza una excepción.
	 */
	private void combinarArchivos(File archivoNuevo, List<File> archivosACombinar) throws Exception {
		FileWriter fw = new FileWriter(archivoNuevo);
		BufferedWriter bw = new BufferedWriter(fw);

		String linea;
		for (File archivo : archivosACombinar) {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				bw.write(linea);
				bw.newLine();
			}
			br.close();
		}
		bw.close();
	}
	
	/**
	 * Verifica si un archivo con un nombre específico existe en el directorio especificado.
	 *
	 * @param directorio El directorio en el que se buscará el archivo.
	 * @param nombreArchivo El nombre del archivo que se desea verificar.
	 * @return true si el archivo existe en el directorio, false en caso contrario.
	 */
	private boolean archivoExiste(File directorio, String nombreArchivo) {
		for (String archivo : directorio.list()) {
			if (archivo.equals(nombreArchivo)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Ordena una lista de archivos por el nombre de los archivos en orden alfabético ascendente.
	 *
	 * @param lista La lista de archivos que se desea ordenar.
	 */
	private void ordenarListaPorNombre(List<File> lista) {
		lista.sort(new Comparator<File>() {
			public int compare(File archivo1, File archivo2) {
				return archivo1.getName().compareTo(archivo2.getName());
			}
		});
	}
	
	/**
	 * Ordena una lista de archivos por la fecha de modificación en orden ascendente (más reciente primero).
	 *
	 * @param lista La lista de archivos que se desea ordenar por fecha de modificación.
	 */
	private void ordenarListaPorFecha(List<File> lista) {
		lista.sort(new Comparator<File>() {
			public int compare(File archivo1, File archivo2) {
				if (archivo1.lastModified() > archivo2.lastModified()) return -1;
				else if (archivo1.lastModified() < archivo2.lastModified()) return 1;
				else return 0;
			}
		});
	}
	
	/**
	 * Ordena una lista de archivos por el tamaño de los archivos en orden ascendente (desde el más pequeño al más grande).
	 *
	 * @param lista La lista de archivos que se desea ordenar por tamaño.
	 */
	private void ordenarListaPorTamanyo(List<File> lista) {
		lista.sort(new Comparator<File>() {
			public int compare(File archivo1, File archivo2) {
				if (archivo1.length() < archivo2.length()) return -1;
				else if (archivo1.length() > archivo2.length()) return 1;
				else return 0;
			}
		});
	}
	
	/**
	 * Filtra una lista de archivos para incluir solo aquellos cuyos nombres contienen un texto específico.
	 *
	 * @param lista La lista de archivos que se desea filtrar.
	 * @return Una lista que contiene los archivos cuyos nombres coinciden con el texto especificado.
	 */
	private List<File> filtrarArchivosPorNombre(List<File> lista) {
		List<File> archivosCoinciden = new ArrayList<File>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getName().contains(textBuscarPor.getText())) {
				archivosCoinciden.add(lista.get(i));
			}
		}
		return archivosCoinciden;
	}
	
	/**
	 * Genera un informe formateado que incluye detalles de archivos que cumplen con ciertas condiciones.
	 *
	 * @param lista La lista de archivos de la que se generará el informe.
	 * @return Una cadena de texto que contiene los detalles de los archivos seleccionados en un formato específico.
	 */
	private String generarContenido(List<File> lista) {
		String archivostxt = String.format("%-10s\t %-10s\t %-30s\t %s", "Extensión", "Tamaño", "Última fecha modificación", "Nombre de fichero");

		for (File fichero : lista) {
			if (fichero.isFile() && fichero.getName().toLowerCase().endsWith(".txt")) {
				archivostxt += String.format("\n%-10s\t %-10s\t %-30s\t %s",
						fichero.getName().substring(fichero.getName().lastIndexOf(".")),
						String.format("%.2f KB", (double) fichero.length() / 1024),
						new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(fichero.lastModified())),
						fichero.getName());
			}
		}
		return archivostxt;
	}
}
