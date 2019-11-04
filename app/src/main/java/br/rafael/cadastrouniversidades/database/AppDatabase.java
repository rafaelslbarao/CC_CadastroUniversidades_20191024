package br.rafael.cadastrouniversidades.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.rafael.cadastrouniversidades.database.daos.AlunoDao;
import br.rafael.cadastrouniversidades.database.daos.AlunoUniversidadeDao;
import br.rafael.cadastrouniversidades.database.daos.UniversidadeDao;
import br.rafael.cadastrouniversidades.database.entidades.Aluno;
import br.rafael.cadastrouniversidades.database.entidades.Universidade;

@Database(entities = {Universidade.class, Aluno.class}
        , version = AppDatabase.VERSAO)
public abstract class AppDatabase extends RoomDatabase {

    public static final String NOME = "ArquivoBancoDeDados";
    public static final int VERSAO = 2;

    public abstract UniversidadeDao getUniversidadeDao();
    public abstract AlunoDao getAlunoDao();
    public abstract AlunoUniversidadeDao getAlunoUniversidadeDao();

    private static AppDatabase instancia;

    public static AppDatabase getInstancia(Context context)
    {
        if(instancia == null)
            instancia = Room
                    .databaseBuilder(
                            context
                            , AppDatabase.class
                            , NOME)
                    .addMigrations(new Migration[] {migration1to2})
                    .allowMainThreadQueries()
                    .build();

        return instancia;
    }

    public static Migration migration1to2 = new Migration(1,2)
    {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //Executa a alteração de banco da versão 1 para 2
            //database.execSQL("executa qualquer alteração no banco de dados;");
        }
    };

}
