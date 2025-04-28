// src/main/java/com/squad2/model/ProtocoloSequence.java
package com.squad2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProtocoloSequence {
    @Id
    private String id;
    private Long valor;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}