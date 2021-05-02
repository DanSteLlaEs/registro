package com.DanSteLlaEs.Registro.persistence;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.repository.DocumentRepository;
import com.DanSteLlaEs.Registro.persistence.crud.DocumentoCrudRepository;
import com.DanSteLlaEs.Registro.persistence.entity.Documento;
import com.DanSteLlaEs.Registro.persistence.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentoRepository implements DocumentRepository {

    @Autowired
    private DocumentoCrudRepository documentCrudRepository;

    @Autowired
    private DocumentMapper mapper;


    @Override
    public List<Document> getAll() {
        List<Documento> documentos= (List<Documento>) documentCrudRepository.findAll();
        return mapper.toDocuments(documentos);
    }

    @Override
    public Optional<Document> getDocument(int idDocument) {
        return documentCrudRepository.findById(idDocument)
                .map(documento -> mapper.toDocument(documento));
    }

    @Override
    public Document save(Document document) {
        Documento documento=mapper.toDocumento(document);
        return mapper.toDocument(documentCrudRepository.save(documento));
    }

    @Override
    public void delete(int idDocument) {
        documentCrudRepository.deleteById(idDocument);
    }
}
