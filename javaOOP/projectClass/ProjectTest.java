public class ProjectTest{
    public static void main(String[] args){
        Project project1 = new Project();
        Project project2 = new Project("Project2");
        Project project3 = new Project("Project3", "project3 description");

        
        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());


        //set 
        project1.setName("project1");
        project1.setDescription("project1 Description");
        System.out.println("Project1 : "+ project1.elevatorPitch());
        project2.setDescription("Project2 Description2");

        System.out.println(project2.getName());
        System.out.println(project2.getDescription());

        //get project name, description
        System.out.println(project1.getName());
        System.out.println(project1.getDescription());

    }
}