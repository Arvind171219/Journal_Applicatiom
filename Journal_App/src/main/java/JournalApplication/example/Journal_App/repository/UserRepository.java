package JournalApplication.example.Journal_App.repository;


import JournalApplication.example.Journal_App.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByusername(String username);

}
