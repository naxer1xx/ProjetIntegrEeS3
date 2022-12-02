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

		if (choice != null)
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

				request.getRequestDispatcher("ajouter.jsp").forward(request, response);

				break;

			case "modifier":

				request.setAttribute("clientM",
						new ClientBean(request.getParameter("nom"), request.getParameter("prenom"),
								request.getParameter("email"), request.getParameter("ville"),
								request.getParameter("adresse"), Integer.parseInt(request.getParameter("idC"))));
				request.getRequestDispatcher("modifier.jsp").forward(request, response);

				break;

			case "supprimer":
				try {
					this.clientDao.delete(Integer.parseInt(request.getParameter("idC")));
				} catch (NumberFormatException | DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					request.setAttribute("clients", this.clientDao.lister());
					request.getRequestDispatcher("afficher.jsp").forward(request, response);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String insert = request.getParameter("insert");
		String modifier = request.getParameter("mod");
		System.out.println(insert);

		
		if(insert==null ) {
			insert = "";
		}
		if(modifier==null ) {
			modifier = "";
		}
		
			
			
		if (insert.equals("OK") && insert!=null) {
			try {

				ClientBean client = new ClientBean();
				client.setNom(request.getParameter("nom"));
				client.setPrenom(request.getParameter("prenom"));
				client.setEmail(request.getParameter("email"));
				client.setAdresse(request.getParameter("adresse"));
				client.setVille(request.getParameter("ville"));

				this.clientDao.ajouter(client);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("clients", this.clientDao.lister());
				request.getRequestDispatcher("afficher.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (modifier.equals("OK") && modifier!=null) {
			try {

				ClientBean client = new ClientBean();
				client.setId(Integer.parseInt(request.getParameter("idC")));
				client.setNom(request.getParameter("nom"));
				client.setPrenom(request.getParameter("prenom"));
				client.setEmail(request.getParameter("email"));
				client.setAdresse(request.getParameter("adresse"));
				client.setVille(request.getParameter("ville"));

				System.out.println(client.toString());
				
				this.clientDao.modifier(client);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("clients", this.clientDao.lister());
				request.getRequestDispatcher("afficher.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void destroy() {
	}
}