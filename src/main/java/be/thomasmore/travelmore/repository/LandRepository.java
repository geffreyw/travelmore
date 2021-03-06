package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Land;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LandRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Land findById(int id) {
        return entityManager.find(Land.class, id);
    }

    public List<Land> findAll() {
        return entityManager.createNamedQuery(Land.FIND_ALL, Land.class).getResultList();
    }

    public void insert(Land land) {
        entityManager.persist(land);
    }

    public void delete(int id){
        entityManager.createQuery("delete from Land l where l.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
