package contest.mar28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 3/28/20 11:14 PM
 */


public class UndergroundSystem {
    private class Info {
        double sum;
        int count;
        double average;

        public Info() {
            this.sum = 0;
            this.count = 0;
            this.average = 0;
        }
    }

    Map<Integer, Integer> time;
    Map<Integer, String> from;
    Map<String, Map<String, Info>> stations;

    public UndergroundSystem() {
        this.time = new HashMap<>();
        this.stations = new HashMap<>();
        this.from = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        time.put(id, t);
        from.put(id, stationName);
        if (!stations.containsKey(stationName)) {
            stations.put(stationName, new HashMap<>());
        }
    }

    public void checkOut(int id, String stationName, int t) {
        int duration = t - time.get(id);
        String fromStation = from.get(id);
        Map<String, Info> froms = stations.get(fromStation);
        if (!froms.containsKey(stationName)) {
            froms.put(stationName, new Info());
        }
        Info tripInfo = froms.get(stationName);
        tripInfo.sum += duration;
        tripInfo.count += 1;
        tripInfo.average = tripInfo.sum / tripInfo.count;
    }

    public double getAverageTime(String startStation, String endStation) {
        return stations.get(startStation).get(endStation).average;
    }
}
