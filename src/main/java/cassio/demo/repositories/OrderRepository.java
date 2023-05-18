package cassio.demo.repositories;

import cassio.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // não precisa dessa anotation, já que ele herda de um Repository.
public interface OrderRepository extends JpaRepository<Order, Long>{


}
