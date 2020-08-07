package newquestion.day66;

/**
 * leetcode 681: Next closest time
 */
public class NextClosestTime {
    private static class Time {
        int hour;
        int minute;

        public Time() {}

        public Time(int h, int m) {
            this.hour = h;
            this.minute = m;
        }

        public int compare(Time time) {
            return this.hour != time.hour ? this.hour - time.hour : this.minute - time.minute;
        }
    }

    public String nextClosestTime(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Time target = new Time(h, m);

        boolean[] existed = new boolean[10];
        for (char c : time.toCharArray()) {
            if (c != ':') {
                existed[c - '0'] = true;
            }
        }

        Time min = null;

        for (int i = 0; i < 3; i++) {
            if (existed[i]) {
                for (int j = 0; j < 10; j++) {
                    if (existed[j] && (i < 2 || j < 4)) {
                        h = i * 10 + j;
                        for (int k = 0; k < 6; k++) {
                            if (existed[k]) {
                                for (int l = 0; l < 10; l++) {
                                    if (existed[l]) {
                                        m = k * 10 + l;
                                        Time t = new Time(h, m);
                                        if (target.compare(t) >= 0) {
                                            t.hour += 24;
                                        }
                                        if (min == null) {
                                            min = t;
                                        } else {
                                            if (t.compare(min) < 0) {
                                                min = t;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (min.hour >= 24) min.hour -= 24;

        StringBuilder sb = new StringBuilder();

        if (min.hour < 10) sb.append(0);

        sb.append(min.hour);
        sb.append(':');

        if (min.minute < 10) sb.append(0);

        sb.append(min.minute);

        return sb.toString();
    }
}
