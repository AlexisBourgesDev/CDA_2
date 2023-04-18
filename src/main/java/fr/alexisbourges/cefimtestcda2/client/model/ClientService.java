package fr.alexisbourges.cefimtestcda2.client.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    List<Client> listClient = new ArrayList<>(){{
        add(new Client("Alexis"));
    }};

    public List<Client> getListClient(){
        return listClient;
    }
}
