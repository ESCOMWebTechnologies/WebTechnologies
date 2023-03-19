package webdevelopment.fileuploader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FileForm extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        int fileCount = Integer.parseInt(request.getParameter("fileNumber"));
        String input = "<input type='file' name='file%d' class='form-control'/>";
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Upload form</title>");            
            out.println("<link rel='stylesheet' href='css/bootstrap.css'/>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<h1>Upload your files</h1>");
            out.println("<form method='POST' action='UploadFile' enctype='multipart/form-data'>");
            out.println("<div class='row'>");
            for(int i = 0; i < fileCount; i++){
                out.println("<div class='col'>");
                out.println(String.format(input,i));
                out.println("</div>");
            }
            out.println("</div>");
            out.println(String.format("<input name='fileNumber' value='%d'/>",fileCount));
            out.println("<button type='submit' class='btn btn-outline-success'>Upload file (s)</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}