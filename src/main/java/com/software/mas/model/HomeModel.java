package com.software.mas.model;

import com.software.mas.App;
import com.software.mas.model.templates.HomeCard;

import java.sql.*;
import java.util.*;

public class HomeModel {

    //this flag will help us to determine whether putting OR/AND or NOT.
    private String tagBuilder(String tag, boolean flag){
        if(flag){
            return " OR tags like '%"+tag+"%' ";
        }else {
            return " tags like '%"+tag+"%' ";
        }
    }

    private void tagsConditionsBuilder(String tags, StringBuilder qry){


        String[] tagsArr = tags.split(" ");
        if(tagsArr.length == 0){
            qry.append(" tags like '%%' ");
                    return;
        }
        boolean flag =false;
        for (String s : tagsArr) {
            if (!flag) {
                //ONCE A CALL
                qry.append(tagBuilder(s, false));
                flag = true;
            }else
            qry.append(tagBuilder(s, true));

        }

    }
    //EMPTY EQUALS >> ""
    //IMPORTANT userEmail help us dedicate whether the service bookmarked or no
    public Queue<HomeCard> searchFor(String tags, String street,
                                     String city, String country,boolean bookmarked ){
        try {

            Connection con = DBHelper.connect();

            String bookMarkSQL= bookmarked?"":"not";

            StringBuilder qry = new StringBuilder("SELECT * FROM services WHERE services.id "+bookMarkSQL+" in (SELECT service_id FROM bookmarks where customer_email='"+App.current_user.getKey()+"') AND ");
            Queue<HomeCard> dataContainer = new LinkedList<>();


            //BUILDING THE QUERY.. . .
            tagsConditionsBuilder(tags,qry);
            String locationConditions = " AND street like '%"+street+"%' AND city like " +
                    " '%"+city+"%' AND country like '%"+country+"%'";
            qry.append(locationConditions);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.valueOf(qry));

            while(rs.next()){
            String providerEmail = rs.getString(1);
            long id = rs.getLong(2);
            String name = rs.getString(3);
            String tagsService = rs.getString(4);
            String desc = rs.getString(5);
            String streetService = rs.getString(6);
            String cityService = rs.getString(7);
            String countryService = rs.getString(8);
            boolean stat = rs.getBoolean(9);
            int price = rs.getInt(10);
            String main_img = rs.getString(11);

            dataContainer.add(new HomeCard(providerEmail,id,name,tagsService,desc,streetService,
                           cityService,countryService,stat,price,main_img));

            }

            con.close();
            return dataContainer;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Queue<HomeCard> getAll(){
      return this.searchFor("", "" ,"", "",false);
    }

    public HomeCard getServiceData(String serviceId, boolean bookmarked){
       Queue<HomeCard> data = this.searchFor("", "" ,"", "",bookmarked);
        for (HomeCard datum : data) {
            if(String.valueOf(datum.id()).equals(serviceId)) {
                return datum;
            }
        }
        //executing this line of code is impossible.
        return null;
    }
    public HomeCard getServiceDataWithoutBookmark(String serviceId){
        return getServiceData(serviceId,false);
    }


    public Queue<HomeCard> searchFor(String tags){
        return this.searchFor(tags, "" ,"", "",false);
    }


    public Queue<Set<String>> getLocations() throws Exception {
        Set<String> setStreet = new HashSet<>();
        Set <String> setCity = new HashSet<>();
        Set <String> setCountry = new HashSet<>();

        Connection con = DBHelper.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT street, city, country FROM services");

        while(rs.next()){
            setStreet.add(rs.getString(1));
            setCity.add(rs.getString(2));
            setCountry.add(rs.getString(3));
        }

        Queue<Set<String>> list = new LinkedList<>();
        list.add(setStreet);
        list.add(setCity);
        list.add(setCountry);

        return list;
    }

    public Queue<HomeCard> getAllBookMarked(String userEmail) throws SQLException {
        Queue<HomeCard> data = new LinkedList<>();
        Connection con = DBHelper.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT service_id FROM bookmarks WHERE customer_email ='"+userEmail+"'");

        while(rs.next()) {
            data.add(this.getServiceData(rs.getString(1),true));
        }
        con.close();
        return data;
    }
    public void bookMarkService(String serviceId) throws SQLException {
        Connection con = DBHelper.connect();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO bookmarks (customer_email, service_id) values('"+App.current_user.getKey()+"', "+serviceId+")");

        con.close();
    }
    public void unBookMarkService(String serviceId) throws SQLException {
        Connection con = DBHelper.connect();
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM bookmarks WHERE service_id="+serviceId+" AND customer_email ='"+App.current_user.getKey()+"'");
        con.close();
    }
}
