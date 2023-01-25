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

        //get
        public String getName(){
            return this.name;
        }
        //get
        public String getDescription(){
            return this.description;
        }

            // set
    public void setName(String name){
        this.name = name;
    }
    // set
    public void setDescription(String description){
        this.description = description;
    }

    public String elevatorPitch(){
        return (name+description); 
    }


}
