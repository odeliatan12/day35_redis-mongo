package nus.iss.edu.server;

import java.io.Reader;
import java.io.StringReader;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.iss.edu.server.models.AccountCreation;
import nus.iss.edu.server.models.AccountTransfer;

public class Utils {

    public static Document toDocument(AccountCreation ac){

        Document doc = new Document();
        doc.put("id", ac.getId());
        doc.put("name", ac.getName());
        doc.put("balance", ac.getBalance());
        return doc;
    }

    public static Document toDocument(AccountTransfer at){

        Document doc = new Document();
        doc.put("id", at.getId());
        doc.put("fromAccount", at.getFromAccount());
        doc.put("toAccount", at.getToAccount());
        doc.put("transferAmount", at.getTransferAmount());
        doc.put("comments", at.getComments());
        return doc;
    }

    public static JsonObject toJSON(AccountCreation ac){
        return Json.createObjectBuilder()
                .add("id", ac.getId())
                .add("name", ac.getName())
                .add("balance", ac.getBalance())
                .build();
    }

    public static JsonObject toJSON(AccountTransfer at){
        return Json.createObjectBuilder()
                .add("id", at.getId())
                .add("fromAccount", at.getFromAccount())
                .add("toAccount", at.getToAccount())
                .add("transferAmount", at.getTransferAmount())
                .add("comments", at.getComments())
                .build();
    }

    public static JsonObject tocreateJson(String str){
        Reader reader = new StringReader(str);
        JsonReader jsonReader = Json.createReader(reader);
        return jsonReader.readObject();
    }

    public static AccountTransfer createTransferAcc(JsonObject str, String id){
        AccountTransfer at = new AccountTransfer();
        at.setId(id);
        at.setFromAccount(str.getString("fromAccount"));
        at.setToAccount(str.getString("toAccount"));
        at.setTransferAmount(str.getJsonNumber("transferAmount").doubleValue());
        at.setComments(str.getString("comments"));
        return at;
    }
    
    public static AccountCreation createAccount(JsonObject str, String id){
        AccountCreation ac = new AccountCreation();
        ac.setId(id);
        ac.setName(str.getString("name"));
        ac.setBalance(str.getJsonNumber("balance").doubleValue());
        return ac;
    }

    public static AccountCreation createAccounts(Document doc){
        AccountCreation ac = new AccountCreation();
        ac.setId(doc.getString("id"));
        ac.setName(doc.getString("name"));
        ac.setBalance(doc.getDouble("balance"));
        return ac;
    }

    
}
