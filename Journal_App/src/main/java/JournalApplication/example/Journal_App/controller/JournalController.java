package JournalApplication.example.Journal_App.controller;


import JournalApplication.example.Journal_App.model.JournalEntry;
import JournalApplication.example.Journal_App.servicee.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {



    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<JournalEntry> getAllEntries(){
        return journalService.getAllEntries();
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable String id) {
        return journalService.getEntryById(id).orElseThrow(() -> new RuntimeException("Entry not found"));
    }


    @PostMapping
    public JournalEntry createEntry(@RequestBody  JournalEntry journalEntry){
        return journalService.createEntry(journalEntry);
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable String id,@RequestBody JournalEntry journalEntry){
        return journalService.updateEntry(id,journalEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable String id){
        journalService.deleteEntry(id);
    }

}
