//package br.com.projeto.GestaoUniversitario.modelo;

//import java.util.ArrayList;

//import java.util.List;
//import java.util.stream.Collectors;

//import javax.swing.JOptionPane;


//public class App {
//    public static void main(String[] args) throws Exception {
//        List<Usuario> admin = new ArrayList<>();
//        List<UsuarioAluno> aluno = new ArrayList<>();
//        List<UsuarioProf> professor = new ArrayList<>();
//        List<UsuarioVistante> visitante = new ArrayList<>();
//        List<Cursos> cursos = new ArrayList<>();
//        List<Forum> forum = new ArrayList<>();
//        List<Salas> salas = new ArrayList<>();
//        List<RespostaForum> respostas = new ArrayList<>();


//      //:::::::::::::::::  LISTAS  :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//        salas.add(new Salas("Java","Java"));
//        salas.add(new Salas("Walker","pontes"));
//        cursos.add(new Cursos("JavaScript", "Criação web"));
//        cursos.add(new Cursos("Css","Básico"));
//        forum.add(new Forum("Java é facil?", "Java"));
//        forum.add(new Forum("Como é que faço uma pagina web", "Html"));
//        aluno.add(new UsuarioAluno("walker","walker@gmail.com", "walker234"));
//        aluno.add(new UsuarioAluno("teste", "teste@gmail.com", "walker234"));
//        professor.add(new UsuarioProf("Raimundo", "raimundo@gmail.com", "raimundo1820"));
//        professor.add(new UsuarioProf("Jose", "jose@gmail.com", "jase1900"));
//        visitante.add(new UsuarioVistante("Maria", "maria@gmail.com", "maria123"));
//        visitante.add(new UsuarioVistante("Pedro", "pedro@gmail.com", "pedro123"));
//        respostas.add(new RespostaForum("Java", "É bom?", "Não"));

//      //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



//        JOptionPane.showMessageDialog(null, "Bem vindo a Faculdade Walk", "Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//        String[] optionss = {"Administrador" , "Professor", "Estudante","Visitante"};
//        int escolha = JOptionPane.showOptionDialog(null, "Que tipo de usuario você é ?","Escolha uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionss, optionss[0]);
///*Admin*/if(escolha==0){
//            String nomeAdmin = JOptionPane.showInputDialog(null, "Coloque seu nome:", "Login Admin", JOptionPane.INFORMATION_MESSAGE);
//            String senhaAdmin = JOptionPane.showInputDialog(null, "Coloque sua senha:", "Login Admin", JOptionPane.INFORMATION_MESSAGE);
//            admin.add(new Usuario(nomeAdmin, senhaAdmin));
//            String[] options = {"Salas","Cursos","Forum","Alunos","Professores","Visitantes"};
//            int escolha2 = JOptionPane.showOptionDialog(null, "O que você deseja acessar:", "Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
//  /*Salas*/ if(escolha2==0){
//                String[] options1 = {"Cria sala","Procurar Sala","Remover Sala"};
//                int escolha3=JOptionPane.showOptionDialog(null, "O que você deseja acessar:", "Faculdade Walk",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
//                if(escolha3==0){
//                    String salaCurso = JOptionPane.showInputDialog(null, "Coloque o nome do Curso:", "Criação de Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    String salaTitulo = JOptionPane.showInputDialog(null, "Coloque o título que deseja:", "Criação de Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    salas.add(new Salas(salaCurso, salaTitulo));
//                   List<Salas> novaSala = salas.stream().filter(s -> s.getTitulo() == salaTitulo).collect(Collectors.toList());
//                    JOptionPane.showMessageDialog(null, novaSala, "Sala Criada", JOptionPane.INFORMATION_MESSAGE);
//                }
//                if(escolha3==1){

//                    String tituloSeach = JOptionPane.showInputDialog(null, "Que sala você quer acessar\nColoque o titulo:", "Procurar Sala - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaTrueOrFalse = salas.stream().anyMatch(sl -> sl.getTitulo().equals(tituloSeach));
//                    if(salaTrueOrFalse == true){
//                        List<Salas> salaSeach = salas.stream().filter(sls -> sls.getTitulo().equals(tituloSeach)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, salaSeach,"Sala encontrada - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada", "Erro - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }
//                if(escolha3==2){
//                    String tituloRemov = JOptionPane.showInputDialog(null, "Qual sala você deseja remover?\nColoque o Titulo:", "Remover Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaRemovTrueOrFalse = salas.stream().anyMatch(rm -> rm.getTitulo().equals(tituloRemov));
//                    if(salaRemovTrueOrFalse==true){
//                        List<Salas> salaRemov = salas.stream().filter(s -> s.getTitulo().equals(tituloRemov)).collect(Collectors.toList());
//                        salas.removeAll(salaRemov);
//                        JOptionPane.showMessageDialog(null, "Essa sala foi removida com sucesso", "Remover Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada\nVerifique se o titulo está certo", "Remover Sala - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }
//            }
//  /*Curso*/ if(escolha2==1){
//                String[] options2 = {"Cria Curso","Procurar Curso","Remover Curso"};
//                int escolha4=JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Curso - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
//                if(escolha4==0){

