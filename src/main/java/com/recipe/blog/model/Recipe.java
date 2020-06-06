package com.recipe.blog.model;

import javax.persistence.*;

import com.sun.istack.NotNull;

import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    
    private String kindOfFood;

    private String lvl;
    
    private String requiredTime;
    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

    public Long getId() {
    	return id;
    }
    
	public String getKindOfFood() {
		return kindOfFood;
	}

	public void setKindOfFood(String kindOfFood) {
		this.kindOfFood = kindOfFood;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(String requiredTime) {
		this.requiredTime = requiredTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}