package nus.iss.edu.server.service;

import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import nus.iss.edu.server.Utils;
import nus.iss.edu.server.models.AccountCreation;
import nus.iss.edu.server.models.AccountTransfer;
import nus.iss.edu.server.repo.AccCreateRepoImpl;
import nus.iss.edu.server.repo.AccTransRedisImpl;

@Service
public class AccCreateService {

    @Autowired
    private AccCreateRepoImpl repository;

    // @Autowired
    // private AccTransRedisImpl redisRepo;

    public String insertAccount(String s){

        String id = UUID.randomUUID().toString().substring(0, 8);
        JsonObject j = Utils.tocreateJson(s);
        System.out.println(">>>>>>> JsonObject " + j);
        AccountCreation ac = Utils.createAccount(j, id);
        System.out.println(">>>>>>>>Account creation" + ac);
        repository.insertAccount(ac);
        return id;
    }

    public List<JsonObject> getAllAccounts() {
        List<Document> l = repository.getAllAccounts();

        List<AccountCreation> j = l.stream().map(v -> Utils.createAccounts(v)).toList();

        List<JsonObject> jO = j.stream().map(v -> Utils.toJSON(v)).toList();

        return jO;
        
    }

    public String insertTransferAccount(String s){
        String id = UUID.randomUUID().toString().substring(0, 8);
        JsonObject j = Utils.tocreateJson(s);
        AccountTransfer at = Utils.createTransferAcc(j, id);
        repository.insertTransferAccount(at);
        // Integer result = redisRepo.saveTransferAccount(at);
        // System.out.println(result);
        return id;
    }
    
}