//                    String cursoNome = JOptionPane.showInputDialog(null, "Coloque o nome do Curso:", "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    String cursoTitulo = JOptionPane.showInputDialog(null, "Coloque o titulo do Curso:", "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    cursos.add(new Cursos(cursoNome, cursoTitulo));
//                   List<Cursos> novoCurso = cursos.stream().filter(s -> s.getNome().equals(cursoNome)).collect(Collectors.toList());
//                   JOptionPane.showMessageDialog(null, novoCurso, "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                }
//                if(escolha4==1){
//                    String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer acessar\nColoque o nome do curso:", "Procurar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//                    if(cursoTrueOrFalse == true){
//                        List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, cursoNameSeach,"Procurar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Procurar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }
//                if(escolha4==2){
//                    String cursoNameRemov = JOptionPane.showInputDialog(null, "Qual curso você deseja remover?\nColoque o nome do curso:", "Remover Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    boolean cursoNameTrueOrFalse = cursos.stream().anyMatch(rm -> rm.getNome().equals(cursoNameRemov));
//                    if(cursoNameTrueOrFalse==true){
//                        List<Cursos> cursoRemov = cursos.stream().filter(s -> s.getNome().equals(cursoNameRemov)).collect(Collectors.toList());
//                        cursos.removeAll(cursoRemov);
//                        JOptionPane.showMessageDialog(null, "Esse curso foi removido com sucesso", "Remover Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);}
//                    else{JOptionPane.showMessageDialog(null, "Curso não encontrado\nVerifique se o nome está certo", "Remover Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }

//            }
//  /*Forum*/ if(escolha2==2){
//               String[] opcoes3 = {"Criar Pergunta","Procurar","Remover"};
//               int option = JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Forum - Universidade Walk", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null,opcoes3,opcoes3[0]);
//               switch(option){
//                   case 0:
//                   String creationTheme = JOptionPane.showInputDialog(null, "Qual tema você quer falar ?", "Criação de Forum - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                   var creationQuestion = JOptionPane.showInputDialog(null, "Qual é a sua pergunta?", "Criação de forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);;
//                   forum.add(new Forum(creationQuestion, creationTheme));
//                   List<Forum> newForum = forum.stream().filter(f -> f.getPergunta().equals(creationQuestion)).collect(Collectors.toList());
//                   JOptionPane.showMessageDialog(null, newForum, "Forum criado - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                   break;
//                   case 1:
//                   String[] opcoes4 ={"Tema","Pergunta","Busca Avançada"};
//                   int escolha5 = JOptionPane.showOptionDialog(null, "Por categoria você deseja buscar?", "Busca de Forum - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes4, opcoes4[0]);
//                   switch(escolha5){
//                       case 0:
//                       String seachTema = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       List<Forum> filterTema = forum.stream().filter(filter -> filter.getTema().equals(seachTema)).collect(Collectors.toList());
//                       JOptionPane.showMessageDialog(null, filterTema , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       break;
//                       case 1:
//                       String seachPch = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       List<Forum> filterPch = forum.stream().filter(filter -> filter.getPergunta().equals(seachPch)).collect(Collectors.toList());
//                       JOptionPane.showMessageDialog(null, filterPch , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       break;
//                       case 2:
//                       String theme = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       String shPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                       List<Forum> filterPegunta = forum.stream()
//                                                        .filter(fl -> fl.getTema().equals(theme))
//                                                        .filter(flt -> flt.getPergunta().equals(shPergunta))
//                                                        .collect(Collectors.toList());

//                        JOptionPane.showMessageDialog(null, filterPegunta , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);

//                       int condicao = JOptionPane.showOptionDialog(null, "Você deseja responder?", "Área de resposta - Faculdade Walk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//                       switch(condicao){
//                           case 0:
//                           String resposta = JOptionPane.showInputDialog(null, "Coloque a sua resposta:", "Respondendo pergunta - Facildade Walk", JOptionPane.INFORMATION_MESSAGE);
//                           RespostaForum resposta1 = new RespostaForum(theme, shPergunta, resposta);
//                          JOptionPane.showMessageDialog(null, resposta1, "Pergunta Respondida", JOptionPane.INFORMATION_MESSAGE);
//                          break;
//                           case 1: break;

