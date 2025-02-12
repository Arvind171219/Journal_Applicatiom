package JournalApplication.example.Journal_App.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
@Document(collection = "journalEntries") // mongodb collection name
public class JournalEntry {

    @Id
    private String id;

    private String title;
    private String content;
    private LocalDate date;

}
