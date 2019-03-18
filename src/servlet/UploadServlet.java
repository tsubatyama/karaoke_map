package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entities.Stores;
import tools.DataAccess;

 
 

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8"); 
        
        int cnt = 0;

        Stores res = new Stores();
        
		// 保存先のディレクターを取得
		// (2) アップロードファイルを受け取る準備
	    // ディスク領域を利用するアイテムファクトリーを作成
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	 
	    // tempディレクトリをアイテムファクトリーの一次領域に設定
	    ServletContext servletContext = this.getServletConfig().getServletContext();
	    factory.setRepository((File) servletContext.getAttribute("javax.servlet.context.tempdir"));
	 
	    // ServletFileUploadを作成
	    ServletFileUpload upload = new ServletFileUpload(factory);

	 
	    try {
	      // (3) リクエストをファイルアイテムのリストに変換
	      List<FileItem> items = upload.parseRequest(request);
	 
	      // アップロードパス取得
	      String upPath = "/Users/tsubasakotani/eclipse-workspace/karaoke_map/WebContent/img/";
	      byte[] buff = new byte[1024];
	      int size = 0;
	 
	      for (FileItem item : items) {
	        // (4) アップロードファイルの処理
	        if (!item.isFormField()) {
	          // ファイルをuploadディレクトリに保存
	          BufferedInputStream in = new BufferedInputStream(item.getInputStream());
	          File f = new File(upPath + item.getName());
	          BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
	          while ((size = in.read(buff)) > 0) {
	            out.write(buff, 0, size);
	          }
	          out.close();
	          in.close();
	          
	          res.setPhoto(item.getName());
	          // (5) フォームフィールド（ファイル以外）の処理
	        } else {
                String val = item.getString();
                val = new String(val.getBytes("iso-8859-1"), "utf-8");
	        		switch(cnt) {
	        		case 0:
	        			res.setName(val);
	        			break;
	        		case 1:
	        			res.setIcon(val);
	        			break;
	        		case 2:
	        			res.setTel(val);
	        			break;
	        		case 3:
	        			res.setRoomNum(Integer.parseInt(val));
	        			break;
	        		case 4:
	        			res.setSmallNum(Integer.parseInt(val));
	        			break;
	        		case 5:
	        			res.setMiddleNum(Integer.parseInt(val));
	        			break;
	        		case 6:
	        			res.setLargeNum(Integer.parseInt(val));
	        			break;
	        		case 7:
	        			res.setIsAte(Integer.parseInt(val));
	        			break;
	        		case 8:
	        			res.setAddress(val);
	        			break;
	        		case 9:
	        			res.setLatitude(Double.parseDouble(val));
	        			break;
	        		case 10:
	        			res.setLongitude(Double.parseDouble(val));
	        			break;
	        		case 11:
	        			res.setAccess(val);
	        			break;
	        		case 12:
	        			res.setBusiness(val);
	        			break;
	        		case 13:
	        			res.setHoliday(val);
	        			break;
	        		case 14:
	        			res.setReservationUrl(val);
	        			break;
	        		case 15:
	        			res.setIsImmediately(Integer.parseInt(val));
	        			break;
	        		case 16:
	        			res.setMoneyUrl(val);
	        			break;
	        		case 17:
	        			res.setIsHalf(val);
	        			break;
	        		}
	        		cnt ++;
                
	          // ここでは処理せず、直接requestからgetParamしてもいいと思います。
	        }
	      }
	    } catch (FileUploadException e) {
	      // 例外処理
	    }
	    DataAccess d;
		try {
			d = new DataAccess();
		    d.test(res);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("./InsertIndex.jsp");
	}

}
