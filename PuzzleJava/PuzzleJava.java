import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
public class PuzzleJava{
    public static void main(String[] args){
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(sumArray(array));
        greaterThan(array);
        String[] mylist = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        shuffleArray(mylist);
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shuffleAlphabet(alphabet);
        randomTen();
        randomTenSorted();
        System.out.println(randomString());
        randomStringArray();
    }
public static int sumArray(int[] arr){
    
    int sum=0;
    for (int i=0;i<arr.length;i++){
        sum+=arr[i];
    }
return sum;
}
public static void greaterThan(int[] arr){
ArrayList<Integer> x = new ArrayList<Integer>();
for (int i=0;i<arr.length;i++){
    if(arr[i]>10){
        x.add(arr[i]);
    }
    System.out.println(x) ;
}

}

public static void shuffleArray(String[] arr){
    ArrayList<String> newList = new ArrayList<String>();
    ArrayList<String> newList2 = new ArrayList<String>();
    for(int i = 0; i < arr.length; i++){
        if(arr[i].length() > 5){
            newList2.add(arr[i]);
        }
        newList.add(arr[i]);
    }
    Collections.shuffle(newList);
    System.out.println(newList);
    System.out.println(newList2);
}


public static void shuffleAlphabet(char[] arr){
    Collections.shuffle(Arrays.asList(arr));
    char first = arr[0];
    System.out.println("The last letter is: "+arr[25]);
    System.out.println("The first letter is: "+first);
    if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
        System.out.println("The first letter is a vowel");
    }
}

public static void randomTen() {
    ArrayList<Integer> randNums0 = new ArrayList<Integer>();
    for(int i = 0; i < 10; i++){
        int num = ThreadLocalRandom.current().nextInt(55, 100);
        randNums0.add(num);
    }
    System.out.println(randNums0);
}

public static void randomTenSorted() {
    ArrayList<Integer> randNums = new ArrayList<Integer>();
    int min = 100;
    int max = 55;
    for(int i = 0; i < 10; i++){
        int num = ThreadLocalRandom.current().nextInt(55, 100);
        randNums.add(num);
        if(num < min){
            min = num;
        }
        if(num > max){
            max= num;
        }

    }
    Collections.sort(randNums);
    System.out.println(randNums);
    System.out.println("The smallest random number is: " + min);
    System.out.println("The largest random number is: " + max);
}


public static String randomString(){
    String letters = "abcdefghijklmnopqrstuvwxyz";
    char[] randChars;
    randChars = new char[5];
    for(int i=0; i<5; i++){
        int random = ThreadLocalRandom.current().nextInt(0,  26);
        randChars[i] = letters.charAt(random);
    }
    String Str = new String(randChars);
    return Str;
}

public static void randomStringArray(){
    String[] rStr;
    rStr = new String[10];
    for(int i=0;i<10; i++){
        rStr[i] = randomString();
        System.out.println(rStr[i]);
        
    }
    
}


}