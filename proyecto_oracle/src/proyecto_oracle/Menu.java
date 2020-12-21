package proyecto_oracle;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import oracle.jdbc.OracleTypes;

public class Menu {

	Excepciones ex = new Excepciones();
	
	/**
	 * Muestra por consola el menu principal.
	 */
	public void menuPrincipal() {

		int key;

		do {
			System.out.println("-----ADMINISTRACION DE INSTITUTO-----");
			System.out.println("Elija una opcion:");
			System.out.println("1. MOSTRAR DATOS.");
			System.out.println("2. INSERTAR DATOS.");
			System.out.println("3. MODIFICAR DATOS.");
			System.out.println("4. ELIMINAR DATOS.");
			System.out.println("0. SALIR DEL PROGRAMA.");

			key = ex.controlInt();

			switch (key) {

			case 1:
				menuMostrar();
				break;
			case 2:
				menuInsertar();
				break;
			case 3:
				menuModificar();
				break;
			case 4:
				menuEliminar();
				break;
			default:
				break;
			}

		} while (key != 0);

		System.out.println("Programa terminado.");
	}
	
	/**
	 * Muestra por consola el menu Mostrar Datos.
	 */
	public void menuMostrar() {

		int key;

		do {
			System.out.println("-----MENU MOSTRAR DATOS-----");
			System.out.println("Elija una opcion:");
			System.out.println("1. MOSTRAR CURSOS.");
			System.out.println("2. MOSTRAR ASIGNATURAS.");
			System.out.println("3. MOSTRAR ALUMNOS.");
			System.out.println("4. MOSTRAR NOTAS.");
			System.out.println("0. VOLVER.");
			
			key = ex.controlInt();

			switch (key) {

			case 1:
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call mostrar_cursos}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call mostrar_asignaturas}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call mostrar_alumnos}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Introduce el DNI del alumno para ver sus notas:");
				String dni = ex.limitaString(10);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call mostrar_notas(?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dni);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			default:
				break;
			}
		} while (key != 0);
	}
	
	/**
	 * Muestra por consola el menu Insertar Datos.
	 */
	public void menuInsertar() {

		int key;

		do {
			System.out.println("-----MENU INSERTAR DATOS-----");
			System.out.println("Elija una opcion:");
			System.out.println("1. INSERTAR CURSO.");
			System.out.println("2. INSERTAR ASIGNATURA.");
			System.out.println("3. INSERTAR ALUMNO.");
			System.out.println("4. INSERTAR NOTAS.");
			System.out.println("0. VOLVER.");
			
			key = ex.controlInt();
			
			switch (key) {
				
			case 1:
				System.out.println("Introduce la ID del curso:");
				int id = ex.limitaInt(4);
				System.out.println("Introduce la descripcion:");
				String descripcion = ex.limitaString(60);
				System.out.println("Introduce el nivel:");
				String nivel = ex.limitaString(30);
				System.out.println("Introduce el turno (M o T):");
				String turno = Character.toString(ex.controlChar());
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call insertar_curso(?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, id);
					cstmt.setString(3, descripcion);
					cstmt.setString(4, nivel);
					cstmt.setString(5, turno);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 2:
				System.out.println("Introduce el codigo de asignatura:");
				int codigo = ex.limitaInt(4);
				System.out.println("Introduce el nombre:");
				String nombreAsignatura = ex.limitaString(80);
				System.out.println("Introduce el tipo:");
				String tipo = ex.limitaString(80);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call insertar_asignatura(?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, codigo);
					cstmt.setString(3, nombreAsignatura);
					cstmt.setString(4, tipo);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Introduce el DNI del alumno:");
				String dni = ex.limitaString(10);
				System.out.println("Introduce el nombre:");
				String nombreAlumno = ex.limitaString(50);
				System.out.println("Introduce la direccion:");
				String direccion = ex.limitaString(50);
				System.out.println("Introduce la poblacion:");
				String poblacion = ex.limitaString(50);
				System.out.println("Introduce el codigo postal:");
				int codPostal = ex.limitaInt(5);
				System.out.println("Introduce la provincia:");
				String provincia = ex.limitaString(40);
				System.out.println("Introduce un telefono de contacto:");
				String telefono1 = ex.limitaString(15);
				System.out.println("Introduce otro telefono de contacto:");
				String telefono2 = ex.limitaString(15);
				System.out.println("Introduce la fecha de nacimiento del alumno:");
				LocalDate fecha = ex.controlDate();
				System.out.println("Introduce la ID de curso del alumno:");
				int idCurso = ex.limitaInt(4);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call insertar_alumno(?,?,?,?,?,?,?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dni);
					cstmt.setString(3, nombreAlumno);
					cstmt.setString(4, direccion);
					cstmt.setString(5, poblacion);
					cstmt.setInt(6, codPostal);
					cstmt.setString(7, provincia);
					cstmt.setString(8, telefono1);
					cstmt.setString(9, telefono2);
					cstmt.setDate(10, Date.valueOf(fecha));
					cstmt.setInt(11, idCurso);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println("Introduce el DNI del alumno al que se va a calificar:");
				String dniBusqueda = ex.limitaString(10);
				System.out.println("Introduce el codigo de asignatura:");
				int codAsignatura = ex.limitaInt(4);
				System.out.println("Introduce la nota de 1a evaluacion:");
				float nota1ev = ex.controlFloat();
				System.out.println("Introduce la nota de 2a evaluacion:");
				float nota2ev = ex.controlFloat();
				System.out.println("Introduce la nota de 3a evaluacion:");
				float nota3ev = ex.controlFloat();
				System.out.println("Introduce la nota de Septiembre (si existe):");
				float notaSept = ex.controlFloat();
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call insertar_nota(?,?,?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dniBusqueda);
					cstmt.setInt(3, codAsignatura);
					cstmt.setFloat(4, nota1ev);
					cstmt.setFloat(5, nota2ev);
					cstmt.setFloat(6, nota3ev);
					cstmt.setFloat(7, notaSept);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		} while (key != 0);
	}
	
	/**
	 * Muestra por consola el menu Modificar Datos.
	 */
	public void menuModificar() {

		int key;

		do {
			System.out.println("-----MENU MODIFICAR DATOS-----");
			System.out.println("Elija una opcion:");
			System.out.println("1. MODIFICAR CURSO.");
			System.out.println("2. MODIFICAR ASIGNATURA.");
			System.out.println("3. MODIFICAR ALUMNO.");
			System.out.println("4. MODIFICAR NOTAS.");
			System.out.println("0. VOLVER.");
			
			key = ex.controlInt();
			
			switch (key) {

			case 1:
				System.out.println("Introduce la ID del curso a modificar:");
				int id = ex.limitaInt(4);
				System.out.println("Introduce la nueva descripcion:");
				String descripcion = ex.limitaString(60);
				System.out.println("Introduce el nuevo nivel:");
				String nivel = ex.limitaString(30);
				System.out.println("Introduce el nuevo turno (M o T):");
				String turno = Character.toString(ex.controlChar());
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call modificar_curso(?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, id);
					cstmt.setString(3, descripcion);
					cstmt.setString(4, nivel);
					cstmt.setString(5, turno);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Introduce el codigo de asignatura a modificar:");
				int codigo = ex.limitaInt(4);
				System.out.println("Introduce el nuevo nombre:");
				String nombreAsignatura = ex.limitaString(80);
				System.out.println("Introduce el nuevo tipo:");
				String tipo = ex.limitaString(80);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call modificar_asignatura(?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, codigo);
					cstmt.setString(3, nombreAsignatura);
					cstmt.setString(4, tipo);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Introduce el DNI del alumno a modificar:");
				String dni = ex.limitaString(10);
				System.out.println("Introduce el nuevo nombre:");
				String nombreAlumno = ex.limitaString(50);
				System.out.println("Introduce la nueva direccion:");
				String direccion = ex.limitaString(50);
				System.out.println("Introduce la nueva poblacion:");
				String poblacion = ex.limitaString(50);
				System.out.println("Introduce el nuevo codigo postal:");
				int codPostal = ex.limitaInt(5);
				System.out.println("Introduce la nueva provincia:");
				String provincia = ex.limitaString(40);
				System.out.println("Introduce un nuevo telefono de contacto:");
				String telefono1 = ex.limitaString(15);
				System.out.println("Introduce otro nuevo telefono de contacto:");
				String telefono2 = ex.limitaString(15);
				System.out.println("Introduce la fecha de nacimiento del alumno:");
				LocalDate fecha = ex.controlDate();
				System.out.println("Introduce la nueva ID de curso del alumno:");
				int idCurso = ex.limitaInt(4);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call modificar_alumno(?,?,?,?,?,?,?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dni);
					cstmt.setString(3, nombreAlumno);
					cstmt.setString(4, direccion);
					cstmt.setString(5, poblacion);
					cstmt.setInt(6, codPostal);
					cstmt.setString(7, provincia);
					cstmt.setString(8, telefono1);
					cstmt.setString(9, telefono2);
					cstmt.setDate(10, java.sql.Date.valueOf(fecha));
					cstmt.setInt(11, idCurso);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Introduce el DNI del alumno al que se le va a modificar la nota:");
				String dniBusqueda = ex.limitaString(10);
				System.out.println("Introduce el codigo de asignatura:");
				int codAsignatura = ex.limitaInt(4);
				System.out.println("Introduce la nota de 1a evaluacion:");
				float nota1ev = ex.controlFloat();
				System.out.println("Introduce la nota de 2a evaluacion:");
				float nota2ev = ex.controlFloat();
				System.out.println("Introduce la nota de 3a evaluacion:");
				float nota3ev = ex.controlFloat();
				System.out.println("Introduce la nota de Septiembre (si existe):");
				float notaSept = ex.controlFloat();
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call modificar_nota(?,?,?,?,?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dniBusqueda);
					cstmt.setInt(3, codAsignatura);
					cstmt.setFloat(4, nota1ev);
					cstmt.setFloat(5, nota2ev);
					cstmt.setFloat(6, nota3ev);
					cstmt.setFloat(7, notaSept);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		} while (key != 0);

	}
	
	/**
	 * Muestra por consola el menu Eliminar Datos.
	 */
	public void menuEliminar() {

		int key;

		do {
			System.out.println("-----MENU ELIMINAR DATOS-----");
			System.out.println("Elija una opcion:");
			System.out.println("1. ELIMINAR CURSO.");
			System.out.println("2. ELIMINAR ASIGNATURA.");
			System.out.println("3. ELIMINAR ALUMNO.");
			System.out.println("4. ELIMINAR NOTAS.");
			System.out.println("0. VOLVER.");

			key = ex.controlInt();
			
			switch (key) {

			case 1:
				System.out.println("Introduce la ID del curso a eliminar:");
				int id = ex.limitaInt(4);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call borrar_curso(?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, id);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Introduce el codigo de la asignatura a eliminar:");
				int codigo = ex.limitaInt(4);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call borrar_asignatura(?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setInt(2, codigo);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Introduce el dni del alumno a eliminar:");
				String dni = ex.limitaString(10);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call borrar_alumno(?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dni);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Introduce el dni del alumno para eliminar su nota:");
				String dniBusqueda = ex.limitaString(10);
				System.out.println("Introduce el codigo de asignatura de la nota a eliminar:");
				int codAsig = ex.limitaInt(4);
				
				try {
					CallableStatement cstmt = Principal.databaseConnection.prepareCall("{? = call borrar_nota(?,?)}");
					cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
					cstmt.setString(2, dniBusqueda);
					cstmt.setInt(3, codAsig);
					cstmt.execute();
					System.out.println(cstmt.getString(1));
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		} while (key != 0);
	}
}
