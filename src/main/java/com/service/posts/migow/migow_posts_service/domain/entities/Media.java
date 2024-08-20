package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medias")
@Getter
@Setter
@AllArgsConstructor
public class Media implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false, length = 10)
    private String type;
    @URL
    private String url;

    public Media() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        return Objects.equals(name, other.name) && Objects.equals(type, other.type) && Objects.equals(url, other.url);
    }

}
