package dao;

import connection.ConexaoJDBC;
import entities.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection minhaConexao;

    public AlunoDAO(){
        this.minhaConexao = ConexaoJDBC.getConnection();
    }

    public void criarAluno(Aluno novoAluno){
        try {
            String meuSql = "insert into aluno (nome, idade, cidade, estado) values (?, ?, ?, ?)";

            PreparedStatement preparedStatement = minhaConexao.prepareStatement(meuSql);
            preparedStatement.setString(1, novoAluno.getNome());
            preparedStatement.setInt(2, novoAluno.getIdade());
            preparedStatement.setString(3, novoAluno.getCidade());
            preparedStatement.setString(4,novoAluno.getEstado());

            int linhaInserida = preparedStatement.executeUpdate();
            System.out.println("Adicionado novo aluno! Inserida " + linhaInserida + " linha(s)!");
        }catch (SQLException e) {
            System.out.println("Gerado erro na inserção de dadaos...");
            System.out.println(e.getMessage());
        }
    }

    public List<Aluno> buscarAlunos(){
        List<Aluno> alunosCadastrados = new ArrayList<>();
        try {
            String meuSql = "select * from aluno";
            PreparedStatement preparedStatement = minhaConexao.prepareStatement(meuSql);
            ResultSet resultadoSql = preparedStatement.executeQuery();

            while (resultadoSql.next()){
                Aluno cadastrado = new Aluno();
                cadastrado.setId(resultadoSql.getInt("id"));
                cadastrado.setNome(resultadoSql.getString("nome"));
                cadastrado.setIdade(resultadoSql.getInt("idade"));
                cadastrado.setCidade(resultadoSql.getString("cidade"));
                cadastrado.setEstado(resultadoSql.getString("estado"));
                alunosCadastrados.add(cadastrado);
            }
        }catch (SQLException e) {
            System.out.println("Gerado erro na busca de dados...");
            System.out.println(e.getMessage());
        }
        return alunosCadastrados;
    }

    public Aluno buscarAlunoPorId(Integer id){
        Aluno alunoCadastrado = new Aluno();
        try {
            String meuSql = "select * from aluno where id = ?";
            PreparedStatement preparedStatement = minhaConexao.prepareStatement(meuSql);
            preparedStatement.setInt(1, id);
            ResultSet resultado = preparedStatement.executeQuery();
            if(resultado.next()){
                alunoCadastrado.setId(resultado.getInt("id"));
                alunoCadastrado.setNome(resultado.getString("nome"));
                alunoCadastrado.setIdade(resultado.getInt("idade"));
                alunoCadastrado.setCidade(resultado.getString("cidade"));
                alunoCadastrado.setEstado(resultado.getString("estado"));
            }
        }catch (SQLException e){
            System.out.println("Gerado erro na busca de dados!");
            System.out.println(e.getMessage());
        }
        return alunoCadastrado;
    }

    public void atualizarAluno(Aluno alunoAtualizar) {
        try {
            String meuSql = "update aluno set nome = ?, idade = ?, cidade = ?, estado = ? where id = ? ";
            PreparedStatement preparedStatement = minhaConexao.prepareStatement(meuSql);
            preparedStatement.setString(1, alunoAtualizar.getNome());
            preparedStatement.setInt(2,alunoAtualizar.getIdade());
            preparedStatement.setString(3, alunoAtualizar.getCidade());
            preparedStatement.setString(4, alunoAtualizar.getEstado());
            preparedStatement.setInt(5, alunoAtualizar.getId());

            int atualizados = preparedStatement.executeUpdate();

            System.out.println("Aluno: " + alunoAtualizar.getId() + " atualizado com sucesso!");
        }catch (SQLException e){
            System.out.println("Gerado erro na atualização de dados...");
            System.out.println(e.getMessage());
        }
    }

    public void excluirAluno(Aluno alunoAtualizar){
        try {
            String meuSql = "delete from aluno where id = ?";
            PreparedStatement preparedStatement = minhaConexao.prepareStatement(meuSql);
            preparedStatement.setInt(1, alunoAtualizar.getId());

            int excluidos = preparedStatement.executeUpdate();
            System.out.println("Aluno " + alunoAtualizar.getId() + " excluído com sucesso!");
        }catch (SQLException e) {
            System.out.println("Gerado erro na atualização de dados...");
            System.out.println(e.getMessage());
        }
    }
}


