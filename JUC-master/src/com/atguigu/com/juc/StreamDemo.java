package com.atguigu.com.juc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


class User{
    private Integer id;
    private String userName;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
/**
 * @author zjc
 * @create 2020--03--20--15:14
 * 题目:  请按照给出数据,找出同时满足一下条件的用户,也即一下条件全部满足
 *        偶数ID且年龄大于24且用户名转为大写
 *        且用户名字母倒排序
 *        只输出一个用户名字
 *
 *        select * from student where id  =   and age >24  and
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);




        list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 24;
        }).map(m -> {return  m.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);



        //map(Function< T, R> mapper)

   /*     List<Integer> list2 = Arrays.asList(1,2,3);
        list2 = list2.stream().map(x -> {return  x * 2 ;}).collect(Collectors.toList());

        for (Integer element : list2) {
            System.out.println(element);
        }*/





        //---------------------------------------------------------------------------------------

       /* //函数型接口
        Function<String ,Integer> function = s -> {return s.length();};

        System.out.println(function.apply("abc"));*/



      /*  Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };*/
      //断定性接口
     /* Predicate<String> predicate =s -> {return s.isEmpty();};
      System.out.println(predicate.test("zhaojiacheng"));*/

     /*   Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };*/
     //消费型接口
    /* Consumer<String> consumer = s -> { System.out.println(s); };
     consumer.accept("zhaojiacheng");*/

     /*Supplier<String> supplier = new Supplier<String>() {
         @Override
         public String get() {
             return null;
         }
     };*/

     //供给型函数
    /* Supplier<String> supplier = () -> {return "java0111";};
     System.out.println(supplier.get());*/


    }
}

interface MyInterface{
    public int myInt(int x);
    public String  myString(String  x);
    public boolean isOk(String str);

}