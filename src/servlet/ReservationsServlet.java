package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.DataAccess;
import entities.Reservations;
import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class ReservationsServlet
 */
@WebServlet("/ReservationsServlet")
public class ReservationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");

		String re_J =  "";
	    String id = request.getParameter("id");
	    String flg = request.getParameter("flg");
	    String time = request.getParameter("time");
	    String date = request.getParameter("date");
	    System.out.println(time);
	    System.out.println(date);
	    System.out.println(flg);
	    int nowtime = Integer.parseInt(time);
	    DataAccess dao = null;
	    String name = "";
	    ArrayList<Reservations> result = new ArrayList<Reservations>();
        try {
            dao = new DataAccess();
            if(flg.equals("0")) {
                result = dao.ReservationsSelect(id,date,nowtime);
            }else {
                result = dao.ReservationsSelect(id,date);
            }
             name = id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

		String reservation = "{";
		reservation += "\"storename\":\""+name+"\",";
		reservation += "\"contents\":[";
		int cnt = 0;
		for(Reservations rec : result){
			String str_n = rec.getSei() + "&nbsp;" + rec.getMei();
			if(cnt == 0) {
				reservation += 	"{\"id\":\""+ rec.getId() +"\",\"arrivaltime\":\""+ rec.getArrivaltime() +"\",\"usetime\":\""+rec.getUsetime()+"\",\"numberpeople\":\""+rec.getNumberpeople()+"\",\"name\":\""+str_n+"\",\"tel\":\""+rec.getTel()+"\",\"mail\":\""+rec.getMail()+"\",\"remarks\":\""+rec.getRemarks()+"\"}";
				cnt += 1;
			}else {
				reservation += 	",{\"id\":\""+ rec.getId() +"\",\"arrivaltime\":\""+ rec.getArrivaltime() +"\",\"usetime\":\""+rec.getUsetime()+"\",\"numberpeople\":\""+rec.getNumberpeople()+"\",\"name\":\""+str_n+"\",\"tel\":\""+rec.getTel()+"\",\"mail\":\""+rec.getMail()+"\",\"remarks\":\""+rec.getRemarks()+"\"}";
			}
		}
		
		reservation += "]";
		reservation += "}";
		
						
		response.setContentType("application/json;charset=UTF-8");
		re_J = JSON.encode(reservation);
		PrintWriter out = response.getWriter();
		out.print(re_J);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
