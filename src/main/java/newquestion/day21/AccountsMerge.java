package newquestion.day21;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/25/20 4:55 PM
 */

/**
 * leetcode 721: Accounts merge
 * Solution: union find
 */
public class AccountsMerge {
    public static void main(String[] args) {

    }

    private static class Person {
        String name;
        Set<String> emails;

        public Person(String name) {
            this.name = name;
            this.emails = new HashSet<>();
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Person> emailToPerson = new HashMap<>();
        Set<Person> persons = new HashSet<>();

        for (List<String> account : accounts) {
            Person person = null;
            String name = account.get(0);
            for (int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                if (emailToPerson.containsKey(email)) {
                    if (person == null) {
                        person = emailToPerson.get(email);
                    } else {
                        Person curPerson = emailToPerson.get(email);
                        if (person != curPerson) {
                            person.emails.addAll(curPerson.emails);
                            persons.remove(curPerson);
                            for (String e : curPerson.emails) {
                                emailToPerson.put(e, person);
                            }
                        }
                    }
                }
            }

            if (person == null) {
                person = new Person(name);
                persons.add(person);
            }

            for (int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                emailToPerson.put(email, person);
                person.emails.add(email);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Person person : persons) {
            List<String> list = new ArrayList<>(person.emails);
            list.sort(String::compareTo);
            list.add(0, person.name);
            res.add(list);
        }

        return res;
    }
}
