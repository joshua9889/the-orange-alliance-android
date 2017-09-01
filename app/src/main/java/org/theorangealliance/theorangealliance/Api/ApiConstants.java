package org.theorangealliance.theorangealliance.Api;

/**
 * Created by joshua9889 on 8/31/2017.
 *
 * This class is for storage of Api Calls
 */

public class ApiConstants {
    //Base URLs
    public static String baseUrl = "https://www.theorangealliance.org";
    public static String betaUrl = "https://beta.theorangealliance.org";
    public static String devUrl = "https://dev.theyellowalliance.com";

    public static String TOA_App_Origin = "X-Application_Origin";
    public static String TOA_Key = "X-TOA-Key";

    //The base route for accessing anything inside of TOA API. Also returns API version.
    public static String api = betaUrl + "/api";

    //Retrieve all available event-types types.
    public static String eventTypes = api + "/event-types";

    //Retrieve all available leagues in FTC.
    public static String leagues = api + "/leagues";

    //Retrieve all available regions in FTC.
    public String regions = this.api + "/regions";

    //Retrieve all available seasons.
    public String seasons = this.api + "/seasons";

    //Retrieve all Events in our Database.
    public String events = this.api + "/events";

    //Retrieve all Events from a particular region.
    public String eventRegion(String region_id){
        return this.api + "/region/" + region_id;
    }

    //Retrieve all Events of a particular type.
    public String eventTypes(String event_type){
        return this.api + "/type/" + event_type;
    }

    //Retrieve all Events from a particular league.
    public String eventLeague(String league_key){
        return this.api + "/events/league/" + league_key;
    }

    //Retrieve total number of teams
    public String teamCount(){
        return this.api + "/teams/count";
    }

    //Return 100 teams from starting_number.
    public String teamsData(String starting_number){
        return this.api + "/teams/" + starting_number;
    }

    //Retrieve event-specific information such as website, location, event name, region, and dates.
    public String eventData(String event_key){
        return this.api + "/event/" + event_key;
    }

    //Retrieve event name.
    public String eventName(String event_key){
        return this.api + "/event/" + event_key + "/name";
    }

    //Retrieve all match data for an event and year.
    public String matchData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return this.api + "/event/" + year + "/" + event_key + "/matches";
    }

    //Retrieve rankings, win/loss/ties record, qualifying points, and ranking points for an event key and year.
    public String rankingData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return this.api + "/event/" + year + "/" + event_key + "/rankings";
    }

    /**
     *
     * @param event_key in the form '
     * @return
     */
    public String awardData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return this.api + "/event/" + year + "/" + event_key + "/awards";
    }

    /**
     *
     * @param team_key or team number, String
     * @return team-specific information such as their website, name, sponsors, and location in JSON.
     */
    public String team(String team_key){
        return this.api + "/team/" + team_key;
    }

    /**
     *
     * @param team_key or team number, int
     * @return team-specific information such as their website, name, sponsors, and location in JSON.
     */
    public String team(int team_key){
        return this.api + "/team/" + Integer.toString(team_key);
    }

    /**
     *
     * @param team_key or team number, String
     * @param year in the format '2017', String
     * @return all events that a team attends in a given year
     */
    public String teamEvents(String team_key, String year){
        return api + "/team/" + team_key + "/" + year + "/events";
    }

    /**
     *
     * @param team_key or team number, int
     * @param year in the format '2017', String
     * @return all events that a team attends in a given year
     */
    public String teamEvents(int team_key, String year){
        return api + "/team/" + Integer.toString(team_key) + "/" + year + "/events";
    }

    /**
     *
     * @param team_key or team number, int
     * @param year in the format '2017', int
     * @return all events that a team attends in a given year
     */
    public String teamEvents(int team_key, int year){
        return api + "/team/" + Integer.toString(team_key) + "/" + Integer.toString(year) + "/events";
    }

    /**
     *
     * @param team_key or team number, String
     * @param year in the format '2017', String
     * @return all events that a team attends in a given year
     */
    public String teamEvents(String team_key, int year){
        return api + "/team/" + team_key + "/" + Integer.toString(year) + "/events";
    }
}