//                       }break;

//                    }break;
//                   case 2:
//                   String rmvPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja remover?","Remover pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                   List<Forum> RemoverPergunta = forum.stream().filter(pg -> pg.getPergunta().equals(rmvPergunta)).collect(Collectors.toList());
//                    forum.removeAll(RemoverPergunta);

//                    JOptionPane.showMessageDialog(null, "Pergunta removida", "Remover ", JOptionPane.INFORMATION_MESSAGE);
//                    break;

//                }
//            }
//  /*Aluno*/ if(escolha2==3){
//                String[] options4 = {"Procurar Alunos", "Remover Alunos"};
//            int condicao1 = JOptionPane.showOptionDialog(null, "O que você quer acessar?", "Alunos - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4[0]);
//                switch(condicao1){
//                    case 0:
//                        String seachnome = JOptionPane.showInputDialog(null, "Qual aluno você deseja procurar?\nColoque o nome do aluno:", "Procurar Aluno - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                        boolean procurarAluno = aluno.stream().anyMatch(al -> al.getNome().equals(seachnome));
//                        if(procurarAluno==true){
//                        List<UsuarioAluno> alunosList = aluno.stream().filter(f -> f.getNome().equals(seachnome)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, alunosList, "Procurar Aluno - Unviversidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                        }else{JOptionPane.showMessageDialog(null, "Esse aluno " + seachnome + " não existe", "Aluno Inexistente - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//                        break;
//                    case 1:
//                        String rmvAluno = JOptionPane.showInputDialog(null, "Qual aluno você quer remover\nDigite o nome do aluno", "Remover Aluno - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                        Boolean removerAluno = aluno.stream().anyMatch(p -> p.getNome().equals(rmvAluno));
//                        if(removerAluno == true){
//                            List<UsuarioAluno> alunoseach = aluno.stream().filter(p -> p.getNome().equals(rmvAluno)).collect(Collectors.toList());
//                            aluno.removeAll(alunoseach);
//                            JOptionPane.showMessageDialog(null, "O aluno "+rmvAluno+" foi removido","Aluno Removido - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//                        }else{JOptionPane.showMessageDialog(null, "O Aluno "+rmvAluno+" não foi encontrado\nVerifique se o nome esta certo", "Remover Aluno - Univerdade Walk",JOptionPane.INFORMATION_MESSAGE);}
//                        break;

//                }
//          }
///*Professor*/ if(escolha2==4){
//    String[] options5 = {"Procurar Professor", "Remover Professor"};
//    int condicao1 = JOptionPane.showOptionDialog(null, "O que você quer acessar?", "Professor - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options5, options5[0]);
//        switch(condicao1){
//            case 0:
//                String seachnome1 = JOptionPane.showInputDialog(null, "Qual Professor você deseja procurar?\nColoque o nome do professor:", "Procurar Profesor - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                boolean procurarProf = professor.stream().anyMatch(al -> al.getNome().equals(seachnome1));
//                if(procurarProf==true){
//                List<UsuarioProf> profList = professor.stream().filter(f -> f.getNome().equals(seachnome1)).collect(Collectors.toList());
//                JOptionPane.showMessageDialog(null, profList, "Procurar Professor - Unviversidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                }else{JOptionPane.showMessageDialog(null, "Esse Professor " + seachnome1 + " não existe", "Professor Inexistente - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//                break;
//            case 1:
//                String rmvProf = JOptionPane.showInputDialog(null, "Qual Professor você quer remover\nDigite o nome do professor", "Remover Professor - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                Boolean removerProf = professor.stream().anyMatch(p -> p.getNome().equals(rmvProf));
//                if(removerProf == true){
//                    List<UsuarioProf> profseach = professor.stream().filter(p -> p.getNome().equals(rmvProf)).collect(Collectors.toList());
//                    professor.removeAll(profseach);
//                    JOptionPane.showMessageDialog(null, "O Professor "+rmvProf+" foi removido","Professor Removido - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//                }else{JOptionPane.showMessageDialog(null, "O Aluno "+rmvProf+" não foi encontrado\nVerifique se o nome esta certo", "Remover Professor - Univerdade Walk",JOptionPane.INFORMATION_MESSAGE);}
//                break;

