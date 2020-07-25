package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InsertDataDao;
import dto.FilePathDto;

/**
 * Servlet implementation class CompleteServlet
 */
@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionFilePath = request.getSession();
		FilePathDto filePathDto = (FilePathDto) sessionFilePath.getAttribute("filePathDto");
		String uploadFilePath = filePathDto.getUploadFilePath();
		
		InsertDataDao insertDataDao = new InsertDataDao();
		boolean result = insertDataDao.insertExcute(uploadFilePath);
		if(result) {
			System.out.println("正常に動作");
			request.setAttribute("msg", "登録完了");
		}else {
			System.out.println("失敗");
			request.setAttribute("msg", "失敗");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/complete.jsp");
		dispatcher.forward(request, response);
		
		sessionFilePath.removeAttribute("filePathDto");
		
	}
	


}