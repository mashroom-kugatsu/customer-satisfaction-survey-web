package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dto.FilePathDto;
import dto.InsertDataDto;
import model.GetInsertDataLogic;

/**
 * Servlet implementation class ConfrimDisplayServlet
 */
@WebServlet("/ConfirmServlet")
@MultipartConfig(location = "C:/temp")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("file");
		String uploadDir = "C:/Users/S.Matsukawa/Desktop/cs_web_entry/upload/";
		String fileName = part.getSubmittedFileName();
		String uploadFilePath = uploadDir + fileName;
		part.write(uploadFilePath);
		
		FilePathDto filePathDto = new FilePathDto(uploadFilePath);
		
		HttpSession sessionFilePath = request.getSession();
		sessionFilePath.setAttribute("filePathDto", filePathDto);

		GetInsertDataLogic getInsertDataLogic = new GetInsertDataLogic();
		List<InsertDataDto> insertDataList = getInsertDataLogic.getInsertDataList(uploadFilePath);

		HttpSession session = request.getSession();
		session.setAttribute("insertDataList", insertDataList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/confirm.jsp");
		dispatcher.forward(request, response);

	}

}
