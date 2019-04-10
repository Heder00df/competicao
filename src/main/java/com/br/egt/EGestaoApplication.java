package com.br.egt;

import com.br.egt.entidade.*;
import com.br.egt.repositories.AtletaRepository;
import com.br.egt.repositories.CategoriaRepository;
import com.br.egt.repositories.CompeticaoRepository;
import com.br.egt.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EGestaoApplication implements CommandLineRunner {
	@Autowired
	private CompeticaoRepository competicaoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
    private AtletaRepository atletaRepository;

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

		//Amador adulto 1 divisao
		Competicao amadaorPrimeiraDivisao = new Competicao();
		CompeticaoCategoriaPK pkPrimeira = new CompeticaoCategoriaPK();
		pkPrimeira.setCategoria(categoriaAdulto);
		pkPrimeira.setCompeticao(amadaorPrimeiraDivisao);
		pkPrimeira.setTemporada(2018);
		CompeticaoCategoria competicaoCategoria = new CompeticaoCategoria();
		competicaoCategoria.setId(pkPrimeira);
		amadaorPrimeiraDivisao.setNome("Campeonato Amador de Samambaia 2018");
		amadaorPrimeiraDivisao.setTipoCompeticao(TipoCompeticao.PRIMEIRA_DIVISAO);
		amadaorPrimeiraDivisao.getCompeticoesCategorias().add(competicaoCategoria);
		competicaoRepository.save(amadaorPrimeiraDivisao);

		Competicao amadaorPrimeiraDivisao2019 = new Competicao();
		CompeticaoCategoriaPK pk = new CompeticaoCategoriaPK();
		pk.setCategoria(categoriaAdulto);
		pk.setCompeticao(amadaorPrimeiraDivisao2019);
		pk.setTemporada(2019);
		CompeticaoCategoria competicaoCategoria2019 = new CompeticaoCategoria();
		competicaoCategoria2019.setId(pk);
		amadaorPrimeiraDivisao2019.setNome("Campeonato Amador de Samambaia 2019");
		amadaorPrimeiraDivisao2019.setTipoCompeticao(TipoCompeticao.PRIMEIRA_DIVISAO);
		amadaorPrimeiraDivisao2019.getCompeticoesCategorias().add(competicaoCategoria2019);
		competicaoRepository.save(amadaorPrimeiraDivisao2019);

		//Amador adulto 2 divisao
		Competicao amadaorSegundaDivisao = new Competicao();
		CompeticaoCategoriaPK pksegunda = new CompeticaoCategoriaPK();
		pksegunda.setCategoria(categoriaAdulto);
		pksegunda.setCompeticao(amadaorSegundaDivisao);
		pksegunda.setTemporada(2018);
		CompeticaoCategoria competicaoCategoriaSegunda = new CompeticaoCategoria();
		competicaoCategoriaSegunda.setId(pksegunda);

		amadaorSegundaDivisao.setNome("Campeonato Amador de Samambaia 2018");
		amadaorSegundaDivisao.setTipoCompeticao(TipoCompeticao.SEGUNDA_DIVISAO);
		amadaorSegundaDivisao.getCompeticoesCategorias().add(competicaoCategoriaSegunda);
		competicaoRepository.save(amadaorSegundaDivisao);

		//Amador adulto 2 divisao 2019
		Competicao amadaor2019 = new Competicao();
		CompeticaoCategoriaPK pksegunda2019 = new CompeticaoCategoriaPK();
		pksegunda2019.setCategoria(categoriaAdulto);
		pksegunda2019.setCompeticao(amadaor2019);
		pksegunda2019.setTemporada(2019);
		CompeticaoCategoria competicaoCategoriaSegunda2019 = new CompeticaoCategoria();
		competicaoCategoriaSegunda2019.setId(pksegunda2019);
		amadaor2019.setNome("Campeonato Amador de Samambaia 2019");
		amadaor2019.setTipoCompeticao(TipoCompeticao.SEGUNDA_DIVISAO);
		amadaor2019.getCompeticoesCategorias().add(competicaoCategoriaSegunda2019);
		competicaoRepository.save(amadaor2019);

		//Amador adulto 2 divisao
		Competicao juvenilCompeticao = new Competicao();
		CompeticaoCategoriaPK pkJuvenil = new CompeticaoCategoriaPK();
		pkJuvenil.setCategoria(juvenil);
		pkJuvenil.setCompeticao(juvenilCompeticao);
		pkJuvenil.setTemporada(2018);
		CompeticaoCategoria competicaoCategoriaJuvenil = new CompeticaoCategoria();
		competicaoCategoriaJuvenil.setId(pkJuvenil);
		juvenilCompeticao.setNome("Campeonato juvevil de Samambaia 2018");
		juvenilCompeticao.setTipoCompeticao(TipoCompeticao.BASE);
		juvenilCompeticao.getCompeticoesCategorias().add(competicaoCategoriaJuvenil);
		competicaoRepository.save(juvenilCompeticao);

		Equipe panelinha = new Equipe();
		panelinha.setDescricao("Panelinha Futebol Clube");

		Time timePanelinha2018 = new Time();
		timePanelinha2018.getId().setCompeticao(amadaorSegundaDivisao);
		timePanelinha2018.getId().setEquipe(panelinha);
		panelinha.getTimes().add(timePanelinha2018);

		Time timePanelinha2019 = new Time();
		timePanelinha2019.getId().setCompeticao(amadaorPrimeiraDivisao);
		timePanelinha2019.getId().setEquipe(panelinha);
		panelinha.getTimes().add(timePanelinha2019);

		equipeRepository.save(panelinha);

		Equipe mafia = new Equipe();
		mafia.setDescricao("Mafia Futebol Clube");

		Time timeMafia2018 = new Time();
		timeMafia2018.getId().setCompeticao(amadaorPrimeiraDivisao);
		timeMafia2018.getId().setEquipe(mafia);
		mafia.getTimes().add(timeMafia2018);

		Time timemafia2019 = new Time();
		timemafia2019.getId().setCompeticao(amadaorPrimeiraDivisao2019);
		timemafia2019.getId().setEquipe(mafia);

		mafia.getTimes().add(timemafia2019);

		equipeRepository.save(mafia);

		List<Competicao> competicoes = competicaoRepository.findAll();
		List<Competicao> categorias = competicoes.get(2).getCompeticoesCategorias().stream().map(c->c.getId().getCompeticao()).collect(Collectors.toList());
		categorias.forEach(c-> System.out.println(c.getNome()));
		categorias.size();


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


		Atleta heder = new Atleta();
		heder.setEndereco(endereco);
		heder.getTelefones().add(fixo);
		fixo.setAtleta(heder);
		heder.setCpf(69638969172L);
		heder.setPosicao("Lateral");
		heder.setDataNascimento(LocalDate.of(1981,10,18));
		heder.setRg(1895541L);
		heder.setEmail("heder00df@gmail.com");
		heder.setEquipe(panelinha);
		atletaRepository.save(heder);


		panelinha.getAtletas().add(heder);

		timePanelinha2018.getAtletas().add(heder);
		timePanelinha2019.getAtletas().add(heder);

	}
}
