package com.info.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.info.model.StateCityInfo;


import ha.util.DBUtil;

public class dataExtractDao {
	Connection conn = null;
	ResultSet rslt = null;
	Statement stmt = null;
	
	
	public StateCityInfo getLocDetails(String city) {
		StateCityInfo sci = new StateCityInfo(); 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DBUtil.getInstance().getDBConnection();
			stmt = conn.createStatement();
			String query = "select STATE,CITY,POPULATION,CAPITAL,TEMP from locdtls where CITY = '" + city + "'";
			rslt = stmt.executeQuery(query);
			while (rslt.next()) {
				System.out.println("Did i go inside");
				
				sci.setState(rslt.getString("STATE"));
				sci.setCity(rslt.getString("CITY"));//as we are passing same city
				sci.setPopulation(rslt.getInt("POPULATION"));
				sci.setCapital(rslt.getString("CAPITAL"));
				sci.setTemp(rslt.getInt("TEMP"));
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if  ( rslt != null ) {
					rslt.close();
					rslt = null;
				}
				if  ( stmt != null ) {
					stmt.close();
					stmt = null;
				}
				
				if  ( conn != null ) {
					conn.close();
					conn = null;
				}
				
				
			  }
			catch (Exception e) {
				System.out.println(e);
			}
			
		}

		
		return sci;
	}

//////////////////////////////////////////
	public List<StateCityInfo> getAllCitiesDtls() {
		List<StateCityInfo> sdtls = new ArrayList<StateCityInfo>();
		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DBUtil.getInstance().getDBConnection();
			stmt = conn.createStatement();
			String query = "select STATE,CITY,POPULATION,CAPITAL,TEMP from locdtls";
			rslt = stmt.executeQuery(query);
			while (rslt.next()) {
				 sdtls.add(
						  new StateCityInfo(
									rslt.getString("STATE"),
					                rslt.getString("CITY"),
					                rslt.getString("CAPITAL"),
					                rslt.getInt("POPULATION"),
					                rslt.getInt("TEMP")
								   )
						    );
				

			        }
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if  ( rslt != null ) {
					rslt.close();
					rslt = null;
				}
				if  ( stmt != null ) {
					stmt.close();
					stmt = null;
				}
				
				if  ( conn != null ) {
					conn.close();
					conn = null;
				}
				
				
			  }
			catch (Exception e) {
				System.out.println(e);
			}
			
		}

		
		return sdtls;		
		
		
	}
	
}
