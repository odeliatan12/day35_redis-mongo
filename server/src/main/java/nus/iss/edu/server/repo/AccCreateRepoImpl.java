package nus.iss.edu.server.repo;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import nus.iss.edu.server.Utils;
import nus.iss.edu.server.models.AccountCreation;
import nus.iss.edu.server.models.AccountTransfer;

import static nus.iss.edu.server.Constants.*;

import java.util.List;

@Repository
public class AccCreateRepoImpl {

    @Autowired
    @Qualifier(DATABASE_MONGO)
    private MongoTemplate template;

    public void insertAccount(AccountCreation ac){
        Document j = Utils.toDocument(ac);
        System.out.println(">>>>>>>Document" + j);
        template.insert(j, COLLECTION_ACCOUNT);
    }

    public List<Document> getAllAccounts(){
        Criteria criteria = Criteria.where(FIELD_ID).exists(true);
        Query query = Query.query(criteria);
        System.out.println(">>>>> query" + query);
        return template.find(query, Document.class, COLLECTION_ACCOUNT);
    }

    public void insertTransferAccount(AccountTransfer at){
        Document j = Utils.toDocument(at);
        template.insert(j, COLLECTION_ACCOUNTTRANSFER);
    }
    
}
