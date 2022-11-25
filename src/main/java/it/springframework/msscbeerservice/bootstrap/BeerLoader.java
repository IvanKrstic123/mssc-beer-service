package it.springframework.msscbeerservice.bootstrap;


import it.springframework.msscbeerservice.domain.Beer;
import it.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234567890363";
    public static final String BEER_2_UPC = "0638789225545457";
    public static final String BEER_3_UPC = "0631245848952258";

    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {
        if (beerRepository.count() == 0) {

            beerRepository.save(
                    Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(
                    Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal(13.95))
                    .build());

            beerRepository.save(
                    Beer.builder()
                            .beerName("No Hammers On The Bar")
                            .beerStyle("PALE_ALE")
                            .quantityToBrew(200)
                            .upc(BEER_3_UPC)
                            .price(new BigDecimal(13.95))
                            .build());
        }
    }
}
