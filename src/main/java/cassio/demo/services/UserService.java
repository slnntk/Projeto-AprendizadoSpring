package cassio.demo.services;

import cassio.demo.entities.User;
import cassio.demo.repositories.UserRepository;

import cassio.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        //return obj.get(); -> antigo porém da exception
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        // Esse obj.orElseThrow() é simplesmente um get, mas funciona da seguinte forma:
        // Vou tentar dar o get, se não conseguir vou chamar a Exception pre-definida, passando
        // o id que deu erro.
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