//        }
//           }
///*Visitante*/ if(escolha2==5) {
//    String[] options4 = {"Procurar Visitantes", "Remover Visitantes"};
//    int condicao1 = JOptionPane.showOptionDialog(null, "O que você quer acessar?", "Vistantes - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4[0]);
//        switch(condicao1){
//            case 0:
//                String seachnome = JOptionPane.showInputDialog(null, "Qual Visitante você deseja procurar?\nColoque o nome do Visitante:", "Procurar Visitante - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                boolean procurarVis = visitante.stream().anyMatch(al -> al.getNome().equals(seachnome));
//                if(procurarVis==true){
//                List<UsuarioVistante> visList = visitante.stream().filter(f -> f.getNome().equals(seachnome)).collect(Collectors.toList());
//                JOptionPane.showMessageDialog(null, visList, "Procurar Visitante - Unviversidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                }else{JOptionPane.showMessageDialog(null, "Esse visitante " + seachnome + " não existe", "Visitante Inexistente - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//                break;
//            case 1:
//                String rmvVis = JOptionPane.showInputDialog(null, "Qual Vistante você quer remover\nDigite o nome do Visitante", "Remover Visitante - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                Boolean removerVis = visitante.stream().anyMatch(p -> p.getNome().equals(rmvVis));
//                if(removerVis == true){
//                    List<UsuarioVistante> visseach = visitante.stream().filter(p -> p.getNome().equals(rmvVis)).collect(Collectors.toList());
//                    visitante.removeAll(visseach);
//                    JOptionPane.showMessageDialog(null, "O Visitante "+rmvVis+" foi removido","Visitante Removido - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//                }else{JOptionPane.showMessageDialog(null, "O Visitante "+rmvVis+" não foi encontrado\nVerifique se o nome esta certo", "Remover Visitante - Univerdade Walk",JOptionPane.INFORMATION_MESSAGE);}
//                break;

//        }

//            }
//        }

///*Professor*/if(escolha==1){
//            String emailProf = JOptionPane.showInputDialog(null,"Coloque o email:","Login Professor - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//            String nomeProf = JOptionPane.showInputDialog(null, "Coloque o seu nome de usuário:","Login Professor - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            String senhaProf = JOptionPane.showInputDialog(null, "Coloque a senha:","Login Professor - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            Boolean verificar = professor.stream().anyMatch(v -> v.getEmail().equals(emailProf));
//            if (verificar== false){
//                JOptionPane.showMessageDialog(null, "Você não possui cadastro\nVocê ira ser direcionada a área de cadastro", "Universidade Walk", JOptionPane.ERROR_MESSAGE);
//                JOptionPane.showMessageDialog(null, "As informçoes dadas na Área de login\nserá usadas no cadastro automatico", "Cadastro Automático - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//                Boolean cadastro = professor.add(new UsuarioProf(nomeProf, emailProf, senhaProf));
//                if(cadastro==true){JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso", "Cadastro - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);}
//                else{JOptionPane.showMessageDialog(null, "Ouve um erro no cadastro\nTente de novo outra vez :(", "Cadastro - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//            }
//             String[] optionsProf ={"Cursos","Salas","Forum"};
//             int option1 = JOptionPane.showOptionDialog(null, "Oque você deseja acessar?\nEscolha umas das opções abaixo:", "Área do Professor - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsProf, optionsProf[0]);

///*Cursos*/ if(option1==0){
//             String[] options2 = {"Cria Curso","Procurar Curso","Remover Curso"};
//             int escolha4=JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Curso - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
//             if(escolha4==0){

//             String cursoNome = JOptionPane.showInputDialog(null, "Coloque o nome do Curso:", "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//             String cursoTitulo = JOptionPane.showInputDialog(null, "Coloque o titulo do Curso:", "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//             cursos.add(new Cursos(cursoNome, cursoTitulo));
//             List<Cursos> novoCurso = cursos.stream().filter(s -> s.getNome().equals(cursoNome)).collect(Collectors.toList());
//             JOptionPane.showMessageDialog(null, novoCurso, "Criação de Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            }
//             if(escolha4==1){
//             String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer acessar\nColoque o nome do curso:", "Procurar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//             boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//             if(cursoTrueOrFalse == true){
//             List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//             JOptionPane.showMessageDialog(null, cursoNameSeach,"Procurar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Procurar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//            }
//             if(escolha4==2){
//             String cursoNameRemov = JOptionPane.showInputDialog(null, "Qual curso você deseja remover?\nColoque o nome do curso:", "Remover Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//             boolean cursoNameTrueOrFalse = cursos.stream().anyMatch(rm -> rm.getNome().equals(cursoNameRemov));
//             if(cursoNameTrueOrFalse==true){
//             List<Cursos> cursoRemov = cursos.stream().filter(s -> s.getNome().equals(cursoNameRemov)).collect(Collectors.toList());
//             cursos.removeAll(cursoRemov);
//             JOptionPane.showMessageDialog(null, "Esse curso foi removido com sucesso", "Remover Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);}
//             else{JOptionPane.showMessageDialog(null, "Curso não encontrado\nVerifique se o nome está certo", "Remover Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//             }

//        }

