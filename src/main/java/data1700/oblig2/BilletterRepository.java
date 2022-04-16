package data1700.oblig2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilletterRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreKunde (Billetter innbillette){
        String sql = "INSERT INTO Billetter (film, antall, fornavn, etternavn, tlf, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, innbillette.getFilm(), innbillette.getAntall(), innbillette.getFornavn(),
                innbillette.getEtternavn(), innbillette.getTlf(), innbillette.getEpost());
    }

    public List<Billetter> hentAlle () {
        String sql = "SELECT * FROM Billetter";
        List<Billetter> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Billetter.class));
        return alleBilletter;
    }

    public void slettAlle () {
        String sql = "DELETE FROM Billetter";
        db.update(sql);
    }
}
