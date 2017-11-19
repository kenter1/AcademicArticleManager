package JsonFormat;/*
* Generates the parsed pdf information into json format
* Constructor: String title, String articleAbstract, String publisher, ArrayList<String> authors, ArrayList<String> tags, String category, String subCategory, String dateOfPublication
* To get jsonformat call getJsonString() or toString method
*
* Reason for this class:
*   To pass information from java to javascript and store the information into the database
*
* Programmer: Mark Kenneth Alano
* Date: 11/11/2017
*
* */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class PDFTOJSON {
    private String title;
    private String articleAbstract;
    private String publisher;
    private ArrayList<String> authors;
    private ArrayList<String> tags;
    private String category;
    private String subCategory;
    private String dateOfPublication;

    private String jsonString;

    public PDFTOJSON(String title, String articleAbstract, String publisher, ArrayList<String> authors, ArrayList<String> tags, String category, String subCategory, String dateOfPublication) {
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.publisher = publisher;
        this.authors = authors;
        this.tags = tags;
        this.category = category;
        this.subCategory = subCategory;
        this.dateOfPublication = dateOfPublication;

        jsonString = generateJson();
    }

    /*https://examples.javacodegeeks.com/core-java/json/json-simple/json-simple-example-to-read-and-write-json-in-java/*/
    private String generateJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;

        jsonObject.put("Title", title);
        jsonObject.put("Abstract", articleAbstract);
        jsonObject.put("Publisher", publisher);
        jsonObject.put("Category",category);
        jsonObject.put("SubCategory", subCategory);
        jsonObject.put("DateOfPublication", dateOfPublication);

        jsonArray = new JSONArray();
        for (String string: authors){
            jsonArray.add(string);
        }
        jsonObject.put("Authors", jsonArray);

        jsonArray = new JSONArray();
        for (String string: tags){
            jsonArray.add(string);
        }
        jsonObject.put("Tags", jsonArray);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonObject);


        return json;
    }

    @Override
    public String toString() {
        return jsonString;
    }

    public String getJsonString() {
        return jsonString;
    }
}
