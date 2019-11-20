package cart.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cart.model.Cart;


public class cartServices {

	
	//Cart
		public void CreateCart(Cart c1) throws SQLException, ClassNotFoundException {

			DBConnection db = new DBConnection();
			Connection conn = null;
			conn = db.getConnection();

			String insert = "INSERT INTO cart" + "(eventDes,price,quantity,sDate,eDate)" + "VALUES ('" + c1.getDescription() + "','" + c1.getPrice() + "','" + c1.getQuantity() +"','" + c1.getsDate() +"','" + c1.geteDate() +"')";

			Statement stinsert = conn.createStatement();

			stinsert.executeUpdate(insert);
			
			

		}
		
		
}
