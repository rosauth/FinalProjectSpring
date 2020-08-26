package com.bcaf.finalproject.Util;

import com.bcaf.finalproject.Entity.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyDAO extends JpaRepository<Agency, String > {
}
