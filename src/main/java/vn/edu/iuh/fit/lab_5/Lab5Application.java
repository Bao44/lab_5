package vn.edu.iuh.fit.lab_5;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab_5.backend.models.Address;
import vn.edu.iuh.fit.lab_5.backend.models.Candidate;
import vn.edu.iuh.fit.lab_5.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.lab_5.backend.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab5Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();
            for (int i = 1; i < 1000; i++) {
                Address address = new Address(rnd.nextLong(1, Long.MAX_VALUE), "Street " + i, "City " + i, (short) i, "Number " + i, CountryCode.VN.getAlpha2());
                addressRepository.save(address);


                Candidate can = new Candidate(rnd.nextLong(1111111, 99999999L), LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)), "email_" + i + "@example.com", "Name #" + i, "Phone " + i, address);
                candidateRepository.save(can);
                System.out.println("Added: " + can);
            }
        };
    }
}
