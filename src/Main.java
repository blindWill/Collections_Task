import java.util.*;

public class Main {
    public static void main(String[] args) {
        performFirstTask();
        performSecondTask();
        performThirdTask();
    }

    public static void performFirstTask(){
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> numberList = fillArrayList(s);
        HashMap<Integer, Integer> numberMap = createMap(numberList);
        System.out.println(numberMap);
    }
    public static ArrayList<Integer> fillArrayList(Scanner s) {
        System.out.println("Input array list size: ");
        final int size = inputInteger(s);
        ArrayList<Integer> numberList = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            System.out.printf("A[%d]:", i);
            numberList.add(inputInteger(s));
            System.out.println();
        }
        return numberList;
    }
    public static HashMap<Integer, Integer> createMap(ArrayList<Integer> numberList){
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        int counter;
        for (int i = 0; i < numberList.size(); i++) {
            counter = 1;
            if (!numberMap.containsKey(numberList.get(i))){
                for (int j = i + 1; j < numberList.size(); j++) {
                    if (numberList.get(i).equals(numberList.get(j))){
                        counter++;
                    }
                }
                if (counter > 1){
                    numberMap.put(numberList.get(i), counter);
                }
            }
        }
        return numberMap;
    }

    public static void performSecondTask(){
        Scanner s = new Scanner(System.in);
        ArrayList<String> stringList = fillArrayListWithStrings(s);
        HashSet<String> stringSet = new HashSet<>(stringList);
        System.out.println(stringList);
        System.out.println(stringSet);
    }

    public static ArrayList<String> fillArrayListWithStrings(Scanner s) {
        System.out.println("Input your text(English):");
        String text = s.nextLine();
        text = text.replaceAll("[^a-zA-Z\s]", "");
        text = text.toLowerCase();
        return new ArrayList<>(Arrays.asList(text.split("\s+")));
    }

    public static void performThirdTask(){

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Time spent on inserting million elements in Array List: " + getTimeToCompleteInsertion(arrayList) + "ms");
        System.out.println("Time spent on inserting million elements in Linked List: " +getTimeToCompleteInsertion(linkedList) + "ms");

        System.out.println("Time spent on getting 100_000 elements in Array List: " +getTimeToCompleteSelection(arrayList) + "ms");
        System.out.println("Time spent on getting 100_000 elements in Linked List: " +getTimeToCompleteSelection(linkedList) + "ms");
    }

    public static void insertElements(List list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(0,1);//if you insert at the beginning then the advantage is on linked list's side
        }
    }

    public static void getElements(List list) {
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            list.get(rand.nextInt(1000000));
        }
    }

    public static long getTimeToCompleteInsertion(List list){
        long time = System.currentTimeMillis();
        insertElements(list);
        return System.currentTimeMillis() - time;
    }

    public static long getTimeToCompleteSelection(List list){
        long time = System.currentTimeMillis();
        getElements(list);
        return System.currentTimeMillis() - time;
    }
    public static int inputInteger(Scanner in) {
        int num = 0;
        boolean isNotCorrect;
        do {
            isNotCorrect = false;
            try {
                num = in.nextInt();
            } catch (IllegalStateException | InputMismatchException e) {
                System.out.println("Wrong input! try again: ");
                in.next();
                isNotCorrect = true;
            }
        }while(isNotCorrect);
        return num;
    }
}