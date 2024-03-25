
package com.mycomany.grocemart.model;

    


import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Role name, e.g., "admin", "customer", "merchant"

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructors, getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
