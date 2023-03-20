package com.ssafy.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		0. 파라미터 한글 처리
//		get방식은 한글처리를 알아서 해준다. 근데 post는 한글처리를 꼭 따로 해줘야한다.
		request.setCharacterEncoding("utf-8");

//		1. 작성자 아이디, 글제목, 글내용을 얻으세요.
		String userid = request.getParameter("userid"); // html의 form태그에서 보낸 name 속성값과 매핑하기
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardDto boardDto = new BoardDto();
		boardDto.setuserid(userid);
		boardDto.setSubject(subject);
		boardDto.setContent(content);

//		2. 1의 data를 BoardDao의 writeArticle()메소드에 전달하고 DB에 insert 하세요.
		BoardDaoImpl dao = new BoardDaoImpl();
		int result = dao.writeArticle(boardDto); // 1이면 성공, 0이면 실패

//		3. 2의 결과에 따라 결과 화면을 출력하세요.
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("  <head>");
		out.println("    <meta charset=\"UTF-8\" />");
		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.println("    <link");
		out.println("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"");
		out.println("      rel=\"stylesheet\"");
		out.println("      integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"");
		out.println("      crossorigin=\"anonymous\"");
		out.println("    />");
		out.println("    <link href=\"/board/assets/css/app.css\" rel=\"stylesheet\" />");
		out.println("    <title>SSAFY</title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("    <div class=\"container\">");
		out.println("      <div class=\"row justify-content-center\">");
		out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
		out.println("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">");
		out.println("            <mark class=\"sky\">글쓰기 결과</mark>");
		out.println("          </h2>");
		out.println("        </div>");
		out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");

		if (result == 1) {
//		성공했을 때 출력될 내용
			out.println("          <div class=\"card text-center bg-light\">");
			out.println("            <h2 class=\"fw-bold text-primary pt-3\">등록 완료!!!</h2>");
			out.println("            <div class=\"card-body\">");
			out.println("              <p class=\"card-text\">글작성이 완료되었습니다.</p>");
			out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-primary\">");
			out.println("                글목록 페이지 이동...");
			out.println("              </button>");
			out.println("            </div>");
			out.println("          </div>");
		} else {
//		실패했을 때 출력될 내용
			out.println("          <div class=\"card text-center bg-light\">");
			out.println("            <h2 class=\"fw-bold text-danger pt-3\">등록 실패T.T</h2>");
			out.println("            <div class=\"card-body\">");
			out.println("              <p class=\"card-text\">");
			out.println("                글작성에 문제가 있습니다. <br />");
			out.println("                잠시 후 시도해주세요.");
			out.println("              </p>");
			out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-danger\">");
			out.println("                글목록 페이지 이동...");
			out.println("              </button>");
			out.println("            </div>");
			out.println("          </div>");
		}

		out.println("        </div>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("    <script");
		out.println("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"");
		out.println("      integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"");
		out.println("      crossorigin=\"anonymous\"");
		out.println("    ></script>");
		out.println("    <script>");
		out.println("      document.querySelector(\"#btn-list\").addEventListener(\"click\", function () {");
		out.println("        location.href = \"\";");
		out.println("      });");
		out.println("    </script>");
		out.println("  </body>");
		out.println("</html>");

	}

}
