package it.polito.tdp.metroparis.db;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import it.polito.tdp.metroparis.model.Fermata;

public class TestDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = DBConnect.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			MetroDAO dao = new MetroDAO() ;
			Map<Integer, Fermata>test=new HashMap<>();
			dao.getAllFermate(test);
			
			System.out.println(test) ;
		//	System.out.println(dao.getAllLinee()) ;

		} catch (Exception e) {
			throw new RuntimeException("Test FAILED", e);
		}
	}

}
