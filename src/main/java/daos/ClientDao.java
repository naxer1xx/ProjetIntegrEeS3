package daos;

import beans.ClientBean;

import java.util.List;

public interface ClientDao {

    public List<ClientBean> lister() throws DaoException;
    public void ajouter(ClientBean var) throws DaoException;
    public void delete(int idC) throws DaoException;


}
