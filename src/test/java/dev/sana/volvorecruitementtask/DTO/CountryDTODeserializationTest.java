package dev.sana.volvorecruitementtask.DTO;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CountryDTODeserializationTest {

    @Test
    void load1Country() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new ClassPathResource("test1country.json").getFile();

        CountryDTO country = objectMapper.readValue(file, CountryDTO.class);

        assertEquals("Gibraltar", country.getName().getCommon());
        assertEquals("Gibraltar", country.getName().getOfficial());
        assertTrue(country.getCurrencies().containsKey("GIP"));
        assertEquals("Gibraltar pound", country.getCurrencies().get("GIP").getName());
        assertEquals(1, country.getCurrencies().size());
        assertEquals("£", country.getCurrencies().get("GIP").getSymbol());
        assertTrue(country.getCapital().contains("Gibraltar"));
        assertEquals(1, country.getCapital().size());
        assertEquals("Europe", country.getRegion());
        assertEquals("Southern Europe", country.getSubregion());
        assertTrue(country.getLanguages().containsKey("eng"));
        assertEquals("English", country.getLanguages().get("eng"));
        assertEquals(1, country.getLanguages().size());
        assertEquals(33691, country.getPopulation());
        assertTrue(country.getBorders().contains("ESP"));
        assertEquals(1, country.getBorders().size());
        assertTrue(country.getTimezones().contains("UTC+01:00"));
        assertEquals(1, country.getTimezones().size());
    }

    @Test
    void load2Countries() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new ClassPathResource("test2countries.json").getFile();

        List<CountryDTO> countries = objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, CountryDTO.class)
        );

        assertEquals(2, countries.size());
    }

}
