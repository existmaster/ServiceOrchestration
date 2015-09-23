package com.pineone.so.back.core.test;

import com.pineone.icbms.so.Application;
import com.pineone.so.back.core.model.Service;
import com.pineone.so.back.core.model.ServiceCondition;
import com.pineone.so.back.core.model.ServiceTask;
import com.pineone.so.back.core.model.Task;
import com.pineone.so.back.core.repository.ServiceConditionRepository;
import com.pineone.so.back.core.repository.ServiceRepository;
import com.pineone.so.back.core.repository.ServiceTaskRepository;
import com.pineone.so.back.core.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by existmaster on 2015. 9. 10..
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//For server port Integration
@IntegrationTest("server.port:0")
public class ServiceJUnitTest {

    @Autowired
    ServiceConditionRepository serviceConditionRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ServiceTaskRepository serviceTaskRepository;

    @Value("${local.server.port}")
    int port;

    ServiceCondition serviceConditionA;
    Service serviceA;

    @Before
    public void setUp() {

        serviceRepository.deleteAll();
        serviceConditionRepository.deleteAll();
        //RestAssured.port = port;
    }

    public ServiceCondition saveServiceCondition(String name){

        return serviceConditionRepository.save(new ServiceCondition(name));
    }

    public Task saveTask(String name){
        return taskRepository.save(new Task(name));
    }

    public Service saveService(String name, List<ServiceCondition> scs){
        Service service = new Service(name);
        for (ServiceCondition sc : scs){
            service.addServiceCondition(sc);
        }
        return serviceRepository.save(service);
    }

    public ServiceTask saveServiceTask(Service s, Task t, int order){
        ServiceTask st = new ServiceTask();
        st.setService(s);
        st.setTask(t);
        st.setOrder(order);

        return serviceTaskRepository.save(st);
    }

    @Test
    public void canSaveCondition() {
        ServiceCondition A = saveServiceCondition("ConditionA");
        assertEquals(A.getName(), "ConditionA");
    }

    @Test
    public void canSaveTask(){
        Task A = saveTask("TaskA");
        assertEquals(A.getName(), "TaskA");
    }

    @Test
    public void canSaveService() {

        List<ServiceCondition> scA = new ArrayList<>();
        scA.add(saveServiceCondition("ConditionA"));
        scA.add(saveServiceCondition("ConditionB"));

        List<Task> tA = new ArrayList<>();
        tA.add(saveTask("TaskA"));
        tA.add(saveTask("TaskB"));

        Service sA = saveService("ServiceA", scA);
        assertEquals(sA.getServiceConditions().size(), scA.size());
        for (int i =0;i<scA.size(); i++){
            assertEquals(sA.getServiceConditions().get(i), scA.get(i));
        }

    }

    @Test
    public void SaveResource() {


    }

//    @Test
//    public void canSavePlayer() {
//        Game testGame = gameRepository.save(new Game(6));
//        testGame.addPlayer(new Player("윤성열"));
//        gameRepository.save(testGame);
//        Game testGame = gameRepository.save(new Game(2));
//
////        Player player1 = playerRepository.save(new Player(testGame, "AAA"));
////
////        List<Game> list = gameRepository.findAll();
////
////        assertEquals(list.get(3).getPlayer().size(),1);
//    }
//
//    @Test
//    public void canCreatePlayer() {
//        Game game = gameRepository.save(new Game(3));
//        Player player = playerRepository.save(new Player(game, "ABCD"));
//        Player player2 = playerRepository.save(new Player(game, "BBBD"));
//        assertEquals(player.getName(), "ABCD");
//
//    }

    //@Test
//    public void canSaveLadder() {
//        Game testGame = gameRepository.save(new Game(2));
//
//        Player player1 = playerRepository.save(new Player(testGame, "AAA"));
//
//        Ladder ladder1 = ladderRepository.save(new Ladder(player1, 3));
//        Ladder ladder2 = ladderRepository.save(new Ladder(player1, 4));
//        Ladder ladder3 = ladderRepository.save(new Ladder(player2, 2));
//
//        List<Ladder> testladder = ladderRepository.selectByPlayerId(player1.getPlayerId());
//
//        assertEquals(testladder.size(),2);
//
//    }
//    @Test
//    public void canSaveUser() {
//        User user4 = new User("test", "1111", "중성", "바부", "1234@pineone.com");
//
//        when().
//                get("user/add?userId={userId}&password={password}&sex={sex}&nickname={nickname}&email={email}",
//                        user4.getUserId(), user4.getPassword(), user4.getSex(), user4.getNickname(), user4.getEmail()).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user4.getUserId()));
//    }
//
//    @Test
//    public void canFetchUser1() {
//        String user1Id = user1.getUserId();
//
//        when().
//                get("user/search/{userId}", user1Id).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user1Id));
//    }


}
