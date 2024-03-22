package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardWriteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forward = null;
		BoardBean boardBean = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5*1024*1024;	// 5MB로 파일 지정
		// 실제로 저장시킬 파일 이름
		realFolder = request.getServletContext().getRealPath(saveFolder);
		MultipartRequest multi =
				new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			// DefaultFileRenamePolicy 파일 중복 저장 허락
		// 이 때 파일이 실제 저장됨.
		
		// 넘어오는 DATA를 보드 빈에다가 저장하기 
		boardBean = new BoardBean();
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		boardBean.setBoard_file(multi.getOriginalFileName("board_file"));
		
		BoardDAO boardDAO = new BoardDAO();
		int insertCount = boardDAO.insertArticle(boardBean);	// 제대로 된 경우 1이 옵니다. 그렇지 않으면 0
		if(insertCount > 0 ) {
			forward = "boardList.do";
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
