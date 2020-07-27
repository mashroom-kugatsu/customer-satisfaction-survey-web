package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InsertDataDao;
import dto.FilePathDto;
import dto.InsertDataDto;

/**
 * Servlet implementation class CompleteServlet
 */
@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet {
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

		HttpSession sessionFilePath = request.getSession();
		FilePathDto filePathDto = (FilePathDto) sessionFilePath.getAttribute("filePathDto");
		String uploadFilePath = filePathDto.getUploadFilePath();

		HttpSession session = request.getSession();
		List<InsertDataDto> insertDataList = (List<InsertDataDto>) session.getAttribute("insertDataList");
		InsertDataDto insertDataDto = insertDataList.get(0);
		String old_discount = insertDataDto.getOld_discount();

		InsertDataDao insertDataDao = new InsertDataDao();
		boolean result = insertDataDao.insertExcute(uploadFilePath);
		if (result) {
			System.out.println("正常に動作");
			request.setAttribute("msg", old_discount);
			
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
			String mkdirPath = "C:\\Users\\S.Matsukawa\\Desktop\\cs_web_entry\\登録" + "\\" + dateFormat.format(date);

			boolean resultExist = existsDirTest();
			if(!resultExist) {
				File dirPath = new File(mkdirPath);
				dirPath.mkdir();
			}
			
			File uploadFile = new File(uploadFilePath);
			String fileName = uploadFile.getName();
			File registerFile = new File(mkdirPath + "\\" + fileName);
			uploadFile.renameTo(registerFile);
			
		} else {
			System.out.println("失敗");
			request.setAttribute("msg", "失敗");
			
			File uploadFile = new File(uploadFilePath);
			uploadFile.delete();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/complete.jsp");
		dispatcher.forward(request, response);
		
		sessionFilePath.removeAttribute("filePathDto");

	}

	public boolean existsDirTest() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String dirName = dateFormat.format(date);

		File dir = new File("C:\\Users\\S.Matsukawa\\Desktop\\cs_web_entry\\登録" + "\\" + dirName);
		boolean resultExist = dir.exists();
		return resultExist;
	}

}
