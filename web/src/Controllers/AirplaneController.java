package Controllers;

import Classes.Airplane;
import DB.AirplaneDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AirplaneController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatcher = null;
    AirplaneDAO airplaneDAO = null;

    public AirplaneController() {
        airplaneDAO = new AirplaneDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null) {
            action = "LIST";
        }

        switch(action) {

            case "LIST":
                listAirplane(request, response);
                break;

            case "EDIT":
                getSingleAirplane(request, response);
                break;

            case "DELETE":
                deleteAirplane(request, response);
                break;

            default:
                listAirplane(request, response);
                break;

        }

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

        dispatcher = request.getRequestDispatcher("/airplane-form.jsp");

        dispatcher.forward(request, response);
    }

    private void listAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Airplane> theList = airplaneDAO.get();


        request.setAttribute("list", theList);

        dispatcher = request.getRequestDispatcher("/airplane-form.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Airplane e = new Airplane();
        e.setModel(request.getParameter("Model"));
        e.setEconomySeats(Integer.parseInt(request.getParameter("EconomySeats")));
        e.setBusinessSeats(Integer.parseInt(request.getParameter("dob")));

        if(id.isEmpty() || id == null) {

            if(airplaneDAO.save(e)) {
                request.setAttribute("NOTIFICATION", "Airplane Saved Successfully!");
            }

        }else {

            e.setAirplaneId(Integer.parseInt(id));
            if(airplaneDAO.update(e)) {
                request.setAttribute("NOTIFICATION", "Airplane Updated Successfully!");
            }

        }

        listAirplane(request, response);
    }

}

