package br.rafael.cadastrouniversidades.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.rafael.cadastrouniversidades.database.entidades.Universidade;

@Dao
public interface UniversidadeDao {

    @Insert
    public long[] insert(Universidade...universidades);

    @Query("select * from tb_universidade order by upper(descricao)")
    public List<Universidade> selecionaTodasUniversidades();

    @Update
    public int update(Universidade...universidade);
}
