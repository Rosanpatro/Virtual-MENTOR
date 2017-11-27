package facultyController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FacultyBean;
import dao.FacultyDao;
//import bean.UserBean;

/**
 * Servlet implementation class FirstInternalMark
 */
@WebServlet("/FirstInternalMark")
public class FirstInternalMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstInternalMark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			int count=0,InternalFullMark,size;
			boolean Status = false;
			size = Integer.parseInt(request.getParameter("size"));
			int[] StudentIds = new int[size];
			int[] StudentMarks = new int[size];
			InternalFullMark = Integer.parseInt(request.getParameter("fullMark"));
			List<FacultyBean> StudentList = (List<FacultyBean>)session.getAttribute("StudentList");
			String Department,Semester,Year,SubjectCode;
			SubjectCode = (String)session.getAttribute("SubCode");
			Department = (String) session.getAttribute("Department");
			Semester = (String) session.getAttribute("Semester");
			Year = (String) session.getAttribute("Year");
			try {
			for(FacultyBean bean : StudentList) {
				StudentIds[count] = bean.getStudentId();
				String parameter = Integer.toString(bean.getStudentId());
				StudentMarks[count] = Integer.parseInt(request.getParameter(parameter));
				count++;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			Status = FacultyDao.firstInternalMarkAssign(StudentIds, SubjectCode, InternalFullMark, StudentMarks, Department, Semester, Year);
			if(Status == true)
				response.getWriter().println("Successful");
			else
				response.getWriter().println("Unsuccessful");
		}else
			response.sendRedirect("../Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
