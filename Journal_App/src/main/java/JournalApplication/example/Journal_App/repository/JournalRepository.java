package JournalApplication.example.Journal_App.repository;

import JournalApplication.example.Journal_App.model.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntry,String> {

}
