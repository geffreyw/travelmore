package be.thomasmore.travelmore.controlller;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {
    private Reis gezochteReis = new Reis();

    @Inject
    private ReisService reisService;

    public Reis getGezochteReis() {
        return gezochteReis;
    }

    public void setGezochteReis(Reis gezochteReis) {
        this.gezochteReis = gezochteReis;
    }

    public List<Reis> getReizen(){
        return this.reisService.findAllReizen();
    }

    public void zoekReis(){
        gezochteReis = gezochteReis;
    }
}
