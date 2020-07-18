package newquestion.day56;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/18/20 5:40 PM
 */


public class SnapshotArray {
    private TreeMap<Integer, Integer>[] records;
    private int[] cur;
    private int version;
    private Set<Integer> log;

    public SnapshotArray(int length) {
        records = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            records[i] = new TreeMap<>();
        }

        cur = new int[length];
        version = 0;
        log = new HashSet<>();
    }

    public void set(int index, int val) {
        cur[index] = val;
        log.add(index);
    }

    public int snap() {
        if (version == 0) {
            for (int i = 0; i < cur.length; i++) {
                records[i].put(version, cur[i]);
            }
        } else {
            for (int i : log) {
                records[i].put(version, cur[i]);
            }
        }
        log.clear();
        return version++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> record = records[index];
        return record.floorEntry(snap_id).getValue();
    }
}
