package com.tutor.ti_kolb.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor.ti_kolb.models.TesteKolb;

public interface KolbRepository extends JpaRepository<TesteKolb, UUID> {
    Optional<TesteKolb> findByUserId(UUID userUuid);
}
