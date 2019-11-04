package br.rafael.cadastrouniversidades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import br.rafael.cadastrouniversidades.database.AppDatabase;
import br.rafael.cadastrouniversidades.database.daos.AlunoUniversidadeDao;
import br.rafael.cadastrouniversidades.database.daos.UniversidadeDao;
import br.rafael.cadastrouniversidades.database.entidades.AlunoUniversidade;
import br.rafael.cadastrouniversidades.database.entidades.Universidade;

public class CadastroUniversidadesActivity extends AppCompatActivity {

    private EditText etDescricao;
    private Button btSalvar;
    private RecyclerView rvInformacoes;
    //
    private List<Universidade> listaUniversidades;
    //
    //Instancia/Conexão com banco de dados
    private AppDatabase instanciaBD;
    //
    //DAO para manipular a tabela de universidades
    private UniversidadeDao universidadeDao;
    private AlunoUniversidadeDao alunoUniversidadeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_universidades);
        inicializaConexaoBanco();
        inicializaComponentes();
        carregaUniversidades();
    }

    private void inicializaConexaoBanco()
    {
        //
        //Busca instancia/conexão com banco de dados
        instanciaBD = AppDatabase.getInstancia(this);
        //
        //Da conexão busca o DAO para ser utilizado
        universidadeDao = instanciaBD.getUniversidadeDao();
        alunoUniversidadeDao = instanciaBD.getAlunoUniversidadeDao();
        List<AlunoUniversidade> alunoUniversidades
                = alunoUniversidadeDao.selectAlunosESuasUniversidades();
    }

    private void inicializaComponentes() {
        etDescricao = findViewById(R.id.etDescricao);
        btSalvar = findViewById(R.id.btSalvar);
        rvInformacoes = findViewById(R.id.rvInformacoes);
        rvInformacoes.setAdapter(new MeuAdapter());
        //
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaNovaUniversidade();
            }
        });
    }

    private void carregaUniversidades()
    {
        listaUniversidades = universidadeDao.selecionaTodasUniversidades();
        rvInformacoes.getAdapter().notifyDataSetChanged();
    }

    private void salvaNovaUniversidade()
    {
        String descricao = etDescricao.getText().toString().trim();

        if(!descricao.isEmpty())
        {
            // Cria o objeto para ser inserido
            Universidade novaUniversidade = new Universidade();
            novaUniversidade.setDescricao(descricao);
            //
            //Com o DAO é possível realizar as operações no banco
            universidadeDao.insert(novaUniversidade);
            //
            //Após inserir, precisa carregar as universidade novamente
            carregaUniversidades();
            //
            //
            etDescricao.setText("");
        }
    }

    private class MeuHolder extends RecyclerView.ViewHolder
    {
        private TextView tvCodigo;
        private TextView tvDescricao;

        public MeuHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }

    private class MeuAdapter extends RecyclerView.Adapter<CadastroUniversidadesActivity.MeuHolder>
    {

        @NonNull
        @Override
        public MeuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_cadastro_universidade, parent, false);
            MeuHolder holder = new MeuHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MeuHolder holder, int position) {
            Universidade universidade = listaUniversidades.get(position);
            holder.tvCodigo.setText(universidade.getId().toString());
            holder.tvDescricao.setText(universidade.getDescricao());
        }

        @Override
        public int getItemCount() {
            return listaUniversidades != null ? listaUniversidades.size() : 0;
        }
    }
}