///*Salas*/   if(option1==1){
//         String[] options1 = {"Cria sala","Procurar Sala","Remover Sala"};
//                int escolha3=JOptionPane.showOptionDialog(null, "O que você deseja acessar:", "Faculdade Walk",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
//                if(escolha3==0){
//                    String salaCurso = JOptionPane.showInputDialog(null, "Coloque o nome do Curso:", "Criação de Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    String salaTitulo = JOptionPane.showInputDialog(null, "Coloque o título que deseja:", "Criação de Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    salas.add(new Salas(salaCurso, salaTitulo));
//                   List<Salas> novaSala = salas.stream().filter(s -> s.getTitulo() == salaTitulo).collect(Collectors.toList());
//                    JOptionPane.showMessageDialog(null, novaSala, "Sala Criada", JOptionPane.INFORMATION_MESSAGE);
//                }
//                if(escolha3==1){

//                    String tituloSeach = JOptionPane.showInputDialog(null, "Que sala você quer acessar\nColoque o titulo:", "Procurar Sala - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaTrueOrFalse = salas.stream().anyMatch(sl -> sl.getTitulo().equals(tituloSeach));
//                    if(salaTrueOrFalse == true){
//                        List<Salas> salaSeach = salas.stream().filter(sls -> sls.getTitulo().equals(tituloSeach)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, salaSeach,"Sala encontrada - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada", "Erro - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }
//                if(escolha3==2){
//                    String tituloRemov = JOptionPane.showInputDialog(null, "Qual sala você deseja remover?\nColoque o Titulo:", "Remover Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaRemovTrueOrFalse = salas.stream().anyMatch(rm -> rm.getTitulo().equals(tituloRemov));
//                    if(salaRemovTrueOrFalse==true){
//                        List<Salas> salaRemov = salas.stream().filter(s -> s.getTitulo().equals(tituloRemov)).collect(Collectors.toList());
//                        salas.removeAll(salaRemov);
//                        JOptionPane.showMessageDialog(null, "Essa sala foi removida com sucesso", "Remover Sala - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada\nVerifique se o titulo está certo", "Remover Sala - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }

//        }
///*Forum*/  if(option1==2) {
//    String[] opcoes3 = {"Criar Pergunta","Procurar","Remover"};
//    int option = JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Forum - Universidade Walk", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null,opcoes3,opcoes3[0]);
//    switch(option){
//        case 0:
//        String creationTheme = JOptionPane.showInputDialog(null, "Qual tema você quer falar ?", "Criação de Forum - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        var creationQuestion = JOptionPane.showInputDialog(null, "Qual é a sua pergunta?", "Criação de forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);;
//        forum.add(new Forum(creationQuestion, creationTheme));
//        List<Forum> newForum = forum.stream().filter(f -> f.getPergunta().equals(creationQuestion)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, newForum, "Forum criado - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//        break;
//        case 1:
//        String[] opcoes4 ={"Tema","Pergunta","Busca Avançada"};
//        int escolha5 = JOptionPane.showOptionDialog(null, "Por categoria você deseja buscar?", "Busca de Forum - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes4, opcoes4[0]);
//        switch(escolha5){
//            case 0:
//            String seachTema = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterTema = forum.stream().filter(filter -> filter.getTema().equals(seachTema)).collect(Collectors.toList());
//            JOptionPane.showMessageDialog(null, filterTema , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            break;
//            case 1:
//            String seachPch = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterPch = forum.stream().filter(filter -> filter.getPergunta().equals(seachPch)).collect(Collectors.toList());
//            JOptionPane.showMessageDialog(null, filterPch , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            break;
//            case 2:
//            String theme = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            String shPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterPegunta = forum.stream()
//                                             .filter(fl -> fl.getTema().equals(theme))
//                                             .filter(flt -> flt.getPergunta().equals(shPergunta))
//                                             .collect(Collectors.toList());

//             JOptionPane.showMessageDialog(null, filterPegunta , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);

//            int condicao = JOptionPane.showOptionDialog(null, "Você deseja responder?", "Área de resposta - Faculdade Walk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//            switch(condicao){
//                case 0:

//                String resposta = JOptionPane.showInputDialog(null, "Coloque a sua resposta:", "Respondendo pergunta - Facildade Walk", JOptionPane.INFORMATION_MESSAGE);
//                RespostaForum resposta1 = new RespostaForum(theme, shPergunta, resposta);
//               JOptionPane.showMessageDialog(null, resposta1, "Pergunta Respondida", JOptionPane.INFORMATION_MESSAGE);
//               break;
//                case 1: break;

//            }break;

//         }break;
//        case 2:
//        String rmvPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja remover?","Remover pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        List<Forum> RemoverPergunta = forum.stream().filter(pg -> pg.getPergunta().equals(rmvPergunta)).collect(Collectors.toList());
//         forum.removeAll(RemoverPergunta);

