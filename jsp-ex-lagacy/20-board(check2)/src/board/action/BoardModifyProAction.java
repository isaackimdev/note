package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		
		[ 선생님 풀이 ]
		 
		request.setCharacterEncoding("UTF-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page request.getParameter("page");
		String pass = request.getParameter("board_pass");
		 
		BoardBean boardBean = new BoardBean();
		BoardDAO boardDAO = new BoardDAO();
		boolean isRightUser = boardDAO.isArticleBoardWriter(board_num, pass);
		int updateCount = 0;
		String forward = null;
		
		if(isRightUser) {
			boardBean.setBoard_num(board_num);
			boardBean.setBoard_subject(request.getParameter("board_subject"));
			boardBean.setBoard_content(request.getParameter("board_content"));
			updateCount = boardDAO.updateArticle(boardBean);
			
			if(updateCount == 0) {
				forward = "boardModifyFail.do?board_num=" + board_num + "&err_no=1";
			} else {
				forward = "boardDetail.do?board_num=" + board_num ;
			}			
		} else { 	// err_no  = 2   => 수정할 ㄹ권한이 없음
			forward = "boardModifyFail.do?board_num=" + board_num + "&err_no=2";
		}
		
		request.setAttribute("page", page);
		
		return forward;
		
		*/
		
		String forward = null;
		BoardBean boardBean = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5*1024*1024;
		
		realFolder = request.getServletContext().getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		// 번호 페이지 각종 수정 값
		int page = Integer.parseInt(multi.getParameter("page"));
		int board_num = Integer.parseInt(multi.getParameter("board_num"));
		
		// selecArticle의 비밀번호와 수정할 비밀번호와 비교하여 수정 가능케 함.
		BoardDAO boardDAO = new BoardDAO();
		
		BoardBean boardBeanGi = boardDAO.selectArticle(board_num);
		
		// 자바 빈즈에 담아서 수정 올리기
		boardBean = new BoardBean();
		boardBean.setBoard_num(Integer.parseInt(multi.getParameter("board_num")));
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		String pwChk = boardBean.getBoard_pass();
		System.out.println("[boardBeanGi.getBoard_Pass()] : " + boardBeanGi.getBoard_pass() );
		System.out.println("[pwChk] : " + pwChk );
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		boardBean.setBoard_file(multi.getOriginalFileName("board_file"));

		// 패스워드 일치 여부 체킹하기 
		if(boardBeanGi.getBoard_pass().equals(pwChk)) {
			System.out.println("수정성공");
			boardDAO.modifyArticle(boardBean);
			forward = "boardList.do?page="+page;
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('[수정 실패] 비밀번호가 일치하지 않습니다.')");
			out.println("<script>");
			forward = "boardModifyFail.do";
		}

		return forward;
	}

}
