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

    private final static class DataForTesting {
        final List<String> names;
        final List<String> surnames;
        final List<String> colors;
        final List<String> robots;
        final List<String> phones;

        DataForTesting() {
            this.names = getListFromFile("./src/Files/Names.txt");
            this.surnames = getListFromFile("./src/Files/Surnames.txt");
            this.colors = getListFromFile("./src/Files/Colors.txt");
            this.robots = getListFromFile("./src/Files/Robot companies.txt");
            this.phones = getPhones();
        }
    }

    private final static class ListOfEntities {
        final List<Employee> collectors;
        final List<Employee> managers;
        final List<Employee> technicians;
        final List<Machine> calibrators;
        final List<Machine> testers;
        final List<Machine> packers;

        ListOfEntities() {
            this.collectors = new ArrayList<>();
            this.managers = new ArrayList<>();
            this.technicians = new ArrayList<>();
            this.calibrators = new ArrayList<>();
            this.testers = new ArrayList<>();
            this.packers = new ArrayList<>();
        }
    }

    private static List<String> getNameSurnamePhone(DataForTesting dataForTesting) {
        String name = getRandomFromList(dataForTesting.names);
        String surname = getRandomFromList(dataForTesting.surnames);
        String phone = getRandomFromList(dataForTesting.phones);

        return new ArrayList<>(Arrays.asList(name, surname, phone));
    }

    private static ListOfEntities initializeEntities(DataForTesting dataForTesting){
        ListOfEntities listOfEntities = new ListOfEntities();

        // Managers initialization
        for(int i = 0; i < 5; i++) {
            List<String> nameSurnamePhone = getNameSurnamePhone(dataForTesting);
            Employee manager;

            if (i % 2 == 0) { // with|without phone number
                manager = new Manager(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));
            } else {
                manager = new Manager(nameSurnamePhone.get(0), nameSurnamePhone.get(1));
            }

            listOfEntities.managers.add(manager);
        }

        // Collectors and technicians initialization
        for(int i = 0; i < 10; i++) {
            List<String> nameSurnamePhone = getNameSurnamePhone(dataForTesting);
            Employee collector;
            Employee technician;

            if (i % 2 == 0) { // with|without phone number
                collector = new Collector(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));
            } else {
                collector = new Collector(nameSurnamePhone.get(0), nameSurnamePhone.get(1));
            }

            listOfEntities.collectors.add(collector);

            nameSurnamePhone = getNameSurnamePhone(dataForTesting);
            if (i % 2 == 0) { // Similarly
                technician = new Technician(nameSurnamePhone.get(0), nameSurnamePhone.get(1), nameSurnamePhone.get(2));
            } else {
                technician = new Technician(nameSurnamePhone.get(0), nameSurnamePhone.get(1));
            }

            listOfEntities.technicians.add(technician);
        }

        // Machines initialization
        for(int i = 0; i < 5; ++i) {
            Machine calibrator = new Calibrator(getRandomFromList(dataForTesting.robots));
            Machine tester = new Tester(getRandomFromList(dataForTesting.robots));
            Machine packer = new Packer(getRandomFromList(dataForTesting.robots));

            listOfEntities.calibrators.add(calibrator);
            listOfEntities.testers.add(tester);
            listOfEntities.packers.add(packer);
        }

        return listOfEntities;

    }

    private static Camera assembling(ListOfEntities listOfEntities, DataForTesting dataForTesting) {
        AssemblingService assemblingService = new AssemblingService();
        Random rand = new Random();

        Employee collectorCameraBack = getRandomFromList(listOfEntities.collectors);
        Employee collectorCameraBody = getRandomFromList(listOfEntities.collectors);
        Employee collectorCameraLens = getRandomFromList(listOfEntities.collectors);
        Employee collectorCamera = getRandomFromList(listOfEntities.collectors);

        // Randomized parameters
        Dimensions randomDimensions = new Dimensions();
        Integer resolution = 5 + rand.nextInt(10);
        Integer colorDepth = 5 + rand.nextInt(10);
        String colorBody = getRandomFromList(dataForTesting.colors);
        Integer focalLength = 5 + rand.nextInt(10);
        LensType lensType = getRandomFromList(Arrays.asList(LensType.values()));

        CameraBack cameraBack = assemblingService.assembleBack((Collector) collectorCameraBack, randomDimensions,
                resolution, colorDepth);
        print();
        CameraBody cameraBody = assemblingService.assembleBody((Collector) collectorCameraBody, colorBody);
        print();
        CameraLens cameraLens = assemblingService.assembleLens((Collector) collectorCameraLens, focalLength, lensType);
        print();
        Camera camera = assemblingService.assembleCamera((Collector) collectorCamera, cameraBack, cameraBody,
                cameraLens);
        print();

        return camera;
    }

    private static void calibration(ListOfEntities listOfEntities, Camera camera) {
        CalibrationService calibrationService = new CalibrationService();
        Machine calibratorMatrix = getRandomFromList(listOfEntities.calibrators);
        Machine calibratorCharacteristics =  getRandomFromList(listOfEntities.calibrators);

        calibrationService.checkMatrix((Calibrator) calibratorMatrix, camera.getBack());
        print();
        calibrationService.innerCharacteristics((Calibrator) calibratorCharacteristics, camera);
        print();
        calibrationService.saveResults(camera);
        print();
    }

    private static void testing(ListOfEntities listOfEntities, Camera camera) {
        MechanicalTestService mechanicalTestService = new MechanicalTestService();
        Tester testerDims = (Tester) getRandomFromList(listOfEntities.testers);
        Tester testerAutoFocus = (Tester) getRandomFromList(listOfEntities.testers);
        Technician technicianAudioSystem = (Technician) getRandomFromList(listOfEntities.technicians);

        mechanicalTestService.checkDimensions(testerDims, camera);
        print();
        mechanicalTestService.checkAutoFocus(testerAutoFocus, camera);
        print();
        mechanicalTestService.checkAudioSystem(technicianAudioSystem, camera);
        print();
    }

    private static void finalStage(ListOfEntities listOfEntities, Camera camera) {
        FinalStageService finalStageService = new FinalStageService();

        Technician technicianFinalStage = (Technician) getRandomFromList(listOfEntities.technicians);
        Machine packer = getRandomFromList(listOfEntities.packers);
        Boolean checkDefects = finalStageService.checkDefects(technicianFinalStage, camera);
        if (!checkDefects) {
            finalStageService.flash(technicianFinalStage, camera);
            print();
            finalStageService.clean(technicianFinalStage, camera);
            print();
            finalStageService.packCamera((Packer) packer, camera);
            print();
        } else {
            print();
            OrderService orderService = new OrderService();
            Manager managerToOrder = (Manager) getRandomFromList(listOfEntities.managers);
            orderService.reportAboutDefect(managerToOrder, camera);
            print();
            print(managerToOrder);
            orderService.orderDetails(managerToOrder, camera);
            print();
        }
    }

    public static void main(String[] args) { 
        DataForTesting dataForTesting = new DataForTesting();

        ListOfEntities listOfEntities = initializeEntities(dataForTesting);

        // PRODUCT LIFECYCLE

        // Assembling
        Camera camera = assembling(listOfEntities, dataForTesting);

        // Calibration
        calibration(listOfEntities, camera);

        // Testing
        testing(listOfEntities, camera);

        // Release or rejection
        finalStage(listOfEntities, camera);

        // Resulting product
        print(camera);

    }
}
