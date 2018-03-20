package test.referencenull;

public class Demo {


    public void checkNullReference(){
        ConsumerName name =  null;
        addReference(name);
        System.out.println(name.getConsumerName());
    }

    public static void addReference(ConsumerName name){
        name = new ConsumerName();
        name.setConsumerName("KRISHNA");
    }

    public static void main(String []args){
        Demo demo = new Demo();
        demo.checkNullReference();
    }
}