
public class Gorilla extends Mammal {
    
    public void throwSomething(){
        System.out.println("the gorilla has thrown something!!, decreased energy by 5");
        this.energylevel-=5;
    }
    public void eatBananas(){
        System.out.println("the gorilla  ate a banana and increased its energy by 10");
        this.energylevel+=10;

    }
    public void climb(){
        System.out.println("the gorilla has climbed and decreased its energy by 10");
        this.energylevel-=10;
    }
}