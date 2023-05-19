package cassio.demo.repositories;

import cassio.demo.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // não precisa dessa anotation, já que ele herda de um Repository.
public interface CategoryRepository extends JpaRepository<Category, Long>{


}
