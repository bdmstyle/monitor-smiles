package br.com.monitorsmiles.config;

import br.com.monitorsmiles.domain.Item;

public class ItemsFactory {
	
	static String baseImageUrl = "https://s3-sa-east-1.amazonaws.com/monitorsmiles.com.br/images/";
	static String extension = ".png";
	
	static Item pcr() {
		Item item = new Item();
		item.setName("PCR Obrigatório");
		item.setImage(baseImageUrl + "V1" +extension);
		item.setDescription("Está sendo solicitado o teste de PCR negativo.");
		return item;
	}
	
	static Item partialBusiness() {
		Item item = new Item();
		item.setName("Comércio parcialmente aberto");
		item.setImage(baseImageUrl + "V2"+ extension);
		item.setDescription("Comércio está restrições de funcionamento.");
		return item;
	}
	
	static Item businessClosed() {
		Item item = new Item();
		item.setName("Comércio fechado");
		item.setImage(baseImageUrl + "V2"+extension);
		item.setDescription("Comércio não está operando.");
		return item;
	}
	
	static Item fastExam() {
		Item item = new Item();
		item.setName("Teste rápido Obrigatório");
		item.setImage(baseImageUrl + "V3"+extension);
		item.setDescription("Está sendo requisitado o teste rápido de Covid negativo.");
		return item;
	}
	
	static Item partialTourism() {
		Item item = new Item();
		item.setName("Turismo parcialmente aberto");
		item.setImage(baseImageUrl + "V4"+extension);
		item.setDescription("Turismo está com restrições de funcionamento.");
		return item;
	}
	
	static Item closedTourism() {
		Item item = new Item();
		item.setName("Turismo fechado");
		item.setImage(baseImageUrl + "V4"+extension);
		item.setDescription("Turismo não está operando.");
		return item;
	}
	
	static Item beachesClosed() {
		Item item = new Item();
		item.setName("Praias fechadas");
		item.setImage(baseImageUrl + "V5"+extension);
		item.setDescription("Praias com acesso restrito.");
		return item;
	}
	
	static Item bordersClosed() {
		Item item = new Item();
		item.setName("Fronteiras fechadas");
		item.setImage(baseImageUrl + "V6"+extension);
		item.setDescription("Fronteiras fechada para turistas.");
		return item;
	}
	
	static Item partiallLockdown() {
		Item item = new Item();
		item.setName("Circulação moderada");
		item.setImage(baseImageUrl + "V7"+extension);
		item.setDescription("Pode ser que voce não possa sair do seu hotel em determinados horarios.");
		return item;
	}
	
	static Item lockdown() {
		Item item = new Item();
		item.setName("Circulação restrita");
		item.setImage(baseImageUrl + "V7"+extension);
		item.setDescription("Você não poderá realizar atividades fora da sua hospedagem");
		return item;
	}

}
