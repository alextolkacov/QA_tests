import model.Department;
import model.Employee;
import model.Team;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {

        Department it = new Department();
        Department business = new Department();

        it.setName("IT");
        business.setName("BUSINESS");

        List<Team> itTeams = new ArrayList<>();

        Team team = new Team();
        team.setName("QA");

        List<Employee> employees = new ArrayList<>();

        Employee bugBuger = new Employee();
        bugBuger.setName("Bug Bugger");
        bugBuger.setAge(18);
        bugBuger.setSalary(0.00);

        employees.add(bugBuger);

        Employee bugFich = new Employee();
        bugFich.setName("Bug Fichevich");
        bugFich.setAge(66);
        bugFich.setSalary(100.00);

        employees.add(bugFich);

        team.setEmployees(employees);
        itTeams.add(team);

        it.setTeams(itTeams);

        System.out.println("Department: " + it.getName());
        System.out.println("Teams:");

        for (int i = 0; i < it.getTeams().size(); i++) {
            System.out.println("Name: " + it.getTeams().get(i).getName());
            System.out.println("Employees:");

            for (int j = 0; j < it.getTeams().get(i).getEmployees().size(); j++) {
                System.out.println("Name: " + it.getTeams().get(i).getEmployees().get(j).getName());
            }
        }



//        List<String> strings = new ArrayList<>();
//
//        strings.add("Katja");
//        strings.add("Nailj aka bacila");
//        strings.add("Alex");

//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }

//        for (String name : strings) {
//            if (name.contains("bacila")) {
//                System.out.println(name);
//                break;
//            }
//        }

//        Collections.addAll(strings, "Ksjusha", "Tanja", "Tanya");

//        for (String name : strings) {
//            System.out.println(name);
//        }

//        ------------------------------------------------------------------------

//        HashMap<Integer, String> qas = new HashMap<>();
//
//        qas.put(0, "Bacila");
//        qas.put(1, "Katja");
//        qas.put(2, "Tanya");
//
//        qas.get(2);
//
//        String text = "A text message as it appears on the display screen of an iPhone before iOS 7. Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer. Text messages may be sent over a cellular network, or may also be sent via an Internet connection. The term originally referred to messages sent using the Short Message Service (SMS). It has grown beyond alphanumeric text to include multimedia messages (known as MMS) containing digital images, videos, and sound content, as well as ideograms known as emoji (happy faces, sad faces, and other icons). As of 2017, text messages are used by youth and adults for personal, family, business and social purposes. Governmental and non-governmental organizations use text messaging for communication between colleagues. In the 2010s, the sending of short informal messages has become an accepted part of many cultures, as happened earlier with emailing.[1] This makes texting a quick and easy way to communicate with friends, family and colleagues, including in contexts where a call would be impolite or inappropriate (e.g., calling very late at night or when one knows the other person is busy with family or work activities). Like e-mail and voicemail, and unlike calls (in which the caller hopes to speak directly with the recipient), texting does not require the caller and recipient to both be free at the same moment; this permits communication even between busy individuals. Text messages can also be used to interact with automated systems, for example, to order products or services from e-commerce websites, or to participate in online contests. Advertisers and service providers use direct text marketing to send messages to mobile users about promotions, payment due dates, and other notifications instead of using postal mail, email, or voicemail.";
//
//        String[] words = text.split(" ");
//
//        HashMap<String, Integer> uniqueWords = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            uniqueWords.put(words[i], 0);
//        }

//        System.out.println(uniqueWords.size());
    }
}
