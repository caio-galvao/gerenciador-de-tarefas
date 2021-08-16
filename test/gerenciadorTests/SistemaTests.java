package gerenciadorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gerenciador.Sistema;

class SistemaTests {
	
	Sistema sistemaPadrao;

	@BeforeEach
	void setUp() throws Exception {
		this.sistemaPadrao = new Sistema();
	}

	@Test
	void testNovaTarefa() {
		assertTrue(sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste"));
	}
	
	@Test
	void testNovaTarefaDetalhesVazios() {
		assertTrue(sistemaPadrao.novaTarefa("teste", "00/00/0000", ""));
	}
	
	@Test
	void testNovaTarefaNomeJaExistente() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		assertFalse(sistemaPadrao.novaTarefa("teste", "00/00/0000", ""));;
	}
	
	@Test
	void testNovaTarefaDataInvalida() {
		assertFalse(sistemaPadrao.novaTarefa("teste", "00/00/000", ""));;
	}
	
	@Test
	void testNovaTarefaNomeVazio() {
		assertFalse(sistemaPadrao.novaTarefa("", "00/00/0000", ""));;
	}

	@Test
	void testListaTarefas() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		String str = "\nteste (00/00/0000)";
		assertEquals(str, sistemaPadrao.listaTarefas());
	}
	
	@Test
	void testListaTarefasVazia() {
		assertEquals("", sistemaPadrao.listaTarefas());
	}

	@Test
	void testVerTarefa() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		String str = "teste: tarefa de teste (00/00/0000)";
		assertEquals(str, sistemaPadrao.verTarefa("teste"));
	}
	
	@Test
	void testVerTarefaDetalhesVazios() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "");
		String str = "teste (00/00/0000)";
		System.out.println(sistemaPadrao.verTarefa("teste"));
		assertEquals(str, sistemaPadrao.verTarefa("teste"));
	}
	
	@Test
	void testVerTarefaDetalhesVaziosNomeNaoExiste() {
		assertEquals(null, sistemaPadrao.verTarefa("teste"));
	}

	@Test
	void testMudaPrazo() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		assertTrue(sistemaPadrao.mudaPrazo("teste", "11/11/1111"));
	}
	
	@Test
	void testMudaPrazoDataInvalida() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		assertFalse(sistemaPadrao.mudaPrazo("teste", "11/11/111"));
	}
	
	@Test
	void testMudaPrazoNomeNaoExiste() {
		assertFalse(sistemaPadrao.mudaPrazo("teste", "11/11/1111"));
	}

	@Test
	void testMudaDetalhes() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		assertTrue(sistemaPadrao.mudaDetalhes("teste", "novos detalhes"));
	}
	
	@Test
	void testMudaDetalhesVazio() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "tarefa de teste");
		assertTrue(sistemaPadrao.mudaDetalhes("teste", ""));
	}
	
	@Test
	void testMudaDetalhesNomeNaoExiste() {
		assertFalse(sistemaPadrao.mudaDetalhes("teste", ""));
	}
	
	@Test
	void testExisteTarefaTrue() {
		sistemaPadrao.novaTarefa("teste", "00/00/0000", "");
		assertTrue(sistemaPadrao.existeTarefa("teste"));
	}
	
	@Test
	void testExisteTarefaFalse() {
		assertFalse(sistemaPadrao.existeTarefa("teste"));
	}

}
