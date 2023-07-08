package com.atguigu.com.juc;

import com.atguigu.com.entities.Person;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/20 11:49
 * @Description:
 */
public class TestTransferValue {
    public void changeValue1(int age){
        age =30;
    }

    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }

    public void changeValue3(String str){
        str ="xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();

        int age = 20;
        test.changeValue1(age);
        System.out.println("age-----"+age);

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("PersonName------"+person.getPersonName());


        String str = "abc";
        test.changeValue3(str);
        System.out.println("String-----"+str);


    }
}
