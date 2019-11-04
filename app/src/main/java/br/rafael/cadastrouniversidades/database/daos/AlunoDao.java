package br.rafael.cadastrouniversidades.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.rafael.cadastrouniversidades.database.entidades.Aluno;

@Dao
public interface AlunoDao {

    @Insert
    public long[] insert(Aluno...alunos);

    @Query(" select ifnull(max(ra), 0) + 1 " +
            " from TB_ALUNO " +
            " where idUniversidade = :idUniversidade")
    public Long selectProximoCodigoAluno(Long idUniversidade);

    @Query("select * from TB_ALUNO order by nome")
    public List<Aluno> selectTodosOsAlunos();

    @Update
    public int update(Aluno...alunos);

    @Delete
    public int delete(Aluno...alunos);

    @Query("delete from TB_ALUNO")
    public int deletaTodos();

}
