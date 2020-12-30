package zookeeper22;

public class Bat extends Mammal{
public void fly() {
	System.out.println("bat is taking off and decreased energy by 50");
	this.energylevel-=50;
}
public void eatHumans() {
	System.out.println("bat ate a human and increaed energy by 25");
	this.energylevel+=25;
}
public void attackTown() {
	System.out.println(" the sound of a town on fire ,decreased energy by 100!");
	this.energylevel-=100;
}
}
