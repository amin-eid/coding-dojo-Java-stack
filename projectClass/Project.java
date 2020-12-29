public class Project{
    private String name;
    private String description;
    public Project(){
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

        //getting name
        public String getName(){
            return this.name;
        }
        //getting description
        public String getDescription(){
            return this.description;
        }

            // setting name
    public void setName(String name){
        this.name = name;
    }
    // setting description
    public void setDescription(String description){
        this.description = description;
    }

    public String elevatorPitch(){
        return (name+description); 
    }


}
