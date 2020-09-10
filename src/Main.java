import entities.camera.*;
import entities.employees.Collector;
import entities.employees.Employee;
import entities.employees.Manager;
import entities.employees.Technician;
import entities.machines.Calibrator;
import entities.machines.Machine;
import entities.machines.Packer;
import entities.machines.Tester;
import services.*;

import java.io.*;
import java.util.*;

public final class Main {

    private static final String splitter = "-----------------------------------------------------------------------" +
            "-------------------------------------------------";

    private static List<String> getPhones() {
        Random rand = new Random();
        List<String> listNumbers = new ArrayList<>();
        for(int i = 0; i < 100; ++i) {
            int n1 = rand.nextInt(7) + 1;
            int n2 = rand.nextInt(8);
            int n3 = rand.nextInt(8);
            int set2 = rand.nextInt(899) + 100;
            int set3 = rand.nextInt(8999) + 1000;
            listNumbers.add("(" + n1 + n2 + n3 + ")" + "-" + set2 + "-" + set3);
        }
        return listNumbers;
    }

    private static List<String> getListFromFile(String fileName) {
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                list.add(currentLine);
            }
            return list;

        } catch (IOException e) {
            return null;
        }
    }

    private static void print(Object object) {
        System.out.println(object);
        System.out.println(splitter);
    }

    private static void print() {
        System.out.println(splitter);
    }

    private static <T> T getRandomFromList(List<T> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        List<String> names = getListFromFile("./src/Files/Names.txt");
        List<String> surnames = getListFromFile("./src/Files/Surnames.txt");
        List<String> colors = getListFromFile("./src/Files/Colors.txt");
        List<String> robots = getListFromFile("./src/Files/Robot companies.txt");
        List<String> phones = getPhones();
        Random rand = new Random();

        String name;
        String surname;
        String phone;

        List<Employee> collectors = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();
        List<Employee> technicians = new ArrayList<>();

        List<Machine> calibrators = new ArrayList<>();
        List<Machine> testers = new ArrayList<>();
        List<Machine> packers = new ArrayList<>();

        Employee manager;
        for(int i = 0; i < 5; i++) {
            name = getRandomFromList(names);
            surname = getRandomFromList(surnames);
            phone = getRandomFromList(phones);
            manager = new Manager(name, surname, phone);
            managers.add(manager);
        }

        Employee collector;
        Employee technician;
        for(int i = 0; i < 10; i++) {
            name = getRandomFromList(names);
            surname = getRandomFromList(surnames);
            phone = getRandomFromList(phones);
            collector = new Collector(name, surname, phone);
            collectors.add(collector);

            name = getRandomFromList(names);
            surname = getRandomFromList(surnames);
            technician = new Technician(name, surname);
            technicians.add(technician);
        }

        Machine calibrator;
        Machine tester;
        Machine packer;
        for(int i = 0; i < 3; ++i) {
            calibrator = new Calibrator(getRandomFromList(robots));
            tester = new Tester(getRandomFromList(robots));
            packer = new Packer(getRandomFromList(robots));

            calibrators.add(calibrator);
            testers.add(tester);
            packers.add(packer);
        }

        // PRODUCT LIFECYCLE

        // Assembling
        AssemblingService assemblingService = new AssemblingService();
        CameraBack cameraBack = assemblingService.assembleBack((Collector) getRandomFromList(collectors),
                new Dimensions(10, 20, 15), 1 + rand.nextInt(10), 12);
        print();
        CameraBody cameraBody = assemblingService.assembleBody((Collector) getRandomFromList(collectors),
                getRandomFromList(colors));
        print();
        CameraLens cameraLens = assemblingService.assembleLens((Collector) getRandomFromList(collectors), 5,
                LensType.ZOOM);
        print();
        Camera camera = assemblingService.assembleCamera((Collector) getRandomFromList(collectors), cameraBack,
                cameraBody, cameraLens);
        print();

        // Calibration
        CalibrationService calibrationService = new CalibrationService();
        calibrationService.checkMatrix((Calibrator) getRandomFromList(calibrators), cameraBack);
        print();
        calibrationService.innerCharacteristics((Calibrator) getRandomFromList(calibrators), camera);
        print();
        calibrationService.saveResults(camera);
        print();

        // Testing
        MechanicalTestService mechanicalTestService = new MechanicalTestService();
        mechanicalTestService.checkDimensions((Tester) getRandomFromList(testers), camera);
        print();
        mechanicalTestService.checkAutoFocus((Tester) getRandomFromList(testers), camera);
        print();
        mechanicalTestService.checkAudioSystem((Technician) getRandomFromList(technicians), camera);
        print();

        // Release or rejection
        FinalStageService finalStageService = new FinalStageService();
        Boolean checkDefects = finalStageService.checkDefects((Technician) getRandomFromList(technicians), camera);
        Technician technicianFinalStage = (Technician) getRandomFromList(technicians);
        if (!checkDefects) {
            finalStageService.flash(technicianFinalStage, camera);
            print();
            finalStageService.clean(technicianFinalStage, camera);
            print();
            finalStageService.packCamera((Packer) getRandomFromList(packers), camera);
            print();
        } else {
            OrderService orderService = new OrderService();
            Manager managerToOrder = (Manager) getRandomFromList(managers);
            orderService.reportAboutDefect(managerToOrder, camera);
            print();
            print(managerToOrder);
            orderService.orderDetails(managerToOrder, camera);
            print();
        }

        // Resulting product
        print(camera);

    }
}
