package lionschool.lion.school.service;

import lionschool.lion.school.domain.Author;

import java.util.*;

public class MenuService {
    Scanner text = new Scanner(System.in);

    Map<Long, Author> list = new HashMap<>();

    private Long key = 0L;
    public Author save(String writer , String name) {
        Author author = new Author(key , writer, name);

        list.put(key ,author);


        key++;

        return author;
    }
    public void textDelete(long findId) {
        Author author = list.get(findId);
        if (author == null) {
            System.out.println("삭제된 파일, 혹은 등록되지 않은 파일입니다.");
        }else {
            list.remove(findId);
            System.out.println("삭제 완료");
        }
    }

    public Author update(long updateId ) {
        Author author = list.get(updateId);
        System.out.println("명언(기존) :" +author.toString());

        //명언
        System.out.print("명언 : ");

        String writer = text.next();
//        String writer = inputWriters;

        //작가
        System.out.print("작가 : ");
        String name = text.next();
//        String name = inputNames;

        //update
        author.update(writer , name);

        return list.put(updateId, author);
    }


    public void findAll() {
        System.out.println(" 번호 " + "/ 작가"+ "/  명언  ");
        System.out.println("---------------------------");
        for (long i = 0; i <=list.size(); i++) {
            if (list.get(i) !=null) {
                System.out.println((i)+"번호 "+list.get(i));
            }
        }
    }


    public List<Author> jsPost() {
        return new ArrayList<>(list.values());
    }




}
