package com.apress;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ContactController {

    private ContactRepository contactRepository;

    @GetMapping("/Contacts")
    public ResponseEntity<Iterable<Contact>> getContacts(){
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @PostMapping("/Contacts")
    public ResponseEntity<Contact> AddNewContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        Contact saveData = contactRepository.findById(contact.getEmail()).get();
        return ResponseEntity.ok(saveData);
    }
}
