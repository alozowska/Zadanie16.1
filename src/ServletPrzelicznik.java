import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletPrzelicznik")
public class ServletPrzelicznik extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        calculate(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        calculate(request, response);
    }

    private void calculate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String m = request.getParameter("m");
        String cm = request.getParameter("cm");
        String mm = request.getParameter("mm");
        PrintWriter writer = response.getWriter();
        if (m != null) {
            writer.println("Podana wartość w przeliczeniu na: ");
            writer.println("metry: " + Integer.parseInt(m));
            writer.println("centymetry: " + (Integer.parseInt(m) * 100));
            writer.println("milimetry: " + (Integer.parseInt(m) * 1000));
        } else if (cm != null){
            writer.print("Podana wartość w przeliczeniu na: ");
        writer.println("metry: " + (Integer.parseInt(cm) / 100));
        writer.println("centymetry: " + (Integer.parseInt(cm)));
        writer.println("milimetry: " + (Integer.parseInt(cm) * 10));
    } else if (mm!= null)
            writer.println("Podana wartość w przeliczeniu na: ");
        writer.println("metry: " + (Integer.parseInt(mm)/1000));
        writer.println("centymetry: " + (Integer.parseInt(mm))/10);
        writer.println("milimetry: " + (Integer.parseInt(mm)));
}
}
