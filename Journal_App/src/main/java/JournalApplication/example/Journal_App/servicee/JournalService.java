package JournalApplication.example.Journal_App.servicee;


import JournalApplication.example.Journal_App.JournalAppApplication;
import JournalApplication.example.Journal_App.model.JournalEntry;
import JournalApplication.example.Journal_App.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAllEntries(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(String id){
        return journalRepository.findById(id);
    }

    public JournalEntry createEntry(JournalEntry journalEntry){
        journalEntry.setDate(LocalDate.now());
        return journalRepository.save(journalEntry);
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
