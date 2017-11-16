package org.theorangealliance.theorangealliance.Api;

/**
 * Created by joshua9889 on 8/31/2017.
 *
 * class is for storage of Api Calls
 */

public class ApiConstants {
    //Api Key
    public static String apiApplicationName = "PyScout";
    public static String apiKey = "dL5DVJ5oOPth7vtDJmZ1J3MetkNjcZ1PIyN0fgCxiiyx2kh7pEz13A==";

    //Base URLs
    public static String v2Url = "http://theorangealliance.org/apiv2";
    private static String v1Url = "https://www.theorangealliance.org";
    private static String betaUrl = "https://beta.theorangealliance.org";
    private static String devUrl = "https://dev.theyellowalliance.com";

    public static String TOA_App_Origin = "X-Application_Origin";
    public static String TOA_Key = "X-TOA-Key";

    //The base route for accessing anything inside of TOA API. Also returns API version.
    public static String api = betaUrl;

    //Retrieve all available event-types types.
    public static String eventTypes = api + "/event-types";

    //Retrieve all available leagues in FTC.
    public static String leagues = api + "/leagues";

    //Retrieve all available regions in FTC.
    public static String regions = api + "/regions";

    //Retrieve all available seasons.
    public static String seasons = api + "/seasons";

    //Retrieve all Events in our Database.
    public static String events = api + "/events";

    //Retrieve all Events from a particular region.
    public static String eventRegion(String region_id){
        return api + "/region/" + region_id;
    }

    //Retrieve all Events of a particular type.
    public static String eventTypes(String event_type){
        return api + "/type/" + event_type;
    }

    //Retrieve all Events from a particular league.
    public static String eventLeague(String league_key){
        return api + "/events/league/" + league_key;
    }

    //Retrieve total number of teams
    public static String teamCount(){
        return api + "/teams/count";
    }

    //Return 100 teams from starting_number.
    public static String teamsData(String starting_number){
        return api + "/teams/" + starting_number;
    }

    //Retrieve event-specific information such as website, location, event name, region, and dates.
    public static String eventData(String event_key){
        return api + "/event/" + event_key;
    }

    //Retrieve event name.
    public static String eventName(String event_key){
        return api + "/event/" + event_key + "/name";
    }

    //Retrieve all match data for an event and year.
    public static String matchData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return api + "/event/" + year + "/" + event_key + "/matches";
    }

    //Retrieve rankings, win/loss/ties record, qualifying points, and ranking points for an event key and year.
    public static String rankingData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return api + "/event/" + year + "/" + event_key + "/rankings";
    }

    /**
     *
     * @param event_key in the form
     * @return
     */
    public static String awardData(String event_key){
        String year = "20" + event_key.substring(3,4);
        return api + "/event/" + year + "/" + event_key + "/awards";
    }

    /**
     *
     * @param team_key or team number, String
     * @return team-specific information such as their website, name, sponsors, and location in JSON.
     */
    public static String team(String team_key){
        return api + "/team/" + team_key;
    }

    /**
     *
     * @param team_key or team number, String
     * @param year in the format '2017', String
     * @return all events that a team attends in a given year
     */
    public static String teamEvents(String team_key, String year){
        return api + "/team/" + team_key + "/" + year + "/events";
    }

    //Retrieve all event results for a team in a given year
    public static String teamResults(String team_key, String year){
        return api + "/team/" + team_key + "/" + year + "/results";
    }

    //Retrieve all awards that a team receives in a given year
    public static String teamAwards(String team_key, String year){
        return api + "/team/"+team_key+"/"+year+"/awards";
    }

    //Returns number of matches from year.
    public static String matchCount(String year){
        return api + "/matches/" + year + "/count";
    }

    public static String matchHighScoreNoPenaltyQual(String year){
        return api + "matches/"+year+"/high-scores/qual-no-penalty";
    }

    public static String matchHighScoreNoPenaltyElim(String year){
        return api + "matches/"+year+"/high-scores/elim-no-penalty";
    }

    public static String matchHightScoreWithPenalty(String year){
        return api + "matches/"+year+"/high-scores/with-penalty";
    }
}
