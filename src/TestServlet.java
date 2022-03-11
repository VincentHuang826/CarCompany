import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "Hello World , Nice To Meet You: 中文化" + System.currentTimeMillis();
        System.out.println("servlet初始化....");
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "<h1>");
        destroy();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
        System.out.println("Servlet銷毀...");
        super.destroy();
    }
}