//         JOptionPane.showMessageDialog(null, "Pergunta removida", "Remover ", JOptionPane.INFORMATION_MESSAGE);
//         break;

//          }
//        }



//        }

///*Aluno*/if(escolha==2){
//    String alunoEmail = JOptionPane.showInputDialog(null,"Coloque o email:","Login Aluno - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//    String nomeAluno = JOptionPane.showInputDialog(null, "Coloque o seu nome de usuário:","Login Aluno - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    String senhaAluno = JOptionPane.showInputDialog(null, "Coloque a senha:","Login Aluno - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    Boolean verificar = aluno.stream().anyMatch(v -> v.getEmail().equals(alunoEmail));
//    if (verificar== false){
//        JOptionPane.showMessageDialog(null, "Você não possui cadastro\nVocê ira ser direcionada a área de cadastro", "Universidade Walk", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "As informçoes dadas na Área de login\nserá usadas no cadastro automatico", "Cadastro Automático - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        Boolean cadastro = aluno.add(new UsuarioAluno(nomeAluno, alunoEmail, senhaAluno));
//        if(cadastro==true){JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso", "Cadastro - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);}
//        else{JOptionPane.showMessageDialog(null, "Ouve um erro no cadastro\nTente de novo outra vez :(", "Cadastro - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//    }
//     String[] optionsAluno ={"Cursos","Salas","Forum"};
//     int option1 = JOptionPane.showOptionDialog(null, "Oque você deseja acessar?\nEscolha umas das opções abaixo:", "Área do Aluno - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsAluno, optionsAluno[0]);
///*Cursos*/if(option1==0){
//        String[] options2 = {"Procurar Curso","Acessar Curso"};
//        int escolha4=JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Curso - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);

//        if(escolha4==0){
//        String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer procurar?\nColoque o nome do curso:", "Procurar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//        boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//        if(cursoTrueOrFalse == true){
//        List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, cursoNameSeach,"Procurar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//       }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Procurar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//       }

//        if(escolha4==1){
//            String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer acessar?\nColoque o nome do curso:", "Acessar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//        boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//        if(cursoTrueOrFalse == true){
//        List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, cursoNameSeach,"Acessar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//       }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Acessar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}

//        }


//      }

///*Salas*/if(option1==1){
//             String[] options1 = {"Procurar Sala","Acessar Sala"};
//                int escolha3=JOptionPane.showOptionDialog(null, "O que você deseja acessar:", "Faculdade Walk",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);

//                if(escolha3==0){

//                    String tituloSeach = JOptionPane.showInputDialog(null, "Que sala você quer procurar\nColoque o titulo:", "Procurar Sala - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaTrueOrFalse = salas.stream().anyMatch(sl -> sl.getTitulo().equals(tituloSeach));
//                    if(salaTrueOrFalse == true){
//                        List<Salas> salaSeach = salas.stream().filter(sls -> sls.getTitulo().equals(tituloSeach)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, salaSeach,"Sala encontrada - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada", "Erro - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//                }

//                if(escolha3==1){
//                    String tituloSeach = JOptionPane.showInputDialog(null, "Que sala você quer acessar\nColoque o titulo:", "Acessar Sala - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    boolean salaTrueOrFalse = salas.stream().anyMatch(sl -> sl.getTitulo().equals(tituloSeach));
//                    if(salaTrueOrFalse == true){
//                        List<Salas> salaSeach = salas.stream().filter(sls -> sls.getTitulo().equals(tituloSeach)).collect(Collectors.toList());
//                        JOptionPane.showMessageDialog(null, salaSeach,"Sala encontrada - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                    }else{JOptionPane.showMessageDialog(null, "Sala não encontrada", "Erro - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}

//                }
//            }

