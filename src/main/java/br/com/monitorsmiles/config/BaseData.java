package br.com.monitorsmiles.config;

import static br.com.monitorsmiles.config.ItemsFactory.beachesClosed;
import static br.com.monitorsmiles.config.ItemsFactory.bordersClosed;
import static br.com.monitorsmiles.config.ItemsFactory.businessClosed;
import static br.com.monitorsmiles.config.ItemsFactory.closedTourism;
import static br.com.monitorsmiles.config.ItemsFactory.fastExam;
import static br.com.monitorsmiles.config.ItemsFactory.lockdown;
import static br.com.monitorsmiles.config.ItemsFactory.partialBusiness;
import static br.com.monitorsmiles.config.ItemsFactory.partialTourism;
import static br.com.monitorsmiles.config.ItemsFactory.partiallLockdown;
import static br.com.monitorsmiles.config.ItemsFactory.pcr;
import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.monitorsmiles.domain.Flight;
import br.com.monitorsmiles.domain.Monitor;
import br.com.monitorsmiles.domain.Place;
import br.com.monitorsmiles.persistence.FlightRepository;
import br.com.monitorsmiles.persistence.MonitorRepository;
import br.com.monitorsmiles.persistence.PlaceRepository;

@Component
public class BaseData {
    
    @Autowired
	private MonitorRepository monitorRepository;
    
    @Autowired
  	private PlaceRepository placeRepository;
    
    @Autowired
   	private FlightRepository flightRepository;
	
