public class Project {
    private String name;
    private String description;
    
    public Project(){
        this.name = "Cadens Website";
        this.description = "Java Fun learn to code!";
    }
    public Project(String name){
        this.name = name;
        this.description = "Check out our Python course and learn to code!";
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String elevatorPitch(){
        return this.name + "; " + this.description;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String setName(String name){
        if (name.length() < 4){
            System.out.println("Name must be longer than 4 characters");
            return "Name must be longer than 4 characters";
        }
        this.name = name;
        return name;
    }
    public String setDescription(String description){
        if (description.length() < 10){
            System.out.println("Description must be longer then 10 characters");
            return "Description must be longer then 10 characters";
        }
        this.description = description;
        return description;
    }

}