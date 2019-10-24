package br.rafael.cadastrouniversidades.database.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "TB_ALUNO"
        ,
        foreignKeys =
        {
                @ForeignKey(entity = Universidade.class,
                        parentColumns = {"id"},
                        childColumns = {"idUniversidade"}
                )
        }
        , primaryKeys = {"ra", "idUniversidade"}
        )
public class Aluno {

    @NonNull
    private Long ra;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    @NonNull
    private Long idUniversidade;

    public Aluno() {
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdUniversidade() {
        return idUniversidade;
    }

    public void setIdUniversidade(Long idUniversidade) {
        this.idUniversidade = idUniversidade;
    }
}