	@PostConstruct
	public void init() {
		
		String baseImageUrl = ItemsFactory.baseImageUrl;
		String extension = ItemsFactory.extension;
		
		monitorRepository.save(Monitor.create(1l));
		
		var placeList = new ArrayList<Place>();
		
		Place maceio = new Place();
		
		maceio.setId(ObjectId.get());
		maceio.setPlaceId(3l);
		maceio.setLastUpdated(now());
		
		
		maceio.setDescription("Maceió, capital do Estado de Alagoas, tem um jeitinho de cidade do interior e ritmo menos acelerado do que outras capitais brasileiras, e esse é um de seus grandes charmes. Ainda que seja relativamente pequena, os turistas que a visitam contam com restaurantes de qualidade, bons hotéis, além de ótimas praias e diversidade de passeios.");
		maceio.setName("Maceió ");
		maceio.setNameState("Maceió - AL");
		
		maceio.setDescriptionUrl(baseImageUrl + "T22"+extension);
		maceio.setHeaderUrl(baseImageUrl + "J22"+extension);
		maceio.setThumbnailUrl(baseImageUrl + "H22"+extension);
		
		maceio.addItem(beachesClosed());
		maceio.addItem(partialBusiness());
		maceio.addItem(partiallLockdown());
		maceio.addItem(partialTourism());
		
		placeList.add(maceio);
		
		Place foz = new Place();
		
		foz.setId(ObjectId.get());
		foz.setPlaceId(2l);
		foz.setLastUpdated(now());
		
		
		foz.setDescription("Foz do Iguaçu, localizada no Paraná, é uma cidade cheia de atrações e que tem a honra de guardar um dos mais belos espetáculos da natureza na Terra, as Cataratas do Iguaçu. Todo o crédito pertence ao Rio Iguaçu, na fronteira entre Brasil e Argentina e presenteia ambos os países com as Cataratas  um cenário natural perfeito, com as mais lindas quedas d'água do planeta. ");
		foz.setName("Foz do Iguaçu");
		foz.setNameState("Foz do Iguaçu - PR");
		
		foz.setDescriptionUrl(baseImageUrl + "T16"+ extension);
		foz.setHeaderUrl(baseImageUrl + "J16"+ extension);
		foz.setThumbnailUrl(baseImageUrl + "H16"+ extension);

		foz.addItem(bordersClosed());
		foz.addItem(partialBusiness());
		
		placeList.add(foz);
		
        Place noronha = new Place();    
		
		noronha.setId(ObjectId.get());
		noronha.setPlaceId(1l);
		noronha.setLastUpdated(now());
		
		
		noronha.setDescription("Fernando de Noronha mexe com o imaginário de muitos brasileiros. O lugar tem fama de ser uma paraíso na Terra, e quer saber? É mesmo. Algumas de suas praias são as mais bonitas do Brasil, a água tem uma coloração incrível e a vida marinha... ah, essa é tão rica que é quase impossível descrever. O mergulho com cilindro é considerado um dos melhores do mundo e, mesmo nas praias, você pode nadar entre pequenos tubarões e tartarugas. ");
		noronha.setName("Fernando de Noronha");
		noronha.setNameState("Fernando de Noronha - PE");
		
		noronha.setDescriptionUrl(baseImageUrl + "T13"+extension);
		noronha.setHeaderUrl(baseImageUrl + "J13"+extension);
		noronha.setThumbnailUrl(baseImageUrl + "H13"+extension);

		noronha.addItem(pcr());
		noronha.addItem(partiallLockdown());
		
		placeList.add(noronha);
		
        Place rio = new Place();    
		
		rio.setId(ObjectId.get());
		rio.setPlaceId(4l);
		rio.setLastUpdated(now());
		
		
		rio.setDescription("O Rio de Janeiro, é a cidade brasileira mais conhecida no exterior tem a fama de possuir um povo alegre, ávido por sol, praia, futebol e samba. Mas o Rio vai muito além disso: tem história. Tornar-se sede da colônia, abrigo da corte portuguesa e depois capital do Brasil foi fundamental para que não apenas a própria cidade como o país todo se desenvolvesse em diversos aspectos.");
		rio.setName("Rio de Janeiro ");
		rio.setNameState("Rio de Janeiro - RJ");
		
		rio.setDescriptionUrl(baseImageUrl + "H34"+extension);
		rio.setHeaderUrl(baseImageUrl + "J34"+extension);
		rio.setThumbnailUrl(baseImageUrl + "T34"+extension);

		rio.addItem(beachesClosed());
		rio.addItem(lockdown());
		rio.addItem(closedTourism());
		rio.addItem(businessClosed());
		
		placeList.add(rio);
		
        Place sp = new Place();    
		
		sp.setId(ObjectId.get());
		sp.setPlaceId(5l);
		sp.setLastUpdated(now());
		
		
		sp.setDescription("O mundo em uma cidade. O mundo em uma avenida. O mundo em um restaurante de esquina. São Paulo é tão grandiosa que nela tudo cabe. Cabe o empresário apressado para a reunião na Paulista, o jovem que devora uma média com pão na chapa depois da balada na Augusta e o boêmio que espera o final do dia para um chopp com jazz na Vila Madalena.");
		sp.setName("São Paulo ");
		sp.setNameState("São Paulo - SP");
		
		sp.setDescriptionUrl(baseImageUrl + "H38"+extension);
		sp.setHeaderUrl(baseImageUrl + "J38"+extension);
		sp.setThumbnailUrl(baseImageUrl + "T38"+extension);

		sp.addItem(beachesClosed());
		sp.addItem(lockdown());
		sp.addItem(closedTourism());
		sp.addItem(businessClosed());
		
		placeList.add(sp);
		
        Place curitiba = new Place();    
		
		curitiba.setId(ObjectId.get());
		curitiba.setPlaceId(6l);
		curitiba.setLastUpdated(now());
		
		
		curitiba.setDescription("A cidade de Curitiba, capital do estado do Paraná, é conhecida pelo cuidado com o planejamento urbano, belas áreas verdes e um transporte público de qualidade. A fama não é para menos. Curitiba realmente oferece um excelente padrão de vida para os moradores. O fenômeno se reflete também no turismo e torna a cidade um dos destinos mais bem preparados do país para receber viajantes.");
		curitiba.setName("Curitiba");
		curitiba.setNameState("Curitiba - PR");
		
		curitiba.setDescriptionUrl(baseImageUrl + "H12"+extension);
		curitiba.setHeaderUrl(baseImageUrl + "J12"+extension);
		curitiba.setThumbnailUrl(baseImageUrl + "T12"+extension);
	
		curitiba.addItem(beachesClosed());
		curitiba.addItem(partiallLockdown());
		curitiba.addItem(partialTourism());
		curitiba.addItem(fastExam());
		
		placeList.add(curitiba);
		
		placeRepository.saveAll(placeList);
		
		var flightList = new ArrayList<Flight>();
		
		Flight fozFlight = new Flight();
		
		fozFlight.setDestinationPlaceId(2l);
		fozFlight.setId(ObjectId.get());
		fozFlight.setOriginCode("GRU");
		fozFlight.setOriginName("São Paulo");
		fozFlight.setSmilesId(1l);
		fozFlight.setLocatorCode("ZAAF7V");
		fozFlight.setDestinyCode("IGU");
		fozFlight.setDestinyName("Foz do Iguaçu");
		fozFlight.setDuration("1h40");
		fozFlight.setDepartDateTime(LocalDateTime.of(2021,10,10,8,30));
		fozFlight.setArriveDateTime(LocalDateTime.of(2021,10,10,10,10));
		
		flightList.add(fozFlight);
		
		Flight maceioFlight = new Flight();
		
		maceioFlight.setDestinationPlaceId(3l);
		maceioFlight.setId(ObjectId.get());
		maceioFlight.setOriginCode("GRU");
		maceioFlight.setOriginName("São Paulo");
		maceioFlight.setSmilesId(1l);
		maceioFlight.setLocatorCode("ZBBBBV");
		maceioFlight.setDestinyCode("MCZ");
		maceioFlight.setDestinyName("Maceió");
		maceioFlight.setDuration("2h50");
		maceioFlight.setDepartDateTime(LocalDateTime.of(2021,5,5,9,15));
		maceioFlight.setArriveDateTime(LocalDateTime.of(2021,5,5,12,10));
		
		flightList.add(maceioFlight);
		
		flightRepository.saveAll(flightList);
		
	}

}
