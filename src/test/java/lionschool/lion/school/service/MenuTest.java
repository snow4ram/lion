package lionschool.lion.school.service;

import lionschool.lion.school.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuTest {

    MenuService service = new MenuService();

    @Test
    @DisplayName("기존 목록 업데이트")
    public void updates() {

        //when
        Author user_a = service.save("test1", "user a");
        Author user_b = service.save("test2" , "user b");

        //give
        //Author update = service.update(0L , "update writer" , "update name");

        //then
        //Assertions.assertEquals(user_a , update);


    }

    @Test
    @DisplayName("명단 제거 후 명단 제거됐는지 확인")
    public void list_deletes() {

        //when
        Author user_a = service.save("test1", "user a");
        Author user_b = service.save("test2" , "user b");

        service.textDelete(1L);

    }

    @Test
    @DisplayName("data Js 리스트 출력")
    public void data_Js() {

        //give
        Author user_a = service.save("test1", "user a");
        Author user_b = service.save("test2" , "user b");

        //when
        List<Author> list = service.jsPost();

        //then
        System.out.println(list);
    }
}