///*Forum*/if(option1==2){
//    String[] opcoes3 = {"Criar Pergunta","Procurar","Remover"};
//    int option = JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Forum - Universidade Walk", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null,opcoes3,opcoes3[0]);
//    switch(option){
//        case 0:
//        String creationTheme = JOptionPane.showInputDialog(null, "Qual tema você quer falar ?", "Criação de Forum - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        var creationQuestion = JOptionPane.showInputDialog(null, "Qual é a sua pergunta?", "Criação de forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);;
//        forum.add(new Forum(creationQuestion, creationTheme));
//        List<Forum> newForum = forum.stream().filter(f -> f.getPergunta().equals(creationQuestion)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, newForum, "Forum criado - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//        break;
//        case 1:
//        String[] opcoes4 ={"Tema","Pergunta","Busca Avançada"};
//        int escolha5 = JOptionPane.showOptionDialog(null, "Por categoria você deseja buscar?", "Busca de Forum - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes4, opcoes4[0]);
//        switch(escolha5){
//            case 0:
//            String seachTema = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterTema = forum.stream().filter(filter -> filter.getTema().equals(seachTema)).collect(Collectors.toList());
//            JOptionPane.showMessageDialog(null, filterTema , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            break;
//            case 1:
//            String seachPch = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterPch = forum.stream().filter(filter -> filter.getPergunta().equals(seachPch)).collect(Collectors.toList());
//            JOptionPane.showMessageDialog(null, filterPch , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//            break;
//            case 2:
//            String theme = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            String shPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//            List<Forum> filterPegunta = forum.stream()
//                                             .filter(fl -> fl.getTema().equals(theme))
//                                             .filter(flt -> flt.getPergunta().equals(shPergunta))
//                                             .collect(Collectors.toList());

//             JOptionPane.showMessageDialog(null, filterPegunta , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);

//            int condicao = JOptionPane.showOptionDialog(null, "Você deseja responder?", "Área de resposta - Faculdade Walk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//            switch(condicao){
//                case 0:

//                String resposta = JOptionPane.showInputDialog(null, "Coloque a sua resposta:", "Respondendo pergunta - Facildade Walk", JOptionPane.INFORMATION_MESSAGE);
//                RespostaForum resposta1 = new RespostaForum(theme, shPergunta, resposta);
//               JOptionPane.showMessageDialog(null, resposta1, "Pergunta Respondida", JOptionPane.INFORMATION_MESSAGE);
//               break;
//                case 1: break;

//            }break;

//         }break;
//        case 2:
//        String rmvPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja remover?","Remover pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        List<Forum> RemoverPergunta = forum.stream().filter(pg -> pg.getPergunta().equals(rmvPergunta)).collect(Collectors.toList());
//         forum.removeAll(RemoverPergunta);

//         JOptionPane.showMessageDialog(null, "Pergunta removida", "Remover ", JOptionPane.INFORMATION_MESSAGE);
//         break;

//          }

//        }



//       }


///*Visitante*/if(escolha==3){
//    String visitanteEmail = JOptionPane.showInputDialog(null,"Coloque o email:","Login Visitante - Universidade Walk",JOptionPane.INFORMATION_MESSAGE);
//    String nomeVisitante = JOptionPane.showInputDialog(null, "Coloque o seu nome de usuário:","Login Visitante - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    String senhaVisitante = JOptionPane.showInputDialog(null, "Coloque a senha:","Login Visitante - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    Boolean verificar = visitante.stream().anyMatch(v -> v.getEmail().equals(visitanteEmail));
//    if (verificar== false){
//        JOptionPane.showMessageDialog(null, "Você não possui cadastro\nVocê ira ser direcionada a área de cadastro", "Universidade Walk", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "As informçoes dadas na Área de login\nserá usadas no cadastro automatico", "Cadastro Automático - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        Boolean cadastro = visitante.add(new UsuarioVistante(nomeVisitante, visitanteEmail, senhaVisitante));
//        if(cadastro==true){JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso", "Cadastro - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);}
//        else{JOptionPane.showMessageDialog(null, "Ouve um erro no cadastro\nTente de novo outra vez :(", "Cadastro - Universidade Walk", JOptionPane.ERROR_MESSAGE);}
//    }
//     String[] optionsAluno ={"Cursos","Salas","Forum"};
//     int option1 = JOptionPane.showOptionDialog(null, "Oque você deseja acessar?\nEscolha umas das opções abaixo:", "Área do Aluno - Universidade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsAluno, optionsAluno[0]);
///*Cursos*/if(option1==0){
//    String[] options2 = {"Procurar Curso","Acessar Curso"};
//    int escolha4=JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Curso - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);

//    if(escolha4==0){
//    String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer procurar?\nColoque o nome do curso:", "Procurar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//    boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//    if(cursoTrueOrFalse == true){
//    List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//    JOptionPane.showMessageDialog(null, cursoNameSeach,"Procurar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//   }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Procurar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//   }

//    if(escolha4==1){
//        String cursoSeach = JOptionPane.showInputDialog(null, "Que curso você quer acessar?\nColoque o nome do curso:", "Acessar Curso - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//    boolean cursoTrueOrFalse = cursos.stream().anyMatch(sl -> sl.getNome().equals(cursoSeach));
//    if(cursoTrueOrFalse == true){
//    List<Cursos> cursoNameSeach = cursos.stream().filter(sls -> sls.getNome().equals(cursoSeach)).collect(Collectors.toList());
//    JOptionPane.showMessageDialog(null, cursoNameSeach,"Acessar Curso - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//   }else{JOptionPane.showMessageDialog(null, "Curso não encontrado","Acessar Curso - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}

