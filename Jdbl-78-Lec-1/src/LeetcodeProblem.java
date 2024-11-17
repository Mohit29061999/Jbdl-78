public class LeetcodeProblem {
  String id;
  String  desc ="abcd";
  //private static variable
  static int totalQuestionCount = 0;

  //method that gets called whenever an object is created

    //do things that you need to do at object creation in constructor
  public LeetcodeProblem(){
      totalQuestionCount++;
  }

    public LeetcodeProblem(String desc1){
      //represents object which is calling this method
     desc= desc1;
        totalQuestionCount++;
    }

    //this will be added by java by default only if we don't have any constructor
//    public LeetcodeProblem(){
//
//    }


   void printDesc(){
     // int a = 5;
       //System.out.println(second.desc);
       //refrence to current object
       System.out.println(this.desc);
     // System.out.println(desc);
  }

  void printAAgain(){
      //System.out.println(a);
  }

  //
  //Singleton class
    //static variable which is private
   //constructor is also priavte
    //public method which is non-static to access singleton variable


}
