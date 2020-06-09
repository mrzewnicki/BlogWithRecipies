package com.cookingbook.model;

import javax.persistence.*;

import com.sun.istack.NotNull;

import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "przepis")
public class Przepis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "przepis_id")
    private Long id;
    
    private String nazwa;
    
    private String rodzajPotrawy;

    private String poziomTrudnosci; 
    
    private String czasWykonania;
    
    @Column(name="opis", length=10000)
    private String opis;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;
    
    @OneToMany(mappedBy = "przepis")
    private Set<Komentarz> komentarze;
    
    private Blob zdjecie;
    
    public Long getId() {
    	return id;
    }
    
	public String getRodzajPotrawy() {
		return rodzajPotrawy;
	}

	public void setRodzajPotrawy(String rodzajPotrawy) {
		this.rodzajPotrawy = rodzajPotrawy;
	}

	public String getPoziomTrudnosci() {
		return poziomTrudnosci;
	}

	public void setPoziomTrudnosci(String poziomTrudnosci) {
		this.poziomTrudnosci = poziomTrudnosci;
	}

	public String getCzasWykonania() {
		return czasWykonania;
	}

	public void setCzasWykonania(String czasWykonania) {
		this.czasWykonania = czasWykonania;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Blob getZdjecie() {
		return zdjecie;
	}

	public void setZdjecie(Blob zdjecie) {
		this.zdjecie = zdjecie;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}