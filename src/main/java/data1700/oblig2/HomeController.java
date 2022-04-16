package data1700.oblig2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    BilletterRepository rep;

    @PostMapping("/lagre")
    public void lagreKunde(Billetter innBillett){
    rep.lagreKunde(innBillett);
    }

    @GetMapping("/hentAlle")
    public List<Billetter> hentAlle(){
        return rep.hentAlle();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlle();
    }
}
