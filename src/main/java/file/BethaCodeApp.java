package file;

import dao.AlunoDAO;
import entities.Aluno;

import java.util.List;

public class BethaCodeApp {
    public static void main(String[]args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        //Busca aluno por ID, e excluí no banco
        //Aluno alunoCadastrado = alunoDAO.buscarAlunoPorId(2);
       // alunoDAO.excluirAluno(alunoCadastrado);

        //Busca aluno por id, altera a cidade para Criciúma e atualiza o banco
        Aluno alunoCadastrado = alunoDAO.buscarAlunoPorId(1);
        alunoCadastrado.setCidade("Tubarão");
        alunoDAO.atualizarAluno(alunoCadastrado);

        //Buscar aluno por id
        //Aluno alunoCadastrado = alunoDAO.buscarAlunoPorId(2);
        //System.out.println(alunoCadastrado);

        //Criando um novo aluno
        //Aluno novo = new Aluno("Cléo Constantino", 31, "Criciuma", "SC");
        //alunoDAO.criarAluno(novo);

        //Buscar alunos cadastrados
        //List<Aluno> alunosCadastrados = alunoDAO.buscarAlunos();
        //alunosCadastrados.forEach(aluno -> System.out.println(aluno));

    }
}
