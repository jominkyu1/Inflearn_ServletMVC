package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns="/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-type
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("Hong Gildong");
        helloData.setAge(30);

        // Json type    {"username":"kim", "age":30}
        String result = objectMapper.writeValueAsString(helloData);

        resp.getWriter().write(result);
    }
}
