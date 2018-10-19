
package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReisService {

    @Inject
    private ReisRepository reisRepository;

    public Reis findLocationById(int id) {
        return reisRepository.findById(id);
    }

    public List<Reis> findAllReizen() {
        return reisRepository.findAll();
    }

    public void insert(Reis reis) {
        reisRepository.insert(reis);
    }
}