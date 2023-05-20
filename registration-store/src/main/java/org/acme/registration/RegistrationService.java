package org.acme.registration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RegistrationService {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void register(String name, String surname, String email) {
        var reg = new RegistrationEntity();
        reg.setName(name);
        reg.setSurname(surname);
        reg.setEmail(email);
        em.persist(reg);
    }

    public List<RegistrationEntity> getAllRegistrations() {
        TypedQuery<RegistrationEntity> query = em.createQuery("SELECT r FROM RegistrationEntity r", RegistrationEntity.class);
        return query.getResultList();
    }

}
