package cassio.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@Transient // -> impedir que o JPA tente interpretar.
    @JsonIgnore // ignorar a categoria quando for chamada por alguem, tirando o loop.
    @ManyToMany(mappedBy = "categories") // nome da colletion que foi mapeada na classe Product
    private Set<Product> products = new HashSet<>();
    // Set é interface e Hash é a implementação, tem que usar ele
    // para que não tenham produtos iguais dentro da categoria x.


    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;

        return getId() != null ? getId().equals(category.getId()) : category.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
