/**
 * @Autor yeison caballero diaz
 */
package com.g30.alquiler.computadores.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Param computador 
 * @comment clase entidad
 * @version 1.0
 * se Crea la clase entida que maneja la tabla de la base de datos con sus atributos
 */
@Entity
@Table(name = "computador")
public class Computador implements Serializable{

    /**
     * @apiNote utiliza las anotaciones para generar una 
     * clave pk autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    /**
     * @ManyToOne genera la relacion de muchos a uno la cual crea una nueva column en la tabla
     *se crea las relaciones entre categoria y computadores
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("computers")
    private Categoria category;
/**
 * @OneToMany se genera la relacion uno a muchos entre la entidad mensajes y computadores
 */
     @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Mensaje> messages;
/**
 * @onetomany Se crea la relacion 1 M entre reservaciones y computadores .
 */
    @OneToMany(cascade = {CascadeType.PERSIST},  mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Reservaciones> reservations;

    /**
     * metodo getter
     * @return id
     */
    public Integer getId() {
        return id;
    }
/**
 * retorna el id
 * @param id
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 * metodo getter
 * @return atributo name
 */
    public String getName() {
        return name;
    }
    /**
     * metodo seter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
/**
 * metodo geter
 * @return brand
 */
    public String getBrand() {
        return brand;
    }
/**
 * metodo seter
 * @param brand
 */
    public void setBrand(String brand) {
        this.brand = brand;
    }
/**
 * metodo geter
 * @return year
 */
    public Integer getYear() {
        return year;
    }
/**
 * 
 * @param year
*/
    public void setYear(Integer year) {
        this.year = year;
    }
/**
 * metodo geter
 * @return description
 */
    public String getDescription() {
        return description;
    }
/**
 * metodo geter
 * @return year
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * metodo geter
 * @return category
 */
    public Categoria getCategory() {
        return category;
    }
/**
 * metodo geter
 * @return this.category = category;
 */
    public void setCategory(Categoria category) {
        this.category = category;
    }
/**
 * metodo geter
 * @return messages
 */
    public List<Mensaje> getMessages() {
        return messages;
    }
/**
 * metodo geter
 * @return messages
 */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
/**
 * metodo geter
 * @return reservations
 */
    public List<Reservaciones> getReservations() {
        return reservations;
    }
/**
 * metodo geter
 * @return reservations
 */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}