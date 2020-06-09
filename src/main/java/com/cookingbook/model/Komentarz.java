package com.cookingbook.model;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "komentarz")
public class Komentarz {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "komentarz_id")
    private Long id;

    @Column(name = "tresc", columnDefinition = "TEXT")
    private String tresc;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dataDodania;

    @ManyToOne
    @JoinColumn(name = "przepis_id", referencedColumnName = "przepis_id", nullable = false)
    private Przepis przepis;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date date) {
        this.dataDodania = date;
    }

    public Przepis getPrzepis() {
        return przepis;
    }

    public void setPrzepis(Przepis przepis) {
        this.przepis = przepis;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}