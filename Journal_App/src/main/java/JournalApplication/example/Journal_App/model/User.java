package JournalApplication.example.Journal_App.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Document(collection = "users")
public class User {

    @Id
    private String id;


    private String username;
    private String email;
    private List<String> journalEntryids = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getJournalEntryids() {
        return journalEntryids;
    }

    public void setJournalEntryids(List<String> journalEntryids) {
        this.journalEntryids = journalEntryids;
    }
}
