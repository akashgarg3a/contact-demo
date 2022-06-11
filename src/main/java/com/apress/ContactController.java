package com.apress;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ContactController {

    private ContactRepository contactRepository;

    @GetMapping("/Contacts")
    public ResponseEntity<Iterable<Contact>> getContacts(){
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @PutMapping("/Contacts")
    public ResponseEntity<Contact> AddNewContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        Contact saveData = contactRepository.findById(contact.getEmail()).get();
        return ResponseEntity.ok(saveData);
    }
}
