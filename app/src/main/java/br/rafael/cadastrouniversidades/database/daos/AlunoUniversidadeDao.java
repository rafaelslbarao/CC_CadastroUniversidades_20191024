package br.rafael.cadastrouniversidades.database.daos;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import br.rafael.cadastrouniversidades.database.entidades.AlunoUniversidade;

@Dao
public interface AlunoUniversidadeDao {

    @Query(" select ra, nome nome_aluno, descricao descricao_universidade, idUniversidade " +
            " from tb_aluno " +
            " inner join tb_universidade " +
            " on tb_aluno.idUniversidade = tb_universidade.id")
    public List<AlunoUniversidade> selectAlunosESuasUniversidades();

}
