package com.DanSteLlaEs.Registro.domain.service;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
   private DocumentRepository documentRepository;

        public List<Document> getAll(){
            return documentRepository.getAll();
        }
        public Optional<Document> getDocument(int idDocument){
        return documentRepository.getDocument(idDocument);
        }
        public Document save(Document document){
            return documentRepository.save(document);
        }
        public  boolean delete(int idDocument){
            return getDocument(idDocument).map(document -> {
            documentRepository.delete(idDocument);
            return true;
            }).orElse(false);
        }


}
