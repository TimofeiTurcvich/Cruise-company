import com.my.DB.DAO.ShipDAO;
import com.my.DB.DAO.StationDAO;
import com.my.DB.DAO.TicketsDAO;
import com.my.DB.ShipDB;
import com.my.DB.StationDB;
import com.my.DB.TicketsDB;
import com.my.classes.User;
import com.my.classes.Voyage;
import com.my.servlets.FavoriteServlet;
import com.my.servlets.SalesServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SalesTest {
    private final List<Voyage> voyages = new ArrayList<>();

    @Test
    void someBoughtTest() throws SQLException, ServletException, IOException {
        Voyage voyage =new Voyage();
        voyages.add(voyage);


        ShipDAO shipDAO = mock(ShipDB.class);
        StationDAO stationDAO = mock(StationDB.class);
        TicketsDAO ticketsDAO = mock(TicketsDB.class);
        SalesServlet salesServlet = new SalesServlet();
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpServletRequest req =  mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher reqDisp = mock(RequestDispatcher.class);

        salesServlet.ticketsDAO = ticketsDAO;
        salesServlet.shipDAO = shipDAO;
        salesServlet.stationDAO = stationDAO;
        salesServlet.path = "";

        when(ticketsDAO.getSaleTickets(shipDAO,stationDAO,"")).thenReturn(voyages);
        when(req.getSession()).thenReturn(session);
        when(req.getRequestDispatcher("sales.jsp?page=1")).thenReturn(reqDisp);

        salesServlet.doGet(req,resp);

        verify(session).setAttribute("salesTickets",voyages);
        verify(reqDisp).forward(req,resp);
    }

    @Test
    void secondPageTest() throws SQLException, ServletException, IOException {
        Voyage voyage =new Voyage();
        voyages.add(voyage);
        voyages.add(voyage);
        voyages.add(voyage);
        voyages.add(voyage);


        ShipDAO shipDAO = mock(ShipDB.class);
        StationDAO stationDAO = mock(StationDB.class);
        TicketsDAO ticketsDAO = mock(TicketsDB.class);
        SalesServlet salesServlet = new SalesServlet();
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpServletRequest req =  mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher reqDisp = mock(RequestDispatcher.class);

        salesServlet.ticketsDAO = ticketsDAO;
        salesServlet.shipDAO = shipDAO;
        salesServlet.stationDAO = stationDAO;
        salesServlet.path = "";

        when(ticketsDAO.getSaleTickets(shipDAO,stationDAO,"")).thenReturn(voyages);
        when(req.getSession()).thenReturn(session);
        when(req.getParameter("page")).thenReturn("2");
        when(req.getRequestDispatcher("sales.jsp")).thenReturn(reqDisp);

        salesServlet.doGet(req,resp);

        verify(reqDisp).forward(req,resp);
    }

    @Test
    void invalidPageTest() throws SQLException, ServletException, IOException {
        Voyage voyage =new Voyage();
        voyages.add(voyage);
        voyages.add(voyage);


        ShipDAO shipDAO = mock(ShipDB.class);
        StationDAO stationDAO = mock(StationDB.class);
        TicketsDAO ticketsDAO = mock(TicketsDB.class);
        SalesServlet salesServlet = new SalesServlet();
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpServletRequest req =  mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher reqDisp = mock(RequestDispatcher.class);

        salesServlet.ticketsDAO = ticketsDAO;
        salesServlet.shipDAO = shipDAO;
        salesServlet.stationDAO = stationDAO;
        salesServlet.path = "";

        when(ticketsDAO.getSaleTickets(shipDAO,stationDAO,"")).thenReturn(voyages);
        when(req.getSession()).thenReturn(session);
        when(req.getParameter("page")).thenReturn("2");
        when(req.getRequestDispatcher("sales.jsp")).thenReturn(reqDisp);

        salesServlet.doGet(req,resp);

        verify(resp).sendError(404,"This page("+req.getParameter("page")+") is not existing");
    }

    @Test
    void sqlException() throws SQLException, ServletException, IOException {
        ShipDAO shipDAO = mock(ShipDB.class);
        StationDAO stationDAO = mock(StationDB.class);
        TicketsDAO ticketsDAO = mock(TicketsDB.class);
        SalesServlet salesServlet = new SalesServlet();
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpServletRequest req =  mock(HttpServletRequest.class);

        salesServlet.ticketsDAO = ticketsDAO;
        salesServlet.shipDAO = shipDAO;
        salesServlet.stationDAO = stationDAO;
        salesServlet.path = "";

        when(ticketsDAO.getSaleTickets(shipDAO,stationDAO,"")).thenThrow(new SQLException());

        salesServlet.doGet(req,resp);

        verify(resp).sendError(500,"Something went wrong. Try again later");
    }
}
