package Servlet;

import model.VsPlayerModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet.GameScreenServlet", urlPatterns = "/Servlet.GameScreenServlet")

public class GameScreenServlet extends HttpServlet {
	VsPlayerModel vsPlayerModel = new VsPlayerModel();
	private static int x;
	private static int y;
	private static String value = "";

	public void fieldClickHandler() {

		if(!value.equals(" ") && !value.equals("")) {
			return;
		}

		vsPlayerModel.setClickedX(x);
		vsPlayerModel.setClickedY(y);
		vsPlayerModel.setboardTile();

		if(vsPlayerModel.checkWin()) {
			System.out.println("winner: " + (vsPlayerModel.isPlayer1() ? "Player 1" : "Player 2"));
		}
		vsPlayerModel.switchPlayer();

		//System.out.println(model.getClickedY() + " : " + model.getClickedX());

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var proto = req.getParameterMap();

		for (Map.Entry<String, String[]> entry : proto.entrySet()) {
			String[] asd = entry.getKey().split("_");
			x = Integer.parseInt(asd[1]);
			y = Integer.parseInt(asd[0]);
			value = entry.getValue()[0];
			// Do things with the list
		}
		fieldClickHandler();
		req.setAttribute("board", vsPlayerModel.toString());

		RequestDispatcher rd = req.getRequestDispatcher("GameScreen.jsp");
		rd.forward(req, resp);
	}
}
