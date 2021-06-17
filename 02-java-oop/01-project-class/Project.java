public class Project {
    private String name;
    private String description;
    private double cost;
    
    public Project(){
        this.name = "Cadens Website";
        this.description = "Java Fun learn to code!";
        this.cost = 100.00;
    }
    public Project(String name){
        this.name = name;
        this.description = "Check out our Python course and learn to code!";
        this.cost = 100.00;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
        this.cost = 100.00;
    }
    public String elevatorPitch(){
        return this.name + " "+(this.cost) +": " + this.description;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getCost(){
        return this.cost;
    }

    public void setName(String name){
        if (name.length() < 4){
            System.out.println("Name must be longer than 4 characters");
        }
        this.name = name;
    }
    public void setDescription(String description){
        if (description.length() < 10){
            System.out.println("Description must be longer then 10 characters");
        }
        this.description = description;
    }
    public void setCost(double newCost){
        this.cost = newCost;
    }

}