import java.util.HashMap;
import java.util.Set;
public class HashMat{
    public HashMap songs(){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("The Less I know The Better", "She Was Holding Hands With Trevor");
        trackList.put("Enter Sandman", "Exit Light Enter Night");
        trackList.put("Sara Smile", "Baby Hair With A Womens Eyes");
        trackList.put("Bartender", "She gave me a wink I wink back");
        System.out.println(trackList.get("Enter Sandman"));

        Set<String> tracks = trackList.keySet();
        for (String track : tracks){
            System.out.println(track + ":" + trackList.get(track));
        }
        return trackList;
    }
}