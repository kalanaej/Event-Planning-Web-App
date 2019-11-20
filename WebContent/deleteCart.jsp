<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%
    if(request.getParameter("delete_id")!=null) 
    {
        int eventId=Integer.parseInt(request.getParameter("delete_id")); 
        
        String url="jdbc:mysql://localhost/event"; 
        String username="root"; 
        String password=""; 
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(url,username,password); 
            
            PreparedStatement pstmt=null; 
            
            pstmt=con.prepareStatement("delete from cart where eventId=? "); 
            pstmt.setInt(1,eventId);
            pstmt.executeUpdate(); 

            RequestDispatcher rd=request.getRequestDispatcher("viewCart.jsp"); 
            rd.forward(request, response); 
            
            pstmt.close(); 
            
            con.close();    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
%>