package com.br.egt;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.entidade.*;
import com.br.egt.repositories.*;
import com.br.egt.service.JogoService;
import com.br.egt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class EGestaoApplication implements CommandLineRunner {
	@Autowired
	private CompeticaoRepository competicaoRepository;

	@Autowired
	private TimeRepository timeRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClienteRepository clienteRepository;


	@Autowired
	private ClassificacaoRepository classificacaoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
    private AtletaRepository atletaRepository;

	@Autowired
	private JogoService jogoService;

	public static void main(String[] args) {
		SpringApplication.run(EGestaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoriaAdulto = new Categoria();
		categoriaAdulto.setDescricao("Adulto");
		categoriaAdulto.setIdadeMaxima(80);
		categoriaRepository.save(categoriaAdulto);

		Categoria juvenil = new Categoria();
		juvenil.setDescricao("Juvenil sub 17");
		juvenil.setIdadeMaxima(17);
		categoriaRepository.save(juvenil);

		Categoria infatil = new Categoria();
		infatil.setDescricao("Infantil sub 15");
		infatil.setIdadeMaxima(15);
		categoriaRepository.save(infatil);

		Categoria mirim = new Categoria();
		mirim.setDescricao("Mirim sub 13");
		mirim.setIdadeMaxima(13);
		categoriaRepository.save(mirim);

		Categoria preMirim = new Categoria();
		preMirim.setDescricao("Pre-mirim sub 11");
		preMirim.setIdadeMaxima(11);
		categoriaRepository.save(preMirim);

		Cliente cliente = new Cliente();
		cliente.setNome("Alexandre - LUFAS");
		clienteRepository.save(cliente);


		Usuario usuarioPanelinha = gerarUsuario("panelinha", cliente);
		cliente.getUsuarios().add(usuarioPanelinha);

		//Usuario mafia
		Usuario usuarioMafia = gerarUsuario("mafia", cliente);
		cliente.getUsuarios().add(usuarioMafia);
		//usuarioService.salvarUsuario(usuarioMafia);

		//Usuario real
		Usuario usuarioReal = gerarUsuario("real", cliente);
		cliente.getUsuarios().add(usuarioReal);
		//usuarioService.salvarUsuario(usuarioReal);


		//Usuario parma
		Usuario usuarioParma = gerarUsuario("parma", cliente);
		cliente.getUsuarios().add(usuarioParma);
		//usuarioService.salvarUsuario(usuarioParma);

		//Amador adulto 1 divisao
		Competicao amadaorPrimeiraDivisao = new Competicao();

		amadaorPrimeiraDivisao.setNome("Campeonato Amador de Samambaia");
		amadaorPrimeiraDivisao.setTipoCompeticao(Divisao.PRIMEIRA_DIVISAO);
		amadaorPrimeiraDivisao.setCategoria(categoriaAdulto);
		amadaorPrimeiraDivisao.setTemporada(2018);
		amadaorPrimeiraDivisao.setSituacao(SituacaoCompeticao.FINALIZADO);
		competicaoRepository.save(amadaorPrimeiraDivisao);

		Competicao amadaorPrimeiraDivisao2019 = new Competicao();
		amadaorPrimeiraDivisao2019.setTemporada(2019);

		amadaorPrimeiraDivisao2019.setNome("Campeonato Amador de Samambaia");
		amadaorPrimeiraDivisao2019.setTipoCompeticao(Divisao.PRIMEIRA_DIVISAO);
		amadaorPrimeiraDivisao2019.setCategoria(categoriaAdulto);
		amadaorPrimeiraDivisao2019.setSituacao(SituacaoCompeticao.ATIVO);
		competicaoRepository.save(amadaorPrimeiraDivisao2019);

		//Amador adulto 2 divisao
		Competicao amadaorSegundaDivisao = new Competicao();
		amadaorSegundaDivisao.setCategoria(categoriaAdulto);
		amadaorSegundaDivisao.setTemporada(2018);
		amadaorSegundaDivisao.setNome("Campeonato Amador de Samambaia");
		amadaorSegundaDivisao.setSituacao(SituacaoCompeticao.FINALIZADO);
		amadaorSegundaDivisao.setTipoCompeticao(Divisao.SEGUNDA_DIVISAO);
		competicaoRepository.save(amadaorSegundaDivisao);

		//Competicao excluida
		Competicao exluida = new Competicao();
		exluida.setCategoria(categoriaAdulto);
		exluida.setTemporada(2018);
		exluida.setNome("Campeonato Amador de Samambaia");
		exluida.setSituacao(SituacaoCompeticao.EXCLUIDO);
		exluida.setTipoCompeticao(Divisao.SEGUNDA_DIVISAO);
		competicaoRepository.save(exluida);

		//Amador adulto 2 divisao 2019
		Competicao amadaor2019 = new Competicao();
		amadaor2019.setTemporada(2019);
		amadaor2019.setNome("Campeonato Amador de Samambaia");
		amadaor2019.setSituacao(SituacaoCompeticao.ATIVO);
		amadaor2019.setTipoCompeticao(Divisao.SEGUNDA_DIVISAO);
		amadaor2019.setCategoria(categoriaAdulto);
		competicaoRepository.save(amadaor2019);

		//Amador adulto 2 divisao
		Competicao juvenilCompeticao = new Competicao();
		juvenilCompeticao.setTemporada(2019);
		juvenilCompeticao.setNome("Campeonato juvevil de Samambaia");
		juvenilCompeticao.setTipoCompeticao(Divisao.BASE);
		juvenilCompeticao.setSituacao(SituacaoCompeticao.ATIVO);
		juvenilCompeticao.setCategoria(juvenil);
		competicaoRepository.save(juvenilCompeticao);

		//Amador adulto 2 divisao
		Competicao infantil = new Competicao();
		infantil.setTemporada(2019);
		infantil.setNome("Campeonato infantil de Samambaia");
		infantil.setTipoCompeticao(Divisao.BASE);
		infantil.setSituacao(SituacaoCompeticao.ATIVO);
		infantil.setCategoria(infatil);
		competicaoRepository.save(infantil);

		Equipe panelinha = new Equipe();
		panelinha.setDescricao("Panelinha Futebol Clube");
		panelinha.setUsuario(usuarioPanelinha);

		Time timePanelinha2018 = new Time();
		timePanelinha2018.setCompeticao(amadaorSegundaDivisao);
		timePanelinha2018.setEquipe(panelinha);
		timePanelinha2018.setDivisao(Divisao.SEGUNDA_DIVISAO);
		timePanelinha2018.setCategoria(categoriaAdulto);
		panelinha.getTimes().add(timePanelinha2018);


		Time timePanelinha2019 = new Time();
		timePanelinha2019.setCompeticao(amadaorPrimeiraDivisao2019);
		timePanelinha2019.setEquipe(panelinha);
		timePanelinha2019.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timePanelinha2019.setCategoria(categoriaAdulto);
		panelinha.getTimes().add(timePanelinha2019);

		Equipe equipeReal = new Equipe();
		equipeReal.setDescricao("Real Esporte Clube");
		equipeReal.setUsuario(usuarioReal);

		Time timeReal2018 = new Time();
		timeReal2018.setCompeticao(amadaorPrimeiraDivisao);
		timeReal2018.setEquipe(equipeReal);
		timeReal2018.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timeReal2018.setCategoria(categoriaAdulto);
		equipeReal.getTimes().add(timeReal2018);

		Time timeReal2019 = new Time();
		timeReal2019.setCompeticao(amadaorPrimeiraDivisao2019);
		timeReal2019.setEquipe(equipeReal);
		timeReal2019.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timeReal2019.setCategoria(categoriaAdulto);
		equipeReal.getTimes().add(timeReal2019);


		Equipe equipeParma = new Equipe();
		equipeParma.setDescricao("Parma");
		equipeParma.setUsuario(usuarioParma);

		Time timeParma2018 = new Time();
		timeParma2018.setCompeticao(amadaorPrimeiraDivisao);
		timeParma2018.setEquipe(equipeParma);
		timeParma2018.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timeParma2018.setCategoria(categoriaAdulto);
		equipeParma.getTimes().add(timeParma2018);

		Time timeParma2019 = new Time();
		timeParma2019.setCompeticao(amadaorPrimeiraDivisao2019);
		timeParma2019.setEquipe(equipeParma);
		timeParma2019.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timeParma2019.setCategoria(categoriaAdulto);
		equipeParma.getTimes().add(timeParma2019);

		Equipe mafia = new Equipe();
		mafia.setDescricao("Mafia Futebol Clube");
		mafia.setUsuario(usuarioMafia);

		Time timeMafia2018 = new Time();
		timeMafia2018.setCompeticao(amadaorPrimeiraDivisao);
		timeMafia2018.setEquipe(mafia);
		timeMafia2018.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timeMafia2018.setCategoria(categoriaAdulto);
		mafia.getTimes().add(timeMafia2018);

		Time timeMafiaJuvenil2018 = new Time();
		timeMafiaJuvenil2018.setCompeticao(juvenilCompeticao);
		timeMafiaJuvenil2018.setEquipe(mafia);
		timeMafiaJuvenil2018.setDivisao(Divisao.BASE);
		timeMafiaJuvenil2018.setCategoria(juvenil);
		mafia.getTimes().add(timeMafiaJuvenil2018);

		Time timeMafiaInfatil = new Time();
		timeMafiaInfatil.setCompeticao(infantil);
		timeMafiaInfatil.setEquipe(mafia);
		timeMafiaInfatil.setDivisao(Divisao.BASE);
		timeMafiaInfatil.setCategoria(infatil);
		mafia.getTimes().add(timeMafiaInfatil);

		Time timemafia2019 = new Time();
		timemafia2019.setCompeticao(amadaorPrimeiraDivisao2019);
		timemafia2019.setEquipe(mafia);
		timemafia2019.setDivisao(Divisao.PRIMEIRA_DIVISAO);
		timemafia2019.setCategoria(categoriaAdulto);
		mafia.getTimes().add(timemafia2019);


		List<Competicao> competicoes = competicaoRepository.findAll();
		List<CompeticaoDto> competicoesAtivas = competicaoRepository.findBySituacao(SituacaoCompeticao.ATIVO);

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Novo endereco sdfdf");
		endereco.setComplemento("Apartamento");
		endereco.setNumero(304L);

		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Endereco 2");
		endereco1.setComplemento("Casa");
		endereco1.setNumero(8L);

		Telefone celular = new Telefone();
		celular.setNumero(33589316L);

		Telefone fixo = new Telefone();
		fixo.setNumero(999342035L);

		Telefone celular2 = new Telefone();
		celular2.setNumero(33589316L);

		Telefone fixo2 = new Telefone();
		fixo2.setNumero(999342035L);


		Atleta heder = new Atleta();
		heder.setEndereco(endereco);
		heder.getTelefones().add(fixo);
		heder.setNome("Heder Machado da Silva");
		fixo.setAtleta(heder);
		heder.setCpf(69638969172L);
		heder.setPosicao("Lateral");
		heder.setDataNascimento(LocalDate.of(1981,10,18));
		heder.setRg(1895541L);
		heder.setEmail("heder00df@gmail.com");
		heder.setEquipe(panelinha);


		//usuarioService.salvarUsuario(usuarioPanelinha);
		equipeRepository.save(panelinha);

		equipeRepository.save(equipeParma);
		equipeRepository.save(mafia);
		equipeRepository.save(equipeReal);
		atletaRepository.save(heder);


		panelinha.getAtletas().add(heder);
		heder.getTimes().add(timePanelinha2018);
		heder.getTimes().add(timePanelinha2019);
		timePanelinha2018.getAtletas().add(heder);
		timePanelinha2019.getAtletas().add(heder);

		timeRepository.save(timePanelinha2018);
		timeRepository.save(timePanelinha2019);

		timeRepository.save(timemafia2019);
		timeRepository.save(timeMafia2018);
		timeRepository.save(timeMafiaJuvenil2018);
		timeRepository.save(timeMafiaInfatil);

		timeRepository.save(timeParma2018);
		timeRepository.save(timeParma2019);

		timeRepository.save(timeReal2018);
		timeRepository.save(timeReal2019);


/*		Classificacao c1 = new Classificacao();
		c1.setDerrotas(3);
		c1.setEmpates(2);
		c1.setVitorias(5);
		c1.setPontos(17);
		c1.setTime(timePanelinha2018);
		c1.setCompeticao(amadaorSegundaDivisao);
		classificacaoRepository.save(c1);

		Classificacao c2 = new Classificacao();
		c2.setDerrotas(4);
		c2.setEmpates(3);
		c2.setVitorias(3);
		c2.setPontos(12);
		c2.setTime(timePanelinha2019);
		c2.setCompeticao(amadaorPrimeiraDivisao2019);
		classificacaoRepository.save(c2);

		Classificacao c3 = new Classificacao();
		c3.setDerrotas(3);
		c3.setEmpates(3);
		c3.setVitorias(4);
		c3.setPontos(15);
		c3.setTime(timemafia2019);
		c3.setCompeticao(amadaorPrimeiraDivisao2019);
		classificacaoRepository.save(c3);

		Classificacao c4 = new Classificacao();
		c4.setDerrotas(3);
		c4.setEmpates(5);
		c4.setVitorias(3);
		c4.setPontos(15);
		c4.setTime(timeParma2019);
		c4.setCompeticao(amadaorPrimeiraDivisao2019);
		classificacaoRepository.save(c4);*/


		List<Time> times = timeRepository.recuperarTimesPorCompeticao(2L);
		jogoService.gerarPartidas(times);

		List<Jogo> primeiraRodada = jogoService.recuperaJogosPorRodada(1);
		primeiraRodada.get(0).setResultado(Resultado.MANDANTE);
		primeiraRodada.get(0).setPlacarTimeMandante(3);
		primeiraRodada.get(0).setPlacarTimeVisitante(1);

		primeiraRodada.get(1).setResultado(Resultado.VISITANTE);
		primeiraRodada.get(1).setPlacarTimeMandante(3);
		primeiraRodada.get(1).setPlacarTimeVisitante(5);


		List<Jogo> jogosSegundaRodada = jogoService.recuperaJogosPorRodada(2);
		jogosSegundaRodada.get(0).setResultado(Resultado.VISITANTE);
		jogosSegundaRodada.get(0).setPlacarTimeMandante(4);
		jogosSegundaRodada.get(0).setPlacarTimeVisitante(5);

		jogosSegundaRodada.get(1).setResultado(Resultado.VISITANTE);
		jogosSegundaRodada.get(1).setPlacarTimeMandante(5);
		jogosSegundaRodada.get(1).setPlacarTimeVisitante(6);


		List<Jogo> jogosTerceiraRodada = jogoService.recuperaJogosPorRodada(2);
		jogosTerceiraRodada.get(0).setResultado(Resultado.VISITANTE);
		jogosTerceiraRodada.get(0).setPlacarTimeMandante(4);
		jogosTerceiraRodada.get(0).setPlacarTimeVisitante(5);

		jogosTerceiraRodada.get(1).setResultado(Resultado.VISITANTE);
		jogosTerceiraRodada.get(1).setPlacarTimeMandante(5);
		jogosTerceiraRodada.get(1).setPlacarTimeVisitante(6);


		jogoService.salvar(jogosSegundaRodada);
		processarClassificacao(jogosSegundaRodada, amadaorPrimeiraDivisao2019);

		jogoService.salvar(primeiraRodada);
		processarClassificacao(primeiraRodada, amadaorPrimeiraDivisao2019);

		jogoService.salvar(jogosTerceiraRodada);
		processarClassificacao(jogosTerceiraRodada, amadaorPrimeiraDivisao2019);



		jogoService.atualizarJogo(primeiraRodada.get(0));

		List<Classificacao> classificacaoAtualizada = classificacaoRepository.findAll(Sort.by(Sort.Direction.DESC,"pontos","vitorias"));

		List<Time> timesJuvenis = timeRepository.findByCategoriaAndDivisao(juvenil, Divisao.BASE );

		List<Time> timesAdulto = timeRepository.findByCategoriaAndDivisao(categoriaAdulto, Divisao.PRIMEIRA_DIVISAO );

		Time pa = timeRepository.findById(timePanelinha2019.getId()).get();

		Usuario usuarioLiga = new Usuario();
		usuarioLiga.setEmail("lufas@gmail.com.br");
		usuarioLiga.setSenha("123@");
		usuarioLiga.setLogin("lufas");
		usuarioLiga.setCliente(cliente);
		usuarioLiga.addPerfil(Perfil.DIRETOR_LIGA);

		cliente.getUsuarios().add(usuarioLiga);
		clienteRepository.save(cliente);
		usuarioService.salvarUsuario(usuarioLiga);
	}

	private void processarClassificacao(List<Jogo> jogos, Competicao amadaorPrimeiraDivisao2019) {
		jogos.stream().forEach(j-> {
			if(j.getResultado().equals(Resultado.EMPATE)){

				Classificacao classificacaoVisitante = classificacaoRepository
						.findByTimeAndCompeticao(j.getVisitante(), amadaorPrimeiraDivisao2019);

				if(classificacaoVisitante == null)
					classificacaoVisitante = new Classificacao();

				classificacaoVisitante.setEmpates(classificacaoVisitante.getEmpates()+1);
				classificacaoVisitante.setPontos(classificacaoVisitante.getPontos()+1);
				classificacaoRepository.save(classificacaoVisitante);

				Classificacao classificacaoMandante = classificacaoRepository
						.findByTimeAndCompeticao(j.getVisitante(), amadaorPrimeiraDivisao2019);

				if(classificacaoMandante == null)
					classificacaoMandante = new Classificacao();

				classificacaoMandante.setEmpates(classificacaoMandante.getEmpates()+1);
				classificacaoMandante.setPontos(classificacaoMandante.getPontos()+1);
				classificacaoRepository.save(classificacaoMandante);

			}
			if(j.getResultado().equals(Resultado.MANDANTE)){

				Classificacao classificacaoVisitante = classificacaoRepository
						.findByTimeAndCompeticao(j.getVisitante(), amadaorPrimeiraDivisao2019);

				if(classificacaoVisitante == null){
					classificacaoVisitante = new Classificacao();
					classificacaoVisitante.setTime(j.getVisitante());
					classificacaoVisitante.setCompeticao(j.getVisitante().getCompeticao());
				}

				classificacaoVisitante.setDerrotas(classificacaoVisitante.getDerrotas()+1);
				classificacaoRepository.save(classificacaoVisitante);

				// Mandante
				Classificacao classificacaoMandante = classificacaoRepository
						.findByTimeAndCompeticao(j.getMandante(), amadaorPrimeiraDivisao2019);

				if(classificacaoMandante == null) {
					classificacaoMandante = new Classificacao();
					classificacaoMandante.setTime(j.getMandante());
					classificacaoMandante.setCompeticao(j.getMandante().getCompeticao());
				}

				classificacaoMandante.setVitorias(classificacaoMandante.getVitorias()+1);
				classificacaoMandante.setPontos(classificacaoMandante.getPontos()+3);
				classificacaoRepository.save(classificacaoMandante);

			}
			if(j.getResultado().equals(Resultado.VISITANTE)){

				Classificacao classificacaoVisitante = classificacaoRepository
						.findByTimeAndCompeticao(j.getVisitante(), amadaorPrimeiraDivisao2019);

				if(classificacaoVisitante == null) {
					classificacaoVisitante = new Classificacao();
					classificacaoVisitante.setTime(j.getVisitante());
					classificacaoVisitante.setCompeticao(j.getVisitante().getCompeticao());
				}

				classificacaoVisitante.setVitorias(classificacaoVisitante.getVitorias()+1);
				classificacaoVisitante.setPontos(classificacaoVisitante.getPontos()+3);
				classificacaoRepository.save(classificacaoVisitante);

				//Mandante
				Classificacao classificacaoMandante = classificacaoRepository
						.findByTimeAndCompeticao(j.getMandante(), amadaorPrimeiraDivisao2019);

				if(classificacaoMandante == null) {
					classificacaoMandante = new Classificacao();
					classificacaoMandante.setTime(j.getMandante());
					classificacaoMandante.setCompeticao(j.getMandante().getCompeticao());
				}

				classificacaoMandante.setDerrotas(classificacaoMandante.getDerrotas()+1);
				classificacaoRepository.save(classificacaoMandante);

			}

		});
	}

	private Usuario gerarUsuario(String nomeTime, Cliente cliente){
		Usuario usuarioLiga = new Usuario();
		usuarioLiga.setEmail(nomeTime+"@gmail.com.br");
		usuarioLiga.setSenha("123@");
		usuarioLiga.setLogin(nomeTime);
		usuarioLiga.setCliente(cliente);
		usuarioLiga.addPerfil(Perfil.DIRETOR_EQUIPE);
		return usuarioLiga;

	}
}
