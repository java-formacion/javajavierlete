package com.ipartek.maven.taller.AccesoDatos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.maven.taller.entidades.Coche;

public class CocheBD extends ConexionBD{

	//Coches
	
		public Coche[] obtenerCoche(int id) {
			ArrayList<Coche> coches = new ArrayList<Coche>();
			
			try {
				CrearConexion();
				rs = st.executeQuery("select * from coches where idCoche=?");
				ps.setInt(1, id);
				if (rs.next()) {
					Coche co = new Coche();
					co.setId(rs.getInt(1));
					co.setMarca(rs.getString(2));
					co.setModelo(rs.getString(3));
					co.setMatricula(rs.getString(4));
					coches.add(co);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				cerrarConexion();
			}
			return coches.toArray(new Coche[coches.size()]);
		}

		public int insertarCoche(Coche co, int idUsuario) {
			try {
				CrearConexion();
				ps = con.prepareStatement("INSERT INTO coches (marca,modelo,matricula,idUsuario) values (?,?,?,?)");
				ps.setString(1, co.getMarca());
				ps.setString(2, co.getModelo());
				ps.setString(3, co.getMatricula());
				ps.setInt(4, idUsuario);
				ps.executeUpdate();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		public int eliminarCoche(int id) {
			try {
				CrearConexion();
				ps = con.prepareStatement("delete from coches where idCoche=?");
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

		public int updateCoche(int id, Coche co) {
			try {
				CrearConexion();
				ps = con.prepareStatement("UPDATE coches SET marca=?, modelo=?, matricula=? WHERE idCoche=?");
				ps.setString(1, co.getModelo());
				ps.setString(2, co.getMarca());
				ps.setString(3, co.getMatricula());
				ps.setInt(4, id);
				ps.executeUpdate();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				cerrarConexion();
			}
		}

		public int eliminarTodosLosCoches() {
			try {
				CrearConexion();
				ps = con.prepareStatement("delete from coches");
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
		
		public int obtenerIdCochePorMatricula(String matricula) {
			try {
				
					CrearConexion();
					String sql="select idCoche from coches where matricula=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, matricula);
					rs = ps.executeQuery();
					if (rs.next()) {
						int idCoche = rs.getInt(1);
						return idCoche;
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
