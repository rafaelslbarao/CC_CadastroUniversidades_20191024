package br.rafael.cadastrouniversidades.database.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


public class AlunoUniversidade {

    private Long ra;

    private String nome_aluno;

    private String descricao_universidade;

    private Long idUniversidade;

    public AlunoUniversidade() {
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getDescricao_universidade() {
        return descricao_universidade;
    }

    public void setDescricao_universidade(String descricao_universidade) {
        this.descricao_universidade = descricao_universidade;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public Long getIdUniversidade() {
        return idUniversidade;
    }

    public void setIdUniversidade(Long idUniversidade) {
        this.idUniversidade = idUniversidade;
    }
}
