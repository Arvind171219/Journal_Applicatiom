package JournalApplication.example.Journal_App.servicee;


import JournalApplication.example.Journal_App.model.JournalEntry;
import JournalApplication.example.Journal_App.model.User;
import JournalApplication.example.Journal_App.repository.JournalRepository;
import JournalApplication.example.Journal_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<JournalEntry> getAllEntriesByUserId(String userId) {
        return journalRepository.findById(userId);
    }


    public Optional<JournalEntry> getEntryById(String id){
        return journalRepository.findById(id);
    }

    public JournalEntry createEntry(String userId, JournalEntry journalEntry) {
        journalEntry.setDate(LocalDate.now());
        journalEntry.setUserId(userId);
        JournalEntry savedEntry = journalRepository.save(journalEntry);

        // Add the journal entry ID to the user's list of entries
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getJournalEntryids().add(savedEntry.getId());
        userRepository.save(user);

        return savedEntry;
    }

    public JournalEntry updateEntry(String id, JournalEntry journalEntryDetails) {
        JournalEntry journalEntry = journalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
        journalEntry.setTitle(journalEntryDetails.getTitle());
        journalEntry.setContent(journalEntryDetails.getContent());
        return journalRepository.save(journalEntry);
    }

    public  void deleteEntry(String id){
        journalRepository.deleteById(id);
    }

}
