package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Time;
import tools.DataAccess;

/**
 * Servlet implementation class TimeScheduleServlet
 */
@WebServlet("/TimeScheduleServlet")
public class TimeScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeScheduleServlet() {
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
	    

        String stid = request.getParameter("stid");
        String peonum = request.getParameter("peonum");
        String day1 = request.getParameter("date");
        
        SimpleDateFormat simday = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        
		try {
			date = simday.parse(day1);
		} catch (ParseException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week1 = calendar.get(Calendar.DAY_OF_WEEK);
		
		calendar.add(Calendar.DATE, 1);
		int week2 = calendar.get(Calendar.DAY_OF_WEEK);
		String day2 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));

		calendar.add(Calendar.DATE, 1);
		int week3 = calendar.get(Calendar.DAY_OF_WEEK);
		String day3 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));
        
		calendar.add(Calendar.DATE, 1);
		int week4 = calendar.get(Calendar.DAY_OF_WEEK);
		String day4 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));
        
		calendar.add(Calendar.DATE, 1);
		int week5 = calendar.get(Calendar.DAY_OF_WEEK);
		String day5 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));
        
		calendar.add(Calendar.DATE, 1);
		int week6 = calendar.get(Calendar.DAY_OF_WEEK);
		String day6 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));
        
		calendar.add(Calendar.DATE, 1);
		int week7 = calendar.get(Calendar.DAY_OF_WEEK);
		String day7 = String.valueOf(calendar.get(Calendar.YEAR)) + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d",calendar.get(Calendar.DATE));
		
        ArrayList<Time> result = new ArrayList<Time>();
	    DataAccess dao = null;
	    String roomnum = "";
        try {
            dao = new DataAccess();
            result.add(dao.ReservationTimeSelect(stid,peonum,day1,week1));
            result.add(dao.ReservationTimeSelect(stid,peonum,day2,week2));
            result.add(dao.ReservationTimeSelect(stid,peonum,day3,week3));
            result.add(dao.ReservationTimeSelect(stid,peonum,day4,week4));
            result.add(dao.ReservationTimeSelect(stid,peonum,day5,week5));
            result.add(dao.ReservationTimeSelect(stid,peonum,day6,week6));
            result.add(dao.ReservationTimeSelect(stid,peonum,day7,week7));
            roomnum = dao.RoomnumSelect(stid, peonum);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(roomnum);

        request.setAttribute("result", result);
        request.setAttribute("roomnum", roomnum);
        RequestDispatcher rd = request.getRequestDispatcher("TimeJson.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
