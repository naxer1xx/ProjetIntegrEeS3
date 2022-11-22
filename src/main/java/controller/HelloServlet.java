package controller;

import java.io.*;
import java.util.List;

import beans.ClientBean;
import daos.ClientDao;
import daos.DaoException;
import daos.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name="HelloServlet",value="/hello")
public class HelloServlet extends HttpServlet {
	private ClientDao clientDao;
	private String choice;

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.clientDao = daoFactory.getUtilisateurDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		this.choice = request.getParameter("choice");

		
		if(choice != null)
		switch (choice) {
		case "afficher":

			try {
				request.setAttribute("clients", this.clientDao.lister());
				request.getRequestDispatcher("afficher.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "creer":
			break;
		case "modifier":
			break;

		case "supprimer": break;
		}
		else {
			try {
				request.setAttribute("clients", this.clientDao.lister());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("afficher.jsp").forward(request, response);

		}

//    	request.setAttribute("ss",1);
//    	request.getRequestDispatcher("afficher.jsp").forward(request, response);

//    	for(int i = 0 ; i < 100 ; i++) {
//    		System.out.println(i);
//    	}
//    	

	}

	public void destroy() {
	}
}