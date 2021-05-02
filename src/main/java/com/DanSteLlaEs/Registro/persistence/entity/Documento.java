package com.DanSteLlaEs.Registro.persistence.entity;

import javax.persistence.*;


@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documental")
    private Integer idDocumental;

    @Column(name = "tipo_documental")
    private String tipoDocumental;

    @Column(name = "nombre_lote")
    private String nombreLote;

    @Column(name = "campos_indexar")
    private String camposIndexar;

    @Column(name = "nombre_campos")
    private String nombreCampos;

    @Column(name = "nombre_tipo_documental")
    private String nombreTipoDocumental;

    public Integer getIdDocumental() {
        return idDocumental;
    }

    public void setIdDocumental(Integer idDocumental) {
        this.idDocumental = idDocumental;
    }

    public String getTipoDocumental() {
        return tipoDocumental;
    }

    public void setTipoDocumental(String tipoDocumental) {
        this.tipoDocumental = tipoDocumental;
    }

    public String getNombreLote() {
        return nombreLote;
    }

    public void setNombreLote(String nombreLote) {
        this.nombreLote = nombreLote;
    }

    public String getCamposIndexar() {
        return camposIndexar;
    }

    public void setCamposIndexar(String camposIndexar) {
        this.camposIndexar = camposIndexar;
    }

    public String getNombreCampos() {
        return nombreCampos;
    }

    public void setNombreCampos(String nombreCampos) {
        this.nombreCampos = nombreCampos;
    }

    public String getNombreTipoDocumental() {
        return nombreTipoDocumental;
    }

    public void setNombreTipoDocumental(String nombreTipoDocumental) {
        this.nombreTipoDocumental = nombreTipoDocumental;
    }
}
