package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class Departamentos {

		public static void main(String[] args) {
				
				ConexionBD conexion = new ConexionBD();
			
				
				System.out.println("Conectando a la base de datos...");
				// Paso 1. Obtener la conexion
				Connection con =conexion.getConexion();
				
				//Objetos necesarios para hacer una consulta
				Statement sentencia = null;
				ResultSet resultado = null;
				
				// Algún procesamiento con la base de datos
				// Paso 2. Obtener el Statement
				try {
					sentencia=con.createStatement();
					
					// Paso 3. Ejecutar sentencia
					resultado=sentencia.executeQuery("select cod_departamento, cod_centro, cod_director, tipo_dir, presupuesto, cod_dpto_jefe, nombre from departamentos");
					System.out.println("Cod. Departamento\tcod_Centro\tcod_Director\tTipo_dir\tPresupuesto\tCod_dpto_jefe\tnombre");
					
					// Paso 4. Recorrer el resultado
					while(resultado.next()) {
						int cod_departamento = resultado.getInt("cod_departamento");
						int cod_centro = resultado.getInt("cod_centro");
						int cod_director = resultado.getInt("cod_director");
						String tipo_dir = resultado.getString("tipo_dir");
						int presupuesto = resultado.getInt("presupuesto");
						int cod_dpto_jefe = resultado.getInt("cod_dpto_jefe");
						String nombre = resultado.getString("nombre");
						
						
						System.out.println(cod_departamento+"\t"+cod_centro+"\t"+cod_director+"\t"+tipo_dir+"\t"+presupuesto+"\t"+cod_dpto_jefe+"\t"+nombre);
						}
					
				} catch (SQLException e) {
					System.out.println("Error al consultar los datos. "+e.getMessage());
				}	finally {
					try {
						resultado.close();
						sentencia.close();
					} catch (SQLException e) {
						System.out.println("Error al liberar los recursos");
					}
				}
				
				
				// Liberamos la conexion
				
				System.out.println("Desconectando de la base de datos");
				conexion.desconectar();
			}

		}



