package com.DanSteLlaEs.Registro.domain.repository;

import com.DanSteLlaEs.Registro.domain.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository {
    List<Document> getAll();
    Optional<Document> getDocument(int idDocument);
    Document save(Document document);
    void delete(int idDocument);
}
