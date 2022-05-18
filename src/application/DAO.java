package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	private Connection con;
	static int no = -1;

	// For MYSQL Database
/*
	public void connection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AnimalGuesserGameDB", "root", "root");
	}

	String getRandomImage(String table) {
		no++;

		if (no >= 4)
			no = no = 0;

		String fileName = "image" + no + ".jpg"; // System.out.println(fileName);

		try {

			connection();

			Statement st = con.createStatement();

			ResultSet r;

			String sq = "Select Image from " + table + " ORDER BY RAND() LIMIT 1";

			System.out.println(sq);

			r = st.executeQuery(sq);

			if (!r.next()) {

				st.close();
				con.close();

				return null;
			}

			// String fileName = "image.png";

			try (FileOutputStream fos = new FileOutputStream(fileName)) {

				// new FileOutputStream();
				Blob blob = r.getBlob("Image");
				int len = (int) blob.length();

				byte[] buf = blob.getBytes(1, len);

				fos.write(buf, 0, len);
				return fileName;

			} catch (IOException ex) {

				System.out.println("Could not fecth Image. IO Exception.");
			}
			st.close();
			con.close();

		} catch (SQLException s) {
			System.out.println("Connection Failed!");
			s.printStackTrace();
		} catch (Exception s) {
			System.out.println("Exception!");
			s.printStackTrace();
		} finally {

		}

		return fileName;
	}

	String getRequiredImage(String table, int id) {

		String fileName = "image" + 0 + ".jpg"; // System.out.println(fileName);
		try {

			connection();

			Statement st = con.createStatement();

			ResultSet r;

			String sq = "Select Image from " + table + " where ImageID = " + id;

			System.out.println(sq);

			r = st.executeQuery(sq);

			if (!r.next()) {

				st.close();
				con.close();

				return null;
			}

			// String fileName = "image.png";

			try (FileOutputStream fos = new FileOutputStream(fileName)) {

				// new FileOutputStream();
				Blob blob = r.getBlob("Image");
				int len = (int) blob.length();

				byte[] buf = blob.getBytes(1, len);

				// fos.write(buf, 0, len); return fileName;

			} catch (IOException ex) {

				System.out.println("Could not fecth Image. IO Exception.");
			}
			st.close();
			con.close();

		} catch (SQLException s) {
			System.out.println("Connection Failed!");
			s.printStackTrace();
		} catch (Exception s) {
			System.out.println("Exception!");
			s.printStackTrace();
		} finally {

		}

		return fileName;
	}

	String getFact(String table) {

		// System.out.println(fileName);

		try {

			connection(); // PreparedStatement st = con.prepareStatement("Select * from ?
			// where ImageID = // 1"); // ?"); // st.setString(1, table); // st.set(2,
			// ImgId);

			Statement st = con.createStatement();

			ResultSet r;

			String sq = "Select Fact from " + table + " ORDER BY RAND() LIMIT 1";

			System.out.println(sq);

			r = st.executeQuery(sq);

			if (!r.next()) {

				st.close();
				con.close();

				return null;
			}

			String fileName = r.getString(1);

			st.close();
			con.close();

			return fileName;

		} catch (SQLException s) {
			System.out.println("Connection Failed!");
			s.printStackTrace();
		} catch (Exception s) {
			System.out.println("Exception!");
			s.printStackTrace();
		} finally {

		}

		return null;
	}
	*/

	// For SQLITE Database

	public void connection() throws Exception {

		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:src/com/test/db/Database.db");
		System.out.println("ABC");
		
		System.out.println("Connection Established!");
	}

	String getRandomImage(String table) {
		no++;

		if (no >= 4)
			no = no = 0;

		String fileName = "image" + no + ".jpg"; // System.out.println(fileName);

		try {

			connection();

			Statement st = con.createStatement();

			ResultSet r;

			String sq = "Select Image from " + table + " ORDER BY abs(random()) % (3 - 1) + 1 limit 1";

			System.out.println(sq);

			r = st.executeQuery(sq);

			if (!r.next()) {

				st.close();
				con.close();

				return null;
			}

			// String fileName = "image.png";

			try (FileOutputStream fos = new FileOutputStream(fileName)) {

				//new FileOutputStream(); 
//				Blob blob = r.getBlob("Image"); 
//				int len = (int)blob.length();
//
//				byte[] buf = blob.getBytes(1, len);
//
//				fos.write(buf, 0, len);
//				return fileName;

				byte[] buffer = new byte[1024];

                // Get the binary stream of our BLOB data
                InputStream is = r.getBinaryStream("Image");
                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }
				
//				while (r.next()) {
//	                InputStream input = r.getBinaryStream("picture");
//	                byte[] buffer = new byte[1024];
//	                while (input.read(buffer) > 0) {
//	                    fos.write(buffer);
//	                }
//	            }
                return fileName;

				
			} catch (IOException ex) {

				System.out.println("Could not fecth Image. IO Exception.");
			}
			st.close();
			con.close();

		} catch (SQLException s) {
			System.out.println("Connection Failed!");
			s.printStackTrace();
		} catch (Exception s) {
			System.out.println("Exception!");
			s.printStackTrace();
		} finally {

		}

		return fileName;
	}

	String getRequiredImage(String table, int id) {

		String fileName = "image" + 0 + ".jpg"; // System.out.println(fileName);

		try {

			connection();

			Statement st = con.createStatement();

			ResultSet r;

			String sq = "Select Image from " + table + " where ImageID = " + id;

			System.out.println(sq);

			r = st.executeQuery(sq);

			if (!r.next()) {

				st.close();
				con.close();

				return null;
			}

			// String fileName = "image.png";

			try (FileOutputStream fos = new FileOutputStream(fileName)) {

				// new FileOutputStream(); 
				Blob blob = r.getBlob("Image"); int len = (int)
				blob.length();

				byte[] buf = blob.getBytes(1, len);

				// fos.write(buf, 0, len); return fileName;

			} catch (IOException ex) {

				System.out.println("Could not fecth Image. IO Exception.");
			}
			st.close();
			con.close();

		} catch (SQLException s) {
			System.out.println("Connection Failed!");
			s.printStackTrace();
		} catch (Exception s) {
			System.out.println("Exception!");
			s.printStackTrace();
		} finally {

		}

		return fileName;
	}

	String getFact(String table) {
	   
	   // System.out.println(fileName);
	   
	   try {
	   
	   connection(); 
//	   PreparedStatement st = con.prepareStatement("Select   from ? where ImageID = // 1"); // ?"); // 
//	   st.setString(1, table); 
//	   st.set(2,ImgId);
	   
	   Statement st = con.createStatement();
	   
	   ResultSet r;
	   
	   String sq = "Select Fact from " + table +
	   " ORDER BY abs(random()) % (3 - 1) + 1 limit 1";
	   
	   System.out.println(sq);
	   
	   r = st.executeQuery(sq);
	   
	   if (!r.next()) {
	   
	   st.close(); con.close();
	   
	   return null; }

	   String fileName = r.getString(1);
	   
	   st.close(); con.close();
	   
	   return fileName;
	   
	   } catch (SQLException s) { System.out.println("Connection Failed!");
	   s.printStackTrace(); } catch (Exception s) {
	   System.out.println("Exception!"); s.printStackTrace(); } finally {
	   
	   }
	   
	   return null; }

}
