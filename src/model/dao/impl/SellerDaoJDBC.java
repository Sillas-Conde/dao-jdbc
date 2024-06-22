package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		//

	}

	@Override
	public void update(Seller obj) {
		//

	}

	@Override
	public void deleteById(Integer id) {
		//

	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;

		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller " + "INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE " + "department.Id = ? "
									+ "ORDER BY Name");

			st.setInt(1, department.getId());
			rs = st.executeQuery();
			List<Seller> sellers = new ArrayList<>();
			Map<Integer,Department> depMap = new HashMap<>(); 
			
			while (rs.next()) {	
				// Consult depMap for existing department
				Department dep = depMap.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					//Add department to Map if exists
					dep = instatiateDepartment(rs);
					depMap.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);

				sellers.add(seller);

			}
			
			return sellers;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement st = null;

		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller " + "INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE " + "seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				// Existem dados após o índice 0.
				// Portanto, existem resultados.

				Department dep = instatiateDepartment(rs);

				Seller seller = instantiateSeller(rs, dep);

				return seller;

			} else {
				// Não existem dados retornados para o id de entrada.
				return null;
			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();

		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(dep);

		return seller;
	}

	private Department instatiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();

		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));

		return dep;
	}

	@Override
	public List<Seller> findAll() {

		return null;
	}

}
