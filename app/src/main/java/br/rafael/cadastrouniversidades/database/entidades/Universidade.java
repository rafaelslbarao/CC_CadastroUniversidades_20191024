package br.rafael.cadastrouniversidades.database.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TB_UNIVERSIDADE")
public class Universidade {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo
    private String descricao;

    public Universidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
