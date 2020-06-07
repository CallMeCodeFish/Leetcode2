package contest.june6;

/**
 * @author Heng Yu
 * @date 6/6/20 11:03 PM
 */


public class BrowserHistory {
    private static class Page {
        String domain;
        Page prev;
        Page next;

        public Page(String domain) {
            this.domain = domain;
        }
    }

    private Page head;
    private Page tail;
    private Page cur;

    public BrowserHistory(String homepage) {
        head = new Page("");
        tail = new Page("");
        cur = new Page(homepage);
        head.next = cur;
        cur.prev = head;
        cur.next = tail;
        tail.prev = cur;
    }

    public void visit(String url) {
        Page newPage = new Page(url);
        cur.next = newPage;
        newPage.prev = cur;
        newPage.next = tail;
        tail.prev = newPage;
        cur = newPage;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (cur.prev == head) break;
            cur = cur.prev;
            --steps;
        }

        return cur.domain;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (cur.next == tail) break;
            cur = cur.next;
            --steps;
        }
        return cur.domain;
    }
}
