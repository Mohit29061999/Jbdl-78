package getterSetter;

public class GfgProblemGetterExample {
    private  int id;
    private String desc;

    //getter is a method that returns value of private
    //variable of your class
    public int getId() {
       // return "abcd";
        return id;
        //return id;
    }

    //accept requesting
    //whether to do update or not
    //is still with us
    public void setId(int userId) {
        //some validation here
        //if validation succedds then only i will update
        if(id%2 ==0){
            this.id = id;
        }
//        if(userId==){
//
//        }


    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
