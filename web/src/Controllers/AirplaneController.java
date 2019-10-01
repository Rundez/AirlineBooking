package Controllers;

import Classes.Airplane;
import DB.AirplaneDAO;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AirplaneController")
public class AirplaneController extends HttpServlet {


    AirplaneDAO airplaneDAO = null;

    public AirplaneController() {
        airplaneDAO = new AirplaneDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String action =  request.getParameter("action");
       if(action.equals("createplane"))
           createAirplane(request, response);
       }



    private void deleteAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if(airplaneDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("NOTIFICATION", "Airplane Deleted Successfully!");
        }

        listAirplane(request, response);
    }

    private void getSingleAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");

        Airplane theAirplane = airplaneDAO.get(Integer.parseInt(id));

        request.setAttribute("airplane", theAirplane);



        response.sendRedirect("../airplane-list.jsp");


    }

    private void listAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Airplane> theList = airplaneDAO.get();

        request.setAttribute("list", theList);


       response.sendRedirect("../airplane-list.jsp");


    }

    protected void createAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String model = request.getParameter("airplaneName");
        int economy = Integer.parseInt(request.getParameter("economy"));
        int business = Integer.parseInt(request.getParameter("business"));



        Airplane e = new Airplane();
        e.setModel(model);
        e.setEconomySeats(economy);
        e.setBusinessSeats(business);

        airplaneDAO.save(e);
        request.setAttribute("notification", "Airplane created");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);



    }

}

