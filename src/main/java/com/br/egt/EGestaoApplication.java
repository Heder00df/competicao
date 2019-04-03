package com.br.egt;

import com.br.egt.entidade.*;
import com.br.egt.repositories.CategoriaRepository;
import com.br.egt.repositories.CompeticaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class EGestaoApplication implements CommandLineRunner {
	@Autowired
	private CompeticaoRepository competicaoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

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
		CompeticaoCategoriaPK pk = new CompeticaoCategoriaPK();
		pk.setCategoria(categoriaAdulto);
		pk.setCompeticao(amadaorPrimeiraDivisao);
		pk.setTemporada(2018);
		CompeticaoCategoria competicaoCategoria = new CompeticaoCategoria();
		competicaoCategoria.setId(pk);
		amadaorPrimeiraDivisao.setNome("Campeonato Amador de Samambaia 2019");
		amadaorPrimeiraDivisao.setTipoCompeticao(TipoCompeticao.PRIMEIRA_DIVISAO_LUFAS);
		amadaorPrimeiraDivisao.getCompeticoesCategorias().add(competicaoCategoria);
		competicaoRepository.save(amadaorPrimeiraDivisao);

		//Amador adulto 2 divisao
		Competicao amadaorSegundaDivisao = new Competicao();
		CompeticaoCategoriaPK pksegunda = new CompeticaoCategoriaPK();
		pksegunda.setCategoria(categoriaAdulto);
		pksegunda.setCompeticao(amadaorSegundaDivisao);
		pksegunda.setTemporada(2018);
		CompeticaoCategoria competicaoCategoriaSegunda = new CompeticaoCategoria();
		competicaoCategoriaSegunda.setId(pksegunda);

		amadaorSegundaDivisao.setNome("Campeonato Amador de Samambaia 2019");
		amadaorSegundaDivisao.setTipoCompeticao(TipoCompeticao.SEGUNDA_DIVISAO_LUFAS);
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
		amadaor2019.setTipoCompeticao(TipoCompeticao.SEGUNDA_DIVISAO_LUFAS);
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
		juvenilCompeticao.setTipoCompeticao(TipoCompeticao.BASE_LUFAS);
		juvenilCompeticao.getCompeticoesCategorias().add(competicaoCategoriaJuvenil);
		competicaoRepository.save(juvenilCompeticao);


		List<Competicao> competicoes = competicaoRepository.findAll();
		List<Competicao> categorias = competicoes.get(2).getCompeticoesCategorias().stream().map(c->c.getId().getCompeticao()).collect(Collectors.toList());
		categorias.forEach(c-> System.out.println(c.getNome()));
		categorias.size();




	}
}
