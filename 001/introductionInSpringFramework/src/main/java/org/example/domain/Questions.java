package org.example.domain;

public class Questions {
    private String name;
    private int age;
    private String question,answer1,answer2,answer3,answer4;

    public void setQuestion(String question){this.question=question;}
    public String getQuestion(){return  question;}

    public void setAnswer1(String answer1){this.answer1=answer1;}
    public String getAnswer1(){return answer1;}

    public void setAnswer2(String answer2){this.answer2=answer2;}
    public String getAnswer2(){return answer2;}

    public void setAnswer3(String answer1){this.answer3=answer3;}
    public String getAnswer3(){return answer3;}

    public void setAnswer4(String answer4){this.answer4=answer4;}
    public String getAnswer4(){return answer4;}

    @Override
    public String toString(){
        return "\nQuestion" + getQuestion() + "::Answer1" + getAnswer1() + "::Answer2" + getAnswer2()
                + "::Answer3" + getAnswer3()+ "::Answer4" + getAnswer4();
    }

    public Questions() {}
    public Questions(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  void setAge(int age){
        this.age=age;
    }
    public int getAge() {
        return age;
    }
}