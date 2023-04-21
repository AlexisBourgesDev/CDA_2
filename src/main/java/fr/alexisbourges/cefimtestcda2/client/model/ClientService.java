package fr.alexisbourges.cefimtestcda2.client.model;

import fr.alexisbourges.cefimtestcda2.book.StatsGenreLitteraire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private EntityManager entityManager;

    List<Client> listClient = new ArrayList<>(){{
        add(new Client("Alexis"));
    }};

    public List<Client> getListClient(){
        return listClient;
    }

    public List<StatsGenreLitteraire> getBestGenreForClient(Integer clientId){
        List<Tuple> clients = entityManager.createNativeQuery("""
                            select nom_genre, count(titre) as nb_reservations
                            from client 
                            inner join reservation on reservation.id_client = client.id_client
                            inner join livre on livre.id_livre = reservation.id_livre
                            inner join genre_litteraire on livre.id_genre = genre_litteraire.id_genre
                            where client.id_client = :clientId
                            group by nom_genre;
                        """, Tuple.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return clients.stream().map(StatsGenreLitteraire::new).toList();
        //return clients.stream().map(tuple -> new StatsGenreLitteraire(tuple))
    }
}
