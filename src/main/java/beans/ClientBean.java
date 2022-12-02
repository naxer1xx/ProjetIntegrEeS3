package beans;

public class ClientBean {

    private String nom , prenom , email , ville , adresse ;
    private int id ; 

    public ClientBean(String nom, String prenom, String email, String ville, String adresse, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.ville = ville;
		this.adresse = adresse;
		this.id = id;
	}
    
    

	public ClientBean() {
	}



	public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



	@Override
	public String toString() {
		return "ClientBean [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", ville=" + ville + ", adresse="
				+ adresse + ", id=" + id + "]";
	}
    
    
}
