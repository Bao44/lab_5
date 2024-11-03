package vn.edu.iuh.fit.lab_5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.lab_5.backend.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
