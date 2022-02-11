package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Countries {

    private int countryId;
    private String country;
    private static ObservableList<Countries> allCountries = FXCollections.observableArrayList();

    public Countries(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void setAllCountries() throws SQLException
    {
        Statement stmt = JDBC.getConnection().createStatement();
        String countryQuery = "SELECT * FROM client_schedule.countries";

        ResultSet rs = stmt.executeQuery(countryQuery);

        while(rs.next())
        {
            int countryId = rs.getInt("Country_ID");
            String country = rs.getString("Country");

            Countries newCountry = new Countries(countryId, country);
            allCountries.add(newCountry);
        }
    }

    public static ObservableList<Countries> getAllCountries(){

        return allCountries;
    }

    public static int stateSelectionCountryReturn(int id) throws SQLException {

        ObservableList<Countries> countryList = FXCollections.observableArrayList();

        Statement statement = JDBC.getConnection().createStatement();
        String setAppointmentList = "SELECT * FROM client_schedule.countries WHERE Country_ID="+id+"";
        ResultSet rs = statement.executeQuery(setAppointmentList);
        int countryId = 0;

        if(rs.next())
        {
            countryId = rs.getInt("Country_ID");
            String country = rs.getString("Country");
            Countries countries = new Countries(countryId, country);
            countryList.add(countries);
        }
        return countryId;
    }

    @Override
    public String toString(){
        return(country);
    }
}
