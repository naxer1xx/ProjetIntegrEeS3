package daos;

import beans.ClientBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

	private DaoFactory daoFactory;

	public ClientDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ClientBean> lister() throws DaoException {

		List<ClientBean> clients = new ArrayList<ClientBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT idC ,  nom, prenom  , email , ville , adresse FROM client;");

			while (resultat.next()) {
				int id = resultat.getInt("idC");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");

				ClientBean client = new ClientBean();
				client.setId(id);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setEmail(email);
				client.setVille(ville);
				client.setAdresse(adresse);

				clients.add(client);

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
		return clients;

	}

	@Override
	public void ajouter(ClientBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO client(nom, prenom,email,ville,adresse) VALUES(?, ?,?,?,?);");
			preparedStatement.setString(1, var.getNom());
			preparedStatement.setString(2, var.getPrenom());
			preparedStatement.setString(3, var.getEmail());
			preparedStatement.setString(4, var.getVille());
			preparedStatement.setString(5, var.getAdresse());

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
	}

	@Override
	public void delete(int idC) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from client where idC = ?;");
			preparedStatement.setInt(1, idC);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}

	}

	@Override
	public void modifier(ClientBean var) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("update client set nom = ? , prenom = ? , ville = ?  , email = ? , adresse = ?   where idC = ?;");
			preparedStatement.setString(1, var.getNom());
			preparedStatement.setString(2, var.getPrenom());
			preparedStatement.setString(3, var.getVille());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getAdresse());
			preparedStatement.setInt(6, var.getId());

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
	}
}
