package servlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Reservations;
import tools.DataAccess;

/**
 * Servlet implementation class ReInsertServlet
 */
@WebServlet("/ReInsertServlet")
public class ReInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");

        Reservations res = new Reservations();
        
        String s_na = request.getParameter("s_na");
        String[] sei_mei = s_na.split(" ");
        res.setSei(sei_mei[0]);
        res.setMei(sei_mei[1]);
        
        res.setStId(Integer.parseInt(request.getParameter("s_id")));
        res.setDay(request.getParameter("s_day"));

        
        System.out.println(request.getParameter("s_arri"));
        String s_arri = request.getParameter("s_arri");
        int a_num = Integer.parseInt(s_arri);
        res.setArrivalTime(String.valueOf(a_num));

        
        System.out.println(request.getParameter("s_use"));
        String s_use = request.getParameter("s_use");
        int b = Integer.parseInt(s_use);
        res.setUseTime(String.valueOf(b));
        
        System.out.println(request.getParameter("s_peo"));
        String numpe = request.getParameter("s_peo");
        res.setNumberpeople(Integer.parseInt(numpe));
        
        res.setTel(request.getParameter("s_tel"));
        res.setMail(request.getParameter("s_mai"));
        res.setRemarks(request.getParameter("s_rem"));
        
	    DataAccess dao = null;

        try {
            dao = new DataAccess();
            dao.ResevationInsert(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
