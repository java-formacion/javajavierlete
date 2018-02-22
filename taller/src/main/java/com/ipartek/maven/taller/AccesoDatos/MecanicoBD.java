package com.ipartek.maven.taller.AccesoDatos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.maven.taller.entidades.Coche;
import com.ipartek.maven.taller.entidades.Mecanico;

public class MecanicoBD extends ConexionBD{

	
	//Mecanicos
	
		public Mecanico[] obtenerMecanico(int id) {
			ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
			try {
				CrearConexion();
				rs = st.executeQuery("select * from mecanicos where idMecanico=?");
				ps.setInt(1, id);
				if (rs.next()) {
					Mecanico  me = new Mecanico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							obtenerCochesPorIdMecanico(rs.getInt(1)));
					mecanicos.add(me);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				cerrarConexion();
			}
			return mecanicos.toArray(new Mecanico[mecanicos.size()]);
		}

		public Mecanico[] obtenerTodosMecanico() {
			ArrayList<Mecanico> mecanicos= new ArrayList<Mecanico>();
			try {
				CrearConexion();
				rs = st.executeQuery("select * from mecanicos");
				while (rs.next()) {
					Mecanico me = new Mecanico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							obtenerCochesPorIdMecanico(rs.getInt(1)));
					mecanicos.add(me);
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				cerrarConexion();
			}
			return mecanicos.toArray(new Mecanico[mecanicos.size()]);
		}
		
		public ArrayList<Coche> obtenerCochesPorIdMecanico(int id) {
			ArrayList<Coche> coches = new ArrayList<Coche>();
			try {
				CrearConexion();
				rs = st.executeQuery(
						"select * from coches where idCoche=(select coches.idCoche from coches_has_mecanicos where mecanicos.idMecanico=(SELECT idMecanico from mecanicos))");
				ps.setInt(1, id);
				while (rs.next()) {
					/*Coche co = new Coche(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							obtenerMecanicoPorIdCoche(rs.getInt(1)));*/
					/*Coche oc
					coches.add(co);*/
				}
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				cerrarConexion();
			}
			return coches;
		}

		public ArrayList<Mecanico> obtenerMecanicoPorIdCoche(int id) {
			ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();

			try {
				CrearConexion();
				rs = st.executeQuery(
						"select * from mecanicos where idMecanico = (select mecanicos_idMecanido from coche_has_mecanicos where coches_idCoche = (select idCoche from coches))");
				ps.setInt(1, id);
				while (rs.next()) {
					Mecanico me = new Mecanico();
					me.setId(rs.getInt(0));
					me.setNombre(rs.getString(1));
					me.setApellidos(rs.getString(2));
					me.setDni(rs.getString(4));
					me.setTelefono(rs.getString(5));
					mecanicos.add(me);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				cerrarConexion();
			}
			return mecanicos;
		}

		public int insertarMecanicoPorObjeto(Mecanico me) {
			try {
				CrearConexion();
				ps = con.prepareStatement("INSERT INTO mecanicos (nombre,apellidos,dni,telefono) values (?,?,?,?)");
				ps.setString(1, me.getNombre());
				ps.setString(2, me.getApellidos());
				ps.setString(3, me.getDni());
				ps.setString(4, me.getTelefono());
				ps.executeUpdate();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		public int eliminarMecanico(int id) {
			try {
				CrearConexion();
				ps = con.prepareStatement("delete from mecanicos where id=?");
				ps.setInt(1, id);
				ps.executeQuery();
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		public int updatearMecanico(int id, Mecanico me) {
			try {
				CrearConexion();
				ps = con.prepareStatement(
						"UPDATE mecanicos SET nombre=?, apellidos=?, dni=?, telefono=? WHERE idMecanico=?");
				ps.setString(1, me.getNombre());
				ps.setString(2, me.getApellidos());
				ps.setString(3, me.getDni());
				ps.setString(4, me.getTelefono());
				ps.setInt(5, id);
				ps.executeUpdate();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		
		public int obtenerIdMecanicoPorDniMecanico(String dni) {
			try {
					CrearConexion();
					String sql="select idMecanico from mecanicos where dni=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, dni);
					rs = ps.executeQuery();
					if (rs.next()) {
						int idMecanico = rs.getInt(1);
						return idMecanico;
					} else {
						return 0;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		
}