//    }


//  }

///*Salas*/if(option1==1){
//         String[] options1 = {"Procurar Sala"};
//            int escolha3=JOptionPane.showOptionDialog(null, "O que você deseja acessar:", "Faculdade Walk",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);

//            if(escolha3==0){

//                String tituloSeach = JOptionPane.showInputDialog(null, "Que sala você quer procurar\nColoque o titulo:", "Procurar Sala - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                boolean salaTrueOrFalse = salas.stream().anyMatch(sl -> sl.getTitulo().equals(tituloSeach));
//                if(salaTrueOrFalse == true){
//                    List<Salas> salaSeach = salas.stream().filter(sls -> sls.getTitulo().equals(tituloSeach)).collect(Collectors.toList());
//                    JOptionPane.showMessageDialog(null, salaSeach,"Sala encontrada - Faculdade Walk",JOptionPane.INFORMATION_MESSAGE);
//                }else{JOptionPane.showMessageDialog(null, "Sala não encontrada", "Erro - Faculdade Walk", JOptionPane.ERROR_MESSAGE);}
//            }

//        }

///*Forum*/if(option1==2){
//String[] opcoes3 = {"Criar Pergunta","Procurar","Remover"};
//int option = JOptionPane.showOptionDialog(null, "O que você deseja acessar?", "Forum - Universidade Walk", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null,opcoes3,opcoes3[0]);
//switch(option){
//    case 0:
//    String creationTheme = JOptionPane.showInputDialog(null, "Qual tema você quer falar ?", "Criação de Forum - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    var creationQuestion = JOptionPane.showInputDialog(null, "Qual é a sua pergunta?", "Criação de forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);;
//    forum.add(new Forum(creationQuestion, creationTheme));
//    List<Forum> newForum = forum.stream().filter(f -> f.getPergunta().equals(creationQuestion)).collect(Collectors.toList());
//    JOptionPane.showMessageDialog(null, newForum, "Forum criado - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//    break;
//    case 1:
//    String[] opcoes4 ={"Tema","Pergunta","Busca Avançada"};
//    int escolha5 = JOptionPane.showOptionDialog(null, "Por categoria você deseja buscar?", "Busca de Forum - Faculdade Walk", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes4, opcoes4[0]);
//    switch(escolha5){
//        case 0:
//        String seachTema = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        List<Forum> filterTema = forum.stream().filter(filter -> filter.getTema().equals(seachTema)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, filterTema , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//        break;
//        case 1:
//        String seachPch = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        List<Forum> filterPch = forum.stream().filter(filter -> filter.getPergunta().equals(seachPch)).collect(Collectors.toList());
//        JOptionPane.showMessageDialog(null, filterPch , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);
//        break;
//        case 2:
//        String theme = JOptionPane.showInputDialog(null, "Por qual tema você deseja procurar?","Busca por tema - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        String shPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja procurar?","Busca por pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//        List<Forum> filterPegunta = forum.stream()
//                                         .filter(fl -> fl.getTema().equals(theme))
//                                         .filter(flt -> flt.getPergunta().equals(shPergunta))
//                                         .collect(Collectors.toList());

//         JOptionPane.showMessageDialog(null, filterPegunta , "Busca por Forum - Faculdade Walk", JOptionPane.INFORMATION_MESSAGE);

//        int condicao = JOptionPane.showOptionDialog(null, "Você deseja responder?", "Área de resposta - Faculdade Walk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//        switch(condicao){
//            case 0:
//            String resposta = JOptionPane.showInputDialog(null, "Coloque a sua resposta:", "Respondendo pergunta - Facildade Walk", JOptionPane.INFORMATION_MESSAGE);
//            RespostaForum resposta1 = new RespostaForum(theme, shPergunta, resposta);
//           JOptionPane.showMessageDialog(null, resposta1, "Pergunta Respondida", JOptionPane.INFORMATION_MESSAGE);
//           break;
//            case 1: break;

//        }break;

//     }break;
//    case 2:
//    String rmvPergunta = JOptionPane.showInputDialog(null, "Por qual pergunta você deseja remover?","Remover pergunta - Universidade Walk", JOptionPane.INFORMATION_MESSAGE);
//    List<Forum> RemoverPergunta = forum.stream().filter(pg -> pg.getPergunta().equals(rmvPergunta)).collect(Collectors.toList());
//     forum.removeAll(RemoverPergunta);

//     JOptionPane.showMessageDialog(null, "Pergunta removida", "Remover ", JOptionPane.INFORMATION_MESSAGE);
//     break;

//      }

//    }

//       }

//    }


//}