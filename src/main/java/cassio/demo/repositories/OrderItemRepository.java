package cassio.demo.repositories;

import cassio.demo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // não precisa dessa anotation, já que ele herda de um Repository.
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{


}
