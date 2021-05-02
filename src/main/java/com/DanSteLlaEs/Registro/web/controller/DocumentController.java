package com.DanSteLlaEs.Registro.web.controller;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAll(){
        return new ResponseEntity<>(documentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable("id") int idDocument){
        return documentService.getDocument(idDocument)
                .map(document -> new ResponseEntity<>(document,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Document> save(@RequestBody Document document){
        return new ResponseEntity<>(documentService.save(document),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idDocument){
        if (documentService.delete(idDocument)) {
            return  new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update (@RequestBody Document documentDeatils,@PathVariable("id") int idDocument){
            Optional<Document> document= documentService.getDocument(idDocument);

            if (!document.isPresent()){
                return ResponseEntity.notFound().build();
            }

            document.get().setTypeDocument(documentDeatils.getTypeDocument());
            document.get().setNameLot(documentDeatils.getNameLot());
            document.get().setIndexField(documentDeatils.getIndexField());
            document.get().setNameField(documentDeatils.getNameField());
            document.get().setTypeDocument(documentDeatils.getTypeDocument());

            return ResponseEntity.status(HttpStatus.CREATED).body(documentService.save(document.get()));
    }


}
