import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TempCon")
public class TempCon extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String tempStr = request.getParameter("temp");
        String unit = request.getParameter("unit");
        String result = "";

        if (tempStr != null && !tempStr.isEmpty() && unit != null) {
            try {
                double temp = Double.parseDouble(tempStr);
                switch (unit) {
                    case "Celsius":
                        result = "Celsius: " + temp + "°C\n";
                        result += "Fahrenheit: " + (temp * 9/5 + 32) + "°F\n";
                        result += "Kelvin: " + (temp + 273.15) + "K";
                        break;
                    case "Fahrenheit":                                                                                                                                                                                                                                                                      
                        result = "Celsius: " + ((temp - 32) * 5/9) + "°C\n";
                        result += "Fahrenheit: " + temp + "°F\n";                        
                        result += "Kelvin: " + ((temp - 32) * 5/9 + 273.15) + "K";
                        break;
                    case "Kelvin":  
                        result = "Celsius: " + (temp - 273.15) + "°C\n";
                        result += "Fahrenheit: " + ((temp - 273.15) * 9/5 + 32) + "°F\n";
                        result += "Kelvin: " + temp + "K";                      
                        break;
                    default:
                        result = "Invalid unit selected.";
                        break;
                }
            } catch (NumberFormatException e) {
                result = "Invalid temperature value.";
            }
        } else {
            result = "Please enter a temperature value and select a unit.";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Temperature Converter Result</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<style>");
            out.println("body { background: linear-gradient(to right, #4facfe, #00f2fe); display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh; margin: 0; font-family: Arial, sans-serif; }");
            out.println(".container { background-color: #ffffff; border-radius: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; margin-bottom: 20px; width: 100%; max-width: 400px; box-sizing: border-box; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("""
                        <div style='background-color: #ffffff;
                                    border-radius: 30px;
                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                    padding: 20px;
                                    margin-bottom: 20px;
                                    width: 100%;
                                    max-width: 400px;
                                    box-sizing: border-box;
                                    text-align: center;'>""");
            out.println("<b style='font-size: 1.5em; color: #333333;'>Temperature Converter Result</b>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<div>" + result.replace("\n", "<br>") + "</div>");
            out.println("</div>");
            out.println("""
                        <button style='text-align: center; cursor: pointer; font-size: 1.2em; color: #ffffff;
                                    background-image: linear-gradient( 109.6deg,  rgba(102,51,153,1) 11.2%, rgba(2,0,4,1) 91.1% );
                                    border: none;
                                    padding: 15px 20px;
                                    border-radius: 30px;
                                    transition: background-color 0.3s ease;
                                    width: 100%;
                                    max-width: 400px;
                                    box-sizing: border-box;'>""");
            out.println("<a href='index.html' style='text-decoration: none; color: inherit;'>Back</a>");
            out.println("</button>"); 

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Temperature Converter Servlet";
    }
}
